package com.DBM.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NavigationDao extends  AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List list(String tableName,int page, int pageSize,String zhongwen,String  yingwen, String dewen, String riwen, String yidaliwen, String fawen, String zhongguo, String meiguo, String deguo, String faguo, String yingguo, String ziduan, String searchValue){
		StringBuffer sql = new StringBuffer();
		sql.append("select * from "+tableName+" where 1 = 1 ");
		//语种
		if((zhongwen != null && !"".equals(zhongwen)) || (yingwen != null && !"".equals(yingwen)) || (dewen != null && !"".equals(dewen)) || (fawen != null && !"".equals(fawen)) || (yidaliwen != null && !"".equals(yidaliwen)) || (riwen != null && !"".equals(riwen))){
			sql.append(" and ( ");
		}
		if(zhongwen != null && !"".equals(zhongwen)){
			sql.append(" language = '1' or");
		}
		if(yingwen != null && !"".equals(yingwen)){
			sql.append(" language = '2' or" );
					
		}
		if(dewen != null && !"".equals(dewen)){
			sql.append(" language = '3' or" );
			
		}
		if(fawen != null && !"".equals(fawen)){
			sql.append(" language = '4' or" );
			
		}
		if(yidaliwen != null && !"".equals(yidaliwen)){
			sql.append(" language = '5' or" );
			
		}
		if(riwen != null && !"".equals(riwen)){
			sql.append(" language = '6' or  " );
		}
		if((zhongwen != null && !"".equals(zhongwen)) || (yingwen != null && !"".equals(yingwen)) || (dewen != null && !"".equals(dewen)) || (fawen != null && !"".equals(fawen)) || (yidaliwen != null && !"".equals(yidaliwen)) || (riwen != null && !"".equals(riwen))){
			sql = new StringBuffer(sql.substring(0, sql.lastIndexOf("or")));
			sql.append(")");
		}
		//国家地区
		if((zhongguo != null && !"".equals(zhongguo)) || (meiguo != null && !"".equals(meiguo)) || (deguo != null && !"".equals(deguo)) ||  (faguo != null && !"".equals(faguo)) || (yingguo != null && !"".equals(yingguo)) ){
			sql.append(" and ( ");
		}
		if(zhongguo != null && !"".equals(zhongguo)){
			sql.append(" country = '中国' or");
		}
		if(meiguo != null && !"".equals(meiguo)){
			sql.append(" country = '美国' or");
		}
		if(deguo != null && !"".equals(deguo)){
			sql.append(" country = '德国' or");
		}
		if(faguo != null && !"".equals(faguo)){
			sql.append(" country = '法国' or");
		}
		if(yingguo != null && !"".equals(yingguo)){
			sql.append(" country = '英国' or");
		}
		//国家地区
		if((zhongguo != null && !"".equals(zhongguo)) || (meiguo != null && !"".equals(meiguo)) || (deguo != null && !"".equals(deguo)) ||  (faguo != null && !"".equals(faguo)) || (yingguo != null && !"".equals(yingguo)) ){
			sql = new StringBuffer(sql.substring(0, sql.lastIndexOf("or")));
			sql.append(")");
		}
		if(searchValue != null && !"".equals(searchValue)){
			sql.append(" and " + ziduan + " like '%"+searchValue+"%'");
		}
		sql.append(" limit "+ page*pageSize +","+ pageSize);
		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql.toString());
		return list;
	}
	
	public int getTotal(String tableName, int page, int pageSize, String zhongwen,String  yingwen, String dewen, String riwen, String yidaliwen, String fawen, String zhongguo, String meiguo, String deguo, String faguo, String yingguo, String ziduan, String searchValue){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from "+tableName+" where 1 = 1 ");
		//语种
		if((zhongwen != null && !"".equals(zhongwen)) || (yingwen != null && !"".equals(yingwen)) || (dewen != null && !"".equals(dewen)) || (fawen != null && !"".equals(fawen)) || (yidaliwen != null && !"".equals(yidaliwen)) || (riwen != null && !"".equals(riwen))){
			sql.append(" and ( ");
		}
		if(zhongwen != null && !"".equals(zhongwen)){
			sql.append(" language = '1' or");
		}
		if(yingwen != null && !"".equals(yingwen)){
			sql.append(" language = '2' or" );
					
		}
		if(dewen != null && !"".equals(dewen)){
			sql.append(" language = '3' or" );
			
		}
		if(fawen != null && !"".equals(fawen)){
			sql.append(" language = '4' or" );
			
		}
		if(yidaliwen != null && !"".equals(yidaliwen)){
			sql.append(" language = '5' or" );
			
		}
		if(riwen != null && !"".equals(riwen)){
			sql.append(" language = '6' or  " );
		}
		if((zhongwen != null && !"".equals(zhongwen)) || (yingwen != null && !"".equals(yingwen)) || (dewen != null && !"".equals(dewen)) || (fawen != null && !"".equals(fawen)) || (yidaliwen != null && !"".equals(yidaliwen)) || (riwen != null && !"".equals(riwen))){
			sql = new StringBuffer(sql.substring(0, sql.lastIndexOf("or")));
			sql.append(")");
		}
		//国家地区
		if((zhongguo != null && !"".equals(zhongguo)) || (meiguo != null && !"".equals(meiguo)) || (deguo != null && !"".equals(deguo)) ||  (faguo != null && !"".equals(faguo)) || (yingguo != null && !"".equals(yingguo)) ){
			sql.append(" and ( ");
		}
		if(zhongguo != null && !"".equals(zhongguo)){
			sql.append(" country = '中国' or");
		}
		if(meiguo != null && !"".equals(meiguo)){
			sql.append(" country = '美国' or");
		}
		if(deguo != null && !"".equals(deguo)){
			sql.append(" country = '德国' or");
		}
		if(faguo != null && !"".equals(faguo)){
			sql.append(" country = '法国' or");
		}
		if(yingguo != null && !"".equals(yingguo)){
			sql.append(" country = '英国' or");
		}
		//国家地区
		if((zhongguo != null && !"".equals(zhongguo)) || (meiguo != null && !"".equals(meiguo)) || (deguo != null && !"".equals(deguo)) ||  (faguo != null && !"".equals(faguo)) || (yingguo != null && !"".equals(yingguo)) ){
			sql = new StringBuffer(sql.substring(0, sql.lastIndexOf("or")));
			sql.append(")");
		}
		if(searchValue != null && !"".equals(searchValue)){
			sql.append(" and " + ziduan + " like '%"+searchValue+"%'");
		}
		return getJdbcTemplate().queryForInt(sql.toString());
	}

	public List<Map<String, Object>> get(int id,String table) {
		String sql = "select * from "+ table + " where 1 = 1 and id = '"+id+"'";
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		return list;
	}

	public List<Map<String, Object>> navigationSearch(String table, String search, int page, int pageSize) {
		StringBuffer sql = new StringBuffer("select * from "+ table + " where 1 = 1 and " + search);
		sql.append(" limit "+ (page-1) * pageSize +","+ pageSize);
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql.toString());
		return list;
	}

	public int getTotal(String sql) {
		return getJdbcTemplate().queryForInt(sql);
	}

	public List listNew(String tableName, int page, int pageSize, String language, String country, String ziduan,
			String searchValue) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from "+tableName+" where 1 = 1 ");
		//语种
		if(language != null && !"".equals(language)){
			sql.append(" and language = '" +language+ "'");
		}
		//国家地区
		if(country != null && !"".equals(country)){
			sql.append(" and country = '"  + country + "'");
		}
		if(searchValue != null && !"".equals(searchValue)){
			sql.append(" and " + ziduan + " like '%"+searchValue+"%'");
		}
		sql.append(" limit "+ page*pageSize +","+ pageSize);
		List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql.toString());
		return list;
	}

	public int getTotalNew(String tableName, int page, int pageSize, String language, String country, String ziduan,
			String searchValue) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from "+tableName+" where 1 = 1 ");
		//语种
		if(language != null && !"".equals(language)){
			sql.append(" and language = '" +language+ "'");
		}
		//国家地区
		if(country != null && !"".equals(country)){
			sql.append(" and country = '"  + country + "'");
		}
		if(searchValue != null && !"".equals(searchValue)){
			sql.append(" and " + ziduan + " like '%"+searchValue+"%'");
		}
		return getJdbcTemplate().queryForInt(sql.toString());
	}
}
