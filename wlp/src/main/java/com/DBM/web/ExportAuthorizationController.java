package com.DBM.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.dao.ExportAuthorizationDao;
import com.DBM.domain.ExportAuthorization;
import com.DBM.service.ExportAuthorizationService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/ExportAuthorization")
public class ExportAuthorizationController {
	
	@Autowired
	private ExportAuthorizationService exportAuthorizationService;
	
	@RequestMapping("/get/{roleId}")
	public ModelAndView get(@PathVariable int roleId){
		List<ExportAuthorization> list = exportAuthorizationService.getExportAuthorizationByRoleId(roleId);
		if(list.size() == 0){
			return new ModelAndView("/manage/userManage/exportAuthorization").addObject("roleId", roleId).addObject("eid", 0);
		}else{
			ExportAuthorization ea = list.get(0);
			return new ModelAndView("/manage/userManage/exportAuthorization").addObject("roleId", ea.getRoleId()).addObject("eid", ea.getExptAuthId());
		}
		
	}
	
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(int roleId, int exptAuthId){
		List<ExportAuthorization> list = exportAuthorizationService.getExportAuthorizationByRoleId(roleId);
		if(list.size() == 0){
			ExportAuthorization exportAuthorization = new ExportAuthorization();
			exportAuthorization.setRoleId(roleId);
			exportAuthorization.setExptAuthId(exptAuthId);
			exportAuthorizationService.save(exportAuthorization);
		}else{
			ExportAuthorization exportAuthorization = list.get(0);
			exportAuthorization.setExptAuthId(exptAuthId);
			exportAuthorizationService.updateRoleInfoAndExptAuth(exportAuthorization);
		}
		
		return new ModelAndView("redirect:/manage/authority/roleList.html");
	}
	
	
}
