package com.DBM.domain;

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
 *<br><b>类描述:</b>
 *<pre>订单表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "WF_B_orderstatus")
public class WF_B_orderstatus {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单表id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wf_orderstatus")
    private Integer wf_orderstatus;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单状态 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_orderstatustype")
    private String wf_orderstatustype;

	public Integer getWf_orderstatus() {
		return wf_orderstatus;
	}

	public void setWf_orderstatus(Integer wf_orderstatus) {
		this.wf_orderstatus = wf_orderstatus;
	}

	public String getWf_orderstatustype() {
		return wf_orderstatustype;
	}

	public void setWf_orderstatustype(String wf_orderstatustype) {
		this.wf_orderstatustype = wf_orderstatustype;
	}

}
