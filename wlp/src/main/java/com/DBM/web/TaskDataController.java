package com.DBM.web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.CommonConstant;
import com.DBM.cons.TaskTypes;
import com.DBM.dao.Page;
import com.DBM.domain.ResFldInfo;
import com.DBM.domain.TaskData;
import com.DBM.domain.User;
import com.DBM.service.DBMService;
import com.DBM.service.ResInfoService;
import com.DBM.service.TaskDataService;
import com.DBM.service.UserService;

@Controller
@RequestMapping("/manage")
public class TaskDataController {
	@Autowired
	TaskDataService taskDataService;
	@Autowired
	ResInfoService resInfoService;
	@Autowired
	UserService userService;
	@Autowired
	DBMService dbmService;
	
	private static ApplicationContext context = null;
	private static JdbcTemplate jt=null;
	
	public TaskDataController() {
		super();
		// TODO Auto-generated constructor stub
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jt = (JdbcTemplate)context.getBean("jdbcTemplate");	
		
	}
	
	@RequestMapping( value="/taskData/taskDataList")
	public ModelAndView toTaskDate(Integer pageNo,TaskData taskData,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		pageNo = pageNo==null?1:pageNo;
		
		if(taskData == null){
			taskData = new TaskData();
		}
		
		String handBeginTime1 = request.getParameter("handBeginTime1");
		String handEndTime1 = request.getParameter("handEndTime1");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (handBeginTime1!=null&&!"".equals(handBeginTime1)) {
			try {
				
				taskData.setHandBeginTime(sdf.parse(handBeginTime1+" 00:00:00"));
			} catch (ParseException e) {
				taskData.setHandBeginTime(null);
			}
		}
		if (handEndTime1!=null&&!"".equals(handEndTime1)) {
			try {
				taskData.setHandEndTime(sdf.parse(handEndTime1+" 23:59:59"));
			} catch (ParseException e) {
				taskData.setHandEndTime(null);
			}
		}
		
		List<Map<String, String>> listTypes = new ArrayList<Map<String,String>>(); 
		for (TaskTypes types : TaskTypes.values()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("typeId", types.getTypeId());
			map.put("typeName", types.name());
			listTypes.add(map);
		}
		
		Page page = taskDataService.getPageList(taskData, pageNo, 10);
		List<Double> completionList = new ArrayList<Double>();
		for (Object object : page.getResult()) {
			TaskData taskData1 = (TaskData) object;
			Object o = null;
			
			//文章为数量，不是范围
			if ("2".equals(taskData1.getTaskWay())) {
				o = taskDataService.getAllAndYesDataNum2(taskData1.getTaskTableName(), taskData1.getTaskUserId(), taskData1.getTaskResIds());
			}else{
				o = taskDataService.getAllAndYesDataNum(taskData1.getTaskTableName(),taskData1.getTaskUserId(),taskData1.getResBegin(),taskData1.getResEnd());
			}
			//List list1 = (List) listNums.get(0);
			Object[] listStr = (Object[]) o;
			
			Double allNum = 0.00;
			Double checkNum = 0.00;
			if (listStr[0]!=null) {
				allNum = Double.parseDouble(listStr[0].toString());
			}
			if (listStr[1]!=null) {
				checkNum = Double.parseDouble(listStr[1].toString());
			}
			//完成度	
			Double completion = 0.00;
			if (allNum>0) {
				//四舍五入保存两位小数
				BigDecimal b = new BigDecimal((checkNum/allNum)*100);  
				completion = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
			}
			completionList.add(completion);
		}
		modelAndView.addObject("completionList",completionList);
		modelAndView.addObject("taskTypes",listTypes);
		modelAndView.addObject("taskData",taskData);
		//所有资源库信息
		modelAndView.addObject("resAll",resInfoService.getResInfoDao().ListAllRes());
		modelAndView.addObject("pageTaskData",page);
		modelAndView.setViewName("manage/taskData/taskDataList");
		return modelAndView;
	}

