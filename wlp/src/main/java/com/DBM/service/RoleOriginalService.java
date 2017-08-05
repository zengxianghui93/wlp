package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.RoleDao;
import com.DBM.dao.RoleOriginalDao;
import com.DBM.domain.Role;
import com.DBM.domain.RoleOriginal;

@Service
public class RoleOriginalService {
	
	@Autowired
	private RoleOriginalDao RODao;
	
	@Autowired
	private RoleDao roleDao;
	
	public void add(RoleOriginal ro){
		//添加之前删除
		String sql = " from RoleOriginal where roleId=?";
		List<RoleOriginal> find = RODao.find(sql,ro.getRoleId());
		for (RoleOriginal roleOriginal : find) {
			RODao.remove(roleOriginal);
		}
		
		RODao.save(ro);
	
	}
	
	
	public RoleOriginal findByRoleId(Integer roleId){
		return RODao.findByRoleId(roleId);
	}
	
	
}
