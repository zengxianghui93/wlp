package com.DBM.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.DBM.cons.CommonConstant;
import com.DBM.dao.Page;
import com.DBM.dao.Pagination;
import com.DBM.domain.ResFldInfo;
import com.DBM.domain.ResInfo;
import com.DBM.domain.User;
import com.DBM.domain.UserRoleInfo;
import com.DBM.domain.WF_B_MIdatabase;
import com.DBM.domain.WF_B_langInfo;
import com.DBM.service.AuthorityService;
import com.DBM.service.DBMService;
import com.DBM.service.NewsService;
import com.DBM.service.ResDataService;
import com.DBM.service.TaskDataService;
import com.DBM.util.ResIndexField;

@Controller
public class DBMController extends BaseController{		
	@Autowired
	private DBMService dbmService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private  ResDataService resDataService;
	
	@Autowired
	private TaskDataService taskDataService;
	
	@Autowired
	private AuthorityService authorityService;
	
	private static ApplicationContext context = null;
	private static JdbcTemplate jt=null;
	
	public DBMController() {
		super();
		// TODO Auto-generated constructor stub
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jt = (JdbcTemplate)context.getBean("jdbcTemplate");	
		
	}
	
	
	/**
	 * 创建资源库和对应表
	 * @param tableName
	 */
	@RequestMapping(value = "/DBM/addResC", method = RequestMethod.POST)
	public  ModelAndView createTable(ResInfo res,HttpServletRequest request){
		res.setResDate(new Date());
		dbmService.addRes(jt, res);
		dbmService.addTables(jt, res.getResTblName(), "");	
		
		//跳转到字段列表页面，方便添加字段
		ModelAndView view =new ModelAndView();
		//获取该库的所有字段
		List<ResFldInfo> lstFld=dbmService.ListResFld(res.getResId());
		view.addObject("FldList",lstFld);
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(res.getResId());
		view.addObject("list",lstFldNew);
		view.addObject("ResId",res.getResId());
		view.setViewName("/DBM/FldList");
		return view;
	}	
	
	
	/**
	 * 修改资源库和对应表
	 * @param tableName
	 */
	@RequestMapping(value = "/DBM/EditResC", method = RequestMethod.GET)
	public  ModelAndView editTable(ResInfo res,HttpServletRequest request){
		res.setResDate(new Date());
		dbmService.addRes(jt, res);
		dbmService.addTables(jt, res.getResTblName(), "");	
		
		//跳转到字段列表页面，方便添加字段
		ModelAndView view =new ModelAndView();
		//获取该库的所有字段
		List<ResFldInfo> lstFld=dbmService.ListResFld(res.getResId());
		view.addObject("FldList",lstFld);
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(res.getResId());
		view.addObject("list",lstFldNew);
		view.addObject("ResId",res.getResId());
		view.setViewName("/DBM/EditRes");
		return view;
	}
	
	
	