	@RequestMapping( value="/taskData/taskDataListAdd")
	public ModelAndView toTaskDataListAdd(){
		ModelAndView modelAndView = new ModelAndView();
		
		List<Map<String, String>> listTypes = new ArrayList<Map<String,String>>(); 
		for (TaskTypes types : TaskTypes.values()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("typeId", types.getTypeId());
			map.put("typeName", types.name());
			listTypes.add(map);
		}
		
		//modelAndView.addObject("taskUsers",userService.getUsersByOPURL("/DBM/resourceManage.html"));
		
		//获取所有的数据审核员(9是数据审核员的id)
		modelAndView.addObject("taskCheckUsers",userService.getUsersByRoleId(9));
		//获取所有的数据编辑员(10是数据审核员的id)
		modelAndView.addObject("taskUpdateUsers",userService.getUsersByRoleId(10));
		//所有资源库信息
		modelAndView.addObject("resAll",resInfoService.getResInfoDao().ListAllRes());
		//需要审核的资源库信息
		modelAndView.addObject("resChecks",resInfoService.getRessByResFlow(1));
		modelAndView.addObject("taskTypes",listTypes);
		modelAndView.setViewName("manage/taskData/taskDataListAdd");
		return modelAndView;
	}
	
	@RequestMapping( value="/taskData/taskDataAdd")
	public ModelAndView taskDataAdd(TaskData taskData,HttpServletRequest request){
		String handBeginTime1 = request.getParameter("handBeginTime2");
		String handEndTime1 = request.getParameter("handEndTime2");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (handBeginTime1!=null&&!"".equals(handBeginTime1)) {
			try {
				
				taskData.setHandBeginTime(sdf.parse(handBeginTime1+" 00:00:00"));
			} catch (ParseException e) {
				taskData.setHandBeginTime(null);
			}
		}
		if (handEndTime1!=null&&!"".equals(handEndTime1)) {
			try {
				taskData.setHandEndTime(sdf.parse(handEndTime1+" 00:00:00"));
			} catch (ParseException e) {
				taskData.setHandEndTime(null);
			}
		}
		
		if (taskData.getId()==null) {
			taskData.setCreatTime(new Date());
		}else{
			String creatTime2 = request.getParameter("creatTime2");
			
			try {
				taskData.setCreatTime(sdf.parse(creatTime2));
			} catch (ParseException e) {
				taskData.setCreatTime(new Date());
			}
		}
		
		//获取任务id 
		Integer taskId = Integer.parseInt(taskDataService.getId().toString());
		
		//taskWay：1表示输入范围，2表示输入数量
		if("1".equals(taskData.getTaskWay())){
			if ("1".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的审核者id
				dbmService.addCheckedUserId(jt, taskData.getTaskTableName(), taskData.getResBegin(), taskData.getResEnd(), taskData.getTaskUserId(),taskId);
			}else if ("2".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的编辑者id
				dbmService.addUpdatedUserId(jt, taskData.getTaskTableName(), taskData.getResBegin(), taskData.getResEnd(), taskData.getTaskUserId(),taskId);
			}
		}else if("2".equals(taskData.getTaskWay())){
			String where = null;
			String ids = null;
			if ("1".equals(taskData.getTaskType())) {
				where = " where checkedUserId is null and (pubFlag is null or pubFlag = 0) ";
			}else{
				where = " where updatedUserId is null and (pubFlag is null or pubFlag = 0) ";
			}
			
			if (taskData.getTaskIsGather()!=null&&!taskData.getTaskIsGather().equals("")) {
				where += " and isGather ="+taskData.getTaskIsGather();
			}
			if (taskData.getTaskResKeyword()!=null&&!taskData.getTaskResKeyword().equals("")) {
				where += " and "+taskData.getTaskResFldName()+" like '%"+taskData.getTaskResKeyword()+"%'";
			}
			
			if ("1".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的审核者id
				ids = dbmService.addCheckedUserIdByresNums(jt, taskData.getTaskTableName(), where, taskData.getTaskResNums(), taskData.getTaskUserId(),taskId);
			}else if ("2".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的编辑者id
				ids = dbmService.addUpdatedUserIdByresNums(jt, taskData.getTaskTableName(), where, taskData.getTaskResNums(), taskData.getTaskUserId(),taskId);
			}
			taskData.setTaskResIds(ids);
		}
		//添加任务管理
		taskDataService.addTaskData(taskData);
		return toTaskDate(1, null, request);
	}
	
