package com.DBM.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.DBM.domain.ResInfo;

@Repository
public class ResInfoDao extends BaseDao<ResInfo> {
	private final String LIST_RES= " from ResInfo";
	
	public List<ResInfo> ListAllRes(){
		return getHibernateTemplate().find(LIST_RES);
	}
	/**
	 * 所有库查询
	 */
	public List<Map<String, Object>> getshuju(int type){
		String sql ="select resId,resTblName,resDesc,resName,resImage from tb_res where resType="+type+" or resType='0' order by resdate DESC";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	
	public Object queryDataById(final String tableName,final Integer infoId){
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		
		Session session = sessionFactory.openSession();
		String sql="SELECT * FROM "+tableName+" WHERE id="+infoId;
		SQLQuery query = session.createSQLQuery(sql);
		Object uniqueResult = query.uniqueResult();
		session.close();
		return uniqueResult;  
	}
	/*
	 * 资源分页查询
	 */
	public Page getPageDBM(int pageNo,int pageSize,String resName){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String where = "where 1=1 ";
		if(resName != null && !"".equals(resName)){
			where += " and resName like '%"+resName+"%'";
		}
		String sql1 ="select resid from tb_res " + where;
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		
		String sql="( select * from tb_res "+where+" order by resdate DESC limit 0,"+size+")";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(ResInfo.class);		
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	/*
	 * 资源分页查询
	 */
	public Page getPageDBM2(int pageNo,int pageSize){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 ="select resid from tb_res where resType !=3";
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		
		String sql="( select * from tb_res where resType !=3 order by resdate DESC limit 0,"+size+")";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(ResInfo.class);		
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	/*
	 * 根据resId查询出表名
	 */
	public List<Map<String, Object>> qListByResIdAndFid(Integer resId,Integer f_id){
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		String sql = "SELECT RESTBLNAME FROM  TB_RES WHERE RESID="+resId;
		SQLQuery query = session.createSQLQuery(sql);
		String uniqueResult = (String) query.uniqueResult();
		String sql1 = "SELECT * FROM  "+uniqueResult+" WHERE id="+f_id;
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql1);
		session.close();
		return list;  
	}
	
	/**
	 * 根据表resid获取表名，取出该表中指定ID的记录
	 * @param resId 表ID
	 * @param id 记录id
	 * @return
	 * @author lilongbiao
	 * @since 2017-2-27
	 */
	public List<Map<String, Object>> listByResIdAndId(Integer resId,Integer id){
		SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		String firstSQL= "SELECT RESTBLNAME FROM  TB_RES WHERE RESID="+resId;
		SQLQuery query = session.createSQLQuery(firstSQL);
		String uniqueResult = (String) query.uniqueResult();
		String secondSQL = "SELECT * FROM  "+uniqueResult+" WHERE ID="+id;
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(secondSQL);
		session.close();
		return list;  
	}
	
	/**
	 * 根据资源库Id修改资源库的价格
	 * @author maxiaocheng
	 * @param resId
	 * @param resBalance
	 * @since 2017-3-20
	 */
	public void updateResBalance(Integer resId,Double resBalance){
		String sql = "update tb_res set resBalance = "+resBalance+" where resId="+resId;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.createSQLQuery(sql).executeUpdate();
	}
	
	/**
	 * 根据资源库resId获取资源库详细信息
	 * @author maxiaocheng
	 * @param resId
	 * @param resBalance
	 * @since 2017-3-20
	 */
	public ResInfo getResInfoByResId(Integer resId){
		String sql = "select * from tb_res where resId="+resId;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(ResInfo.class);
		List<ResInfo> list = query.list();
		return list.isEmpty()?null:list.get(0);
	}
	
	/**
	 * 分页查询所有可以显示的资源库信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getAllXIANSHIResPage(int pageNo,int pageSize){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 ="select resid from tb_res where resType != 3";
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		
		String sql="( select * from tb_res where resType != 3 order by resdate DESC limit 0,"+size+")";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(ResInfo.class);		
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	/**
	 * 查询所有可以显示的资源库信息
	 * @return
	 */
	public List<ResInfo> getAllXIANSHIRes(){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql1 ="select * from tb_res where resType != 3";
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1).addEntity(ResInfo.class);
		return sqlQuery1.list();
	}
	
	/**
	 * 显示当前人有资格编辑或审核的资源库信息
	 */
	public Page getPageDBM3(int pageNo,int pageSize,List res){
		if(res==null||res.size()==0){
			return new Page();
		}
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String ress = "(";
		for (Object object : res) {
			if ("(".equals(ress)) {
				ress += "'"+object.toString()+"'";
			}else{
				ress += ",'"+object.toString()+"'";
			}
		}
		ress += ")";
		
		
		String sql1 ="select resid from tb_res where resTblName in "+ress;
		SQLQuery sqlQuery1 = session.createSQLQuery(sql1);
		int size = sqlQuery1.list().size();
		
		String sql="( select * from tb_res where resTblName in "+ress+" order by resdate DESC limit 0,"+size+")";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(ResInfo.class);		
		int totalCount = sqlQuery.list().size();
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize).list();		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	/**
	 * 批量审核
	 * @param talName 表名
	 * @param pubFlag 审核结果
	 * @param ids id字符串集，类似  (1,2,3)
	 * @return
	 */
	public void setPubFlagPiLiang(String talName, String pubFlag, String[] ids) {
		String idss = "(";
		for (String string : ids) {
			if ("(".equals(idss)) {
				idss += "'"+string+"'";
			}else{
				idss += ",'"+string+"'";
			}
		}
		idss += ")";
		String sql = "update "+talName+" set pubFlag ="+pubFlag+" where id in "+idss;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.executeUpdate();
	}
	/**
	 * 全部可检索库查询(知识中心、文献中心)
	 */
	public List<Map<String, Object>> qIndexNameForKL(){
		String sql ="select resId,resName,indexName,indexIfSearch_kc,indexIfSearch_lc from tb_res where  indexName IS NOT NULL AND indexName!=''";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	/**
	 * 知识中心可检索库查询
	 */
	public List<Map<String, Object>> qIndexNameForKC(){
		String sql ="select resId,resName,indexName,indexIfSearch_kc from tb_res where indexIfSearch_kc=1 AND indexName IS NOT NULL AND indexName!=''";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	/**
	 * 文献中心可检索库查询
	 */
	public List<Map<String, Object>> qIndexNameForLC(){
		String sql ="select resId,resName,indexName,indexIfSearch_lc from tb_res where indexIfSearch_lc=1 AND indexName IS NOT NULL AND indexName!=''";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	
	
}
