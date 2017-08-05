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
 *<pre>聚类信息表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_seraching")
public class WF_seraching {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类id 主键  自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>策略名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "searchName")
    private String searchName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>检索式</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_searching")
    private String wf_searching;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>检索类型</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_scope")
    private Integer wf_scope;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>检索类型</pre>
	 *@see
	 *@since
	 */
	@Column(name = "userid")
    private Integer userid;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getWf_searching() {
		return wf_searching;
	}
	public void setWf_searching(String wf_searching) {
		this.wf_searching = wf_searching;
	}
	public Integer getWf_scope() {
		return wf_scope;
	}
	public void setWf_scope(Integer wf_scope) {
		this.wf_scope = wf_scope;
	}
}
