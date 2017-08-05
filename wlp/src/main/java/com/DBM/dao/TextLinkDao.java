package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.TextLink;

import java.util.List;


@Repository
public class TextLinkDao extends BaseDao<TextLink>{
	private final String GET_TEXTLINK = "from TextLink where infoId like ? order by columid ";
	
	/**
	 * 获取某文章对应的栏目
	 */
	public List getNewsColume(String info_id) {
		return find(GET_TEXTLINK,info_id);
	}
	
}