	@RequestMapping( value="/taskData/taskDataUpdate")
	public ModelAndView taskDataUpdate(TaskData taskData,HttpServletRequest request){
		String handBeginTime1 = request.getParameter("handBeginTime2");
		String handEndTime1 = request.getParameter("handEndTime2");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (handBeginTime1!=null&&!"".equals(handBeginTime1)) {
			try {
				taskData.setHandBeginTime(sdf.parse(handBeginTime1+" 00:00:00"));
			} catch (ParseException e) {
				taskData.setHandBeginTime(null);
			}
		}
		if (handEndTime1!=null&&!"".equals(handEndTime1)) {
			try {
				taskData.setHandEndTime(sdf.parse(handEndTime1+" 00:00:00"));
			} catch (ParseException e) {
				taskData.setHandEndTime(null);
			}
		}
		String creatTime2 = request.getParameter("creatTime2");
		try {
			taskData.setCreatTime(sdf.parse(creatTime2));
		} catch (ParseException e) {
			taskData.setCreatTime(new Date());
		}
		
		
		//taskWay：1表示输入范围，2表示输入数量
		if("1".equals(taskData.getTaskWay())){
			
			//删除原来的
			String begin = request.getParameter("begin");
			String end = request.getParameter("end");
			
			
			if ("1".equals(taskData.getTaskType())) {
				dbmService.addCheckedUserId(jt, taskData.getTaskTableName(), begin, end, null,null);
				//添加对应资源库的对应数据的审核者id
				dbmService.addCheckedUserId(jt, taskData.getTaskTableName(), taskData.getResBegin(), taskData.getResEnd(), taskData.getTaskUserId(),taskData.getId());
			}else if ("2".equals(taskData.getTaskType())) {
				dbmService.addUpdatedUserId(jt, taskData.getTaskTableName(), begin, end, null,null);
				//添加对应资源库的对应数据的编辑者id
				dbmService.addUpdatedUserId(jt, taskData.getTaskTableName(), taskData.getResBegin(), taskData.getResEnd(), taskData.getTaskUserId(),taskData.getId());
			}
		}else if("2".equals(taskData.getTaskWay())){
			String idss = request.getParameter("ids");
			//先清除
			if ("1".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的审核者id
				dbmService.delCheckUserId(jt, taskData.getTaskTableName(), idss);
			}else if ("2".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的编辑者id
				dbmService.delUpdatedUserId(jt, taskData.getTaskTableName(), idss);
			}
			
			String where = null;
			String ids = null;
			if ("1".equals(taskData.getTaskType())) {
				where = " where checkedUserId is null and (pubFlag is null or pubFlag = 0) ";
			}else{
				where = " where updatedUserId is null and (pubFlag is null or pubFlag = 0) ";
			}
			
			if (taskData.getTaskIsGather()!=null&&!taskData.getTaskIsGather().equals("")) {
				where += " and isGather ="+taskData.getTaskIsGather();
			}
			if (taskData.getTaskResKeyword()!=null&&!taskData.getTaskResKeyword().equals("")) {
				where += " and "+taskData.getTaskResFldName()+" like '%"+taskData.getTaskResKeyword()+"%'";
			}
			
			if ("1".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的审核者id
				ids = dbmService.addCheckedUserIdByresNums(jt, taskData.getTaskTableName(), where, taskData.getTaskResNums(), taskData.getTaskUserId(),taskData.getId());
			}else if ("2".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的编辑者id
				ids = dbmService.addUpdatedUserIdByresNums(jt, taskData.getTaskTableName(), where, taskData.getTaskResNums(), taskData.getTaskUserId(),taskData.getId());
			}
			taskData.setTaskResIds(ids);
		}
		//添加任务管理
		taskDataService.addTaskData(taskData);
		return toTaskDate(1, null, request);
	}
	
