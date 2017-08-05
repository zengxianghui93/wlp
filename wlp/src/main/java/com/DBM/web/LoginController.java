package com.DBM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.CommonConstant;
import com.DBM.cons.MailUtilByYock;
import com.DBM.domain.User;
import com.DBM.domain.WF_B_Integralment;
import com.DBM.domain.WF_B_shoppingcart;
import com.DBM.domain.WF_Thekey;
import com.DBM.service.DBMService;
import com.DBM.service.UserResourceService;
import com.DBM.service.UserService;
import com.DBM.util.AES;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.poi.hssf.record.UseSelFSRecord;

/**
 * <b>类描述:用户登录</b>
 * @see
 * @since
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	/**
	 * 自动注入
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private DBMService dbmService;
	
	//AES加密的钥匙
	private String AES_PASSWORD = "中国北京复兴路北京万方软件";

	@RequestMapping(value = "/aaaaaaaa")
	public String ceshi(HttpServletRequest request) {

		String success = "111";
		return success;

	}

	/**
	 * 登录注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView view = new ModelAndView();
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		session.removeAttribute(CommonConstant.JJR_CONTEXT);
		session.removeAttribute(CommonConstant.ALL_MANU);
		session.removeAttribute("downloadURL");
		view.setViewName("redirect:/login.html");
		return view;

	}

	public String encoderByMd5(String str) throws UnsupportedEncodingException {

		String digestAsHex = DigestUtils.md5DigestAsHex(str.getBytes("utf-8"));

		return digestAsHex;
	}

	///////////// 新项目登录找回密码/////////////////
	
	/**
	 * 忘记密码跳到找回密码页
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/zhaohuimima")
	public ModelAndView zhaohuimima( HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Personalcenter/retrievepwd");
		return view;
	}
	/**
	 * 忘记密码跳到找回密码页
	 * 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/zhaohui")
	public ModelAndView zhaohui( HttpServletRequest request) throws Exception {
		ModelAndView view = new ModelAndView();
		String username = request.getParameter("userName");
		String email = request.getParameter("email");
		if(username == null || email == null || "".equals(username) || "".equals(email)){
			view.addObject("errorMsg", "用户名和邮箱不能为空！");
			view.setViewName("forward:/login/zhaohuimima.html");
			return view;
		}
		User user=userService.getUserByUserName(username);
		if(user != null){
			String emailshuju = user.getEmail();
			if(email.equals(emailshuju)){
				
				//发送邮件
				MailUtilByYock aa= new MailUtilByYock();
				String contextPath = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+
		                request.getServerPort()+contextPath+"/";
				String zhuti ="冶金信息网用户找回密码(5分钟有效,勿泄露!)";
				String neirong1 = "找回密码";
				String beijing = "width:600px;";
				String neirong="<html><head></head><body><div style=" + beijing + "><ul><hr><br/><li>尊敬的用户,您好!</li><br/><li><span>点此找回密码</span><a href=\""+basePath+"login/emailmima.html?ncbd="+URLEncoder.encode(AES.encrypt2Str(username+"t"+new Date().getTime(), AES_PASSWORD),"utf-8")+"\"> "+neirong1+"</a><br/></li><br/><hr><li color:#00FFFF;>如果你没有注册过metalinfo，请忽略此邮件。</li></ul><div></body></html>";
				aa.sendMail(email, username, zhuti, neirong);
				view.addObject("errorMsgss",1);
				view.setViewName("forward:/login/zhaohuimima.html");
			}else{
				view.addObject("errorMsg", "注册邮箱不正确！");
				view.setViewName("forward:/login/zhaohuimima.html");
			}
		}else{
			view.addObject("errorMsg", "用户名不存在！");
			view.setViewName("forward:/login/zhaohuimima.html");
		}
		view.setViewName("forward:/login/zhaohuimima.html");
		return view;

	}

	/**
	 * 邮件忘记密码跳转页面
	 * 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/emailmima")
	public ModelAndView emailmima(HttpServletRequest request,HttpServletResponse response,String ncbd) throws Exception{
		ModelAndView view = new ModelAndView();
		User user = null;
		/*name = java.net.URLDecoder.decode(name,"utf8");*/
		String names1 = "";
		try {
			names1 = AES.decrypt2Str(ncbd, AES_PASSWORD);
			String postTime = names1.substring(names1.lastIndexOf("t")+1,names1.length());
			long nowTime = new Date().getTime();
			
			if((nowTime - Long.valueOf(postTime))<=5*60*1000){
				user=userService.getUserByUserName(names1.substring(0,names1.lastIndexOf("t")));
			};
		} catch (Exception e) {
			user = null;
		}
		if(user == null){
			PrintWriter out = null;
			try {
				out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('此链接已失效，请重新发送邮件进行修改')");
			    out.println("window.close()");
			    //out.println("window.location.reload(true)");
			    out.println("</script>");
			    out.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally{
				 out.close();
			}
			return null;
		}
		view.addObject("user", user);
		view.addObject("ncbd", ncbd);
		view.setViewName("/Personalcenter/retrievepwdemail");	
		return view;
	}
	/**
	 * 邮件忘记密码修改
	 * 
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception 
	 */
	@RequestMapping("/emailmimaupdate")
	public ModelAndView emailmimaupdate(HttpServletRequest request,HttpServletResponse response,String ncbd) throws UnsupportedEncodingException{
		ModelAndView view = new ModelAndView();
		
		String names1 = "";
		User user = null;
		try {
			names1 = AES.decrypt2Str(ncbd, AES_PASSWORD);
			user=userService.getUserByUserName(names1.substring(0,names1.lastIndexOf("t")));
		} catch (Exception e) {
			user = null;
		}
		
		if(user == null){
			PrintWriter out = null;
			try {
				out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('此次修改已失效，请重新发送邮件进行修改')");
			    out.println("window.close()");
			    //out.println("window.location.reload(true)");
			    out.println("</script>");
			    out.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally{
				 out.close();
			}
			return null;
		}
		String userName = names1.toString();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String pwds = request.getParameter("pwds");
		
		
		if(user.getEmail().equals(email)){
			if(pwds.equals(pwd)){
				String byMd5 = encoderByMd5(pwds);
				user.setPassword(byMd5);
				userService.update(user);
				view.setViewName("/success");
				
				request.getSession().removeAttribute(ncbd);; //移除session
			}else{
				view.addObject("errorMsg", "两次输入的密码不相同！");
				view.setViewName("forward:/login/emailmima.html?ncbd="+ncbd);
			}	
		}else{
			view.addObject("errorMsg", "用户"+userName+"的邮箱输入错误！");
			view.setViewName("forward:/login/emailmima.html?ncbd="+ncbd);
		}
		return view;
	}
	/**
	 * 登录
	 */
	@RequestMapping(value = "/doLogin")
	public ModelAndView login(User user, HttpServletRequest request,HttpServletResponse response)
			throws BeansException, DataAccessException, UnsupportedEncodingException {

		User dbUser = userService.getUserByUserName(user.getUserName());
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/login.jsp");
		
		if (dbUser == null) {
			view.addObject("errorMsg", "用户名不存在");
			int aa = 1;
			view.addObject("aa", aa);
		} else if (!dbUser.getPassword().equals(encoderByMd5(user.getPassword()))) {
			// } else if
			// (!dbUser.getPassword().equals(MD5.digestBytes(user.getPassword().getBytes()).toString()))
			// {
			request.getSession().setAttribute("name",user.getUserName());	
			if(request.getSession().getAttribute("logincount")==null){
				request.getSession().setAttribute("logincount",1);
				view.addObject("errorMsg", "用户密码不正确");
			}else{
				int count=(int) request.getSession().getAttribute("logincount");
				int counts=count+1;
				if(counts>3){
					view.addObject("errorMsg", "用户密码输入错误"+counts+"次，请输入验证码");
				}else{
					view.addObject("errorMsg", "用户密码不正确");
				}
				request.getSession().setAttribute("logincount",count+1);	
			}
			int aa = 1;
			view.addObject("aa", aa);
		} else if (dbUser.getLocked() == User.USER_LOCK) {
			view.addObject("errorMsg", "您的账号未激活，请到注册邮箱进行激活后再登录！");
			int aa = 1;
			view.addObject("aa", aa);
		} else {
			//登录成功去掉name
			request.getSession().setAttribute("name",null);	
			view.addObject("name", user.getUserName());
			dbUser.setLastIp(request.getRemoteAddr());
			dbUser.setLastVisit(new Date());
			userService.loginSuccess(dbUser);
			
			setSessionUser(request, dbUser);
			String toUrl = (String) request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
			request.getSession().setAttribute(CommonConstant.ALL_MANU,userService.getAllManuByUserId(dbUser.getUserId()));

			view.setViewName("forward:/manage/main.html");
			//return "forward:manage/main.html";
		}
		
		return view;
	}
}