	/**
	 * 获取所有的资源库,准备跳到库列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/DBM/resourceManage", method = RequestMethod.GET)
	public  ModelAndView listRes(HttpServletRequest request,@RequestParam(value = "pageNo", required = false) Integer pageNo,String resName){
		ModelAndView view =new ModelAndView();
		//获取所有的资源库,准备跳到库列表页面
		pageNo = pageNo==null?1:pageNo;
		
		Page pagedNews = null;
		//判断当前用户是否为超级管理员，如果是，显示所有的资源库，如果不是，只显示和当前用户有关的资源库
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		List<UserRoleInfo> roles = authorityService.getRoles(user.getUserId());
		
		boolean isAdmin = false;
		for (UserRoleInfo userRoleInfo : roles) {
			if(userRoleInfo.getRoleId()==1){
				isAdmin = true;
				break;
			};
		}
		if (isAdmin) {
			//是超级管理员
			pagedNews = dbmService.ListRes(pageNo,9,resName);
		}else{
			//不是超级管理员
			List res = taskDataService.getTableNameByuserId(user.getUserId());
			pagedNews = dbmService.getPageDBM3(pageNo, 9, res);
		}
		view.addObject("isAdmin",isAdmin);
		view.addObject("resName",resName);
		view.addObject("pagedNews",pagedNews);
		view.setViewName("/manage/resourceManage/resourceManage");
		return view;
	}
	
	/**
	 *  跳到添加资源库的页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/DBM/addResPage", method = RequestMethod.GET)
	public String addResPage() {
		return "DBM/AddRes";
	}
	
	
	/**
	 *  跳到修改资源库的页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/DBM/editResPage-{ResId}", method = RequestMethod.GET)
	public ModelAndView editResPage(@PathVariable String ResId) {
		ModelAndView view =new ModelAndView();
		ResInfo rInfo=dbmService.getResInfo(Integer.parseInt(ResId));
		view.addObject("rInfo",rInfo);
		view.setViewName("DBM/EditRes");
		return view;
	}
	
	/**
	 * 获取某个库的数据列表
	 * @param resFld
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/DBM/ResData-{ResId}", method = RequestMethod.GET)
	public  ModelAndView ResData(ResFldInfo resFld,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		dbmService.addResFld(jt,resFld);
		//获取该库的所有记录
		List<ResFldInfo> lstFld=dbmService.ListResFld(resFld.getResId());
		view.addObject("FldList",lstFld);
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(resFld.getResId());
		view.addObject("list",lstFldNew);
		view.addObject("ResId",resFld.getResId());
		view.setViewName("/DBM/FldList");
		return view;
	}
	
	/**
	 * 跳到某个库添加记录的页面
	 * @param resFld
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/DBM/AddData-{ResId}", method = RequestMethod.GET)
	public  ModelAndView addResData(@PathVariable String ResId,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		
		
		//查询特色库类别信息
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(ResId));
	//	List cateList = resDataService.selectAllData(resInfo.getResTblName());
	//	view.addObject("cateList",cateList);
		
		//获取该库所有字段
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(ResId));
		List<ResFldInfo> lstFldNew=dbmService.ListResFldNew(Integer.parseInt(ResId));
		
		//MI库来源
		/*List<WF_B_MIdatabase> databaseList = dbService.getMIdatabase();*/
		//获取当前{ResId}的记录
		ResInfo ri = dbmService.getResInfo(Integer.parseInt(ResId));
		//因为textarea标签嵌套，会导致样式混乱，所以用<!--textarea 替代<textarea , textarea-->替换textarea>
		if(ri.getResTemplate() != null){
			String temp = ri.getResTemplate().replace("<!--textarea", "<textarea");;
			temp = temp.replace("textarea-->", "textarea>");
			for (int i = 0; i < lstFld.size(); i++) {
				String fieldName = lstFld.get(i).getFldName();
				temp = temp.replace("[" + fieldName + "]","");
			}
			ri.setResTemplate(temp);
		}
		view.addObject("FldList",lstFld);
		view.addObject("ResId",ResId);
		view.addObject("ri", ri);
		view.addObject("list", lstFldNew);
		view.setViewName("/DBM/AddData");
		return view;																
	}
	
	
	/**
	 * 跳到某个库修改记录的页面
	 * @param resFld
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/DBM/EditData-{resId}-{Id}", method = RequestMethod.GET)
	public  ModelAndView editResData(@PathVariable String resId,@PathVariable String Id,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		view.addObject("resInfo", resInfo);
		
		//根据resId和ID找出该记录
		String tname=dbmService.getResInfo(Integer.parseInt(resId )).getResTblName();
		Map<String, Object> map = new HashMap<String, Object>();
		map=dbmService.getData(jt, tname, Id);
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(resId));
		
		//查询特色库类别信息
		ResInfo resInfo2 = dbmService.getResInfo(Integer.parseInt(resId));
		//List cateList = resDataService.selectAllData(resInfo2.getResTblName());
		//view.addObject("cateList",cateList);
		/*//MI库来源
		List<WF_B_MIdatabase> databaseList = dbService.getMIdatabase();*/
		
		//获取当前{ResId}的记录
		ResInfo ri = dbmService.getResInfo(Integer.parseInt(resId));
		//因为textarea标签嵌套，会导致样式混乱，所以用<!--textarea 替代<textarea , textarea-->替换textarea>
		if(ri.getResTemplate() != null){
			String temp = ri.getResTemplate().replace("<!--textarea", "<textarea");;
			temp = temp.replace("textarea-->", "textarea>");
			for (int i = 0; i < lstFld.size(); i++) {
				String fieldName = lstFld.get(i).getFldName();
				Object obj = map.get(fieldName);
				if(obj != null && !obj.toString().equals("")){
					temp = temp.replace("[" + fieldName + "]",obj.toString());
				}else{
					temp = temp.replace("[" + fieldName + "]","");
				}
			}
			//List li = regStr(temp);
			ri.setResTemplate(temp);
		}
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(Integer.parseInt(resId));
		view.addObject("currentPage",request.getParameter("currentPage"));
		view.addObject("list",lstFldNew);
		view.addObject("FldList",lstFld);
		view.addObject("resId",resId);
		view.addObject("dataMap",map);
		view.addObject("ri", ri);
		view.addObject("tname",tname);
		view.setViewName("/DBM/EditData");
		return view;
	}
	
	
	/**
	 *  跳到添加字段的页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/DBM/addFldPage-{ResId}", method = RequestMethod.GET)
	public ModelAndView addFldPage(@PathVariable String ResId) {
		ModelAndView view =new ModelAndView();
		view.addObject("ResId",ResId);
		view.setViewName("/DBM/AddFld");
		return view;
	}
	
	/**
	 *  跳到修改字段的页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/DBM/editFldPage-{fldId}", method = RequestMethod.GET)
	public ModelAndView editFldPage(@PathVariable String fldId) {
		ModelAndView view =new ModelAndView();
		ResFldInfo resFldInfo=dbmService.getResFld(Integer.parseInt(fldId));
		view.addObject("resFldInfo",resFldInfo);
		view.setViewName("/DBM/EditFld");
		return view;
	}
	
	/**
	 * 创建字段
	 * @param tableName
	 */
	@RequestMapping(value = "/DBM/addResFld", method = RequestMethod.POST)
	public  ModelAndView createResFld(ResFldInfo resFld,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		dbmService.addResFld(jt,resFld);
		//获取该库的所有字段,准备跳到字段列表页面
		List<ResFldInfo> lstFld=dbmService.ListResFld(resFld.getResId());
		view.addObject("FldList",lstFld);
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(resFld.getResId());
		view.addObject("list",lstFldNew);
		view.addObject("ResId",resFld.getResId());
		view.setViewName("/DBM/FldList");
		return view;
	}
	
	/**
	 * 列出某个库的字段列表
	 * @param 
	 */
	@RequestMapping(value = "/DBM/listResFld-{resId}", method = RequestMethod.GET)
	public  ModelAndView listResFld(@PathVariable String resId){
		ModelAndView view =new ModelAndView();
		//获取该库的所有字段,准备跳到字段列表页面
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(resId ));
		view.addObject("FldList",lstFld);
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(Integer.parseInt(resId));
		view.addObject("list",lstFldNew);
		view.addObject("ResId",resId);
		view.setViewName("/DBM/FldList");
		return view;
	}
	
	/**
	 * 修改字段
	 * @param tableName
	 */
	@RequestMapping(value = "/DBM/editResFld", method = RequestMethod.POST)
	public  ModelAndView editResFld(ResFldInfo resFld,HttpServletRequest request){
		ModelAndView view =new ModelAndView();
		dbmService.editResFld(jt,resFld);
		//获取该库的所有字段,准备跳到字段列表页面
		List<ResFldInfo> lstFld=dbmService.ListResFld(resFld.getResId());
		view.addObject("FldList",lstFld);
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(resFld.getResId());
		view.addObject("list",lstFldNew);
		view.addObject("ResId",resFld.getResId());
		view.setViewName("/DBM/FldList");
		return view;
	}
	
	
	/**
	 * 添加某个资源库的数据
	 * @param tableName
	 */
	@RequestMapping(value = "/DBM/addResData", method = RequestMethod.POST)
	public  String  addResData(ResFldInfo resFld,HttpServletRequest request,@RequestParam(required=false) MultipartFile[] myfiles){
		//判断该库的发布流程
		ResInfo resInfo = dbmService.getResInfo(resFld.getResId());
		String Flag="0";
		if(resInfo.getResFlow()==0){ //1.需审 0.直接发布
			Flag="1";//直接发布
		}
		//获取当前操作的用户
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		int userId = user.getUserId();
		String sql=" Insert into `"+dbmService.getResInfo(resFld.getResId()).getResTblName()+"` ";
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
	                fields+=resFldInfo.getFldName()+",";
	                values+="'',";
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
		//将复制文本的字体统一为宋体，防止录入数据错误问题
		values = values.replaceAll("font-family:'[a-zA-Z\\s]*'", "font-family:宋体");
		sql+=fields +values ;
		
		dbmService.addData(jt, sql);
		return "redirect:/DBM/PageData-"+request.getParameter("resId")+".html";
	}
	
	/**
	 * 修改某个资源库的数据
	 * @param tableName
	 * @throws RemoteException 
	 */
	@RequestMapping(value = "/DBM/EditResData-{ResId}-{Id}", method = RequestMethod.POST)
	public  String  editData(@PathVariable String ResId,@PathVariable String Id,ResFldInfo resFld,HttpServletRequest request,@RequestParam(required=false) MultipartFile[] myfiles) throws RemoteException{
		String currentPage = request.getParameter("currentPage");
		//获取资源库的物理表名
		ResInfo resInfo = dbmService.getResInfo(resFld.getResId());

		String sql=" update `"+resInfo.getResTblName()+"` set ";
		
		sql+=" editTime='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"', ";
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
		dbmService.addData(jt, sql);
		
		String pubflag = request.getParameter("pubflag");
		if(null!=pubflag || "".equals(pubflag)){
			//修改pubflag
			String sql2=" update `"+resInfo.getResTblName()+"` set pubflag = '"+request.getParameter("pubflag")+"' where id="+Id;
			dbmService.addData(jt, sql2);
		}
		
		
		Map<String,Object> map = dbmService.getData(jt, resInfo.getResTblName(), Id);
		//审核通过后的数据更新至引擎
		if("1".equals(pubflag)||"1".equals(map.get("pubFlag")+"")){
			Boolean bool = true;
			if(resInfo.getResTblName().equals("wf_b_mi")){
				 //获取引擎中需要的资源库的字段
				 String[] fields = ResIndexField.WF_B_MI_Fields;
				 //获取引擎中的资源库的索引字段
				 String[] indexNames = ResIndexField.WF_B_MI_IndexNames;
				 //获取这条数据
				 
				//新建map
				 Map<String, Object> mapF = new HashMap<String, Object>();
				 
				 //循环给索引赋值
				 for (int j = 0;j<fields.length;j++) {
					 //判断是否联合索引（多个字段用,隔开）
					 if(fields[j].contains(":")){
						 String[] field1 = fields[j].split(":");
						 String con = "";
						 for (String string : field1) {
							con += map.get(string);
						 }
						 mapF.put(indexNames[j], con);
					 }else{
						 if("wf_creatTime".equals(fields[j])){
							 mapF.put(indexNames[j], map.get(fields[j]).toString().substring(0, 10));
						 }else{
							 mapF.put(indexNames[j], map.get(fields[j]));
						 }
						 
					 }
					 
				 }
			}else{
				// bool = esService.autoUpdateES(Id, "id,wf_title,WF_LANG,WF_RESOURCE_INDEX",resInfo.getResTblName());
			}
			if(bool){
				System.out.println("---------更新成功!---------");
			}else{
				System.out.println("---------fail!----------");
			}
		}
		
		return "redirect:/DBM/PageData-"+request.getParameter("resId")+".html?currentPage="+currentPage+"&numPerPage=10";
	}
	/*
	 * 删除数据
	 */
	@RequestMapping(value="/DBM/delData-{ResId}-{Id}")
	public String delData(HttpServletRequest request,@PathVariable String ResId,@PathVariable String Id){
		
		ResInfo resInfo = null;
		String talName = request.getParameter("talName");
		if (talName==null||"".equals(talName)) {
			resInfo = dbmService.getResInfo(Integer.parseInt(ResId));
		}else{
			resInfo = new ResInfo();
			resInfo.setResTblName(talName);
		}
		
		if(Integer.parseInt(ResId)==9)
		{
		ApplicationContext context = (ApplicationContext) request.getSession().getServletContext()
				.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");
		String sql = "update wf_b_elePublication set wf_by2='"+1+"'  where id="+Integer.parseInt(Id)+"";
		dbmService.addData(jt, sql);
		}else{
		//dbmService.delData(jt, resInfo.getResTblName(), Id);
			dbmService.delData1(jt, resInfo.getResTblName(), Id,"0");
		}
		return "redirect:/DBM/PageData-"+ResId+".html";
	}
	
	/*
	 * 删除多条数据
	 
	@RequestMapping(value="/DBM/delData-{ResId}-{Id}")
	public String deleteData(@PathVariable String ResId,@PathVariable String[] Id){
		
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(ResId));
		for(int i =0;i<Id.length;i++){
		dbmService.delData(jt, resInfo.getResTblName(), Id[i]);
		}
		return "redirect:/DBM/PageData-"+ResId+".html";
	}*/
	/**
	 * 原文传递请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/tswx-{id}")
	public ModelAndView tswxRequest(@PathVariable int id){
		ModelAndView view = new ModelAndView();
		//获取文献详情
		List list = resDataService.queryDataById("tsk_wenxian", id);
		Map map = (Map) list.get(0);
		
		view.addObject("map", map);
		view.setViewName("/ywqq");
		return view;
	}
	/*
	 * 原文请求的提交
	 */
	/*@RequestMapping(value="/ywqq/tj")
	public String meetList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		//获取当前用户
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		int userId = user.getUserId();
		
		ServletContext servletContext = request.getSession().getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		JdbcTemplate jt = (JdbcTemplate) context.getBean("jdbcTemplate");

		String wxid = request.getParameter("wxid");
		String wxmc = request.getParameter("wxmc");
		String name = request.getParameter("username");
		String phone = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		String sql ="insert into original_transfer (pubFlag,createTime,editTime,userId,wx_name,wx_id,req_person,phone,email) values("
				+ "0, '"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ "','"+userId+ "'"
				+ ",'"+wxmc+ "'"
				+ ",'"+wxid+ "'"
				+ ",'"+name+ "'"
				+ ",'"+phone+ "'"
				+ ",'"+email+ "'"
				+ ")";
		int i = jt.update(sql);
		String msg;
		if(i>=1){
			msg="请求成功！请等候管理员处理。";
		}else{
			msg="请求失败，请与管理员联系！";
		}
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		//response.setHeader("refresh", "2;url='"+basePath+"/index.html'"); 
		out.println(msg+"&nbsp;&nbsp;2秒后关闭。。");
		out.println("<script type=\"text/javascript\">");
		//out.println("setTimeout('window.history.go(-2)', 3000);");
		out.println("setTimeout('window.close()',3000);");
        //out.println("alert(" + msg + ");");  
        out.println("</script>"); 
         
        return null;
	}*/
	
	/**
	 * 查看某一交流会的参会人
	 * @param meetid
	 * @param pageNo
	 * @return
	 */
	/*@RequestMapping(value = "/DBM/meetjoin-{meetid}", method = RequestMethod.GET)
	public ModelAndView queryJoin(@PathVariable int meetid,@RequestParam(value = "pageNo", required = false) Integer pageNo){
		ModelAndView view = new ModelAndView();
		
		List list = resDataService.queryDataById("meet", meetid);
		Map meetmap = (Map) list.get(0);
		String where =" meetid= "+meetid;
		pageNo = pageNo==null?1:pageNo;
		Pagination pagination = resDataService.queryPageDataByWhere("meet_join", where, pageNo, CommonConstant.PAGE_SIZE, false);
		
		view.addObject("meetid", meetid);
		view.addObject("meetmap", meetmap);
		view.addObject("pagination", pagination);
		view.setViewName("/DBM/joinErList");
		return view;
	}*/
	
	/**
	 * 审核信息详情
	 * @return
	 */
	@RequestMapping(value="/DBM/CheckDataDetail-{resId}-{Id}",method=RequestMethod.GET)
	public ModelAndView CheckDataDetail(@PathVariable String resId,@PathVariable String Id,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		
		String pubFlag = request.getParameter("pubFlag");
		String resFlow = request.getParameter("resFlow");
		String fldName = request.getParameter("fldName");
		String keyword2 = request.getParameter("keyword2");
		String isGather = request.getParameter("isGather");
		String currentPage = request.getParameter("currentPage");
		String deleted = request.getParameter("deleted");
		if(keyword2!=null){
			keyword2 = keyword2.trim();
		}
		if (pubFlag==null) {
			pubFlag = "";
		}
		if (isGather==null) {
			isGather = "";
		}
		HttpSession session = request.getSession();
		session.setAttribute("fldName", fldName);
		session.setAttribute("pubFlag", pubFlag);
		session.setAttribute("resFlow", resFlow);
		session.setAttribute("keyword2", keyword2);
		session.setAttribute("isGather", isGather);
		session.setAttribute("deleted", deleted);
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		view.addObject("resInfo", resInfo);
		
		//根据resId和ID找出该记录
		String tname=dbmService.getResInfo(Integer.parseInt(resId )).getResTblName();
		Map<String, Object> map = new HashMap<String, Object>();
		map=dbmService.getData(jt, tname, Id);
		List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(resId));
		
		//查询特色库类别信息
		ResInfo resInfo2 = dbmService.getResInfo(Integer.parseInt(resId));
		//List cateList = resDataService.selectAllData(resInfo2.getResTblName());
		//view.addObject("cateList",cateList);
		
		//获取当前{ResId}的记录
		ResInfo ri = dbmService.getResInfo(Integer.parseInt(resId));
		//因为textarea标签嵌套，会导致样式混乱，所以用<!--textarea 替代<textarea , textarea-->替换textarea>
		if(ri.getResTemplate() != null){
			String temp = ri.getResTemplate().replace("<!--textarea", "<textarea");;
			temp = temp.replace("textarea-->", "textarea>");
			for (int i = 0; i < lstFld.size(); i++) {
				String fieldName = lstFld.get(i).getFldName();
				Object obj = map.get(fieldName);
				if(obj != null && !obj.toString().equals("")){
					temp = temp.replace("[" + fieldName + "]",obj.toString());
				}else{
					temp = temp.replace("[" + fieldName + "]","");
				}
			}
			//List li = regStr(temp);
			ri.setResTemplate(temp);
		}
		List<ResFldInfo> lstFldNew = dbmService.ListResFldNew(Integer.parseInt(resId));
		view.addObject("MIDataBase",resDataService.getMIDataBase());
		view.addObject("list",lstFldNew);
		view.addObject("FldList",lstFld);
		view.addObject("resId",resId);
		view.addObject("dataMap",map);
		view.addObject("ri", ri);
		view.addObject("tname",tname);
		view.addObject("currentPage",currentPage);
		view.setViewName("/DBM/CheckDetail");
		return view;
	
	}
	
	/**
	 * 批量操作
	 */
	@RequestMapping(value="/DBM/piliang-{resId}")
	public String piliang(@PathVariable String resId,HttpServletRequest request) throws RemoteException{
		
		String pubFlag = request.getParameter("pubFlag");
		String resFlow = request.getParameter("resFlow");
		String fldName = request.getParameter("fldName");
		String keyword2 = request.getParameter("keyword2");
		String isGather = request.getParameter("isGather");
		String deleted = request.getParameter("deleted");
		String currentPage = request.getParameter("currentPage");
		
		if(keyword2!=null){
			keyword2 = keyword2.trim();
		}
		if (pubFlag==null) {
			pubFlag = "";
		}
		if (isGather==null) {
			isGather = "";
		}
		HttpSession session = request.getSession();
		session.setAttribute("fldName", fldName);
		session.setAttribute("pubFlag", pubFlag);
		session.setAttribute("resFlow", resFlow);
		session.setAttribute("keyword2", keyword2);
		session.setAttribute("isGather", isGather);
		session.setAttribute("deleted", deleted);
		
		String zhixingCon = request.getParameter("zhixingCon");
		String talName = request.getParameter("talName");
		String ids = request.getParameter("ids");
		String[] id = ids.split(",");
		if ("0".equals(zhixingCon)) {//批量审核通过
			dbmService.setPubFlagPiLiang(talName, "1", id);
			for (String string : id) {
				updateESDATA(Integer.parseInt(resId), string);
			}
			
		}else if ("1".equals(zhixingCon)) {//批量审核不通过
			dbmService.setPubFlagPiLiang(talName, "2", id);
		}else if ("2".equals(zhixingCon)) {//批量删除
			for (String string : id) {
				delData(request, resId, string);
			}
		}else if ("3".equals(zhixingCon)){//批量恢复
			for (String string : id) {
				recoverData(request, resId, string);
			}
		}
		
		return "redirect:/DBM/PageData-"+resId+".html?numPerPage=10&currentPage="+currentPage;
	}
	
	/*
	 * 恢复数据
	 */
	@RequestMapping(value="/DBM/recoverData-{resId}-{id}")
	public String recoverData(HttpServletRequest request,@PathVariable String resId,@PathVariable String id){
		String tableName = request.getParameter("talName");
		String currentPage = request.getParameter("currentPage");
		dbmService.delData1(jt, tableName, id, "1");
		return "redirect:/DBM/PageData-"+resId+".html?currentPage="+currentPage;
	}
	
	
	/**
	 * 数据导出，导出检索结果的前10000条
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/DBM/exportjg-{resId}")
	public void writeResultToExcel(HttpServletRequest request,@PathVariable String resId,HttpServletResponse response) throws IOException{
		//String where = (String) request.getSession().getAttribute("where");
		//String where=" a.zongname like '%学%' and a.title like '%学%' ";
		//String resId = (String) request.getSession().getAttribute("resId");
		//查询资源库，，获取该库字段
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		List<ResFldInfo> listResFld = dbmService.ListResFld(resInfo.getResId());
		//获取查询条件
		String where = (String) request.getSession().getAttribute("batchwhere");
		//获取库记录
		
		List<Map<String, Object>> result = resDataService.selectDataByWhere(resInfo.getResTblName(),where);
		
		if(result==null||result.size()<=0){
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script type=\"text/javascript\">");  
		    out.println("alert('查询结果为空!')");
		    out.println("window.history.go(-1)");
		    out.println("</script>");
		    out.flush();
		    return;
		    
		}else{
			//SXSSFWorkbook swb = new SXSSFWorkbook();
			HSSFWorkbook wb = new HSSFWorkbook();
			//设定每页的最大数据行为20000
			for(int i=0;i<(result.size()/20000+1);i++){
				HSSFSheet sheet = wb.createSheet("sheet"+i);
				HSSFRow row = sheet.createRow(0);
				
				HSSFCellStyle cellStyle = wb.createCellStyle();
				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				//设置首行列标题
				for(int y=0;y<listResFld.size();y++){
					HSSFCell cell = row.createCell(y);
					ResFldInfo resFldInfo = listResFld.get(y);
					cell.setCellValue(resFldInfo.getFldDesc());
					 cell.setCellStyle(cellStyle);
				}
				
				
		        for (int j = 0; j < 20000; j++) {
		        	if((j+i*20000)<result.size()){
			            row = sheet.createRow(j + 1);
			            Map<String, Object> map = result.get(j+i*20000);
			            for(int y=0;y<listResFld.size();y++){
							HSSFCell cell = row.createCell(y);
							ResFldInfo resFldInfo = listResFld.get(y);
							Object object = map.get(resFldInfo.getFldName());
							String value="";
							if(object!=null&&!object.equals("null")){
								value=object.toString();
							}
							if(value.length()>32767){
								value=value.substring(0,32767);
							};
							cell.setCellValue(value);
							cell.setCellStyle(cellStyle);
						}
			            
			            //NewsInfo info =  (NewsInfo) result.get(j+i*20000);
			            
			            // 第四步，创建单元格，并设置值  
			            /*row.createCell(0).setCellValue(info.getZongName());
			            row.createCell(1).setCellValue(info.getJuanName());
			            row.createCell(2).setCellValue(info.getTitle());*/
			            /*row.createCell(3).setCellValue(info.getInfoId());*/
		        	}
		        }
			}
			
	       
	        //response.setContentType("application/x-ms-excel");application/ms-excel
			response.setContentType("application/x-msdownload");
	        response.setHeader("content-disposition",
	        "attachment; filename="+resInfo.getResName()+".xls");
			
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.close();
			return;
		}
	}

	
	private void updateESDATA(Integer resId,String Id) throws RemoteException{
		boolean bool = false;
		ResInfo resInfo = dbmService.getResInfo(resId);
		if(resInfo.getResTblName().equals("wf_b_mi")){
			 //获取引擎中需要的资源库的字段
			 String[] fields = ResIndexField.WF_B_MI_Fields;
			 //获取引擎中的资源库的索引字段
			 String[] indexNames = ResIndexField.WF_B_MI_IndexNames;
			 //获取这条数据
			 Map<String,Object> map = dbmService.getData(jt, resInfo.getResTblName(), Id);
			 
			//新建map
			 Map<String, Object> mapF = new HashMap<String, Object>();
			 
			 //循环给索引赋值
			 for (int j = 0;j<fields.length;j++) {
				 //判断是否联合索引（多个字段用,隔开）
				 if(fields[j].contains(":")){
					 String[] field1 = fields[j].split(":");
					 String con = "";
					 for (String string : field1) {
						con += map.get(string);
					 }
					 mapF.put(indexNames[j], con);
				 }else{
					 if("wf_creatTime".equals(fields[j])){
						 mapF.put(indexNames[j], map.get(fields[j]).toString().substring(0, 10));
					 }else{
						 mapF.put(indexNames[j], map.get(fields[j]));
					 }
					 
				 }
				 
			 }
			 //bool = esService.autoUpdateES(Id,resInfo.getIndexName(),mapF);
		}else{
			// bool = esService.autoUpdateES(Id, "id,wf_title,WF_LANG,WF_RESOURCE_INDEX",resInfo.getResTblName());
		}
		
	}
}
