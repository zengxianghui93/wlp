package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.TextDownload;

@Repository
public class DownloadDao  extends BaseDao<TextDownload>{
	private final String GET_NEWS_FILES = "from TextDownload  where info_id = ? ";
	
	public Page ListFileByNews(int infoid)
	{
		return pagedNewsFiles(GET_NEWS_FILES,1,20,infoid);
	}
}
