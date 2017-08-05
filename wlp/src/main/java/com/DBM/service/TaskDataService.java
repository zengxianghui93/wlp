package com.DBM.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.Page;
import com.DBM.dao.TaskDataDao;
import com.DBM.domain.TaskData;
@Service
public class TaskDataService {
	@Autowired
	TaskDataDao taskDataDao;
	public List<TaskData> loadAll(){
		return taskDataDao.loadAll();
	}
	/**
	 * 根据条件获取所有的任务
	 * @param taskData
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPageList(TaskData taskData,int pageNo,int pageSize){
		return taskDataDao.getPageList(taskData, pageNo, pageSize);
	}

	/**
	 * 添加任务管理信息
	 * @param taskData
	 */
	public void addTaskData(TaskData taskData) {
		if (taskData.getId()==null) {
			taskDataDao.save(taskData);
		}else{
			taskDataDao.update(taskData);
		}
		
	}
	
	/**
	 * 根据条件获取当前用户的所有的任务列表
	 * @param taskData
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getMyPageList(TaskData taskData,int pageNo,int pageSize){
		return taskDataDao.getMyPageList(taskData, pageNo, pageSize);
	}
	
	/**
	 * 获取指定用户的所有任务的详细信息
	 */
	public List<TaskData> getAllByUserId(Integer userId){
		if (userId==null) {
			return null;
		}
		return taskDataDao.findRT("select * from TaskData where taskUserId = "+userId);
	}
	/**
	 * 根据用户Id获取和用户有关的资源库
	 * @param userId
	 * @return
	 */
	public List getTableNameByuserId(Integer userId){
		return taskDataDao.getTableNameByuserId(userId);
	}
	
	/**
	 * 根据数据库表名、审核者id获取审核者已审核的数量和任务的总数
	 * @param tableName 资源库
	 * @param userId 用户id
	 * @param beginId 文章开始id
	 * @param endId 文章结束id
	 * @return list(allNum，checkNum)
	 */
	public Object getAllAndYesDataNum(String tableName,Integer userId,String beginId,String endId){
		return taskDataDao.getAllAndYesDataNum(tableName, userId, beginId, endId);
	}
	/**
	 * 根据数据库表名、审核者id、文章id组获取审核者已审核的数量和任务的总数
	 * @return list
	 */
	public Object getAllAndYesDataNum2(String tableName,Integer userId,String ids){
		if(tableName==null||userId==null||ids==null){
			return null;
		}
		return taskDataDao.getAllAndYesDataNum2(tableName, userId, ids);
	}
	/**
	 * 删除任务
	 * @param taskData
	 */
	public void delTaskData(TaskData taskData){
		if (taskData==null||taskData.getId()==null) {
			return;
		}
		taskDataDao.remove(taskData);
	}
	
	/**
	 * 根据任务id获取任务详细信息
	 * @param taskData
	 */
	public TaskData getTaskDataById(Integer taskDataId){
		if (taskDataId==null) {
			return null;
		}
		String hql = "from TaskData where id ="+taskDataId;
		List<TaskData> list = taskDataDao.findRT(hql);
		return list.isEmpty()?null:list.get(0);
	}
	
	/**
	 * 获取任务的下一个id
	 */
	public Object getId(){
		return taskDataDao.getId();
	}
}
