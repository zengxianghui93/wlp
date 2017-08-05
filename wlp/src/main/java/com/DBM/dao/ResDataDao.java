package com.DBM.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("ResDataDao")
public class ResDataDao extends AbstractDao{
	
	/*
	 * 分页获取待审核数据
	 */
	public Pagination queryPageToCheck(String tableName,Integer currentPage,Integer numPerPage){
		String sql="SELECT * FROM "+tableName+" where pubFlag='0' ORDER BY id DESC ";
		Pagination page=new Pagination(sql, currentPage, numPerPage, getJdbcTemplate());
		return page;
	}
	/**
	 * 后台分页查询(超管用户)  
	 * @param currentPage  当前页 
	 * @param numPerPage   每页记录数
	 * @return 
	 */
	public Pagination queryPageBusiness(String tableName,Integer currentPage,Integer numPerPage) {  
		//String adminsql="SELECT * FROM "+tableName+" ORDER BY id DESC ";
		String adminsql;
		if(tableName.equals("wf_b_elepublication")){
		adminsql="SELECT * FROM "+tableName+" where wf_by2='' ORDER BY id DESC ";
		}else{
			adminsql="SELECT * FROM "+tableName+" ORDER BY id DESC ";	
		}
		Pagination page=new Pagination(adminsql, currentPage, numPerPage,  getJdbcTemplate());
		return page;    
	}
	
	public Pagination queryPageBusinessByWhere(String select,String tableName,String where,Integer currentPage,Integer numPerPage) {  
		//String adminsql="SELECT * FROM "+tableName+" ORDER BY id DESC ";
		
		
		String adminsql;
		if(tableName.equals("wf_b_elepublication")){
			 adminsql="SELECT "+getIdOrFid(tableName)+select+" FROM "+tableName+" where "+where+" and wf_by2='' ORDER BY id DESC ";	
		}else{
			 adminsql="SELECT "+getIdOrFid(tableName)+select+" FROM "+tableName+" where "+where+" ORDER BY id DESC ";
		}
		Pagination page=new Pagination(adminsql, currentPage, numPerPage,  getJdbcTemplate());
		return page;    
	}
	/**
	 * 后台分页查询(内容管理员)  
	 * @param currentPage  当前页 
	 * @param numPerPage   每页记录数
	 * @return 
	 */
	public Pagination queryPageBusinessByUserid(String tableName,Integer userid,Integer currentPage,Integer numPerPage) {  
		String sql;
		if(tableName.equals("wf_b_elepublication")){
		 sql="SELECT * FROM "+tableName+" where (userId ="+userid+" or checkedUserId ="+userid+" or updatedUserId ="+userid+") and wf_by2='' ORDER BY id DESC ";
		}else{
		 sql="SELECT * FROM "+tableName+" where (userId ="+userid+" or checkedUserId ="+userid+" or updatedUserId ="+userid+") ORDER BY id DESC ";	
		}
		Pagination page=new Pagination(sql, currentPage, numPerPage,  getJdbcTemplate());
		return page;    
	}
	public Pagination queryPageBusinessByUserAndWhere(String select,String tableName,String where,Integer userid,Integer currentPage,Integer numPerPage) {  
		String sql;
		if(tableName.equals("wf_b_elepublication")){
		sql="SELECT "+getIdOrFid(tableName)+select+" FROM "+tableName+" where (userId ="+userid+" or checkedUserId ="+userid+" or updatedUserId ="+userid+") and wf_by2='' and "+where+"  ORDER BY id DESC ";
		}else{
		sql="SELECT "+getIdOrFid(tableName)+select+" FROM "+tableName+" where (userId ="+userid+" or checkedUserId ="+userid+" or updatedUserId ="+userid+") and  "+where+" ORDER BY id DESC ";	
		}
		Pagination page=new Pagination(sql, currentPage, numPerPage,  getJdbcTemplate());
		return page;    
	}
	
