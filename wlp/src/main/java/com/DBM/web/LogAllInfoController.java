package com.DBM.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.LogTypeEnum;
import com.DBM.domain.LogAllInfo;
import com.DBM.domain.ResInfo;
import com.DBM.service.LogAllInfoService;
import com.DBM.service.ResInfoService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
@RequestMapping("/manage/logAllInfo")
public class LogAllInfoController {
	@Autowired
	LogAllInfoService logAllInfoService;
	@Autowired
	ResInfoService resInfoService;
	
	private Configuration configuration = null;
	public LogAllInfoController(){
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	
	@RequestMapping(value = "/toLogManage")
	public ModelAndView paged(String logType,String userName,String startTime,String endTime,Integer pageNo,HttpServletRequest request) throws ParseException{
		ModelAndView modelAndView = new ModelAndView();
		//设置基本值进入页面
		modelAndView.addObject("logType",logType);
		modelAndView.addObject("userName",userName);
		modelAndView.addObject("startTime",startTime);
		modelAndView.addObject("endTime",endTime);
		
		/*DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime1 = null;
		Date endTime1 = null;*/
		
		if (startTime!=null&&!"".equals(startTime)) {
			startTime += " 00:00:00";
			//startTime1 = fmt.parse(startTime);
		}
		if (endTime!=null&&!"".equals(endTime)) {
			endTime += " 23:59:59";
			//endTime1 = fmt.parse(endTime);
		}
		
		pageNo = pageNo==null?1:pageNo;
		
		//设置枚举日志类型进入前台控制页面
		List<Map<String,Object>> logTypeList = new ArrayList<Map<String,Object>>();
		for (LogTypeEnum l : LogTypeEnum.values()) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", l.name());
			map.put("typeId", l.toInt());
			logTypeList.add(map);
		}
		
		
		
		modelAndView.addObject("pagedLogs", logAllInfoService.getPageLogAllInfoBySearch(logType, userName, startTime, endTime, pageNo, 10));
		modelAndView.addObject("logTypes",logTypeList);
		//所有资源库信息
		modelAndView.addObject("resAll",resInfoService.getResInfoDao().ListAllRes());
		modelAndView.setViewName("/manage/logManage/logManage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/downloadLogManage")
	public void downloadLogManage(String logType,String userName,String startTime,String endTime,HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException{
		
		String path = request.getSession().getServletContext().getRealPath("/");//获取服务器项目路径
		/*DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime1 = null;
		Date endTime1 = null;*/
		
		if (startTime!=null&&!"".equals(startTime)) {
			startTime += " 00:00:00";
			//startTime1 = fmt.parse(startTime);
		}
		if (endTime!=null&&!"".equals(endTime)) {
			endTime += " 23:59:59";
			//endTime1 = fmt.parse(endTime);
		}
		
		//设置日志类型
		Map<String,String> map = new HashMap<String, String>();
		for (LogTypeEnum l : LogTypeEnum.values()) {
			map.put("typeId"+l.toInt(), l.name());
		}
		
		//获取所有的资源库
		List<ResInfo> listRes = resInfoService.getResInfoDao().ListAllRes();
		
		List<LogAllInfo> list = logAllInfoService.getAllLogAllInfoBySearch(logType, userName, startTime, endTime);
		
		//设置日志类型和访问资源
		String[] resArray = null;
		String resName= "";
		for (LogAllInfo logAllInfo : list) {
			logAllInfo.setLogTypeName(map.get("typeId"+logAllInfo.getLogType()).replace("<", "&lt;").replace(">", "&gt;"));
			
			if (logAllInfo.getLogRes()==null) {
				resArray = new String[]{""};
			}else{
				//访问资源按逗号隔开
				resArray = logAllInfo.getLogRes().split(",");
			}
			for (String str : resArray) {
				//遍历所有资源库找到对应的表名，然后拼接写入访问资源中文
				c:for (ResInfo resInfo : listRes) {
					if (resInfo.getResTblName().equals(str)) {
						//开头没有逗号
						if ("".equals(resName)) {
							resName += resInfo.getResName();
						}else{
							resName += ","+resInfo.getResName();
						}
						break c;
					}
				}
			}
			if ("".equals(resName)) {
				if(logAllInfo.getLogRes()==null){
					logAllInfo.setLogResName("");
				}else{
					logAllInfo.setLogResName(logAllInfo.getLogRes().replace("<", "&lt;").replace(">", "&gt;"));
				}
			}else{
				logAllInfo.setLogResName(resName.replace("<", "&lt;").replace(">", "&gt;"));
			}
			
			//清空resName
			resName = "";
			
			//判断输出内容不能为null,null改为空串
			if (logAllInfo.getLogTypeName()==null) {
				logAllInfo.setLogTypeName("");
			}
			if (logAllInfo.getUserName()==null) {
				logAllInfo.setUserName("");
			}
			if (logAllInfo.getUserIp()==null) {
				logAllInfo.setUserIp("");
			}
			
			if (logAllInfo.getUserName()==null) {
				logAllInfo.setUserName("");
			}
			if (logAllInfo.getInput()!=null) {
				String input = "";
				String input111 = logAllInfo.getInput();
				input111 = input111.replaceAll("&apos;", "'");
				input111 = input111.replaceAll("&quot;", "\"");
				for(int i=0;i<input111.length();i=i+10){
					if ("".equals(input)) {
						if((i+9)>=input111.length()){
							input += input111.substring(i,input111.length()).replace("<", "&lt;").replace(">", "&gt;");
						}else{
							input += input111.substring(i,i+10).replace("<", "&lt;").replace(">", "&gt;");
						}
					}else{
						if((i+9)>=input111.length()){
							input += "<w:p></w:p>"+input111.substring(i,input111.length()).replace("<", "&lt;").replace(">", "&gt;");
						}else{
							input += "<w:p></w:p>"+input111.substring(i,i+10).replace("<", "&lt;").replace(">", "&gt;");
						}
					}
				}
				logAllInfo.setInput(input);
			}else{
				logAllInfo.setInput("");
			}
			
			if (logAllInfo.getOutput()==null) {
				logAllInfo.setOutput(0);
			}
			if (logAllInfo.getLogResName()==null) {
				logAllInfo.setLogResName("");
			}
			if (logAllInfo.getLogResTitle()==null) {
				logAllInfo.setLogResTitle("");
			}
			
			String title = logAllInfo.getLogResTitle();
			title = title.replaceAll("&apos;", "'");
			title = title.replaceAll("&quot;", "\"");
			String title1 = "";
			int lengthTitle = title.length();
			for(int i=0;i<lengthTitle;i=i+10){
				title1 = title1.replace("<", "&lt;").replace(">", "&gt;");
				if((i+10)>=lengthTitle){
					title1 += title.substring(i,title.length());
				}else{
					if(!"".equals(title1)){
						title1 += "<w:p></w:p>";
					}
					title1 += title.substring(i,i+10);
				}
			}
			logAllInfo.setLogResTitle(title1);
		}
		
		
		
		//先在本地创建文件

        Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//给word文件赋值
		SimpleDateFormat dateFormater1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat dateFormater2 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
	    dataMap.put("date", dateFormater1.format(new Date()));
	    dataMap.put("time", dateFormater2.format(new Date()));
	    dataMap.put("dataLogs", list);
	    
	    configuration.setClassForTemplateLoading(this.getClass(), "template/"); // FTL文件所存在的位置:放在和此类同一文件
	    Template template;
		try {
			template = configuration.getTemplate("日志报告.ftl");
			File outFile = new File(path+"/WEB-INF/template/日志报告.doc");
		    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
		    template.process(dataMap, out);
		    out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		//开始下载
		
		//获取目标文件的绝对路径
		//List<Map<String, Object>> onlineList = knowCenterService.getInfoByResIdAndFid(resId,f_id);
		String filePath = path+"/WEB-INF/template/日志报告.doc";
		//设置文件MIME类型
		response.setContentType(request.getSession().getServletContext().getMimeType("日志报告.doc"));
		//设置Content-Disposition  
		String file_name = new String("日志报告.doc".getBytes(), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+file_name); 
        //读取文件  
        InputStream in = new FileInputStream(filePath);  
        OutputStream out = response.getOutputStream();  
        //写文件  
        int b;  
        while((b=in.read())!= -1)  
        {  
            out.write(b);  
        }  
        in.close();  
        out.close(); 
	}
}