	@RequestMapping( value="/myTaskData/taskDataList")
	public ModelAndView toMyTaskDate(Integer pageNo,TaskData taskData,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		pageNo = pageNo==null?1:pageNo;
		
		if(taskData == null){
			taskData = new TaskData();
		}
		taskData.setTaskUserId(user.getUserId());
		String handBeginTime1 = request.getParameter("handBeginTime1");
		String handEndTime1 = request.getParameter("handEndTime1");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (handBeginTime1!=null&&!"".equals(handBeginTime1)) {
			try {
				
				taskData.setHandBeginTime(sdf.parse(handBeginTime1+" 00:00:00"));
			} catch (ParseException e) {
				taskData.setHandBeginTime(null);
			}
		}
		if (handEndTime1!=null&&!"".equals(handEndTime1)) {
			try {
				taskData.setHandEndTime(sdf.parse(handEndTime1+" 23:59:59"));
			} catch (ParseException e) {
				taskData.setHandEndTime(null);
			}
		}
		
		List<Map<String, String>> listTypes = new ArrayList<Map<String,String>>(); 
		for (TaskTypes types : TaskTypes.values()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("typeId", types.getTypeId());
			map.put("typeName", types.name());
			listTypes.add(map);
		}
		modelAndView.addObject("taskTypes",listTypes);
		modelAndView.addObject("taskData",taskData);
		//所有资源库信息
		modelAndView.addObject("resAll",resInfoService.getResInfoDao().ListAllRes());
		modelAndView.addObject("pageTaskData",taskDataService.getMyPageList(taskData, pageNo, 10));
		modelAndView.setViewName("manage/taskData/myTaskDataList");
		return modelAndView;
	}
	@RequestMapping( value="/taskData/delTaskData")
	public ModelAndView delTaskData(TaskData taskData,HttpServletRequest request){
		//还原资源库信息
		TaskData taskDataN = taskDataService.getTaskDataById(taskData.getId());
		if (taskDataN==null) {
			return toTaskDate(1, null, request);
		}
		if(taskDataN.getTaskWay().equals("1")){
			if ("1".equals(taskDataN.getTaskType())) {
				//添加对应资源库的对应数据的审核者id
				dbmService.addCheckedUserId(jt, taskData.getTaskTableName(), taskData.getResBegin(), taskData.getResEnd(), null,null);
			}else if ("2".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的编辑者id
				dbmService.addUpdatedUserId(jt, taskData.getTaskTableName(), taskData.getResBegin(), taskData.getResEnd(), null,null);
			}
		}else{
			if ("1".equals(taskDataN.getTaskType())) {
				//添加对应资源库的对应数据的审核者id
				dbmService.delCheckUserId(jt, taskDataN.getTaskTableName(), taskDataN.getTaskResIds());
			}else if ("2".equals(taskData.getTaskType())) {
				//添加对应资源库的对应数据的编辑者id
				dbmService.delUpdatedUserId(jt, taskDataN.getTaskTableName(), taskDataN.getTaskResIds());
			}
		}
		
		taskDataService.delTaskData(taskDataN);
		return toTaskDate(1, null, request);
	}
	
	@RequestMapping( value="/taskData/toUpdateTaskData")
	public ModelAndView delTaskData(Integer id,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		TaskData taskData = taskDataService.getTaskDataById(id);
		modelAndView.addObject("taskData",taskData);
		
		List<Map<String, String>> listTypes = new ArrayList<Map<String,String>>(); 
		for (TaskTypes types : TaskTypes.values()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("typeId", types.getTypeId());
			map.put("typeName", types.name());
			listTypes.add(map);
		}
		
		
		//获取所有的数据审核员(9是数据审核员的id)
		modelAndView.addObject("taskCheckUsers",userService.getUsersByRoleId(9));
		//获取所有的数据编辑员(10是数据审核员的id)
		modelAndView.addObject("taskUpdateUsers",userService.getUsersByRoleId(10));
		//所有资源库信息
		modelAndView.addObject("resAll",resInfoService.getResInfoDao().ListAllRes());
		//需要审核的资源库信息
		modelAndView.addObject("resChecks",resInfoService.getRessByResFlow(1));
		modelAndView.addObject("taskTypes",listTypes);
		modelAndView.setViewName("manage/taskData/taskDataListUpdate");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping( value="/taskData/getFldByresId")
	public List<ResFldInfo> getFldByresId(Integer resId){
		//可检索字段
		List<ResFldInfo> lstFld=dbmService.ListResFld(resId);
		List<ResFldInfo> searchFldList = new ArrayList<>();
		for (ResFldInfo resFldInfo : lstFld) {
			if(resFldInfo.getFldSearch()==1)
				searchFldList.add(resFldInfo);
		};
		return searchFldList;
	}
	
	@ResponseBody
	@RequestMapping( value="/taskData/getNoCheckNum")
	public Integer getNoCheckNum(HttpServletRequest request){
		String taskType = request.getParameter("taskType");
		String resTalbeName = request.getParameter("resTalbeName");
		String isGather = request.getParameter("isGather");
		String keyword = request.getParameter("keyword");
		String fldName = request.getParameter("fldName");
		String where = null;
		if (TaskTypes.数据审核.getTypeId().equals(taskType)) {
			where = " where checkedUserId is null ";
		}else{
			where = " where updatedUserId is null ";
		}
		if (resTalbeName==null||resTalbeName.equals("")) {
			return 0;
		}
		if (isGather!=null&&!isGather.equals("")) {
			where += " and isGather = "+isGather;
		}
		if (keyword!=null&&!keyword.equals("")) {
			where += " and "+fldName+" like '%"+keyword+"%'";
		}
		
		where += " and (pubFlag is null or pubFlag = 0)";
		return dbmService.getNoCheckNum(jt,resTalbeName,where);
	}
}
