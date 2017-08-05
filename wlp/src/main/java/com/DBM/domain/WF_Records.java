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
@Table(name = "wf_records")
public class WF_Records {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	/**
	 * 充值金额
	 */
	@Column(name = "integral")
	private double integral;
	/**
	 * 用户id
	 */
	@Column(name = "userId")
	private int userId;
	/**
	 * 说明
	 */
	@Column(name = "wf_instructions")
	private String wf_instructions;
	
	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String username;
	
	/**
	 * 时间
	 */
	@Column(name = "createTime")
	private Date createTime;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getIntegral() {
		return integral;
	}

	public void setIntegral(double integral) {
		this.integral = integral;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getWf_instructions() {
		return wf_instructions;
	}

	public void setWf_instructions(String wf_instructions) {
		this.wf_instructions = wf_instructions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
