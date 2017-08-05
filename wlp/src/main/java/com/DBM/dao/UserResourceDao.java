package com.DBM.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DBM.domain.UserOpCategory;
import com.DBM.domain.UserResource;
import com.DBM.util.SearchEscape;
import com.itextpdf.text.log.SysoCounter;

@Repository
public class UserResourceDao extends BaseDao<UserResource>{

	private UserResource urs;
	/**
	 * 根据用户id删除信息
	 * @param userId
	 */
	public void delByUserId(Integer userId) {
		String sql = "delete from tb_user_resource where user_id="+userId;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.createSQLQuery(sql).executeUpdate();
	}

	/**
	 * 获取馆藏文摘的刊名id
	 * @param resId
	 * @param f_id
	 * @return
	 */
	public Object getResSourceId(Integer f_id) {
		String sql = "select mainTainCode from wf_b_libraryabstract where id="+f_id;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		return session.createSQLQuery(sql).uniqueResult();
	}
	
	/**
	 * 根据用户Id获取其具有权限的库
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> qUserQDataByUserId(Integer userId){
		if(userId == null){
			return null;
		}
		String sql = "select distinct res_id  from tb_user_resource where user_id="+userId;
		return getJdbcTemplate().queryForList(sql);
	}
	
	
	/**
	 * 根据用户Id获取所有有权限的刊id
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> qUserQJournalByUserId(Integer userId){
		if(userId == null){
			return null;
		}
		String sql = "select  res_source_id  from tb_user_resource where user_id="+userId;
		return getJdbcTemplate().queryForList(sql);
	}
	
	/**
	 * 根据期刊id查询出所有期刊
	 * @param userId
	 * @return
	 */
	public  String qUserQDataByJournalId(Integer userId){
		if(userId == null){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		SearchEscape se = new SearchEscape();
		List<Map<String, Object>> qJournal = qUserQJournalByUserId(userId);
		if(qJournal.size()>0){
			for(Map<String, Object>  resMap : qJournal){
				for(String k : resMap.keySet()){
					System.out.println("j----:"+k+","+"value---:"+resMap.get(k));
					if(null != resMap.get(k)){
						String sql = "select name  from wf_b_journalmaintain where id="+resMap.get(k);
						List<Map<String, Object>> nameL = getJdbcTemplate().queryForList(sql);
						//过滤掉特殊字符
						sb.append("(wf_journalName:"+se.escape(nameL.get(0).get("name")+"")+")OR");
					}
				}
			}
			return sb.toString().substring(0,sb.toString().lastIndexOf("OR"));
		}else{
			return null;
		}
	
	}

}
