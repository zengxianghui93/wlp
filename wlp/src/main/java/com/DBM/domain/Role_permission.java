package com.DBM.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role_permission")
public class Role_permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "link_id")
	private Integer link_id;
	
	@Column(name = "roleid")
	private Integer roleid;
	
	@Column(name = "permissid")
	private Integer permissid;
	
	

	public Integer getLink_id() {
		return link_id;
	}

	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getPermissid() {
		return permissid;
	}

	public void setPermissid(Integer permissid) {
		this.permissid = permissid;
	}
	
	
}
