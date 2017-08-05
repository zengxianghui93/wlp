package com.DBM.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class VisualDao extends AbstractDao{
	
	/**
	 * 查询导航栏信息
	 * @param jd
	 * @return
	 */
	public List<Map<String,Object>> findNav(){
		String sql =" select id,name,to_url,shunx from wf_front_manage where deleted=1  order by shunx";

		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	/**
	 * 查询模块相关
	 * @param jd
	 * @return
	 */
	public List<Map<String,Object>> findModule(){
		String sql =" select * from wf_front_module where deleted=1 order by module_shunx";

		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	
	
	/**
	 * 获取友情链接
	 * @param jd
	 * @return
	 */
	public List<Map<String,Object>> findFriendlyLink(){
		String sql =" select * from wf_friendly_link where deleted=1 order by shunx";

		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	/**
	 * 获取banner
	 * @param jd
	 * @return
	 */
	public List<Map<String,Object>> findBanner(){
		String sql =" select * from wf_front_banner where deleted=1 order by shunx";

		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	/**
	 * 产品中心轮播图片
	 * @param jd
	 * @return
	 */
	public List<Map<String,Object>> findPCBanner(){
		String sql =" select * from wf_pcenter_banner where deleted=1 order by sx";
		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	
	
	
}
