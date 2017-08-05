package com.DBM.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 
 *<br><b>类描述:</b>
 *<pre>订单详情</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "WF_B_orderDetails")
public class WF_B_orderDetails {   
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单详情表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户id</pre>
	 *@see
	 *@since
	 */
	@ManyToOne(cascade = CascadeType. REFRESH)
	@JoinColumn(name="user")
	private User user;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>商品id</pre>
	 *@see
	 *@since
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="e_fid")
    private WF_B_ElePublication e_fid;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>数量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "number")
    private int number;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public WF_B_ElePublication getE_fid() {
		return e_fid;
	}

	public void setE_fid(WF_B_ElePublication e_fid) {
		this.e_fid = e_fid;
	}

    
}
