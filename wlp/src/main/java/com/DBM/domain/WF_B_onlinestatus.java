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
@Table(name = "WF_B_onlinestatus")
public class WF_B_onlinestatus {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单表id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>订单状态 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_kjcxstatus")
    private String wf_kjcxstatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWf_kjcxstatus() {
		return wf_kjcxstatus;
	}

	public void setWf_kjcxstatus(String wf_kjcxstatus) {
		this.wf_kjcxstatus = wf_kjcxstatus;
	}
}
