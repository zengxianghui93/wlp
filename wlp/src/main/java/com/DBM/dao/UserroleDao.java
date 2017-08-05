package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.User_role;

@Repository
public class UserroleDao extends BaseDao<User_role> {
private final String DEL_ROLES_OP = " delete from User_role a where a.RoleId=?";
	
	
	/**
	 * 删除某个用户的所有角色
	 * @param userId 用户ID
	 */
	public void deleteRoleOP(int roleId) {
		getHibernateTemplate().bulkUpdate(DEL_ROLES_OP,roleId);
	}	
	

}
