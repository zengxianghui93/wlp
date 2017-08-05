package com.DBM.dao;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBMDao {

	
	/**
	 * 根据表名称创建一张表
	 * @param tableName
	 */
	public int createTable(JdbcTemplate jt,String tableName,String fields){
		
		StringBuffer sb = new StringBuffer("");
		sb.append("CREATE TABLE `"+tableName+"` (");
		sb.append(" `id` int(11) NOT NULL AUTO_INCREMENT,");	
		sb.append(" `pubFlag` int(11) DEFAULT  NULL ,");
		sb.append(" `categoryId` varchar(64) DEFAULT  NULL ,");
		sb.append(" `createTime` datetime DEFAULT  NULL ,");
		sb.append(" `editTime` datetime DEFAULT  NULL ,");
		sb.append(" `userId` int(11) DEFAULT  NULL ,");
		sb.append(" `checkedUserId` int(11) DEFAULT  NULL ,");
		sb.append(" `updatedUserId` int(11) DEFAULT  NULL ,");
		sb.append(" `isGather` int(2) DEFAULT  1 COMMENT '是否属于采集(0:是，1:否)' ,");
		sb.append(" `deleted` int(2) DEFAULT  1 COMMENT '是否删除(0:是，1:否)' ,");
		sb.append(" PRIMARY KEY (`id`) ,");
		sb.append(" INDEX `isGather` (`isGather`) USING BTREE ");
		sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		try {
			jt.update(sb.toString());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 插入和更新表数据
	 * @param jt
	 * @param sql
	 * @return
	 */
	public int updateTable(JdbcTemplate jt,String sql){
		try {
			jt.update(sql);
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 修改表结构
	 * @param jt
	 * @param sql
	 */
	public void AlterTable(JdbcTemplate jt,String sql){
		try {
			jt.update(sql);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询数据库是否有某表
	 * @param cnn
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static boolean getAllTableName(JdbcTemplate jt,String tableName) throws Exception {

		Connection conn = jt.getDataSource().getConnection();
		ResultSet tabs = null;
		try {
			DatabaseMetaData dbMetaData = conn.getMetaData();
			String[]   types   =   { "TABLE" };
			tabs = dbMetaData.getTables(null, null, tableName, types);
			if (tabs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			tabs.close();
			conn.close();
		}
		return false;
	}
	/**
	 * 根据表名和删除一条字段
	 * @param jt
	 * @param sql
	 * @return
	 */
	public List getResDatass(JdbcTemplate jt,String tableName,String id){
		List lstResult=jt.queryForList("select * from "+tableName+" where id="+id+"");
		return lstResult;
	}
	/**
	 * 根据id查询一条记录
	 * @param jt
	 * @param sql
	 * @return
	 */
	public List getResData(JdbcTemplate jt,String tableName,String id){
		List lstResult=jt.queryForList("select * from "+tableName+" where id="+id+"");
		return lstResult;
	}
	/*
	 * 
	 * 删除某张表的某个记录
	 */
	public void delData(JdbcTemplate jt,String tableName,String id){
		String sql ="delete from "+tableName+" where id='"+id+"'";
		
		jt.execute(sql);
		
	}
	/**
	 * 
	 * 将某张表的数据设置为隐藏或显示（删除功能）
	 */
	public void delData1(JdbcTemplate jt,String tableName,String id,String deleted){
		String sql ="update "+tableName+" set deleted = "+deleted+" where id='"+id+"'";
		
		jt.execute(sql);
		
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
		if(tableName==null||resBegin==null||resEnd==null){
			return ;
		}
		String sql = null;
		if("wf_b_mi".equals(tableName)){
			sql = "update "+tableName+" set taskId = "+taskId+",checkedUserId = "+userId+" where id >="+resBegin+" and id <="+resEnd;
		}else{
			sql = "update "+tableName+" set checkedUserId = "+userId+" where id >="+resBegin+" and id <="+resEnd;
		}
		jt.execute(sql);
		
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
		if(tableName==null||resBegin==null||resEnd==null){
			return ;
		}
		String sql = null;
		if("wf_b_mi".equals(tableName)){
			sql = "update "+tableName+" set taskId = "+taskId+",updatedUserId = "+userId+" where id >="+resBegin+" and id <="+resEnd;
		}else{
			sql = "update "+tableName+" set updatedUserId = "+userId+" where id >="+resBegin+" and id <="+resEnd;
		}
		jt.execute(sql);
		
	}

	/**
	 * 根据条件和资源库表名和条件查询未审核的数据的数量
	 * @param resTalbeName
	 * @param where
	 */
	public Integer getNoCheckNum(JdbcTemplate jt,String resTalbeName, String where) {
		if(resTalbeName==null||"".equals(resTalbeName)){
			return 0;
		}
		String sql = "select count(1) from "+resTalbeName+where;
		return jt.queryForInt(sql);
	}
	
	/**
	 * 根据条件和数量修改审核者id
	 * @param jt
	 * @param tableName
	 * @param where
	 * @param resNums
	 * @param userId
	 * @param taskId 任务id
	 */
	public void addCheckedUserIdByresNums(JdbcTemplate jt,String tableName,String ids,Integer userId,Integer taskId){
		if(tableName==null){
			return ;
		}
		String sql = null;
		if("wf_b_mi".equals(tableName)){
			sql = "UPDATE "+tableName+" SET taskId = "+taskId+",checkedUserId = "+userId+" where id in "+ids;
		}else{
			sql = "UPDATE "+tableName+" SET checkedUserId = "+userId+" where id in "+ids;
		}
		jt.execute(sql);
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
	public void addUpdatedUserIdByresNums(JdbcTemplate jt,String tableName,String ids,Integer userId,Integer taskId){
		if(tableName==null){
			return ;
		}
		String sql = null;
		if("wf_b_mi".equals(tableName)){
			sql = "UPDATE "+tableName+" SET taskId = "+taskId+",updatedUserId = "+userId+" where id in "+ids;
		}else{
			sql = "UPDATE "+tableName+" SET updatedUserId = "+userId+" where id in "+ids;
		}
		jt.execute(sql);
	}
	/**
	 * 根据条件和数量获取修改文章的id
	 * @param jt
	 * @param tableName
	 * @param where
	 * @param resNums
	 * @param userId
	 */
	public List<Map<String, Object>> getNums(JdbcTemplate jt,String tableName,String where,Integer resNums,Integer userId){
		if(tableName==null||where==null||resNums==null||userId==null){
			return null;
		}
		String sql = "SELECT id FROM "+tableName+" "+where+" ORDER BY id DESC LIMIT "+resNums;
		return jt.queryForList(sql);
	}

	public void delCheckUserIdOrUpdatedUserId(JdbcTemplate jt,String ziduan, String tableName, String ids) {
		String sql = null;
		if("wf_b_mi".equals(tableName)){
			sql = "update "+tableName+" set "+ziduan+"=null,taskId=null where id in "+ids;
		}else{
			sql = "update "+tableName+" set "+ziduan+"=null where id in "+ids;
		}
		jt.execute(sql);
	}
}
