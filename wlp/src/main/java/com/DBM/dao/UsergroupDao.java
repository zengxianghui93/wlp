package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.User_group;

	@Repository
	public class UsergroupDao extends BaseDao<User_group>{	
		private final String DEL_ROLES_OP = " delete from User_group a where a.groupid=?";
		
	
	/**
	 * 删除某个用户组用户
	 * @param userId 用户ID
	 */
	public void deleteRoleOP(int groupid) {
		getHibernateTemplate().bulkUpdate(DEL_ROLES_OP,groupid);
	}	
	
}