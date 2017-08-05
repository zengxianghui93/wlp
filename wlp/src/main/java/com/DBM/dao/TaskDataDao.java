package com.DBM.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.DBM.domain.TaskData;

@Repository
public class TaskDataDao extends BaseDao<TaskData>{
	public Page getPageList(TaskData taskData,int pageNo,int pageSize){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria1 = session.createCriteria(TaskData.class);
		Criteria criteria2 = session.createCriteria(TaskData.class);
		criteria1.setProjection(Projections.rowCount());
		if (taskData.getTaskType() != null &&!taskData.getTaskType().equals("")) {
			criteria2.add(Restrictions.eq("taskType", taskData.getTaskType()));
			criteria1.add(Restrictions.eq("taskType", taskData.getTaskType()));
		}
		if (taskData.getTaskTableName() != null && !"".equals(taskData.getTaskTableName())) {
			criteria2.add(Restrictions.eq("taskTableName", taskData.getTaskTableName()));
			criteria1.add(Restrictions.eq("taskTableName", taskData.getTaskTableName()));
		}
		if (taskData.getTaskName() != null && !"".equals(taskData.getTaskName())) {
			criteria2.add(Restrictions.like("taskName", taskData.getTaskName()));
			criteria1.add(Restrictions.like("taskName", taskData.getTaskName()));
		}
		if (taskData.getTaskUserName() != null && !"".equals(taskData.getTaskUserName())) {
			criteria2.add(Restrictions.like("taskUserName", taskData.getTaskUserName()));
			criteria1.add(Restrictions.like("taskUserName", taskData.getTaskUserName()));
		}
		if (taskData.getHandBeginTime() != null) {
			criteria2.add(Restrictions.ge("handBeginTime", taskData.getHandBeginTime()));
			criteria1.add(Restrictions.ge("handBeginTime", taskData.getHandBeginTime()));
		}
		if (taskData.getHandEndTime() != null) {
			criteria2.add(Restrictions.le("handEndTime", taskData.getHandEndTime()));
			criteria1.add(Restrictions.le("handEndTime", taskData.getHandEndTime()));
		}
		criteria2.setFirstResult(pageSize*(pageNo-1));
		criteria2.setMaxResults(pageSize);
		criteria2.addOrder(Order.desc("creatTime"));
			
		Page page = null;
		Object o = criteria1.uniqueResult();
		int size = 0;
		if (o!=null) {
			size = Integer.parseInt(o.toString());
		}
		if (size==0) {
			page = new Page();
		}else{
			int startIndex = Page.getStartOfPage(pageNo, pageSize);
			page = new Page(startIndex, size, pageSize, criteria2.list());
		}
		//new Page(startIndex, totalCount, pageSize, query.setFirstResult(startIndex).setMaxResults(pageSize).list());
		return page;
	}
	
	public Page getMyPageList(TaskData taskData,int pageNo,int pageSize){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria1 = session.createCriteria(TaskData.class);
		Criteria criteria2 = session.createCriteria(TaskData.class);
		if (taskData.getTaskUserId()!=null) {
			criteria1.add(Restrictions.eq("taskUserId", taskData.getTaskUserId()));
			criteria2.add(Restrictions.eq("taskUserId", taskData.getTaskUserId()));
		}
		criteria1.setProjection(Projections.rowCount());
		if (taskData.getTaskType() != null &&!taskData.getTaskType().equals("")) {
			criteria2.add(Restrictions.eq("taskType", taskData.getTaskType()));
			criteria1.add(Restrictions.eq("taskType", taskData.getTaskType()));
		}
		if (taskData.getTaskTableName() != null && !"".equals(taskData.getTaskTableName())) {
			criteria2.add(Restrictions.eq("taskTableName", taskData.getTaskTableName()));
			criteria1.add(Restrictions.eq("taskTableName", taskData.getTaskTableName()));
		}
		if (taskData.getTaskName() != null && !"".equals(taskData.getTaskName())) {
			criteria2.add(Restrictions.like("taskName", taskData.getTaskName()));
			criteria1.add(Restrictions.like("taskName", taskData.getTaskName()));
		}
		if (taskData.getTaskUserName() != null && !"".equals(taskData.getTaskUserName())) {
			criteria2.add(Restrictions.like("taskUserName", taskData.getTaskUserName()));
			criteria1.add(Restrictions.like("taskUserName", taskData.getTaskUserName()));
		}
		if (taskData.getHandBeginTime() != null) {
			criteria2.add(Restrictions.ge("handBeginTime", taskData.getHandBeginTime()));
			criteria1.add(Restrictions.ge("handBeginTime", taskData.getHandBeginTime()));
		}
		if (taskData.getHandEndTime() != null) {
			criteria2.add(Restrictions.le("handEndTime", taskData.getHandEndTime()));
			criteria1.add(Restrictions.le("handEndTime", taskData.getHandEndTime()));
		}
		criteria2.setFirstResult(pageSize*(pageNo-1));
		criteria2.setMaxResults(pageSize);
		criteria2.addOrder(Order.desc("creatTime"));
			
		Page page = null;
		Object o = criteria1.uniqueResult();
		int size = 0;
		if (o!=null) {
			size = Integer.parseInt(o.toString());
		}
		if (size==0) {
			page = new Page();
		}else{
			int startIndex = Page.getStartOfPage(pageNo, pageSize);
			page = new Page(startIndex, size, pageSize, criteria2.list());
		}
		//new Page(startIndex, totalCount, pageSize, query.setFirstResult(startIndex).setMaxResults(pageSize).list());
		return page;
	}
	
	/**
	 * 根据用户Id获取和用户有关的资源库
	 * @param userId
	 * @return
	 */
	public List getTableNameByuserId(Integer userId){
		String hql = "select distinct taskTableName from TaskData where taskUserId ="+userId;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	/**
	 * 根据数据库表名、审核者id获取审核者已审核的数量和任务的总数
	 * @return list
	 */
	public Object getAllAndYesDataNum(String tableName,Integer userId,String beginId,String endId){
		String sql = "SELECT COUNT(1) as allNum,SUM(CASE WHEN (pubFlag = 1 OR pubFlag = 2) then 1 else 0 end ) as checkNum FROM "+tableName+" where id >="+beginId+" and id<="+endId;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session.createSQLQuery(sql).uniqueResult();
	}
	
	/**
	 * 根据数据库表名、审核者id、文章id组获取审核者已审核的数量和任务的总数
	 * @return list
	 */
	public Object getAllAndYesDataNum2(String tableName,Integer userId,String ids){
		String sql = "SELECT COUNT(1) as allNum,SUM(CASE WHEN (pubFlag = 1 OR pubFlag = 2) then 1 else 0 end ) as checkNum FROM "+tableName+" where id in "+ids;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session.createSQLQuery(sql).uniqueResult();
	}

	/**
	 * 获取下一个Id
	 * 
	 */
	public Object getId() {
		String sql = "SELECT Auto_increment FROM information_schema.`TABLES` WHERE  table_name = 'tb_task_data' limit 1";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session.createSQLQuery(sql).uniqueResult();
	}

}
