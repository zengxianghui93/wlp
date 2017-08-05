package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.GroupInfoDao;
import com.DBM.dao.OperationInfoDao;
import com.DBM.dao.RoleInfoDao;
import com.DBM.dao.RoleOpInfoDao;
import com.DBM.dao.UserDao;
import com.DBM.dao.UserRoleInfoDao;
import com.DBM.dao.UsergroupDao;
import com.DBM.dao.UserroleDao;
import com.DBM.domain.GroupInfo;
import com.DBM.domain.OperationInfo;
import com.DBM.domain.RoleInfo;
import com.DBM.domain.RoleOpInfo;
import com.DBM.domain.User;
import com.DBM.domain.UserRoleInfo;
import com.DBM.domain.User_group;
import com.DBM.domain.User_role;

@Service
public class AuthorityService {

	@Autowired
	private RoleInfoDao roleInfoDao;
	@Autowired
	private GroupInfoDao groupInfoDao;
	@Autowired
	private UserRoleInfoDao userRoleInfoDao;
	@Autowired
	private OperationInfoDao operationInfoDao;
	@Autowired
	private RoleOpInfoDao roleOpInfoDao;
	@Autowired
	private UsergroupDao usergroupDao;
	@Autowired
	private UserroleDao userroleDao;
	@Autowired
	private UserDao userDao;
	//////////用户操作//////////////
	/**
	 * 获取系统所有用户
	 * @return
	 */
	public List<User> getAllUser(){
		return userDao.loadAll();
	}
	
	/**
	 * 为一个用户添加一角色
	 * @param roleOpInfo
	 */
	public void Adduserrole(User_role userrole){
		userroleDao.save(userrole);
	}
	
	/**
	 * 根据id删除用户
	 * @param roleOpInfo
	 */
	public void deleteuser(int userid){
		usergroupDao.deleteRoleOP(userid);
	}
	///////////用户组相关操作/////////////
	
	/**
	 * 获取系统所有用户组
	 * @return
	 */
	public List<GroupInfo> getAllgroups(){
		return groupInfoDao.loadAll();
	}
	
	/**
	 * 获取一个用户组的所有角色
	 * @param roleId
	 * @return
	 */
	public List<User> getgroupuu(int groupId){
		return userDao.getgroupuu(groupId);
	}
	
	/**
	 * 根据ID返回一个用户组
	 * @param id
	 * @return
	 */
	public GroupInfo Getgroup(int id){
		return groupInfoDao.get(id);
	}
	
	/**
	 * 添加一个新用户组
	 * @param role
	 */
	public void Addgroup(GroupInfo role){
		groupInfoDao.save(role);		
	}
	
	/**
	 * 编辑更新一个用户组
	 * @param role
	 */
	public void Updategroup(GroupInfo role){
		groupInfoDao.update(role);
	}
	
	/**
	 * 根据ID删除一个用户组
	 * @param id
	 */
	public void Deletegroup(int id){
		groupInfoDao.remove(groupInfoDao.get(id));
	}
	
	/**
	 * 为一个用户组添加一用户
	 * @param roleOpInfo
	 */
	public void Addusergroup(User_group usergroup){
		usergroupDao.save(usergroup);
	}
	
	///////////角色相关操作/////////////	
	
	/**
	 * 获取系统所有角色
	 * @return
	 */
	public List<RoleInfo> getAllRoles(){
		return roleInfoDao.loadAll();
	}
	/**
	 * 获取该用户所有角色
	 * @return
	 */
	public List<RoleInfo> getRolesOfUser(int userId){
		return roleInfoDao.getUserRoles(userId);
	}
	public List<UserRoleInfo> getRoles(int userId){
		return roleInfoDao.getRoles(userId);
	}
	
	/**
	 * 根据ID返回一个角色
	 * @param id
	 * @return
	 */
	public RoleInfo GetRole(int id){
		return roleInfoDao.get(id);
	}
	
	/**
	 * 添加一个新角色
	 * @param role
	 */
	public void AddRole(RoleInfo role){
		roleInfoDao.save(role);
	}
	
	/**
	 * 编辑更新一个角色
	 * @param role
	 */
	public void UpdateRole(RoleInfo role){
		roleInfoDao.update(role);
	}
	
	/**
	 * 根据ID删除一个角色
	 * @param id
	 */
	public void DeleteRole(int id){
		roleInfoDao.remove(roleInfoDao.get(id));
	}
	/**
	 * 删除一个用户的所有角色
	 * @param userId
	 */
	public void DeleteUserRole(int userId){
		userRoleInfoDao.deleteUserRole(userId);
	}
	
	/**
	 * 为一个用户添加一个新角色
	 * @param role
	 */
	public void AddUserRole( UserRoleInfo  userRoleInfo ){
		userRoleInfoDao.save(userRoleInfo);		
	}
	//////////////功能相关操作////////////////
	/**
	 * 获取所有功能
	 * @return
	 */
	public List<OperationInfo> getAllOp(){
		return operationInfoDao.loadAll();
	}
	/**
	 * 获取子功能列表
	 * @return
	 */
	public List<OperationInfo> listSubOp(String op_id){
		
		return operationInfoDao.getSubOps(op_id);
	}
	/**
	 * 获取父功能列表
	 * @return
	 */
	public List<OperationInfo> listSupOp(String op_id){
		
		return operationInfoDao.getSupOps(op_id);
	}
	/**
	 * 添加一个功能
	 * @param operationInfo
	 */
	public void saveOp(OperationInfo operationInfo){
		operationInfoDao.save(operationInfo);
	}
	/**
	 * 添加一个功能
	 * @param operationInfo
	 */
	public void updateOp(OperationInfo operationInfo){
		operationInfoDao.update(operationInfo);
	}
	/*
	 *根据id获取功能详情
	 */
	public OperationInfo getOpById(String opId){
		return operationInfoDao.get(opId);
	}
	/**
	 * 删除一个功能
	 */
	public void delOp(String opId){
		OperationInfo operationInfo = operationInfoDao.get(opId);
		operationInfoDao.remove(operationInfo);
	}
	
	
	/**
	 * 获取角色的所有功能
	 * @param roleId
	 * @return
	 */
	public List<OperationInfo> getRolesOp(int roleId){
		return operationInfoDao.getRolesOP(roleId);
	}
	
	/**
	 * 删除一个角色的所有功能
	 * @param userId
	 */
	public void DeleteRoleOP(int roleId){
		roleOpInfoDao.deleteRoleOP(roleId);
	}
	
	/**
	 * 为一个角色添加一功能
	 * @param roleOpInfo
	 */
	public void AddRoleOP(RoleOpInfo roleOpInfo){
		roleOpInfoDao.save(roleOpInfo);
	}
	

	
}
