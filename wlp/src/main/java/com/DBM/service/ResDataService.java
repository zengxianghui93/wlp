package com.DBM.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.DBM.dao.Pagination;
import com.DBM.dao.ResDataDao;
import com.DBM.domain.User;

@Service("ResDataService")
public class ResDataService {
	@Resource
    private ResDataDao resDataDao;
	


	/**
	 * 后台分页查询  与本人相关的 超管除外
	 * @param currentPage  当前页 
	 * @param numPerPage   每页记录数
	 * @return 
	 */
	public Pagination queryPageBusiness(String tablename,User user,Integer currentPage,Integer numPerPage) {   
		if(user.getUserType()==user.SUPER_ADMIN){
			return resDataDao.queryPageBusiness(tablename,currentPage, numPerPage);
		}else{
			return resDataDao.queryPageBusinessByUserid(tablename,user.getUserId(),currentPage, numPerPage);
		}
		 
	}
	public Pagination queryPageBusinessAndWhere(String select,String tablename,String where,User user,Integer currentPage,Integer numPerPage) {   
		if(user.getUserType()==user.SUPER_ADMIN){
			return resDataDao.queryPageBusinessByWhere(select,tablename,where,currentPage, numPerPage);
		}else{
			return resDataDao.queryPageBusinessByUserAndWhere(select,tablename,where,user.getUserId(),currentPage, numPerPage);
		}
		 
	}
	/*
	 * 后台获取待审核数据
	 */
	public Pagination queryDataToCheck(String tableName,Integer currentPage,Integer numPerPage){
		return resDataDao.queryPageToCheck(tableName, currentPage, numPerPage);
	}
	/**
	 * 获取已审核数据（特数据库分类）
	 * @param tableName
	 * @return
	 */
	public List queryDataCheckedCate(String tableName){
		
		return resDataDao.queryALLChecked(tableName);
	}
	
	
	/**
	 * 前台分页查询，首先要判断其发布程序
	 * @param tablename
	 * @param currentPage
	 * @param numPerPage
	 * @param flag
	 * @return
	 */
	public Pagination queryPageData(String tablename,Integer currentPage,Integer numPerPage,boolean flag) {   
		return resDataDao.queryPageData(tablename ,currentPage, numPerPage,flag); 
	}
	
	/**
	 *根据id获取一条记录
	 * @param tableName
	 * @param infoId
	 * @return
	 */
	public List queryDataById(String tableName,Integer infoId){
		
		return resDataDao.queryDataById(tableName, infoId);
	}
	
	
	/**
	 * 前台根据条件分页查询，首先要判断其发布流程
	 * @param tablename
	 * @param currentPage
	 * @param numPerPage
	 * @param flag
	 * @return
	 */
	public Pagination queryPageDataByWhere(String tableName,String where,Integer currentPage,Integer numPerPage,boolean flag) {   
		return resDataDao.queryPageDataByWhere(tableName ,where,currentPage, numPerPage,flag); 
	}
	
	
	public List selectAllData(String tableName){
		
		return resDataDao.selectAllData(tableName);
	}
	
	public List<Map<String,Object>> getMIDataBase(){
		return resDataDao.queryALLMIDataBase();
	}
	
	
	/**
	 * 前台根据条件查询，不分页,用于导出记录
	 * @return
	 */
	public List<Map<String, Object>> selectDataByWhere(String tableName,String where){
		return resDataDao.selectDataByWhere(tableName, where);
	}
	
}
