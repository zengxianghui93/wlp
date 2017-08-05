package com.DBM.domain;

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
@Table(name = "wf_account")
public class wf_account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	/**
	 * 充值金额
	 */
	@Column(name = "wf_balance")
	private double wf_balance;
	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String user_name;
	
	/**
	 * 积分
	 * @return
	 */
	@Column(name = "integral")
	private double integral;
	
	public double getIntegral() {
		return integral;
	}
	public void setIntegral(double integral) {
		this.integral = integral;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getWf_balance() {
		return wf_balance;
	}
	public void setWf_balance(double wf_balance) {
		this.wf_balance = wf_balance;
	}
	

}
