package com.DBM.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DBM.domain.Theme;

@Repository
public class ThemeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Theme> list(int page, int pageSize, int userId){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Theme m where 1 = 1 and m.userid = :userId";
		List<Theme> list = session.createQuery(hql).setInteger("userId", userId).setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
		return list;
	}
	
	public Theme getById(int id){
		Session session = sessionFactory.getCurrentSession();
		Theme theme = (Theme) session.get(Theme.class, id);
		return theme;
	}
	
	public void update(Theme theme){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theme);
	}
	
	public void save(Theme theme){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theme);
	}
	
	public void removeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Theme theme = (Theme)session.get(Theme.class, id);
		session.delete(theme);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int getTotal(int userId) {
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("select count(*) from Theme t where userid = :userid ").setInteger("userid", userId).list() ;
		return new Long((Long)list.get(0)).intValue();
	}
	

	

}
