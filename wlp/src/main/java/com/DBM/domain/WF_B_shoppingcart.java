package com.DBM.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 *<br><b>类描述:</b>
 *<pre>购物车表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_shoppingcart")
public class WF_B_shoppingcart {
	/*
	 * 购物车id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/*
	 * 商品对象
	 */
	@OneToOne(cascade = CascadeType. REFRESH)
	@JoinColumn(name="e_fid")
    private WF_B_ElePublication e_fid;
	/*
	 * 用户id
	 */
	@Column(name = "user_id")
    private Integer user_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WF_B_ElePublication getE_fid() {
		return e_fid;
	}
	public void setE_fid(WF_B_ElePublication e_fid) {
		this.e_fid = e_fid;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
}
