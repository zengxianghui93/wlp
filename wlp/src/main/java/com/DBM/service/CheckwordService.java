package com.DBM.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.DBM.dao.ResDataDao;
@Service
public class CheckwordService {
	
	@Autowired
	private ResDataDao resDataDao;
	/**
	 * 根据传进来的词，检索错词库返回list
	 * @param words
	 * @return
	 */
	public List queryword(String words){
		JdbcTemplate jdbcTemplate = resDataDao.getJdbcTemplate();
		String sql = "select * from wf_b_intelligent_check where errorWords like ? ";
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, "%"+words+"%");
		return queryForList;
	}
}
