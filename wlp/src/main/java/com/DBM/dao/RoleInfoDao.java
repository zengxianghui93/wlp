package com.DBM.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.DBM.domain.RoleInfo;
import com.DBM.domain.UserRoleInfo;

@Repository
public class RoleInfoDao extends BaseDao<RoleInfo>{
	private final String GET_USER_ROLES = " from RoleInfo a,UserRoleInfo b where a.roleId=b.roleId and b.userId = ?";
	
	private final String GET_ROLES = " from UserRoleInfo b where b.userId = ?";
	
	public List<RoleInfo> getUserRoles(int user_id) {	
		List<RoleInfo> roles=find(GET_USER_ROLES,user_id);
		return roles;
	}
	@SuppressWarnings("unchecked")
	public List<UserRoleInfo> getRoles(int user_id) {	
		List<UserRoleInfo> roles=find(GET_ROLES,user_id);
		return roles;
	}
}
