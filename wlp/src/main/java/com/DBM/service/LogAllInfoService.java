package com.DBM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.LogAllInfoDao;
import com.DBM.dao.Page;
import com.DBM.domain.LogAllInfo;
/**
 * 
 * @author maxiaocheng
 *20170224
 */
@Service
public class LogAllInfoService {
	@Autowired
	LogAllInfoDao logAllInfoDao;
	
	/**
	 * 新增日志
	 * @param logAllInfo
	 */
	public void addLogAllInfo(LogAllInfo logAllInfo){
		logAllInfoDao.save(logAllInfo);
	}
	
	/**
	 * 修改日志(慎重使用，原则上不允许修改日志)
	 * @param logAllInfo
	 */
	public void updateLogAllInfo(LogAllInfo logAllInfo){
		logAllInfoDao.update(logAllInfo);
	}
	
	/**
	 * 删除日志(慎重使用，原则上不允许删除日志)
	 * @param logAllInfo
	 */
	public void deleteLogAllInfo(int id){
		logAllInfoDao.remove(logAllInfoDao.get(id));
	}
	/**
	 * 根据用户id和数据资源名和文章id获取本文章下载的次数
	 *  @param userId
	 * @param tableName
	 * @param resId
	 * @return
	 */
	public Integer getNumbyUserIdAndRes(Integer userId,String tableName){
		return logAllInfoDao.getNumbyUserIdAndRes(userId,tableName);
	}
	
	/**
	 * 根据日志分类获取所有日志列表(当logType的值为空串或null时，获取所有的类型)
	 * @param logAllInfo
	 */
	public List findAllLogBylogType(int logType){
		
		return logAllInfoDao.findAllLogAllInfo(logType);
	}
	
	/**
	 * 根据查询条件，分页查找
	 */
	public Page getPageLogAllInfoBySearch(String logType,String userName,String startTime,String endTime,int pageNo,int pageSize){
		
		return logAllInfoDao.getLogAllInfoBySearch(getWhere(logType, userName, startTime, endTime), pageNo, pageSize);
	}
	
	/**
	 * 根据查询条件，查询所有日志
	 */
	public List getAllLogAllInfoBySearch(String logType,String userName,String startTime,String endTime){
		
		return logAllInfoDao.getAllLogAllInfoBySearch(getWhere(logType, userName, startTime, endTime));
	}
	
	/**
	 * 根据查询条件，查询所有日志
	 */
	public List getAllLogAllInfoBySearchForRecommend(String logType,String userName,String startTime,String endTime){
		
		return logAllInfoDao.getAllLogAllInfoBySearchForRecommend(pinJie(logType, userName, startTime, endTime));
	}
	
	/**
	 * 拼接查询条件(私有方法)
	 * @param logType
	 * @param userName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private String getWhere(String logType,String userName,String startTime,String endTime){
		String where = "";
		if (logType!=null&&!"".equals(logType)) {
			where +=" and log_type = "+logType;
		}
		
		if (userName!=null&&!"".equals(userName)) {
			where +=" and user_name like '%"+userName+"%'";
		}
		
		if ("".equals(startTime)) {
			startTime = null;
		}
		
		if ("".equals(endTime)) {
			endTime = null;
		}
		
		if (startTime == null&&endTime != null) {
			where +=" and log_time between SYSDATE() and '" +endTime+"'";
		}else if (startTime != null&&endTime == null) {
			where +=" and log_time between '"+startTime+"' and SYSDATE()";
		}else if (startTime != null&&endTime != null){
			where +=" and log_time between '"+startTime+"' and '"+endTime+"'";
		}
		return where;
	}
	
	/**
	 * 拼接查询条件(私有方法)精确查询
	 * @author longbiao
	 * @since 2017-03-15
	 * @param logType
	 * @param userName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private String pinJie(String logType,String userName,String startTime,String endTime){
		String where = "";
		if (logType!=null&&!"".equals(logType)) {
			where +=" and log_type = "+logType;
		}
		
		if (userName!=null&&!"".equals(userName)) {
			where +=" and user_name = '"+userName+"'";
		}
		
		if ("".equals(startTime)) {
			startTime = null;
		}
		
		if ("".equals(endTime)) {
			endTime = null;
		}
		
		if (startTime == null&&endTime != null) {
			where +=" and log_time between SYSDATE() and '" +endTime+"'";
		}else if (startTime != null&&endTime == null) {
			where +=" and log_time between '"+startTime+"' and SYSDATE()";
		}else if (startTime != null&&endTime != null){
			where +=" and log_time between '"+startTime+"' and '"+endTime+"'";
		}
		
		return where;
	}


}
