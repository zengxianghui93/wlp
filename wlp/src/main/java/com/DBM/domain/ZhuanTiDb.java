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

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "zhuantidb")
public class ZhuanTiDb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "pubFlag")
	private Integer pubFlag;
	
	@Column(name = "categoryId")
	private String categoryId;
	
	@Column(name = "createTime")
	private Date createTime;
	
	@Column(name = "editTime")
	private Date editTime;
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "ZTname")
	private String ZTname;
	
	@Column(name = "ZTDesc")
	private String ZTDesc;
	
	@Column(name = "ZTSearchtext")
	private String ZTSearchtext;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getZTname() {
		return ZTname;
	}

	public void setZTname(String zTname) {
		ZTname = zTname;
	}

	public String getZTDesc() {
		return ZTDesc;
	}

	public void setZTDesc(String zTDesc) {
		ZTDesc = zTDesc;
	}

	public String getZTSearchtext() {
		return ZTSearchtext;
	}

	public void setZTSearchtext(String zTSearchtext) {
		ZTSearchtext = zTSearchtext;
	}
	
	

}
