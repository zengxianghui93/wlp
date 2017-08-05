package com.DBM.dao;

import org.springframework.stereotype.Repository;

import com.DBM.domain.ColumnInfo;

import java.util.List;


@Repository
public class ColumnInfoDao extends BaseDao<ColumnInfo>{
	private final String GET_SUB_COLS = "from ColumnInfo where columid like ?  and CHAR_LENGTH(columid)=CHAR_LENGTH(?)+2 order by columid ";
	
	/**
	 * 获取某栏目子栏目
	 */
	public List getSubCols(String column_id) {
		//return pagedQuery(GET_PAGED_NEWS+"'"+column_id+"%' and NewsInfo.status=1 order by entry_date desc",pageNo,pageSize);//,column_id+"%");
		if(column_id.equals("00")){
			String hql = "from ColumnInfo where ismenu = 1 order by columid";
			return find(hql);
		}
		
		return find(GET_SUB_COLS,column_id+"%",column_id);
	}
	
	public List getSupCols(String sql) {
		
		return find(sql);
	}
	
	//查询所有的类别分类,根据id排序
	public List allColOrderByid(){
		
		String sql = "from ColumnInfo order by columid";
		
		return find(sql);
	}
	
}
