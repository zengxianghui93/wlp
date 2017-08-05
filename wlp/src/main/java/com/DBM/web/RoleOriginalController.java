package com.DBM.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.domain.RoleInfo;
import com.DBM.domain.RoleOriginal;
import com.DBM.service.AuthorityService;
import com.DBM.service.RoleOriginalService;

@Controller
public class RoleOriginalController {
	
	@Autowired
	private RoleOriginalService ROService;
	
	@Autowired
	private AuthorityService AuService;
	
	
	@RequestMapping(value = "/roleOriginal/edit-{roleId}")
	public ModelAndView editRoleOriginal(@PathVariable Integer roleId){
		ModelAndView view = new ModelAndView();
		
		RoleInfo role = AuService.GetRole(roleId);
		view.addObject("role", role);
		
		RoleOriginal roleOriginal = ROService.findByRoleId(role.getRoleId());
		view.addObject("roleOriginal", roleOriginal);
		view.setViewName("/manage/userManage/editROriginal");
		return view;
	}
	
	@RequestMapping(value = "/roleOriginal/add")
	public ModelAndView addRoleOriginal(RoleOriginal roleOriginal){
		ModelAndView view = new ModelAndView();
		ROService.add(roleOriginal);
		view.setViewName("redirect:/manage/authority/roleList.html");
		return view;
	}
	
	
	
	
	
	
	
	
	
	
	
}
