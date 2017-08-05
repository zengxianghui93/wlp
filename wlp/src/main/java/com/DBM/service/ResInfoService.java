package com.DBM.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ResInfoDao;
import com.DBM.domain.ResInfo;

@Service
public class ResInfoService {
	
	@Autowired
	private ResInfoDao resInfoDao;
	
	public void save(ResInfo resInfo){
		resInfoDao.update(resInfo);
	}

	public ResInfoDao getResInfoDao() {
		return resInfoDao;
	}

	public void setResInfoDao(ResInfoDao resInfoDao) {
		this.resInfoDao = resInfoDao;
	}
	
	public ResInfo getResInfoByResId(Integer resId){
    	return resInfoDao.getResInfoByResId(resId);
    }

	public List getRessByResFlow(int i) {
		
		return resInfoDao.find("from ResInfo where resFlow = "+i);
	}
	
	/**
	 * 可检索库查询(知识中心、文献中心)
	 */
	public List<Map<String, Object>> getIndexNameForKL(){
		return resInfoDao.qIndexNameForKL();
	}
	
	/**
	 * 知识中心可检索库查询
	 */
	public List<Map<String, Object>> getIndexNameForKC(){
		return resInfoDao.qIndexNameForKC();
	}
	
	/**
	 * 文献中心可检索库查询
	 */
	public List<Map<String, Object>> getIndexNameForLC(){
		return resInfoDao.qIndexNameForLC();
	}
	
}
