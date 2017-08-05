package com.DBM.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.DBM.domain.Role_permission;
@Repository
public class RolepermissionDao extends BaseDao<Role_permission> {
	/**
	 * 根据角色id查询角色权限中间表
	 * @param roleid
	 * @return
	 */
	public List getrolepermissionByroleid(Integer roleid){
		
		String hgl = "from Role_permission where roleid = ?";
		
		HibernateTemplate template = this.getHibernateTemplate();
		List list = template.find(hgl, roleid);
		
		return list;
	}
	
	
}
