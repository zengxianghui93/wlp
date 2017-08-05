package com.DBM.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.DBM.domain.IPAuthority;
/**
 * ip权限dao层
 * @author maxiaocheng
 * 20170226
 */
@Repository
public class IPAuthorityDao extends BaseDao<IPAuthority>{
	public Page pageIPAuthorities(int pageNo,int pageSize){
		String sql="select * from t_ip_authority order by edit_time desc";
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(IPAuthority.class);
		
		long totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List<IPAuthority> list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	public IPAuthority getIPAuthorityById(Integer id){
		if (id == null) {
			return null;
		}
		
		String sql="select * from t_ip_authority where id="+id;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(IPAuthority.class);
		List<IPAuthority> list = sqlQuery.list();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	public List getAllIds(){
		return find("select id from IPAuthority");
	}
	
	public List<IPAuthority> getIPAuthoritiesByAuthorityType(String AuthorityType){
		String sql="select * from t_ip_authority where authority_type like '%"+AuthorityType+"%'";
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(IPAuthority.class);
		List<IPAuthority> list = sqlQuery.list();
		return list;
	}

}
