package com.DBM.dao;

import java.sql.SQLException;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.DBM.domain.GroupInfo;
import com.DBM.domain.ResInfo;

@Repository
public class GroupInfoDao extends BaseDao<GroupInfo> {
	private final String LIST_RES= " from group";
	
	public List<GroupInfo> ListAllRes(){
		return getHibernateTemplate().find(LIST_RES);
	}
	
	public Object queryDataById(final String tableName,final Integer infoId){
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		
		Session session = sessionFactory.openSession();
		String sql="SELECT * FROM "+tableName+" WHERE id="+infoId;
		SQLQuery query = session.createSQLQuery(sql);
		Object uniqueResult = query.uniqueResult();
		return uniqueResult;  
	}
	
	
	
	
	
	
}
