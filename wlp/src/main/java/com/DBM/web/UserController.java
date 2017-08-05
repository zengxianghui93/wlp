package com.DBM.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.CommonConstant;
import com.DBM.dao.Page;
import com.DBM.dao.Pagination;
import com.DBM.domain.OperationInfo;
import com.DBM.domain.ResFldInfo;
import com.DBM.domain.ResInfo;
import com.DBM.domain.Role;
import com.DBM.domain.User;
import com.DBM.domain.UserRoleInfo;
import com.DBM.domain.User_group;
import com.DBM.exception.UserExistException;
import com.DBM.service.AuthorityService;
import com.DBM.service.DBMService;
import com.DBM.service.ResDataService;
import com.DBM.service.UserService;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  ResDataService resDataService;
	
	@Autowired
	private DBMService dbmService;

	@Autowired
	private AuthorityService authorityService ;
	
	
	/*
	 * 跳转后台页面
	 */
	@RequestMapping(value = "/manage/main", method = RequestMethod.POST)
	public ModelAndView adminManage(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		view.setViewName("/manage/main");
		return view;
	}
	
	/*
	 * 跳转后台首页面
	 */
	@RequestMapping(value = "/manage/homePage", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		view.setViewName("/manage/homePage");
		return view;
	}
	
	/*
	 * 左导航栏数据读取
	 */
	@RequestMapping(value = "/manage/leftMenu", method = RequestMethod.GET)
	public ModelAndView leftMenu(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		List<UserRoleInfo> RoleList = authorityService.getRoles(user.getUserId());
		List<OperationInfo> operationInfoList = new ArrayList<OperationInfo>();
		for (UserRoleInfo r : RoleList) {
			List<OperationInfo> opList = authorityService.getRolesOp(r.getRoleId());
			for(Object rol:opList){
				Object[] ob = (Object[]) rol;
				OperationInfo op = (OperationInfo) ob[0];
				if(!operationInfoList.contains(op)){
					operationInfoList.add(op);
				}
			}
		}
		
		for(int i=0;i<operationInfoList.size()-1;i++){ 
			for( int j=operationInfoList.size()-1;j>i;j--){
				if(operationInfoList.get(j).getOpName().equals(operationInfoList.get(i).getOpName())){ 
					operationInfoList.remove(operationInfoList.get(j)); 
				}
				if(operationInfoList.get(j).getOpName() == operationInfoList.get(i).getOpName()){ 
					operationInfoList.remove(operationInfoList.get(j)); 
				}
			} 
		} 
		
		List<OperationInfo> list = new ArrayList<OperationInfo>();
		List<OperationInfo> list2 = new ArrayList<OperationInfo>();
		for(int i=0;i<operationInfoList.size();i++){
			if(operationInfoList.get(i).getOpId().length()>5){
				list2.add(operationInfoList.get(i));
			}else{
				list.add(operationInfoList.get(i));
			}
		}
		for(int i=0;i<list2.size();i++){
			list2.get(i).setOpDesc(list2.get(i).getOpId().substring(0, 4));
		}
		for(int i=0;i<list.size();i++){
			list.get(i).setOpDesc(list.get(i).getOpId().substring(3, 4));
		}
		
		view.addObject("user",user);
		view.addObject("list",list);
		view.addObject("list2",list2);
		view.setViewName("/manage/include/leftMenu");
		return view;
	}
	
	/*
	 * 后台顶部
	 */
	@RequestMapping(value = "/manage/topTo", method = RequestMethod.GET)
	public ModelAndView top(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		view.setViewName("/manage/include/top");
		return view;
	}
	
	@RequestMapping(value = "/manage/bottom", method = RequestMethod.GET)
	public ModelAndView bottom(HttpServletRequest request) {
		ModelAndView view =new ModelAndView();
		view.setViewName("/manage/include/bottom");
		return view;
	}
	
	/*
	 * 查询所有用户
	 */
	@RequestMapping( value="/manage/userList")
	public ModelAndView userList(@RequestParam(value = "pageNo", required = false) Integer pageNo){
		
		ModelAndView view = new ModelAndView();	
		pageNo = pageNo==null?1:pageNo;
		Page pagedNews = userService.getPageUser(pageNo, 9);
		view.addObject("pagedNews",pagedNews);
		view.setViewName("/manage/userManage/userManage");
		return view;
	}
	/*
	 * 根据注册日期查询用户
	 */
	@RequestMapping( value="/manage/userLists")
	public ModelAndView userLists(@RequestParam(value = "pageNo", required = false) Integer pageNo,HttpServletRequest request) throws ParseException{
		
		ModelAndView view = new ModelAndView();	
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		Date Startdate = fmt.parse(request.getParameter("Startdate"));
		Date enddate = fmt.parse(request.getParameter("enddate"));
		pageNo = pageNo==null?1:pageNo;
		Page pagedNews = userService.getPageUsers(pageNo, 9,Startdate,enddate);
		view.addObject("pagedNews",pagedNews);
		view.setViewName("/manage/userManage/userManage");
		return view;
	}
	
	/**
	 * 查询所有用户信息
	 * @param pageNo
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping( value="/manage/userList1" ,method = RequestMethod.GET)
	public ModelAndView userLists1(@RequestParam(value = "pageNo", required = false) Integer pageNo,HttpServletRequest request) throws ParseException{
		ModelAndView view = new ModelAndView();	
		pageNo = pageNo==null?1:pageNo;
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String Startdate1 = request.getParameter("Startdate");
		String enddate1 = request.getParameter("enddate");
		String group = request.getParameter("group");
		String orderByUserName = request.getParameter("orderByUserName");
		String orderByCreateTime = request.getParameter("orderByCreateTime");
		String orderByAuthEndTime = request.getParameter("orderByAuthEndTime");
		String where =" 1=1";
		
		//分组
		if(group!=null&&!"".equals(group)){
			String ids = null;
			List<User_group> userGroups= userService.getUserGroupById(group);
			for (User_group user_group : userGroups) {
				if (ids == null) {
					ids = user_group.getUserid()+"";
				}else{
					ids += ","+user_group.getUserid();
				}
			}
			where += " and user_id in ("+ids+")";
		}
		
		if (name!=null&&!"".equals(name.trim())) {
			where += " and user_name like '%"+name.trim()+"%'";
		}
		if (phone!=null&&!"".equals(phone.trim())) {
			where += " and phone like '%"+phone.trim()+"%'";
		}
		if (email!=null&&!"".equals(email.trim())) {
			where += " and email like '%"+email.trim()+"%'";
		}
		if (Startdate1!=null&&!"".equals(Startdate1)) {
			where += " and create_time >= '"+Startdate1+" 00:00:00'";
		}
		if (enddate1!=null&&!"".equals(enddate1)) {
			where += " and create_time <= '"+enddate1+" 23:59:59'";
		}
		
		if(orderByUserName!=null&&!"".equals(orderByUserName)){
			if (where.contains("order by")) {
				where += ",user_name "+orderByUserName;
			}else{
				where += " order by user_name "+orderByUserName;
			}
		}
		
		if(orderByCreateTime!=null&&!"".equals(orderByCreateTime)){
			if (where.contains("order by")) {
				where += ",create_time "+orderByCreateTime;
			}else{
				where += " order by create_time "+orderByCreateTime;
			}
		}
		
		if(orderByAuthEndTime!=null&&!"".equals(orderByAuthEndTime)){
			if (where.contains("order by")) {
				where += ",authorizeEndTime "+orderByAuthEndTime;
			}else{
				where += " order by authorizeEndTime "+orderByAuthEndTime;
			}
		}
		
		/*DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		Date Startdate = fmt.parse(Startdate1);
		Date enddate = fmt.parse(enddate1);*/
		Page pagedNews = userService.getPagedUsers1(pageNo, 9, where);
		
		//获取所有分组信息
		
		view.addObject("groups",authorityService.getAllgroups());
		view.addObject("group",group);
		view.addObject("orderByUserName",orderByUserName);
		view.addObject("orderByCreateTime",orderByCreateTime);
		view.addObject("orderByAuthEndTime",orderByAuthEndTime);
		view.addObject("name",name);
		view.addObject("phone",phone);
		view.addObject("email",email);
		view.addObject("Startdate",Startdate1);
		view.addObject("enddate",enddate1);
		view.addObject("pagedNews",pagedNews);
		view.setViewName("/manage/userManage/userManage");
		return view;
	}
	
	/*
	 * 
	 * 
	 * 根据id获取用户对象
	 */
	@RequestMapping( value="/manage/editUser-{userId}" ,method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable int userId){
		
		ModelAndView view = new ModelAndView();
		
		User user = userService.getUserById(userId);
		
		view.addObject("user",user);
		view.setViewName("/manage/editUser");
		return view;
	}
	/*
	 * 添加用户
	 */
	@RequestMapping( value="/manage/updateUser" ,method = RequestMethod.POST)
	public ModelAndView updateUser(User user) throws UnsupportedEncodingException{
		
		ModelAndView view = new ModelAndView();
		User userYuan = userService.getUserById(user.getUserId());
		
		
		userYuan.setEmail(user.getEmail());
		userYuan.setUserSex(user.getUserSex());
		userYuan.setUserType(user.getUserType());
		//	以下和云平台用户有关
		userYuan.setPower(user.getPower());
		userYuan.setAuthorizeStartTime(user.getAuthorizeStartTime());
		userYuan.setAuthorizeEndTime(user.getAuthorizeEndTime());
		userService.update(userYuan);
		view.setViewName("redirect:/manage/userList.html");
	
		return view;
	}
	public String encoderByMd5(String str) throws UnsupportedEncodingException {
		
		String digestAsHex = DigestUtils.md5DigestAsHex(str.getBytes("utf-8"));
		
		return digestAsHex;
	}
	/*
	 * 删除用户
	 */
	@RequestMapping( value="/manage/delUser-{userId}" ,method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable int userId){
		ModelAndView view = new ModelAndView();
		User user = userService.getUserById(userId);
		userService.delUserById(userId);
		/*********************云平台账号更新开始*****************************************/
		Date currentDate = new Date();
		int isActive = 0;
		if(currentDate.after(user.getAuthorizeStartTime()) && currentDate.before(user.getAuthorizeEndTime())){
			isActive = 1;
		}
		
		view.setViewName("redirect:/manage/userList.html");
		return view;
	}
	/*
	 * 跳转至修改密码页面
	 */
	@RequestMapping( value="/manage/editPwd-{userId}" ,method = RequestMethod.GET)
	public ModelAndView editPwd(@PathVariable int userId){
		ModelAndView view = new ModelAndView();
		User user = userService.getUserById(userId);
		view.addObject("user", user);
		view.setViewName("/manage/editPwd");
		return view;
	}
	/*
	 * 保存新修改的密码
	 */
	@RequestMapping( value="/manage/updatePwd-{userId}",method = RequestMethod.POST)
	public ModelAndView updatePwd(User user) throws UnsupportedEncodingException{
		ModelAndView view = new ModelAndView();
		User userYuan = userService.getUserById(user.getUserId());
		String byMd5 = encoderByMd5(user.getPassword());
		userYuan.setPassword(byMd5);
		userService.update(userYuan);
		view.addObject("user",userYuan);
		view.setViewName("/manage/editUser");
		return view;
	}
	
	
	@RequestMapping(value="/manage/role")
	public ModelAndView role(){
		ModelAndView view = new ModelAndView();
		List<Role> allRole = userService.getAllRole();
		
		view.addObject("listRoles", allRole);
		view.setViewName("/manage/roleList");
		return view;
	}
	
