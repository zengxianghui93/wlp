package com.DBM.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.cons.IPAuthorityEnum;
import com.DBM.domain.IPAuthority;
import com.DBM.service.IPAuthorityService;

@Controller
@RequestMapping("/manage/IPAuthority")
public class IPAuthorityController {
	@Autowired
	IPAuthorityService iPAuthorityService;
	
	@RequestMapping(value = "/addIPAuthority")
	public String addIPAuthority(HttpServletRequest request) throws ParseException{
		String beginIp = request.getParameter("beginIp");
		String endIp = request.getParameter("endIp");
		String types = request.getParameter("types");
		
		IPAuthority iPAuthority = new IPAuthority();
		iPAuthority.setBeginIp(beginIp);
		iPAuthority.setEndIp(endIp);
		iPAuthority.setAuthorityType(types);
		iPAuthority.setEditTime(new Date());
		
		iPAuthorityService.addIPAuthority(iPAuthority);
		
		return "success";
	}
	
	@RequestMapping(value = "/toList")
	public ModelAndView paged(Integer pageNo,HttpServletRequest request) throws ParseException{
		
		ModelAndView modelAndView = new ModelAndView();
		pageNo = pageNo==null?1:pageNo;
		
		for (IPAuthorityEnum ip : IPAuthorityEnum.values()) {
			ip.getTypeId();
			ip.name();
		}
		//设置枚举权限类型进入前台控制页面
		List<Map<String,Object>> typeList = new ArrayList<Map<String,Object>>();
		for (IPAuthorityEnum l : IPAuthorityEnum.values()) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", l.name());
			map.put("typeId", l.getTypeId());
			typeList.add(map);
		}
		
		modelAndView.addObject("typeList",typeList);
		modelAndView.addObject("pagedIPAuthorities", iPAuthorityService.pageIPAuthority(pageNo, 10));
		modelAndView.setViewName("/manage/ipAuthority/ipAuthorityList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteIPAuthority")
	public String deleteIPAuthority(Integer id){
		
		id = id==null?0:id;
		
		IPAuthority iPAuthority = new IPAuthority();
		iPAuthority.setId(id);
		
		iPAuthorityService.deleteIPAuthority(iPAuthority);
		
		return "success";
	}
	
	@RequestMapping(value = "/toIPAuthorityUpdate")
	public ModelAndView toIPAuthorityUpdate(Integer id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/manage/ipAuthority/ipAuthorityUpdate");
		if(id == null){
			return modelAndView;
		}
		
		//设置枚举权限类型进入前台控制页面
		List<Map<String,Object>> typeList = new ArrayList<Map<String,Object>>();
		for (IPAuthorityEnum l : IPAuthorityEnum.values()) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", l.name());
			map.put("typeId", l.getTypeId());
			typeList.add(map);
		}
		modelAndView.addObject("typeList",typeList);
		modelAndView.addObject("IPAuthority",iPAuthorityService.getIPAuthorityById(id));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateIPAuthority")
	public void updateIPAuthority(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String beginIp = request.getParameter("beginIp");
		String endIp = request.getParameter("endIp");
		String types = request.getParameter("types");
		
		if (id==null) {
			renderData(response,"error");
			return;
		}
		
		IPAuthority iPAuthority = new IPAuthority();
		iPAuthority.setId(Integer.parseInt(id));
		iPAuthority.setBeginIp(beginIp);
		iPAuthority.setEndIp(endIp);
		iPAuthority.setAuthorityType(types);
		iPAuthority.setEditTime(new Date());
		
		renderData(response,iPAuthorityService.updateIPAuthority(iPAuthority));
	}
	
	/**
	   * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	   * 
	   * @param response
	   * @param data 
	   */
	  private void renderData(HttpServletResponse response, String data) {
	    PrintWriter printWriter = null;
	    try {
	      printWriter = response.getWriter();
	      printWriter.print(data);
	    } catch (IOException ex) {
	      Logger.getLogger(IPAuthorityController.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      if (null != printWriter) {
	        printWriter.flush();
	        printWriter.close();
	      }
	    }
	  }
	  
}
