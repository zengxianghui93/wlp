package com.DBM.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.DBM.domain.RoleOriginal;
@Repository
public class RoleOriginalDao extends BaseDao<RoleOriginal> {
	
	public RoleOriginal findByRoleId(Integer roleId){
		String sql = " from RoleOriginal where roleId=?";
		List<RoleOriginal> find = find(sql,roleId);
		if(!find.isEmpty()){
			return find.get(0);
		}
		return null;
	}
	
	
}
