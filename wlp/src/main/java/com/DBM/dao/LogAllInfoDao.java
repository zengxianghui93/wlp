package com.DBM.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.DBM.cons.LogTypeEnum;
import com.DBM.domain.LogAllInfo;
import com.DBM.domain.WF_B_MI;
/**
 * 日志管理dao
 * @author maxiaocheng
 * time:20170224
 */

@Repository
public class LogAllInfoDao extends BaseDao<LogAllInfo>{
	public List findAllLogAllInfo(Integer logType){
		String hql = "";
		if (logType==null || "".equals(logType)) {
			hql = "form LogAllInfo";
		}else{
			hql = "form LogAllInfo where logType = "+logType;
		}
		
		return find(hql);
	}
	
	public Page getLogAllInfoBySearch(String where,int pageNo,int pageSize){
		String sql="select * from t_log_info where 1=1 ";
		if (!"".equals(where)) {
			sql +=  where;
		}
		
		//按时间降序查询
		sql += " order by log_time desc";
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(LogAllInfo.class);
		
		long totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	public List getAllLogAllInfoBySearch(String where){
		String sql="select * from t_log_info where 1=1 ";
		if (!"".equals(where)) {
			sql += where;
		}
		
		//按时间降序查询
		sql += " order by log_time desc";
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(LogAllInfo.class);
		
		return sqlQuery.list();
	}
	/**
	 * 根据用户喜好推荐相关内容
	 * @author longbiao
	 * @param where
	 * @return
	 */
	public List getAllLogAllInfoBySearchForRecommend(String where){
		String sql="select * from t_log_info where 1=1 ";
		if (!"".equals(where)) {
			sql += where;
		}
		
		//按时间降序查询
		sql += " order by log_time desc";
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(LogAllInfo.class);
		sqlQuery.setMaxResults(5);
		return sqlQuery.list();
	}

	/**
	 * 根据用户id和数据资源名和文章id获取本文章下载的次数
	 * @param userId
	 * @param tableName
	 * @param resId
	 * @return
	 */
	public Integer getNumbyUserIdAndRes(Integer userId, String tableName) {
		String sql = "SELECT COUNT(1) FROM t_log_info WHERE log_type = "+LogTypeEnum.文章下载.toInt()+" AND user_id = "+userId+" AND log_res = '"+tableName+"' AND DATE_FORMAT(log_time,'%Y-%m-%d') LIKE CURDATE()";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		return Integer.parseInt(sqlQuery.uniqueResult().toString());
	}
	
	
}
