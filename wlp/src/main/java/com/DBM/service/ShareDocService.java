package com.DBM.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.ShareDocDao;
import com.DBM.domain.ShareDoc;

@Service
public class ShareDocService {
	
	@Autowired
	private ShareDocDao shareDocDao;
	
	public ShareDoc getShareDoc(int id){
		return shareDocDao.getShareDoc(id);
	}
	
	public void createShareDoc(ShareDoc shareDoc){
		shareDocDao.createShareDoc(shareDoc);
	}
	
	public void updateShareDoc(ShareDoc shareDoc){
		shareDocDao.updateShareDoc(shareDoc);
	}
	
	public void deleteShareDoc(ShareDoc shareDoc){
		shareDocDao.deleteShareDoc(shareDoc);
	}
	
	public void deleteShareDocs(Set<ShareDoc> shareDocs){
		shareDocDao.deleteShareDocs(shareDocs);
	}
	
	public List<ShareDoc> findAllShareDocs(){
		return shareDocDao.findAllShareDocs();
	}

	public List<ShareDoc> findAllByPage(int page, int pageSize) {
		return shareDocDao.findAllByPage(page,pageSize);
	}
	public int getCountByPage(int page, int pageSize){
		return shareDocDao.getCountByPage(page, pageSize);
	}

	public List<ShareDoc> findMyShareDocs(int userID, int page, int pageSize) {
		return shareDocDao.findMyShareDocs(userID, page,pageSize);
	}

	public int getCountMyShareDocs(int userId, int page, int pageSize) {
		return shareDocDao.getCountMyShareDocs(userId,page,pageSize);
	}

	public List<ShareDoc> findAllByPage4Search(ShareDoc shareDoc, int page,
			int pageSize) {
		return shareDocDao.findAllByPage4Search(shareDoc, page,
			pageSize);
	}

	public int getCountByPage4Search(ShareDoc shareDoc, int page, int pageSize) {
		return shareDocDao.getCountByPage4Search(shareDoc,page,pageSize);
	}

	public List<ShareDoc> findMyShareDocs4Search(ShareDoc shareDoc,int userId, int page,
			int pageSize){
		return shareDocDao.findMyShareDocs4Search(shareDoc,userId,page,pageSize);
	}

	public int getCountMyShareDocs4Search(ShareDoc shareDoc, int userId,
			int page, int pageSize) {
		return shareDocDao.getCountMyShareDocs4Search(shareDoc,userId,page,pageSize);
	}
	
	
	public List<ShareDoc> findAllByPage4Admin(int page, int pageSize) {
		return shareDocDao.findAllByPage4Admin(page,pageSize);
	}
	public int getCountByPage4Admin(int page, int pageSize){
		return shareDocDao.getCountByPage4Admin(page, pageSize);
	}
	
}
