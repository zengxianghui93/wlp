package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.JournalMaintainDao;
import com.DBM.dao.Page;
import com.DBM.domain.JournalMaintain;

@Service
public class JournalMaintainService {
	@Autowired
	JournalMaintainDao journalMaintainDao;

	/**
	 * 根据条件查询page
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @param type
	 * @return
	 */
	public Page getPageList(Integer pageNo, Integer pageSize, String name, String type) {
		
		return journalMaintainDao.getPageList(pageNo, pageSize, name, type);
	}
	

	/**
	 * 根据id获取实体对象
	 * @param id
	 * @return
	 */
	public JournalMaintain getJournalMaintainById(Integer id){
		if (id==null) {
			return null;
		}
		return journalMaintainDao.load(id);
	}
	
	/**
	 * 修改或增加
	 * @param journalMaintain
	 */
	public void journalMaintainAU(JournalMaintain journalMaintain){
		if(journalMaintain.getId()==null){
			journalMaintainDao.save(journalMaintain);
		}else{
			journalMaintainDao.update(journalMaintain);
		}
	}
	
	/**
	 * 删除
	 * @param journalMaintain
	 */
	public void delJournalMaintain(JournalMaintain journalMaintain){
		journalMaintainDao.remove(journalMaintain);
	}
	
	/**
	 * 获取所有刊名
	 * @return
	 */
	public List<JournalMaintain> getAll(){
		return journalMaintainDao.loadAll();
	}
	
}
