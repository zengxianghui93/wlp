package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ExportAuthorizationDao;
import com.DBM.dao.RoleInfoDao;
import com.DBM.domain.ExportAuthorization;
import com.DBM.domain.RoleInfo;

@Service
public class ExportAuthorizationService {
	
	@Autowired
	private ExportAuthorizationDao exportAuthorizationDao;

	public List<ExportAuthorization> getExportAuthorizationByRoleId(int roleId) {
		return exportAuthorizationDao.getExportAuthorizationByRoleId(roleId);
	}
	
	public void save(ExportAuthorization exportAuthorization){
		exportAuthorizationDao.save(exportAuthorization);
	}
	
	public void updateRoleInfoAndExptAuth(ExportAuthorization exportAuthorization){
		exportAuthorizationDao.update(exportAuthorization);
	}
}
