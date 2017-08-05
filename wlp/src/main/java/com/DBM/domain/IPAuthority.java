package com.DBM.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author maxiaocheng
 *20170226
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_ip_authority")
public class IPAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * 主键
	 */
	@Column(name = "id")
	private int id;
	
	/**
	 * 拥有的权限类型
	 */
	@Column(name = "authority_type")
	private String authorityType;

	/**
	 * 开始ip
	 */
	@Column(name = "begin_ip")
	private String beginIp;
	
	/**
	 * 结束ip
	 */
	@Column(name = "end_ip")
	private String endIp;
	
	/**
	 * 修改数据的时间
	 */
	@Column(name = "edit_time")
	private Date editTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorityType() {
		return authorityType;
	}

	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}

	public String getBeginIp() {
		return beginIp;
	}

	public void setBeginIp(String beginIp) {
		this.beginIp = beginIp;
	}

	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

}