//	@RequestMapping(value="/manage/role-{roleId}")
//	public ModelAndView getRolePermission(@PathVariable Integer roleId){
//		ModelAndView view = new ModelAndView();
//		//获取所有权限信息
//		List allPermission = userService.getAllPermission();
//		view.addObject("allPermission", allPermission);
//		//获取已授权信息
//		List<Role_permission> roleperlinkByRolid = userService.getRoleperlinkByRolid(roleId);
//		List<Permission> list = new ArrayList<Permission>();
//		for (Role_permission role_permission : roleperlinkByRolid) {
//			Permission permission = userService.getPermissionByid(role_permission.getPermissid());
//			list.add(permission);
//		}
//		
//		view.addObject("list", list);
//		view.setViewName("/manage/permis");
//		return view;
//	}
	//经纪人发布的信息列表页
	@RequestMapping(value="/publish-{ResId}",method=RequestMethod.GET)
	public ModelAndView publishData(@PathVariable String ResId,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		String message = "";
		String status = ""; 
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(ResId));
		//获取要查询的表名
		ResInfo resInfo =dbmService.getResInfo(Integer.parseInt(ResId));
		
		//获取当前用户
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		int userType = user.getUserType();
		
		List<Map<String, Object>> businessList =null;
		Pagination page=null; 
 		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//out = response.getWriter();
			String currentPage  = request.getParameter("currentPage");
			String numPerPage  = request.getParameter("numPerPage");
			if(currentPage==null) currentPage="";
			if(numPerPage==null) numPerPage="";
			if("".equals(currentPage)||"".equals(numPerPage)){ 
				page =resDataService.queryPageBusiness(resInfo.getResTblName(),user,1, 10);  
			}else{ 
				page =resDataService.queryPageBusiness(resInfo.getResTblName(),user,Integer.parseInt(currentPage), Integer.parseInt(numPerPage));  
			} 
			List list=page.getResultList();
			businessList=new ArrayList<Map<String,Object>>(); 
			for (int i = 0,len=list.size();i<len; i++) {
				Map<String, Object> maps=new HashMap<String, Object>();
				Map mapRe=(Map)list.get(i); 
				maps.put("id", mapRe.get("id"));
				maps.put("pubFlag", mapRe.get("pubFlag"));
				//获取该库的所有字段，把列表可显示字段存入Map					
				for (ResFldInfo resFldInfo : lstFld) {
					if(resFldInfo.getFldList()==1)
						maps.put(resFldInfo.getFldName(), mapRe.get(resFldInfo.getFldName()));
				}
				businessList.add(maps); 
			}
			message="success"; 
			status = "0";
		} catch (Exception e1) { 
			e1.printStackTrace();
			message="failure";
			status = "1";
		}finally{ 
			int nextPage=1;int prePage=1;
			if(page.getCurrentPage()!=1)
				prePage=page.getCurrentPage()-1;
			
			if(page.getCurrentPage()<page.getTotalPages())
				nextPage=page.getCurrentPage()+1;
			else
				nextPage=page.getTotalPages();
			
			map.put("message", message); 
			map.put("totalPage", page.getTotalPages());  
			map.put("currentPage", page.getCurrentPage());  
			map.put("totalRows", page.getTotalRows());  
			map.put("numPerPage", page.getNumPerPage());  
			map.put("status", status);  
			map.put("prePage", prePage);
			map.put("nextPage", nextPage);
			map.put("resName", resInfo.getResName());

		}
		view.addObject("resInfo",resInfo);
		view.addObject("page",map);
		view.addObject("ResId",ResId);
		view.addObject("dataList",businessList);
		view.addObject("lstFld",lstFld);
		view.setViewName("/publish");
		
		return view;
		
	}
	/**
	 * 到添加数据页面
	 * @param ResId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addRecord-{ResId}", method = RequestMethod.GET)
	public ModelAndView addRecord(@PathVariable String ResId,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		/*//查询特色库类别信息
		ResInfo resInfo = dbmService.getResInfo(16);
		List cateList = resDataService.selectAllData(resInfo.getResTblName());
		view.addObject("cateList",cateList);
		*/
		//获取该库所有字段
		ResInfo resInfo =dbmService.getResInfo(Integer.parseInt(ResId));
		view.addObject("resInfo", resInfo);
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(ResId));
		view.addObject("FldList",lstFld);
		view.addObject("ResId",ResId);
		view.setViewName("/addRecord");
		
		return view;
		
	}
	
	/**
	 * 添加某个资源库的数据
	 * @param tableName
	 */
	@RequestMapping(value = "/publish/addData", method = RequestMethod.POST)
	public String addResData(ResInfo res,HttpServletRequest request,@RequestParam(required=false) MultipartFile[] myfiles){
		//判断该库的发布流程
		ResInfo resInfo = dbmService.getResInfo(res.getResId());
		String Flag="0";
		
		//获取当前操作的用户
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		int userId = user.getUserId();
		String sql=" Insert into `"+dbmService.getResInfo(res.getResId()).getResTblName()+"` ";
		String fields="(pubFlag,createTime,editTime,userId,";
		String values=" VALUES ('"+Flag+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"','"+userId+"',";
		

		//获取该库的所有字段,拼接sql
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(request.getParameter("resId")));
		
		int i=0;
		for (ResFldInfo resFldInfo : lstFld){
			//是否是上传字段
			if(resFldInfo.getFldInputType().equals("file")){
				MultipartFile myfile = myfiles[i];
				if(myfile.isEmpty()){  
	                System.out.println("文件未上传");  
	            }else{  
	                System.out.println("文件长度: " + myfile.getSize());  
	                System.out.println("文件类型: " + myfile.getContentType());  
	                System.out.println("文件名称: " + myfile.getName());  
	                System.out.println("文件原名: " + myfile.getOriginalFilename());  
	                System.out.println("========================================");  
	                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\iamges\\upload\\userPhoto文件夹中  
	                String realPath = request.getSession().getServletContext().getRealPath(CommonConstant.USER_IMAGE);  
	                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
	                
	                String dataname = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).toString()+myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."));
	                try {
						FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, dataname));
					} catch (IOException e) {
						System.out.println("文件上传出错");
						e.printStackTrace();
					}
	                fields+=resFldInfo.getFldName()+",";
	                values+="'"+dataname+"',";
	            }
				if(i<myfiles.length-1){
					i++;
				}
			}else{
				fields+=resFldInfo.getFldName()+",";
				values+="'"+request.getParameter(resFldInfo.getFldName())+"',";
			}
		}
		
		//去掉最后一个‘，’
		fields=fields.substring(0, fields.length()-1);
		values=values.substring(0, values.length()-1);
		
		fields+=")";
		values+=");";
		
		sql+=fields +values ;
		
		ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbcTemplate");
		
		dbmService.addData(jt, sql);
		return "redirect:/publish-"+res.getResId()+".html";
	}
	/**
	 * 跳到修改记录的页面
	 * @param resId
	 * @return
	 */
	@RequestMapping(value="/publish/EditData-{resId}-{Id}",method=RequestMethod.GET)
	public ModelAndView editData(@PathVariable String resId,@PathVariable String Id,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		view.addObject("resInfo", resInfo);
		
		//根据resId和ID找出该记录
		String tname=dbmService.getResInfo(Integer.parseInt(resId )).getResTblName();
		Map<String, Object> map = new HashMap<String, Object>();
		ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbcTemplate");
		map=dbmService.getData(jt, tname, Id);
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(resId));
		
		view.addObject("FldList",lstFld);
		view.addObject("resId",resId);
		view.addObject("dataMap",map);
		
		view.setViewName("/addRecordE");
		/*view.setViewName("redirect:/publish-"+resId+".html");*/
		return view;
	}
	/*
	 * 修改后的保存
	 */
	@RequestMapping(value = "/publish/upData", method = RequestMethod.POST)
	public ModelAndView upData(ResInfo res,HttpServletRequest request,@RequestParam(required=false) MultipartFile[] myfiles){
		ModelAndView view = new ModelAndView();
		//获取当前操作的用户
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		int userId = user.getUserId();
		
		String Id = request.getParameter("id");
		//获取资源库的物理表名
		ResInfo resInfo = dbmService.getResInfo(res.getResId());

		String sql=" update `"+resInfo.getResTblName()+"` set ";
		//修改时把记录改成未审核
		sql+="userId='"+userId+"', pubFlag='0', editTime='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"', ";
		//获取该库的所有字段,准备跳到字段列表页面
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(request.getParameter("resId")));
		int i = 0;
		for (ResFldInfo resFldInfo : lstFld) {
			
			//修改上传字段
			if(resFldInfo.getFldInputType().equals("file")){
				MultipartFile myfile = myfiles[i];
				if(myfile.isEmpty()){  
	                System.out.println("文件未修改");  
	            }else{  
	                System.out.println("文件长度: " + myfile.getSize());  
	                System.out.println("文件类型: " + myfile.getContentType());  
	                System.out.println("文件名称: " + myfile.getName());  
	                System.out.println("文件原名: " + myfile.getOriginalFilename());  
	                System.out.println("========================================");  
	                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
	                String realPath = request.getSession().getServletContext().getRealPath(CommonConstant.USER_IMAGE);  
	                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
	                
	                String dataname = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).toString()+myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."));
	                try{
						FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, dataname));
						
	                } catch (IOException e) {
						System.out.println("文件上传出错");
						e.printStackTrace();
					}
	                sql+=resFldInfo.getFldName()+"='"+dataname+"',";
	            }
				if(i<myfiles.length-1){
					i++;
				}
			
			}else{
				sql+=resFldInfo.getFldName()+"='"+request.getParameter(resFldInfo.getFldName())+"',";
			}
			
		}
		
		//去掉最后一个‘，’
		sql=sql.substring(0, sql.length()-1);
		sql+=" where id="+Id;
		
		ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbcTemplate");
		dbmService.addData(jt, sql);
		view.addObject("resInfo", resInfo);
		view.setViewName("redirect:/publish-"+res.getResId()+".html");
		//return "redirect:/DBM/PageData-"+request.getParameter("resId")+".html";
		return view;
	}
	
	/**
	 * 查看详情
	 * @return
	 */
	@RequestMapping(value = "/publish/Detail-{resId}-{Id}", method = RequestMethod.GET)
	public ModelAndView recordDetail(@PathVariable String resId,@PathVariable String Id,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		view.addObject("resInfo", resInfo);
		
		//根据resId和ID找出该记录
		String tname=dbmService.getResInfo(Integer.parseInt(resId )).getResTblName();
		Map<String, Object> map = new HashMap<String, Object>();
		ApplicationContext context = (ApplicationContext) request.getSession().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbcTemplate");
		map=dbmService.getData(jt, tname, Id);
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(resId));
		
		view.addObject("FldList",lstFld);
		view.addObject("resId",resId);
		view.addObject("dataMap",map);
		
		view.setViewName("/addRecordD");
		/*view.setViewName("redirect:/publish-"+resId+".html");*/
		return view;
	}
	
	@ResponseBody
	@RequestMapping("/manage/getUsersByRoleId")
	public List<User> getUsersByRoleId(Integer roleId){
		return userService.getUsersByRoleId(roleId);
	}
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}

}