package com.DBM.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.dao.ResInfoDao;
import com.DBM.domain.ResInfo;
import com.DBM.service.DBMService;
import com.DBM.service.ResDataService;
import com.DBM.service.ResInfoService;

@Controller
@RequestMapping("/Content")
public class ContentController {
	
	@Autowired
	private DBMService dbmService;
	@Autowired
	private ResInfoService resInfoService;
	
	@RequestMapping("/editContent/{resId}")
	public ModelAndView editContent(@PathVariable String resId, HttpServletRequest request, HttpServletResponse response){
		ResInfo ri = dbmService.getResInfo(Integer.parseInt(resId));
		return new ModelAndView("/Content/template-edit").addObject("ri", ri);
	}
	@RequestMapping("/updateContent")
	public ModelAndView updateContent(String resId, String resTemplate){
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		resInfo.setResTemplate(resTemplate);
		resInfoService.save(resInfo);
		//return new ModelAndView("/manage/resourceManage/resourceManage");
		return new ModelAndView("redirect:/DBM/resourceManage.html");
	}

	public DBMService getDbmService() {
		return dbmService;
	}

	public void setDbmService(DBMService dbmService) {
		this.dbmService = dbmService;
	}
}
