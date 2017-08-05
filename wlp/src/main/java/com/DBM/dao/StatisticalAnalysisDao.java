package com.DBM.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.iterators.ArrayListIterator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticalAnalysisDao {
	/**
	 * 根据资源库表名获取数据总量、最后更新时间
	 * @param jt
	 * @param tableName
	 */
	public List getData(JdbcTemplate jt,String tableName){
		
		String sql = "select '"+tableName+"' as 'tableName',count(*) as 'countAll',max(editTime) as 'editTime' "
				+ "from "+tableName;
		return jt.queryForList(sql);
	}
	
	/**
	 * 根据资源库表名获取数据总量、最后更新时间
	 * @param jt
	 * @param tableName
	 */
	public List getLanguage(JdbcTemplate jt,String resType){
		if (resType==null||"".equals(resType)) {
			return new ArrayList();
		}
		
		String resTypesql = "select wf_authority_cn as 'language' from wf_b_langinfo where f_id = "+resType;
		return jt.queryForList(resTypesql);
	}

	/**
	 * 根据期刊名获取该期刊的详细信息
	 * @param name
	 * @return
	 */
	public List<Map<String, Object>> getJournalDetail(JdbcTemplate jt,String name) {
		String sql = "SELECT wf_year_Index,wf_issue,COUNT(id) as num FROM wf_b_chinesejournal where wf_journalName='"+name+"' GROUP BY wf_year_Index,wf_issue ORDER BY "+
						"wf_year_Index desc,IF(CHAR_LENGTH(wf_issue)>1,wf_issue,CONCAT('0',wf_issue)) asc";
		return jt.queryForList(sql);
	}

	public List<Map<String, Object>> getForeignJournalDetail(JdbcTemplate jt,
			String name) {
		String sql = "SELECT wf_year_Index,wf_issue,COUNT(id) as num FROM wf_b_libraryabstract where wf_source = 1 and wf_journalName='"+name+"' GROUP BY wf_year_Index,wf_issue ORDER BY "+
				"wf_year_Index desc,IF(CHAR_LENGTH(wf_issue)>1,wf_issue,CONCAT('0',wf_issue)) asc";
		return jt.queryForList(sql);
	}
}
