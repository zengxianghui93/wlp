package com.DBM.domain;

import java.util.Date;

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
 *<pre>语种信息表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_langInfo")
public class WF_B_langInfo {
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>语种信息表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>缩写</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CC",length=10)
    private String wf_CC;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国家英文名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authority_en")
    private String wf_authority_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国家中文名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authority_cn")
    private String wf_authority_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>语种:中文、英文...</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_language")
    private String wf_language;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>创建时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_createTime")
    private Date wf_createTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>高级检索中是否可检索 1是</pre>
	 *@see
	 *@since
	 */
	@Column(name = "ifSearchAd")
	private String ifSearchAd;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
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


	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getWf_CC() {
		return wf_CC;
	}

	public void setWf_CC(String wf_CC) {
		this.wf_CC = wf_CC;
	}

	public String getWf_authority_en() {
		return wf_authority_en;
	}

	public void setWf_authority_en(String wf_authority_en) {
		this.wf_authority_en = wf_authority_en;
	}

	public String getWf_authority_cn() {
		return wf_authority_cn;
	}

	public void setWf_authority_cn(String wf_authority_cn) {
		this.wf_authority_cn = wf_authority_cn;
	}

	public Date getWf_createTime() {
		return wf_createTime;
	}

	public void setWf_createTime(Date wf_createTime) {
		this.wf_createTime = wf_createTime;
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
	
	public String getWf_language() {
		return wf_language;
	}

	public void setWf_language(String wf_language) {
		this.wf_language = wf_language;
	}

	public String getIfSearchAd() {
		return ifSearchAd;
	}

	public void setIfSearchAd(String ifSearchAd) {
		this.ifSearchAd = ifSearchAd;
	}

}
