package com.DBM.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DBM.domain.GroupInfo;
import com.DBM.domain.OperationInfo;
import com.DBM.domain.ResInfo;
import com.DBM.domain.RoleInfo;
import com.DBM.domain.RoleOpInfo;
import com.DBM.domain.User;
import com.DBM.domain.UserOpCategory;
import com.DBM.domain.UserOpMICategory;
import com.DBM.domain.UserResource;
import com.DBM.domain.UserRoleInfo;
import com.DBM.domain.User_group;
import com.DBM.service.AuthorityService;
import com.DBM.service.ResInfoService;
import com.DBM.service.UserResourceService;

@Controller
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private UserResourceService userResourceService;
	@Autowired
	private ResInfoService resInfoService;

	// /////////用户相关操作/////////////

	/**
	 * 跳往显示用户组列表的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/groupList")
	public ModelAndView groupList() {
		ModelAndView view = new ModelAndView();
		List<GroupInfo> groupList = authorityService.getAllgroups();
		view.addObject("groupList", groupList);
		view.setViewName("/manage/userManage/groupList");
		return view;
	}

	/**
	 * 跳到新建一个用户组的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/addgroupPage")
	public ModelAndView addgroupPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/manage/userManage/addgroup");
		return view;
	}

	/**
	 * 新建一个用户组
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/addgroupC")
	public String addgroup(GroupInfo role) {
		authorityService.Addgroup(role);
		return "redirect:/manage/authority/groupList.html";
	}

	/**
	 * 跳到编辑一个用户组的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/editgroupPage-{groupId}")
	public ModelAndView editgroupPage(@PathVariable int groupId) {
		ModelAndView view = new ModelAndView();
		GroupInfo groupInfo = authorityService.Getgroup(groupId);
		view.addObject("groupInfo", groupInfo);
		view.setViewName("/manage/userManage/editgroup");
		return view;
	}

	/**
	 * 修改编辑一个用户组
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/editgroupC")
	public String updategroup(GroupInfo role) {
		authorityService.Updategroup(role);
		return "redirect:/manage/authority/groupList.html";
	}

	/**
	 * 删除一个用户组
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/delgroupC-{groupId}")
	public String delgroup(@PathVariable int groupId) {
		authorityService.Deletegroup(groupId);
		return "redirect:/manage/authority/groupList.html";
	}

	// /////////角色相关操作/////////////

	/**
	 * 跳往显示角色列表的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/roleList")
	public ModelAndView userList() {

		ModelAndView view = new ModelAndView();

		List<RoleInfo> roleList = authorityService.getAllRoles();
		view.addObject("roleList", roleList);
		view.setViewName("/manage/userManage/roleList");
		return view;
	}

	/**
	 * 跳到新建一个角色的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/addRolePage")
	public ModelAndView addRolePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/manage/userManage/addRole");
		return view;
	}

	/**
	 * 新建一个角色
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/addRoleC")
	public String addRole(RoleInfo role) {
		authorityService.AddRole(role);
		return "redirect:/manage/authority/roleList.html";
	}

	/**
	 * 跳到编辑一个角色的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/editRolePage-{roleId}")
	public ModelAndView editRolePage(@PathVariable int roleId) {
		ModelAndView view = new ModelAndView();
		RoleInfo roleInfo = authorityService.GetRole(roleId);
		view.addObject("roleInfo", roleInfo);
		view.setViewName("/manage/userManage/editRole");
		return view;
	}

	/**
	 * 修改编辑一个角色
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/editRoleC")
	public String updateRole(RoleInfo role) {
		authorityService.UpdateRole(role);
		return "redirect:/manage/authority/roleList.html";
	}

	/**
	 * 删除一个角色
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/delRoleC-{roleId}")
	public String delRole(@PathVariable int roleId) {
		authorityService.DeleteRole(roleId);
		return "redirect:/manage/authority/roleList.html";
	}

	/**
	 * 跳到显示某个用户的角色的页面
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/roleOfUser-{userId}")
	public ModelAndView getUserRole(@PathVariable int userId) {
		List<RoleInfo> RoleList = authorityService.getRolesOfUser(userId);
		List<RoleInfo> roleList = authorityService.getAllRoles();
		ModelAndView view = new ModelAndView();
		view.addObject("RoleList", RoleList);
		view.addObject("userId", userId);
		view.addObject("roleList", roleList);
		view.setViewName("/manage/userManage/user_role");
		return view;
	}

	/**
	 * 设置某个用户的角色
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/setUserRoles")
	public ModelAndView setUserRoles(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();

		// 删除该用户的角色
		String[] roles = request.getParameterValues("listUserRole");
		if (roles == null || roles.length == 0) {
			view.addObject("errorMsg", "用户角色不能少于一个");
			view.setViewName("forward:/manage/userList.html");
		} else {
			int userId = Integer.parseInt(request.getParameter("userId"));
			authorityService.DeleteUserRole(userId);
			// 获取页面上的该用户角色
			// 添加该用户的角色
			for (String role : roles) {
				UserRoleInfo userRoleInfo = new UserRoleInfo();
				userRoleInfo.setRoleId(Integer.parseInt(role));
				userRoleInfo.setUserId(userId);

				authorityService.AddUserRole(userRoleInfo);
			}

			view.setViewName("forward:/manage/userList.html");

		}
		return view;
	}

	// /////////////////////功能操作相关//////////////////////////

	/**
	 * 跳到显示某个角色的功能的页面
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/OpOfRole-{roleId}")
	public ModelAndView getRoleOP(@PathVariable int roleId) {
		List<OperationInfo> roleOpList = authorityService.getRolesOp(roleId);
		List<OperationInfo> OpList = authorityService.getAllOp();
		ModelAndView view = new ModelAndView();
		view.addObject("roleOpList", roleOpList);
		view.addObject("roleId", roleId);
		view.addObject("OpList", OpList);
		view.setViewName("/manage/userManage/OpOfRole");
		return view;
	}

	/**
	 * 设置某个角色的功能
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/setRoleOP")
	public ModelAndView setRoleOP(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		// 获取页面上的该用户角色
		String[] ops = request.getParameterValues("listRoleOp");
		if (ops == null || ops.length == 0) {
			view.addObject("errorMsg", "用户角色不能少于一个");
			view.setViewName("forward:/manage/authority/roleList.html");
		} else {
			// 删除该用户的角色
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			authorityService.DeleteRoleOP(roleId);
			// 添加该用户的角色
			for (String op : ops) {
				RoleOpInfo roleOpInfo = new RoleOpInfo();
				roleOpInfo.setOpId(op);
				roleOpInfo.setRoleId(roleId);
				authorityService.AddRoleOP(roleOpInfo);
			}

			view.setViewName("forward:/manage/authority/roleList.html");
		}
		return view;
	}

	// ///////////////////用户组操作///////////////////////////////
	/**
	 * 跳到显示某个用户组的用户面
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/groupuser-{groupId}")
	public ModelAndView groupuser(@PathVariable int groupId) {
		List<User> UserList = authorityService.getgroupuu(groupId);
		List<User> UList = authorityService.getAllUser();
		ModelAndView view = new ModelAndView();
		view.addObject("UserList", UserList);
		view.addObject("groupId", groupId);
		view.addObject("UList", UList);
		view.setViewName("/manage/userManage/user_group");
		return view;
	}

	/**
	 * 设置某个用户组的用户
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/setgroup")
	public ModelAndView setgroup(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		// 获取页面上的用户
		String[] gu = request.getParameterValues("listgroupuser");
		if (gu == null || gu.length == 0) {
			view.addObject("errorMsg", "用户角色不能少于一个");
			view.setViewName("forward:/manage/authority/groupList.html");
		} else {
			// 删除该组的用户
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			authorityService.deleteuser(groupId);
			// 添加到用户组
			for (String list : gu) {
				User_group usergroup = new User_group();
				usergroup.setUserid(Integer.parseInt(list));
				usergroup.setGroupid(groupId);
				authorityService.Addusergroup(usergroup);
			}

			view.setViewName("forward:/manage/authority/groupList.html");
		}
		return view;
	}

	/**
	 * 获取子功能操作列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/subOp-{supId}", method = RequestMethod.GET)
	public ModelAndView listSubOp(@PathVariable String supId) {
		ModelAndView view = new ModelAndView();
		if (supId == null || supId.equals("")) {
			supId = "00";
		}
		List<OperationInfo> listSubOp = authorityService.listSubOp(supId);

		List<OperationInfo> listSupOp = authorityService.listSupOp(supId);

		view.addObject("subList", listSubOp);
		view.addObject("supList", listSupOp);
		view.addObject("supId", supId);
		view.setViewName("/manage/userManage/opList");
		return view;
	}

	// ///////////////////功能相关操作/////////////////////////
	/**
	 * 跳转至添加功能页面
	 * 
	 * @param supId
	 * @return
	 */
	@RequestMapping(value = "/manage/authority/addOp-{supId}", method = RequestMethod.GET)
	public ModelAndView addOp(@PathVariable String supId) {
		ModelAndView view = new ModelAndView();

		if (supId.equals("00")) {
			view.addObject("opType", 0);
		} else {
			view.addObject("opType", 1);
		}

		String nextid;
		// 获取该栏目的子栏目列表
		List<OperationInfo> subOps = authorityService.listSubOp(supId);
		if (subOps.isEmpty()) {
			nextid = supId + "01";
		} else {
			// 获取该栏目的最后子栏目
			OperationInfo operationInfo = subOps.get(subOps.size() - 1);
			String opId = operationInfo.getOpId();
			String ss = opId.substring(opId.length() - 2, opId.length());
			nextid = String.valueOf(Integer.parseInt(ss) + 1);

			if (nextid.length() == 1) {
				nextid = "0" + nextid;
			}
			nextid = opId.substring(0, opId.length() - 2) + nextid;

		}

		view.addObject("nextId", nextid);

		List<OperationInfo> listSupOp = authorityService.listSupOp(supId);
		view.addObject("supList", listSupOp);

		view.setViewName("/manage/userManage/opAdd");
		return view;
	}

	/**
	 * 添加功能的保存提交
	 */
	@RequestMapping(value = "/manage/authority/saveOp", method = RequestMethod.POST)
	public ModelAndView saveOp(OperationInfo operation) {
		ModelAndView view = new ModelAndView();

		authorityService.saveOp(operation);
		String supId = operation.getOpId().substring(0,
				operation.getOpId().length() - 2);
		view.setViewName("redirect:/manage/authority/subOp-" + supId + ".html");
		return view;
	}

	/**
	 * 删除一个功能
	 */
	@RequestMapping(value = "/manage/authority/delOp-{opId}", method = RequestMethod.GET)
	public ModelAndView delOp(@PathVariable String opId) {
		ModelAndView view = new ModelAndView();

		List<OperationInfo> subOps = authorityService.listSubOp(opId);
		if (subOps.isEmpty()) {

			authorityService.delOp(opId);
			if (opId.length() == 2) {
				view.setViewName("redirect:/manage/authority/subOp-00.html");
				return view;
			}
			String temp = opId.substring(0, opId.length() - 2);
			view.setViewName("redirect:/manage/authority/subOp-" + temp
					+ ".html");
			return view;
		} else {

			view.addObject("errorMsg", "请先删除子项目");
			view.setViewName("forward:/manage/authority/subOp-" + opId
					+ ".html");
			return view;
		}

	}

	/**
	 * 调至修改页面
	 */
	@RequestMapping(value = "/manage/authority/editOp-{opId}", method = RequestMethod.GET)
	public ModelAndView editOp(@PathVariable String opId) {
		ModelAndView view = new ModelAndView();

		OperationInfo operationInfo = authorityService.getOpById(opId);

		List<OperationInfo> listSupOp = authorityService.listSupOp(opId);
		view.addObject("supList", listSupOp);

		view.addObject("opInfo", operationInfo);
		view.setViewName("/manage/userManage/opEdit");
		return view;
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/manage/authority/updateOp", method = RequestMethod.POST)
	public ModelAndView updateOp(OperationInfo operation) {
		ModelAndView view = new ModelAndView();

		authorityService.updateOp(operation);
		String opId = operation.getOpId();

		if (opId.length() == 2) {
			view.setViewName("redirect:/manage/authority/subOp-00.html");
			return view;
		}

		String temp = opId.substring(0, opId.length() - 2);
		view.setViewName("redirect:/manage/authority/subOp-" + temp + ".html");
		return view;
	}

	@RequestMapping(value = "/manage/authority/toUserResource")
	public ModelAndView toUserResource(Integer userId, Integer pageNo,
			HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<Map> list = new ArrayList<Map>();
		List<UserResource> resOpList = userResourceService
				.getUserResourceByUserId(userId);
		List<ResInfo> resList = resInfoService.getResInfoDao().findRT(
				"from ResInfo where resType !=3");
		// 获取资源库的名称，写入map，前台获取
		for (UserResource userResource : resOpList) {
			Map map = new HashMap();
			a: for (ResInfo resInfo : resList) {
				if (resInfo.getResId() == userResource.getResId()) {
					map.put("resName", resInfo.getResName());
					break a;
				}
			}
			map.put("userResource", userResource);
			list.add(map);
		}
		model.addObject("resOpList", list);
		model.addObject("resList", resList);
		model.addObject("userId", userId);
		model.addObject("pageNo", pageNo);
		model.setViewName("/manage/userManage/OpOfResource");
		return model;
	}

	@RequestMapping(value = "/manage/authority/setUserResource")
	public ModelAndView setUserResource(Integer userId, Integer pageNo,
			HttpServletRequest request) {
		String[] listRoleOp = request.getParameterValues("listRoleOp");
		String[] libIds = request.getParameter("libIds").split(",");
		String[] eleIds = request.getParameter("eleIds").split(",");
		// 先删除表中的原有权限
		userResourceService.delUserResourceByUserId(userId);
		// 重新给用户赋权限
		for (String string : listRoleOp) {
			if ("8".equals(string)) {
				for (String string2 : libIds) {
					UserResource userResource = new UserResource();
					userResource.setResId(Integer.parseInt(string));
					if (!"".equals(string2)) {
						userResource.setResSourceId(Integer.parseInt(string2));
						userResource.setUserId(userId);
						userResourceService.addUserResource(userResource);
					}
				}
			} else if ("9".equals(string)) {
				for (String string2 : eleIds) {
					UserResource userResource = new UserResource();
					userResource.setResId(Integer.parseInt(string));
					if (!"".equals(string2)) {
						userResource.setResSourceId(Integer.parseInt(string2));
						userResource.setUserId(userId);
						userResourceService.addUserResource(userResource);
					}
				}
			} else {
				UserResource userResource = new UserResource();
				userResource.setResId(Integer.parseInt(string));
				userResource.setUserId(userId);
				userResourceService.addUserResource(userResource);
			}
		}

		// 跳转页面
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/manage/userList1.html?pageNo=" + pageNo);
		return model;
	}

}