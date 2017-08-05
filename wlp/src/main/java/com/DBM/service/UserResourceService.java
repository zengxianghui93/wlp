package com.DBM.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DBM.dao.UserResourceDao;
import com.DBM.domain.UserResource;

@Service
public class UserResourceService {
	@Autowired
	private UserResourceDao userResourceDao;
	
	/**
	 * 添加
	 * @param userResource
	 */
	public void addUserResource(UserResource userResource){
		userResourceDao.save(userResource);
	}
	
	/**
	 * 根据用户id删除
	 * @param userId
	 */
	public void delUserResourceByUserId(Integer userId){
		if (userId==null) {
			return;
		}
		userResourceDao.delByUserId(userId);
	}
	
	/**
	 * 根据用户id获取
	 * @param userId
	 */
	public List<UserResource> getUserResourceByUserId(Integer userId){
		if(userId==null){
			return null;
		}
		return userResourceDao.findRT("from UserResource where userId ="+userId);
	}
	
	/**
	 * 根据条件判断有没有权限
	 * @param userId 用户id
	 * @param resId 资源库id
	 * @param resSourceId 资源刊库名Id（针对馆藏文摘或电子出版物：外文期刊、外文会议的刊名id或电子出版物图书的id）
	 * @return
	 */
	public boolean haveAuthority(String userId,String resId,String resSourceId){
		List<UserResource> list=null;
		if("8".equals(resId)||"9".equals(resId)){
			list = userResourceDao.findRT("from UserResource where userId ="+userId+" and resId="+resId+" and resSourceId="+resSourceId);
		}else{
			list = userResourceDao.findRT("from UserResource where userId ="+userId+" and resId="+resId);
		}
		return list.size()>0?true:false;
	}
	
	/**
	 * 获取馆藏文摘资源库刊名id
	 */
	public String getResSourceId(Integer f_id){
		Object o = userResourceDao.getResSourceId(f_id);
		
		return o==null?null:o.toString();
	}
	
	/**
	 * 根据用户Id获取其具有权限的库
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getUserQDataByUserId(Integer userId){
		return  userResourceDao.qUserQDataByUserId(userId);
	}
	
	/**
	 * 根据用户Id获取有权限的全部期刊
	 * @param userId
	 * @return
	 */
	public String getUserQJournalByUserId(Integer userId){
		return userResourceDao.qUserQDataByJournalId(userId);
		
	}
	
	/**
	 * 根据用户Id获取其具有权限的所有库并拼接成检索式
	 * @param userId
	 * @return
	 */
	public String getUserQDataSearchByUserId(Integer userId){
		StringBuffer sb = new StringBuffer();
		List<Map<String, Object>>  qResource = userResourceDao.qUserQDataByUserId(userId);
		if(qResource.size()>0){
			for(Map<String, Object>  resMap : qResource){
				for(String k : resMap.keySet()){
					sb.append("(WF_RESOURCE_INDEX:"+resMap.get(k)+")OR");
					System.out.println("k----:"+k+","+"value---:"+resMap.get(k));
				}
			}
			return sb.toString().substring(0,sb.toString().lastIndexOf("OR"));
		}
		return null;
	}
	
}
