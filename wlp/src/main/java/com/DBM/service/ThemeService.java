package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ThemeDao;
import com.DBM.domain.Theme;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeDao themeDao;

	public List<Theme> list(int page, int pageSize, int userId){
		return themeDao.list(page, pageSize, userId);
	}
	
	public void update(Theme theme){
		themeDao.update(theme);
	}
	
	public Theme getById(int id){
		return themeDao.getById(id);
	}
	
	public void save(Theme theme){
		themeDao.save(theme);
	}
	
	public void removeById(int id) {
		themeDao.removeById(id);
	}
	
	public ThemeDao getThemeDao() {
		return themeDao;
	}

	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}

	public int getTatal(int userId) {
		return themeDao.getTotal(userId);
	}

	
}
