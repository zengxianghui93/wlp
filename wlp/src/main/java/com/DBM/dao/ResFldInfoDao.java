package com.DBM.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.DBM.domain.ResFldInfo;

@Repository
public class ResFldInfoDao extends BaseDao<ResFldInfo> {
	private final String LIST_RES_FLDS = " from ResFldInfo a where a.resId= ? ";
	/**
	 * 获取后台手动添加的字段
	 * @param resId
	 * @return
	 */
	public List<ResFldInfo> ListResFld(int resId){
		return getHibernateTemplate().find(LIST_RES_FLDS,resId);
	}
	
	/**
	 * 获取后台手动添加的字段 NEW
	 * @param resId
	 * @return
	 */
	public List<ResFldInfo> ListResFldNew(int resId){
		return getHibernateTemplate().find("FROM ResFldInfo r where 1 = 1 and r.resId = ? ORDER BY r.top DESC ",resId);
	}
	
}
