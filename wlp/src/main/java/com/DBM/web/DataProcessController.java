package com.DBM.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.DBM.dao.Page;
import com.DBM.service.DBMService;

@Controller
@RequestMapping("/dataProcess")
public class DataProcessController {
	@Autowired
	private DBMService dbmService;
	/*
	 * 数据加工后台管理
	 */
	@RequestMapping("/dpIndex")
	public ModelAndView dataProcessing(HttpServletRequest request,@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView mv = new ModelAndView();
		//获取所有的资源库,准备跳到库列表页面
		pageNo = pageNo==null?1:pageNo;
		Page pagedNews =dbmService.ListRes(pageNo,9,null);
		mv.addObject("pagedNews",pagedNews);
		mv.setViewName("/manage/dataProcessing/dataProcessing");
		return mv;
	}
}
