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
 *<pre>推送表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "WF_B_tuisong")
public class WF_B_tuisong {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>推送表id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>推送检索式</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_search")
    private String wf_search;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>推送邮箱</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_email")
    private String wf_email;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>推送状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_type")
    private String wf_type;
	
	public String getWf_type() {
		return wf_type;
	}
	public void setWf_type(String wf_type) {
		this.wf_type = wf_type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWf_search() {
		return wf_search;
	}
	public void setWf_search(String wf_search) {
		this.wf_search = wf_search;
	}
	public String getWf_email() {
		return wf_email;
	}
	public void setWf_email(String wf_email) {
		this.wf_email = wf_email;
	}
}
