package com.DBM.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ResInfoDao;

@Service
public class RecordService {
	@Autowired
	private ResInfoDao resInfoDao;
	
	public List<Map<String, Object>> getRecord(int resId,int id){
		return resInfoDao.listByResIdAndId(resId, id);
	}

	public ResInfoDao getResInfoDao() {
		return resInfoDao;
	}

	public void setResInfoDao(ResInfoDao resInfoDao) {
		this.resInfoDao = resInfoDao;
	}
}
