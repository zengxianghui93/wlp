package com.DBM.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 *<br><b>类描述:</b>
 *<pre>订单表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "WF_B_order")
public class WF_B_order {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单表id 主键 自增长</pre>
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
	@Column(name = "user")
    private String user;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单编号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ordernumber")
    private String wf_ordernumber;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单地址</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_orderAddress")
    private String wf_orderAddress;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单详情id</pre>
	 *@see
	 *@since
	 */
	@OneToMany(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="order_Deil")
    private Set<WF_B_orderDetails> order_Deil = new HashSet<WF_B_orderDetails>() ;

	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单金额(总价)</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "money")
    private String money;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单时间</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ideaDate")
    private Date wf_ideaDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>成交方式</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_termsofdelivery")
    private String wf_termsofdelivery;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>发票抬头</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_fapiao")
    private String wf_fapiao;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>发票类型</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_fapiaotype")
    private String wf_fapiaotype;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单状态</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_orderstatus")
    private Integer wf_orderstatus;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电话</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by1")
	private String wf_by1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by2")
	private String wf_by2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by3")
	private String wf_by3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by4")
	private String wf_by4;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by5")
	private String wf_by5;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getWf_orderstatus() {
		return wf_orderstatus;
	}

	public void setWf_orderstatus(Integer wf_orderstatus) {
		this.wf_orderstatus = wf_orderstatus;
	}

	public String getWf_fapiao() {
		return wf_fapiao;
	}

	public void setWf_fapiao(String wf_fapiao) {
		this.wf_fapiao = wf_fapiao;
	}

	public String getWf_fapiaotype() {
		return wf_fapiaotype;
	}

	public void setWf_fapiaotype(String wf_fapiaotype) {
		this.wf_fapiaotype = wf_fapiaotype;
	}

	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getWf_ordernumber() {
		return wf_ordernumber;
	}

	public void setWf_ordernumber(String wf_ordernumber) {
		this.wf_ordernumber = wf_ordernumber;
	}

	public String getWf_orderAddress() {
		return wf_orderAddress;
	}

	public void setWf_orderAddress(String wf_orderAddress) {
		this.wf_orderAddress = wf_orderAddress;
	}


	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Date getWf_ideaDate() {
		return wf_ideaDate;
	}

	public void setWf_ideaDate(Date date) {
		this.wf_ideaDate = date;
	}

	public String getWf_termsofdelivery() {
		return wf_termsofdelivery;
	}

	public void setWf_termsofdelivery(String wf_termsofdelivery) {
		this.wf_termsofdelivery = wf_termsofdelivery;
	}

	public String getWf_by1() {
		return wf_by1;
	}

	public void setWf_by1(String wf_by1) {
		this.wf_by1 = wf_by1;
	}

	public String getWf_by2() {
		return wf_by2;
	}

	public void setWf_by2(String wf_by2) {
		this.wf_by2 = wf_by2;
	}

	public String getWf_by3() {
		return wf_by3;
	}

	public void setWf_by3(String wf_by3) {
		this.wf_by3 = wf_by3;
	}

	public String getWf_by4() {
		return wf_by4;
	}

	public void setWf_by4(String wf_by4) {
		this.wf_by4 = wf_by4;
	}

	public String getWf_by5() {
		return wf_by5;
	}

	public void setWf_by5(String wf_by5) {
		this.wf_by5 = wf_by5;
	}

	public Set<WF_B_orderDetails> getOrder_Deil() {
		return order_Deil;
	}

	public void setOrder_Deil(Set<WF_B_orderDetails> order_Deil) {
		this.order_Deil = order_Deil;
	}


	
}
