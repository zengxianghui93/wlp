package com.DBM.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.DBM.domain.NewsInfo;

@Repository
public class NewsInfoDao extends BaseDao<NewsInfo>{
	private final String GET_PAGED_NEWS = " from NewsInfo a,TextLink b where a.infoId=b.infoId and b.columnId like ? and a.status=1 order by entry_date desc";
	private final String GET_SEARCH_NEWS= " from NewsInfo where content like ? or title like ? and status=1 order by entry_date desc ";
	//private final String GET_NEWS= " from NewsInfo a,TextLink b where a.infoId=b.infoId and a.content like ? or a.title like ? and b.columnId like ? and a.status=1 order by entry_date desc ";
	/**
	 * 获取文章分页
	 * @param pageNo 页号，从1开始。
	 * @param pageSize 每页的记录数
	 * @return 包含分页信息的Page对
	 */
	public Page getPagedNews(String column_id,int pageNo,int pageSize) {
		//return pagedQuery(GET_PAGED_NEWS+"'"+column_id+"%' and NewsInfo.status=1 order by entry_date desc",pageNo,pageSize);//,column_id+"%");
		
		
		
		return pagedNewsQuery(GET_PAGED_NEWS,pageNo,pageSize,column_id+"%");
	}
	
	/**
	 * 获取文章分页  加入了置顶项 istop=1
	 * @param pageNo 页号，从1开始。
	 * @param pageSize 每页的记录数
	 * @return 包含分页信息的Page对
	 */
	public Page getPagedNewsAndTop(String column_id,int pageNo,int pageSize){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 ="select a.info_id from tb_unesco_text a, tb_unesco_text_link b where a.info_id=b.info_id and b.column_id like '%"+column_id+"%' ";
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		
		String sql="( select a.*  from tb_unesco_text a, tb_unesco_text_link b where a.info_id=b.info_id and b.column_id like '%"+column_id+"%' and a.istop=1 order by a.modify_date DESC limit 0,1) union( select a.* from tb_unesco_text a, tb_unesco_text_link b where a.info_id=b.info_id and b.column_id like '%"+column_id+"%' order by a.entry_date DESC limit 0,"+size+")";
		
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(NewsInfo.class);
		
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	
	
	public Page getSearchPagedNews(String key,int pageNo,int pageSize) {
		//return pagedQuery(GET_PAGED_NEWS+"'"+column_id+"%' and NewsInfo.status=1 order by entry_date desc",pageNo,pageSize);//,column_id+"%");
		return pagedSearchNewsQuery(GET_SEARCH_NEWS,pageNo,pageSize,"%"+key+"%");
	}
	/**
	 * 根据关键词，类别分页检索
	 * @param key
	 * @param column_id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPageNewsBySearch(String where,int pageNo,int pageSize){
		String sql="select distinct(a.info_id),a.* from tb_unesco_text a, tb_unesco_text_link b where a.info_id=b.info_id " +where+" order by entry_date desc";
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(NewsInfo.class);
		
		long totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new Page(startIndex, totalCount, pageSize, list);
	}

	
	
}
