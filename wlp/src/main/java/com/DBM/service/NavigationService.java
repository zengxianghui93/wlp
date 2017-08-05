package com.DBM.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.NavigationDao;

@Service
public class NavigationService {
	
	@Autowired
	private NavigationDao navigationDao;
	
	public List list(String tableName, int page,int pageSize,String zhongwen,String  yingwen, String dewen, String riwen, String yidaliwen, String fawen, String zhongguo, String meiguo, String deguo, String faguo, String yingguo, String ziduan, String searchValue){
		return navigationDao.list(tableName, page, pageSize, zhongwen, yingwen,dewen,riwen,yidaliwen,fawen,zhongguo,meiguo,deguo,faguo,yingguo,ziduan,searchValue);
	}
	
	public int getTotal(String tableName, int page,int pageSize,String zhongwen,String  yingwen, String dewen, String riwen, String yidaliwen, String fawen, String zhongguo, String meiguo, String deguo, String faguo, String yingguo, String ziduan, String searchValue){
		return navigationDao.getTotal(tableName, page, pageSize, zhongwen, yingwen,dewen,riwen,yidaliwen,fawen,zhongguo,meiguo,deguo,faguo,yingguo,ziduan,searchValue);
	}
	
	public int getTotal(String sql){
		return navigationDao.getTotal(sql);
	}
	
	public List<Map<String, Object>> get(int id, String table) {
		return navigationDao.get(id,table);
	}
	public List<Map<String, Object>> navigationSearch(String table, String search, int page, int pageSize) {
		// TODO Auto-generated method stub
		return navigationDao.navigationSearch(table, search, page, pageSize);
	}
	
	public NavigationDao getNavigationDao() {
		return navigationDao;
	}

	public void setNavigationDao(NavigationDao navigationDao) {
		this.navigationDao = navigationDao;
	}

	public List listNew(String tableName, int page, int pageSize, String language, String country, String ziduan,
			String searchValue) {
		return navigationDao.listNew(tableName, page, pageSize, language, country , ziduan, searchValue);
	}

	public int getTotalNew(String tableName, int page, int pageSize, String language, String country, String ziduan,
			String searchValue) {
		return navigationDao.getTotalNew(tableName, page, pageSize, language, country, ziduan, searchValue);
	}

	
	
}