	/**
	 * 前台分页查询数据
	 * @param tableName 	表名
	 * @param currentPage	当前页
	 * @param numPerPage	每页记录数
	 * @param flag			是否需要审核  为true则查询通过审核的，为false则不考虑是否审核
	 * @return
	 */
	public Pagination queryPageData(String tableName,Integer currentPage,Integer numPerPage,boolean flag){
		String sql;
		if(flag){
			if(tableName.equals("wf_b_elepublication")){
			sql="SELECT * FROM "+tableName+" WHERE pubFlag=1 and wf_by2='' ORDER BY id DESC ";
			}else{
			sql="SELECT * FROM "+tableName+" WHERE pubFlag=1 ORDER BY id DESC ";		
			}
		}else{
			if(tableName.equals("wf_b_elepublication")){
			sql="SELECT * FROM "+tableName+" where wf_by2='' ORDER BY id DESC ";
			}else{
			sql="SELECT * FROM "+tableName+" ORDER BY id DESC ";	
			}
		}
		Pagination page=new Pagination(sql, currentPage, numPerPage,  getJdbcTemplate());
		return page;
	}
	
	/**
	 * 前台根据条件分页查询数据
	 * @param tableName 	表名
	 * @param currentPage	当前页
	 * @param numPerPage	每页记录数
	 * @param flag			是否需要审核  为true则查询通过审核的，为false则不考虑是否审核
	 * @return
	 */
	public Pagination queryPageDataByWhere(String tableName,String where,Integer currentPage,Integer numPerPage,boolean flag){
		String sql;
		if(flag){
			if(tableName.equals("wf_b_elepublication")){
			sql="SELECT * FROM "+tableName+" WHERE ("+where+") and pubFlag='1' and wf_by2='' ORDER BY id DESC ";
			}else{
			sql="SELECT * FROM "+tableName+" WHERE ("+where+") and pubFlag='1' ORDER BY id DESC ";	
			}
		}else{
			if(tableName.equals("wf_b_elepublication")){
			sql="SELECT * FROM "+tableName+" WHERE "+where+" and wf_by2='' ORDER BY id DESC ";
			}else{
			sql="SELECT * FROM "+tableName+" WHERE "+where+" ORDER BY id DESC ";	
			}
		}
		Pagination page=new Pagination(sql, currentPage, numPerPage,  getJdbcTemplate());
		return page;
	}
	
	/**
	 * 根据表名和记录id查询记录
	 * @param tableName
	 * @param infoId
	 * @return
	 */
	public List queryDataById(String tableName,Integer infoId){
		String sql;
		if(tableName.equals("wf_b_elepublication")){
		 sql="SELECT * FROM "+tableName+" WHERE ID="+infoId+" and wf_by2=''";
		}else{
		 sql="SELECT * FROM "+tableName+" WHERE ID="+infoId;	
		}
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	
	public List selectAllData(String tableName){
		String sql="SELECT * FROM "+tableName;
		
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	/**
	 * 用于获取特色库分类中，获取所有已审核数据
	 * @param tableName
	 * @return
	 */
	public List queryALLChecked(String tableName){
		String sql="SELECT * FROM "+tableName+" where pubFlag=1 ORDER BY id";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	
	/**
	 * 获取所有的mi情报库的资源来源
	 * @param tableName
	 * @return
	 */
	public List<Map<String, Object>> queryALLMIDataBase(){
		String sql="SELECT * FROM wf_b_midatabase";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	
	
	/**
	 * 判断是显示id还是f_id
	 */
	private String getIdOrFid(String tableName){
		String sql = "SELECT COUNT(1) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"+tableName+"i' AND COLUMN_NAME  =  'f_id'";
		if(getJdbcTemplate().queryForInt(sql)>0){
			return "f_id";
		}else{
			return "id";
		}
	}
	
	/*
	 * 根据条件获取某库记录（不分页）
	 */
	public List<Map<String, Object>> selectDataByWhere(String tableName,String where){
		String sql="SELECT * FROM "+tableName;
		if(!where.equals("")){
			sql+=" where "+where;
		}
		sql+=" limit 0,10000 ";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		
		return list;
	}
	
	
}
