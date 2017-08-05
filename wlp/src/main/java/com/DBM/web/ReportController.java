package com.DBM.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.domain.Report;
import com.DBM.service.ReportService;

@Controller
@RequestMapping("/manage/report")
public class ReportController {
	@Autowired
	ReportService reportService;
	@RequestMapping("/toReport")
	public ModelAndView toReport(){
		ModelAndView modelAndWiew = new ModelAndView();
		
		modelAndWiew.addObject("report",reportService.getReport());
		modelAndWiew.setViewName("/manage/report/reportManager");
		return modelAndWiew;
	}
	
	@RequestMapping("/update")
	public String updateReport(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String context = request.getParameter("context");
		String countTime = request.getParameter("countTime");
		String countLanguage = request.getParameter("countTime");
		String countAuthor = request.getParameter("countAuthor");
		String countDatabase = request.getParameter("countDatabase");
		String countOrg = request.getParameter("countOrg");
		String countSerial = request.getParameter("countSerial");
		String numLimit = request.getParameter("numLimit");
		
		if (id==null||"".equals(id)) {
			id = "1";
		}
		if (numLimit==null||"".equals(numLimit)) {
			numLimit = "200";
		}
		
		Report report = new Report();
		report.setId(Integer.parseInt(id));
		report.setContext(context);
		report.setCountTime(countTime);
		report.setCountLanguage(countLanguage);
		report.setCountAuthor(countAuthor);
		report.setCountDatabase(countDatabase);
		report.setCountOrg(countOrg);
		report.setCountSerial(countSerial);
		report.setNumLimit(Integer.parseInt(numLimit));
		reportService.update(report);
		
		return "success";
	}
}
