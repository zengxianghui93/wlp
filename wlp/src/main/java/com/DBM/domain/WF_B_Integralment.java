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
@Table(name = "wf_b_Integralment")
public class WF_B_Integralment {
	/**
     * 用户id
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
    
    /**
     * 注册积分
     */
    @Column(name = "wf_register")
	private String wf_register;
    
    /**
     * 验证手机积分
     */
    @Column(name = "wf_validation")
	private String wf_validation;
    
    /**
     * 登录积分
     */
    @Column(name = "wf_login")
	private String wf_login;
    
    /**
     * 连续登录积分
     */
    @Column(name = "wf_logins")
	private String wf_logins;
    
    /**
     * 上传文献积分
     */
    @Column(name = "wf_literature")
	private String wf_literature;
    
    /**
     * 现金积分
     */
    @Column(name = "wf_cash")
	private String wf_cash;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWf_register() {
		return wf_register;
	}

	public void setWf_register(String wf_register) {
		this.wf_register = wf_register;
	}

	public String getWf_validation() {
		return wf_validation;
	}

	public void setWf_validation(String wf_validation) {
		this.wf_validation = wf_validation;
	}

	public String getWf_login() {
		return wf_login;
	}

	public void setWf_login(String wf_login) {
		this.wf_login = wf_login;
	}

	public String getWf_logins() {
		return wf_logins;
	}

	public void setWf_logins(String wf_logins) {
		this.wf_logins = wf_logins;
	}

	public String getWf_literature() {
		return wf_literature;
	}

	public void setWf_literature(String wf_literature) {
		this.wf_literature = wf_literature;
	}

	public String getWf_cash() {
		return wf_cash;
	}

	public void setWf_cash(String wf_cash) {
		this.wf_cash = wf_cash;
	}

	
}
