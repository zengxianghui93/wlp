package com.DBM.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Repository;

import com.DBM.domain.WF_B_langInfo;

/** 
 *类描述:
 */
//@Repository
/*public class BaikeDao extends BaseDao<WF_>{
	
	
	 * 查询高级检索所需的语种
	 
	public List<WF_B_langInfo> langinfoForAd (){
		String hql = "from WF_B_langInfo WHERE f_id>6";
		return findRT(hql);
	}
}*/
