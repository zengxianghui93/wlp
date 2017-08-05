package com.DBM.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.domain.ResInfo;
import com.DBM.service.DBMService;
import com.DBM.service.ResInfoService;


@Controller
@RequestMapping("/Show")
public class ShowController {
	
	@Autowired
	private DBMService dbmService;
	@Autowired
	private ResInfoService resInfoService;
	
	//展示页面模板编辑
	@RequestMapping("/edit-{resId}")
	public ModelAndView editShow(@PathVariable String resId){
		ModelAndView view  = new ModelAndView();
		ResInfo res = dbmService.getResInfo(Integer.parseInt(resId));
		view.addObject("res",res);
		view.setViewName("/Show/editTemp");
		return view;
	}
	
	@RequestMapping("/updateShow")
	public ModelAndView updateShow( String resId, String showTemp){
		ModelAndView view  = new ModelAndView();
		ResInfo resInfo = dbmService.getResInfo(Integer.parseInt(resId));
		resInfo.setShowTemp(showTemp);
		resInfoService.save(resInfo);
		//return new ModelAndView("/manage/resourceManage/resourceManage");
		view.setViewName("redirect:/DBM/resourceManage.html");
		return view;
	}
}
