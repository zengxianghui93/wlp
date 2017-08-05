package com.DBM.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DBM.domain.ShareDoc;

@Repository
public class ShareDocDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ShareDoc getShareDoc(int id){
		return (ShareDoc) getSession().get(ShareDoc.class, id);
	}
	
	public void createShareDoc(ShareDoc shareDoc){
		getSession().save(shareDoc);
	}
	
	public void updateShareDoc(ShareDoc shareDoc){
		getSession().update(shareDoc);
	}
	
	public void deleteShareDoc(ShareDoc shareDoc){
		if(shareDoc != null){
			getSession().delete(shareDoc);
		}
	}
	public void deleteShareDocs(Set<ShareDoc> shareDocs){
		for (ShareDoc shareDoc : shareDocs) {
			getSession().delete(shareDoc);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ShareDoc> findAllShareDocs(){
		return getSession().createQuery("from ShareDoc ").list();
	}
	
	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	/**************************************共享中心分页列表开始**************************************************************************/
	/**
	 * 共享中心分页列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShareDoc> findAllByPage(int page, int pageSize) {
		String hql = " From ShareDoc where 1=1 and share = :share and audit = :audit ";
		return getSession().createQuery(hql).setBoolean("share", true).setBoolean("audit", true).setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
	}
	/**
	 * 共享中心分页列表 总记录数
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public int getCountByPage(int page, int pageSize){
		String hql = "SElECT count(*) From ShareDoc where 1=1 and share = :share and audit = :audit ";
		return ((Long) getSession().createQuery(hql).setBoolean("share", true).setBoolean("audit", true).uniqueResult()).intValue();
		
	}
	/**************************************共享中心分页列表结束**************************************************************************/
	
	
	/**************************************我的共享 分页列表开始**************************************************************************/
	/**
	 * 我的共享 分页列表
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShareDoc> findMyShareDocs(int userId, int page, int pageSize) {
		String hql = " From ShareDoc where 1=1 and userID = :userID ";
		return getSession().createQuery(hql).setInteger("userID", userId).setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
	
	}
	/**
	 * 我的共享
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public int getCountMyShareDocs(int userId, int page, int pageSize) {
		String hql = "Select count(*) From ShareDoc where 1=1 and userID = :userID ";
		return ((Long) getSession().createQuery(hql).setInteger("userID", userId).uniqueResult()).intValue();
	}
	/**************************************我的共享 分页列表结束**************************************************************************/
	
	/**************************************共享中心 分页查询开始**************************************************************************/
	/**
	 * 共享中心 分页查询 
	 * @param shareDoc
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShareDoc> findAllByPage4Search(ShareDoc shareDoc, int page,
			int pageSize) {
		String hql = " From ShareDoc where 1=1 and share = :share and audit = :audit ";
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			hql += " and title like :title ";
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			hql += " and abstracts like :abstracts ";
		}
		Query query = getSession().createQuery(hql).setBoolean("share", true).setBoolean("audit", true);
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			query.setString("title", "%"+shareDoc.getTitle()+"%");
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			query.setString("abstracts", "%"+shareDoc.getAbstracts()+"%");
		}
		return query.setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
	}
	/**
	 * 共享中心 分页查询 总记录数
	 * @param shareDoc
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public int getCountByPage4Search(ShareDoc shareDoc, int page, int pageSize) {
		String hql = "SElECT count(*) From ShareDoc where 1=1 and share = :share and audit = :audit ";
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			hql += " and title like :title ";
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			hql += " and abstracts like :abstracts ";
		}
		Query query = getSession().createQuery(hql).setBoolean("share", true).setBoolean("audit", true);
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			query.setString("title", "%"+shareDoc.getTitle()+"%");
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			query.setString("abstracts", "%"+shareDoc.getAbstracts()+"%");
		}
		return ((Long)query.uniqueResult()).intValue();
	}
	/**************************************共享中心 分页查询结束**************************************************************************/
	
	/**************************************我的共享 分页查询开始**************************************************************************/
	/**
	 * 我的共享 分页查询
	 * @param shareDoc
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShareDoc> findMyShareDocs4Search(ShareDoc shareDoc, int userId,int page,
			int pageSize) {
		String hql = " From ShareDoc where 1=1 and userID = :userID ";
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			hql += " and title like :title ";
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			hql += " and abstracts like :abstracts ";
		}
		Query query = getSession().createQuery(hql).setInteger("userID", userId);
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			query.setString("title", "%"+shareDoc.getTitle()+"%");
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			query.setString("abstracts", "%"+shareDoc.getAbstracts()+"%");
		}
		return query.setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
	}
	/**
	 * 我的共享 分页查询总记录数
	 * @param shareDoc
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public int getCountMyShareDocs4Search(ShareDoc shareDoc, int userId,
			int page, int pageSize) {
		String hql = "Select count(*) From ShareDoc where 1=1 and userID = :userID ";
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			hql += " and title like :title ";
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			hql += " and abstracts like :abstracts ";
		}
		Query query = getSession().createQuery(hql).setInteger("userID", userId);
		if(shareDoc.getTitle() != null && !"".equals(shareDoc.getTitle())){
			query.setString("title", "%"+shareDoc.getTitle()+"%");
		}
		if(shareDoc.getAbstracts() != null && !"".equals(shareDoc.getAbstracts())){
			query.setString("abstracts", "%"+shareDoc.getAbstracts()+"%");
		}
		return ((Long)query.uniqueResult()).intValue();
	}
	/**************************************我的共享 分页查询结束**************************************************************************/
	
	/**************************************后台管理员审核分页列表开始**************************************************************************/
	/**
	 * 后台管理员审核分页列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShareDoc> findAllByPage4Admin(int page, int pageSize) {
		String hql = " From ShareDoc where 1=1 and share = :share and audit = :audit ";
		return getSession().createQuery(hql).setBoolean("share", true).setBoolean("audit", false).setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
	}
	/**
	 * 后台管理员审核分页列表 总记录数
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public int getCountByPage4Admin(int page, int pageSize){
		String hql = "SElECT count(*) From ShareDoc where 1=1 and share = :share and audit = :audit ";
		return ((Long) getSession().createQuery(hql).setBoolean("share", true).setBoolean("audit", false).uniqueResult()).intValue();
		
	}
	/**************************************后台管理员审核分页列表结束**************************************************************************/
	
	
}
