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
 *<pre>出版机够表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_authorunitType")
public class WF_B_authorunitType {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出版机构id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wf_paper_no")
    private Integer wf_paper_no;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出版社</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnittype")
    private String wf_authorUnittype;
	
	public Integer getWf_paper_no() {
		return wf_paper_no;
	}
	public void setWf_paper_no(Integer wf_paper_no) {
		this.wf_paper_no = wf_paper_no;
	}
	public String getWf_authorUnittype() {
		return wf_authorUnittype;
	}
	public void setWf_authorUnittype(String wf_authorUnittype) {
		this.wf_authorUnittype = wf_authorUnittype;
	}
}
