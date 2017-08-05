package com.DBM.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.DBM.dao.DBMDao;
import com.DBM.dao.Page;
import com.DBM.dao.ResFldInfoDao;
import com.DBM.dao.ResInfoDao;
import com.DBM.domain.ResFldInfo;
import com.DBM.domain.ResInfo;



@Service
public class DBMService {
	@Autowired
	private DBMDao dbmDao;
	@Autowired
	private ResInfoDao resInfoDao;
	@Autowired
	private ResFldInfoDao resFldInfoDao;
	
	/**
	 * 创建一个物理表
	 * @param tName
	 * @param fields
	 */
	public int addTables(JdbcTemplate jt, String tName,String fields){
		//判断是否已有该表
		try {
			if(dbmDao.getAllTableName(jt,tName))
				return 0;
			else
				dbmDao.createTable(jt,tName, fields);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	/**
	 * 创建一个资源库
	 * @param jt
	 * @param res
	 * @return
	 */
	public int addRes(JdbcTemplate jt,ResInfo res){
		//判断对应的物理表是否存在
		try {
			if(dbmDao.getAllTableName(jt,res.getResTblName()))
				return 0;
			else
				resInfoDao.save(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	/**
	 * 添加一个字段
	 * @param resFld
	 */
	public void addResFld(JdbcTemplate jt,ResFldInfo resFld){
		
		ResInfo resInfo=resInfoDao.get(resFld.getResId());
		String isNull="";
		if(resFld.getFldIsNull()==0) isNull=" NOT NULL";
		
		String fldLength="";
		if(!"datetime".equals(resFld.getFldType()) && !"longtext".equals(resFld.getFldType())){
			fldLength="("+resFld.getFldLength()+")";
		}
		
		dbmDao.AlterTable(jt, "ALTER TABLE "+resInfo.getResTblName()+" ADD "+resFld.getFldName()+" "+resFld.getFldType()+fldLength+isNull);
		resFldInfoDao.save(resFld);
	}
	
	/**
	 * 修改一个字段
	 * @param resFld
	 */
	public void editResFld(JdbcTemplate jt,ResFldInfo resFld){
		resFldInfoDao.update(resFld);
		ResInfo resInfo=resInfoDao.get(resFld.getResId());
		String isNull="";
		if(resFld.getFldIsNull()==0) isNull=" NOT NULL";
		//alter table tab_info rename column createname to thisname;
		dbmDao.AlterTable(jt, "ALTER TABLE "+resInfo.getResTblName()+" modify column  "+resFld.getFldName()+" "+resFld.getFldType()+" ("+resFld.getFldLength()+") "+isNull);
	}
	
	/**
	 * 插入和更新数据
	 * @param jt
	 * @param sql
	 */
	public void addData(JdbcTemplate jt,String sql){
		dbmDao.updateTable(jt, sql);
	}
	/**
	 * 删除某条数据
	 */
	public void delData(JdbcTemplate jt,String tableName,String id){
		
		dbmDao.delData(jt, tableName, id);
	}
	/**
	 * 将某张表的数据设置为隐藏或显示（删除功能）
	 */
	public void delData1(JdbcTemplate jt,String tableName,String id,String deleted){
		dbmDao.delData1(jt, tableName, id, deleted);
	}
	/**
	 * 查询返回一条数据
	 * @param jt
	 * @param sql
	 */
	public Map<String, Object> getData(JdbcTemplate jt,String tableName,String id){
		List lstData=dbmDao.getResData(jt, tableName, id);		
		
			Map<String, Object> mapRe=new HashMap<String, Object>();
			mapRe=(Map)lstData.get(0); 
			
		return mapRe;
	}
	
	/**
	 * 根据ID获取ResInfo
	 * @param resId
	 * @return
	 */
	public ResInfo  getResInfo(int resId)
	{
		return resInfoDao.get(resId);
	}
	
	/**
	 * 根据ID获取ResFldInfo
	 * @param resFldId
	 * @return
	 */
	public ResFldInfo getResFld(int resFldId)
	{
		return resFldInfoDao.get(resFldId);
	}
	
	/**
	 * 获取全部资源库的列表
	 * @param 
	 * @return
	 */
	public Page ListRes(int pageNo,int pageSize,String resName)
	{
		return resInfoDao.getPageDBM(pageNo, pageSize, resName);
	}
	
	/**
	 * 获取资源库的全部字段
	 * @param resId
	 * @return
	 */
	public List<ResFldInfo> ListResFld(int resId){
		return resFldInfoDao.ListResFld(resId);
	}
	
	/**
	 * 获取资源库的全部字段
	 * @param resId
	 * @return
	 */
	public List<ResFldInfo> ListResFldNew(int resId){
		return resFldInfoDao.ListResFldNew(resId);
	}
	
	
	/**
	 * 根据表名和记录id,获取这条记录
	 * @param tableName
	 * @param infoId
	 * @return
	 */
	public Object getDataById(String tableName,Integer infoId){
		return resInfoDao.queryDataById(tableName, infoId);
	}
	
	
	/**
	 * 分页查询所有可以显示的资源库信息
	 * @param pageNo
	 * @param pageSize
	 * @return Page
	 */
	public Page getAllXIANSHIResPage(int pageNo,int pageSize){
		return resInfoDao.getAllXIANSHIResPage(pageNo, pageSize);
	}
	
	/**
	 * 查询所有可以显示的资源库信息
	 * @return List<ResInfo> 
	 */
	public List<ResInfo> getAllXIANSHIRes(){
		return resInfoDao.getAllXIANSHIRes();
	}
	
	/**
	 * 添加对应资源库的审核人id
	 * @param jt
	 * @param tableName
	 * @param resBegin
	 * @param resEnd
	 * @param userId
	 * @param taskId任务id
	 */
	public void addCheckedUserId(JdbcTemplate jt,String tableName,String resBegin,String resEnd,Integer userId,Integer taskId){
		dbmDao.addCheckedUserId(jt, tableName, resBegin, resEnd, userId,taskId);
	}
	
	/**
	 * 添加对应资源库的编辑人id
	 * @param jt
	 * @param tableName
	 * @param resBegin
	 * @param resEnd
	 * @param userId
	 * @param taskId任务id
	 */
	public void addUpdatedUserId(JdbcTemplate jt,String tableName,String resBegin,String resEnd,Integer userId,Integer taskId){
		dbmDao.addUpdatedUserId(jt, tableName, resBegin, resEnd, userId,taskId);
	}
	
	/**
	 * 获取全部资源库的列表
	 * @param 
	 * @return
	 */
	public Page getPageDBM3(int pageNo,int pageSize,List res)
	{
		return resInfoDao.getPageDBM3(pageNo, pageSize,res);
	}
	
	/**
	 * 批量审核
	 * @param talName 表名
	 * @param pubFlag 审核结果
	 * @param ids id字符串集，类似  (1,2,3)
	 * @return
	 */
	public void setPubFlagPiLiang(String talName,String pubFlag,String[] ids)
	{
		resInfoDao.setPubFlagPiLiang(talName, pubFlag,ids);
	}

	/**
	 * 根据条件和资源库表名和条件查询未审核的数据的数量
	 * @param resTalbeName 
	 * @param where
	 * @return 
	 */
	public Integer getNoCheckNum(JdbcTemplate jt,String resTalbeName, String where) {
		return dbmDao.getNoCheckNum(jt,resTalbeName,where);
	}
	
	/**
	 * 根据条件和数量修改审核者id
	 * @param jt
	 * @param tableName
	 * @param where
	 * @param resNums
	 * @param userId
	 * @param taskId
	 */
	public String addCheckedUserIdByresNums(JdbcTemplate jt,String tableName,String where,Integer resNums,Integer userId,Integer taskId){
		String ids = "(";
		List<Map<String, Object>> list = dbmDao.getNums(jt, tableName, where, resNums, userId);
		for (Map<String, Object> map : list) {
			if (ids.equals("(")) {
				ids += map.get("id");
			}else{
				ids += ","+map.get("id");
			}
		}
		ids += ")";
		dbmDao.addCheckedUserIdByresNums(jt, tableName, ids, userId,taskId);
		return ids;
	}
	/**
	 * 根据条件和数量修改修改者id
	 * @param jt
	 * @param tableName
	 * @param where
	 * @param resNums
	 * @param userId
	 * @param taskId任务id
	 */
	public String addUpdatedUserIdByresNums(JdbcTemplate jt,String tableName,String where,Integer resNums,Integer userId,Integer taskId){
		String ids = "(";
		List<Map<String, Object>> list = dbmDao.getNums(jt, tableName, where, resNums, userId);
		for (Map<String, Object> map : list) {
			if (ids.equals("(")) {
				ids += map.get("id");
			}else{
				ids += ","+map.get("id");
			}
		}
		ids += ")";
		dbmDao.addUpdatedUserIdByresNums(jt, tableName, ids, userId,taskId);
		return ids;
	}
	/**
	 * 删除审核者
	 * @param jt
	 * @param tableName
	 * @param ids
	 */
	public void delCheckUserId(JdbcTemplate jt,String tableName,String ids){
		dbmDao.delCheckUserIdOrUpdatedUserId(jt,"checkedUserId",tableName,ids);
	}
	/**
	 * 删除修改者
	 * @param jt
	 * @param tableName
	 * @param ids
	 */
	public void delUpdatedUserId(JdbcTemplate jt,String tableName,String ids){
		dbmDao.delCheckUserIdOrUpdatedUserId(jt,"updatedUserId",tableName,ids);
	}
}
