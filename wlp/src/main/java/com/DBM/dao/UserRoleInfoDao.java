package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.UserRoleInfo;

@Repository
public class UserRoleInfoDao extends BaseDao<UserRoleInfo>{
	private final String DEL_USER_ROLES = " delete from UserRoleInfo a where a.userId=?";
	
	/**
	 * 删除某个用户的所有角色
	 * @param userId 用户ID
	 */
	public void deleteUserRole(int userId) {
		getHibernateTemplate().bulkUpdate(DEL_USER_ROLES,userId);
	}	
}
