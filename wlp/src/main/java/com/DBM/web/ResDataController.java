package com.DBM.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.CommonConstant;
import com.DBM.dao.Pagination;
import com.DBM.domain.ResFldInfo;
import com.DBM.domain.ResInfo;
import com.DBM.domain.User;
import com.DBM.domain.UserRoleInfo;
import com.DBM.service.AuthorityService;
import com.DBM.service.DBMService;
import com.DBM.service.ResDataService;
import com.DBM.service.UserService;

@Controller
public class ResDataController {
	@Resource
	private  ResDataService resDataService;
	@Autowired
	private DBMService dbmService;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private UserService userService;
	
	//private JsonSerializer JSONSerializer;
  
	/**  
		 * 分页查询所有
		 * @param request
		 * @param response 
		 */ 
		@RequestMapping(value = "/DBM/PageData-{ResId}")
		public ModelAndView queryPageBusiness(@PathVariable String ResId,HttpServletRequest request,HttpServletResponse response) {
			HttpSession session = request.getSession();
			String message = "";
			String status = "";
			String checkUsersNo = (String) session.getAttribute("checkUsersNo");
			String resFlow = (String) session.getAttribute("resFlow");
			String pubFlag = (String) session.getAttribute("pubFlag");
			String isGather = (String) session.getAttribute("isGather");
			String deleted = (String) session.getAttribute("deleted");
			String[] fldNames = (String[]) session.getAttribute("fldNames");
			String[] keyword2s = (String[]) session.getAttribute("keyword2s");
			String[] andORor = (String[]) session.getAttribute("andORor");
			
			if (deleted == null) {
				deleted = "1";
			}
			String where = " 1=1 ";;
			
			if ("1".equals(resFlow)&&!"".equals(pubFlag)) {
				//判断是否查询未审核
				if ("0".equals(pubFlag)) {
					where += " and (pubFlag = "+pubFlag+" or pubFlag is null) ";
				}else{
					where += " and pubFlag = "+pubFlag;
				}
			}
			
			if(checkUsersNo!=null&&!"".equals(checkUsersNo)&&!"undefined".equals(checkUsersNo)){
				 where += " and checkedUserId = "+checkUsersNo;
			}
			
			if (isGather!=null&&!"".equals(isGather)&&!"undefined".equals(isGather)) {
				 where += " and isGather = "+isGather;
			}
			if(!"".equals(deleted)&&!"undefined".equals(deleted)){
				where += " and deleted ="+deleted;
			}
			
			if (fldNames!=null) {
				String where1 = "";
				
				for (int i=0;i<fldNames.length;i++) {
					
					if("".trim().equals(keyword2s[i])){
						continue;
					}
					
					if (where1.equals("")) {
						where1 += " and ("+fldNames[i] +" like '%"+keyword2s[i]+"%'";
					}else{
						where1 += " "+andORor[i-1]+" "+fldNames[i] +" like '%"+keyword2s[i]+"%'";
					}
				}
				
				if (!"".equals(where1)) {
					where += where1+")";
				}
			}
			//存储查询条件用于批量操作
			request.getSession().setAttribute("batchwhere", where);
			
			//获取后台添加的字段
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
				if(currentPage==null||"null".equals(currentPage)) currentPage="";
				if(numPerPage==null||"null".equals(numPerPage)) numPerPage="";
				
				//获取字段要查询的字段并拼接
				String select = "";
				for (ResFldInfo resFldInfo : lstFld) {
					if(resFldInfo.getFldList()==1){
						select +=","+resFldInfo.getFldName();
					}
				}
				select += ",deleted,pubFlag,checkedUserId,updatedUserId";
				
				if("".equals(currentPage)||"".equals(numPerPage)){
						page =resDataService.queryPageBusinessAndWhere(select,resInfo.getResTblName(),where,user,1, 10);
				}else{ 
						page =resDataService.queryPageBusinessAndWhere(select,resInfo.getResTblName(),where,user,Integer.parseInt(currentPage), Integer.parseInt(numPerPage));
				} 
				List list=page.getResultList();
				businessList=new ArrayList<Map<String,Object>>(); 
				for (int i = 0,len=list.size();i<len; i++) {
					Map<String, Object> maps=new HashMap<String, Object>();
					Map mapRe=(Map)list.get(i); 
					maps.put("id", mapRe.get("id"));
					maps.put("f_id", mapRe.get("f_id"));
					//获取该库的所有字段，把列表可显示字段存入Map					
					for (ResFldInfo resFldInfo : lstFld) {
						if(resFldInfo.getFldList()==1)
							maps.put(resFldInfo.getFldName(), mapRe.get(resFldInfo.getFldName()));
					}
					maps.put("deleted", mapRe.get("deleted"));
					maps.put("pubFlag", mapRe.get("pubFlag"));
					maps.put("checkedUserId", mapRe.get("checkedUserId"));
					if(mapRe.get("checkedUserId")==null||"null".equals(mapRe.get("checkedUserId").toString())){
						maps.put("checkedUserName", "无");
					}else{
						maps.put("checkedUserName", userService.getUserById(Integer.parseInt(mapRe.get("checkedUserId").toString())).getUserName());
					}
					maps.put("updatedUserId", mapRe.get("updatedUserId"));
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

			ModelAndView view =new ModelAndView();
			//可检索字段
			List<ResFldInfo> searchFldList = new ArrayList<>();
			for (ResFldInfo resFldInfo : lstFld) {
				if(resFldInfo.getFldSearch()==1)
					searchFldList.add(resFldInfo);
			};
			
			
			//判断当前用户是否为超级管理员
			List<UserRoleInfo> roles = authorityService.getRoles(user.getUserId());
			
			boolean isAdmin = false;
			for (UserRoleInfo userRoleInfo : roles) {
				if(userRoleInfo.getRoleId()==1){
					isAdmin = true;
					break;
				};
			}
			
			if (fldNames!=null) {
				String fldNames2 = null;
				String keyword2s2 = null;
				String andORor2 = null;
				for (int i=0;i<fldNames.length;i++) {
					if (fldNames2==null) {
						if(i>0){
							andORor2 = andORor[i-1];
						}
						fldNames2 = fldNames[i];
						keyword2s2 = keyword2s[i];
					}else{
						if(i>0){
							andORor2 += ","+andORor[i-1];
						}
						fldNames2 += ","+fldNames[i];
						keyword2s2 += ","+keyword2s[i];
					}
				}
				view.addObject("fldNames", fldNames2);
				view.addObject("keyword2s", keyword2s2);
				view.addObject("andORor", andORor2);
			}
			
			//获取所有的审核人
			view.addObject("checkUsers",userService.getUsersByRoleId(9));
			
			view.addObject("isGather", isGather);
			view.addObject("deleted", deleted);
			view.addObject("isAdmin", isAdmin);
			view.addObject("pubFlag",pubFlag);
			view.addObject("searchFldList", searchFldList);
			view.addObject("resInfo",resInfo);
			view.addObject("page",map);
			view.addObject("ResId",ResId);
			view.addObject("dataList",businessList);
			view.addObject("lstFld",lstFld);
			view.setViewName("/DBM/ResData");
			return view;			
		} 
		
		@RequestMapping(value = "/DBM/searchData-{resId}")
		public ModelAndView searchData(@PathVariable String resId,HttpServletRequest request){
			ModelAndView view = new ModelAndView();
			String checkUsersNo = request.getParameter("checkUsersNo");
			String pubFlag = request.getParameter("pubFlag");
			String resFlow = request.getParameter("resFlow");
			String fldName = request.getParameter("fldName");
			String keyword2 = request.getParameter("keyword2");
			String isGather = request.getParameter("isGather");
			String deleted = request.getParameter("deleted");
			String[] fldNames = request.getParameterValues("fldNames");
			String[] keyword2s = request.getParameterValues("keyword2s");
			String[] andORor = request.getParameterValues("andORor");
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
			session.setAttribute("checkUsersNo", checkUsersNo);
			session.setAttribute("fldName", fldName);
			session.setAttribute("pubFlag", pubFlag);
			session.setAttribute("resFlow", resFlow);
			session.setAttribute("keyword2", keyword2);
			session.setAttribute("isGather", isGather);
			session.setAttribute("deleted", deleted);
			session.setAttribute("fldNames", fldNames);
			session.setAttribute("keyword2s", keyword2s);
			session.setAttribute("andORor", andORor);
			
			view.setViewName("forward:/DBM/PageData-"+resId+".html");
			return view;
		}
		/**
		 * 待审核数据列表
		 * @return
		 */
		@RequestMapping(value = "/DBM/CheckData-{ResId}")
		public ModelAndView goCheck(@PathVariable String ResId,HttpServletRequest request){
			ModelAndView view = new ModelAndView();
			
			String message = "";
			String status = ""; 
			List<ResFldInfo> lstFld=dbmService.ListResFld(Integer.parseInt(ResId));
			//获取要查询的表名
			ResInfo resInfo =dbmService.getResInfo(Integer.parseInt(ResId));
			
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
					page =resDataService.queryDataToCheck(resInfo.getResTblName(),1, 10);  
				}else{ 
					page =resDataService.queryDataToCheck(resInfo.getResTblName(),Integer.parseInt(currentPage), Integer.parseInt(numPerPage));  
				} 
				List list=page.getResultList();
				businessList=new ArrayList<Map<String,Object>>(); 
				for (int i = 0,len=list.size();i<len; i++) {
					Map<String, Object> maps=new HashMap<String, Object>();
					Map mapRe=(Map)list.get(i); 
					maps.put("id", mapRe.get("id"));
					
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

			view.addObject("MIDataBase",resDataService.getMIDataBase());
			view.addObject("resInfo",resInfo);
			view.addObject("page",map);
			view.addObject("ResId",ResId);
			view.addObject("dataList",businessList);
			view.addObject("lstFld",lstFld);
			view.setViewName("/DBM/CheckList");
			return view;
		}
		
		
		
		
}
