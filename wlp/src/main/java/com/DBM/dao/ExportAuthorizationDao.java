package com.DBM.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DBM.domain.ExportAuthorization;
import com.DBM.domain.RoleInfo;
import com.DBM.domain.UserRoleInfo;

@Repository
public class ExportAuthorizationDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ExportAuthorization getExportAuthorization(int id){
		
		Session session = sessionFactory.getCurrentSession();
		ExportAuthorization ea = (ExportAuthorization)session.get(ExportAuthorization.class, id);
		return ea;
	}
	
	public List<ExportAuthorization> getExportAuthorizationByRoleId(int roleId){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ExportAuthorization ea where ea.roleId = "+roleId;
		List<ExportAuthorization> list = session.createQuery(hql).list();
		return list;
	}
	
	public void save(ExportAuthorization exportAuthorization){
		Session session = sessionFactory.getCurrentSession();
		session.save(exportAuthorization);
	}
	
	public void update(ExportAuthorization exportAuthorization){
		Session session = sessionFactory.getCurrentSession();
		session.update(exportAuthorization);
	}
	
	
}
