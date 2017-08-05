package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.RoleOpInfo;

@Repository
public class RoleOpInfoDao extends BaseDao<RoleOpInfo>{	
	private final String DEL_ROLES_OP = " delete from RoleOpInfo a where a.RoleId=?";
	
	
	/**
	 * 删除某个角色的所有功能
	 * @param userId 用户ID
	 */
	public void deleteRoleOP(int roleId) {
		getHibernateTemplate().bulkUpdate(DEL_ROLES_OP,roleId);
	}	
}
