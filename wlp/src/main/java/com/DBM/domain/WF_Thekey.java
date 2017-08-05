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
 *<pre>短信密钥实体类</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_thekey")
public class WF_Thekey {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>id</pre>
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
	@Column(name = "wf_uid")
    private String wf_uid;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>检索式</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_key")
    private String wf_key;
	
	public String getWf_uid() {
		return wf_uid;
	}
	public void setWf_uid(String wf_uid) {
		this.wf_uid = wf_uid;
	}
	public String getWf_key() {
		return wf_key;
	}
	public void setWf_key(String wf_key) {
		this.wf_key = wf_key;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
