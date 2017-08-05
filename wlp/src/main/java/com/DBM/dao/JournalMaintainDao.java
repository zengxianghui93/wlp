package com.DBM.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DBM.domain.JournalMaintain;

@Repository
public class JournalMaintainDao extends BaseDao<JournalMaintain>{

	/**
	 * 根据条件查询page
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @param type
	 * @return
	 */
	public Page getPageList(Integer pageNo, Integer pageSize, String name,
			String type) {
		String where = " 1=1";
		if(name!=null&&!"".equals(name.trim())){
			where += " and name like'%"+name.trim()+"%'";
		}
		if(type!=null&&!"null".equals(type.trim())&&!"".equals(type.trim())){
			where += " and type = '"+type.trim()+"'";
		}
		where += " order by create_time desc";
		String sql = "select * from wf_b_journalmaintain where "+where;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(JournalMaintain.class);
		long totalCount = query.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List<JournalMaintain> list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(startIndex, totalCount, pageSize, list);
	}

}
