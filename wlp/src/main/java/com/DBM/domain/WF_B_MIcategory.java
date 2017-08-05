package com.DBM.domain;

import java.util.List;

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
 *<pre>MI分类</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_MIcategory")
public class WF_B_MIcategory {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类id 主键  自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_categoryName")
    private String wf_categoryName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类英文名称，这里指国家的英文名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_categoryNameEn")
    private String wf_categoryNameEn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>节点父id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_parentId")
	private String wf_parentId;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类检索式</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_searchStrategy")
	private String wf_searchStrategy;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否删除  1删除  </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_deleted")
	private String wf_deleted;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否显示 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ifShow")
	private String wf_ifShow;
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
	public String getWf_searchStrategy() {
		return wf_searchStrategy;
	}
	public void setWf_searchStrategy(String wf_searchStrategy) {
		this.wf_searchStrategy = wf_searchStrategy;
	}
	public String getWf_categoryName() {
		return wf_categoryName;
	}
	public void setWf_categoryName(String wf_categoryName) {
		this.wf_categoryName = wf_categoryName;
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
	public String getWf_deleted() {
		return wf_deleted;
	}
	public void setWf_deleted(String wf_deleted) {
		this.wf_deleted = wf_deleted;
	}
	public String getWf_ifShow() {
		return wf_ifShow;
	}
	public void setWf_ifShow(String wf_ifShow) {
		this.wf_ifShow = wf_ifShow;
	}
	public String getWf_categoryNameEn() {
		return wf_categoryNameEn;
	}
	public void setWf_categoryNameEn(String wf_categoryNameEn) {
		this.wf_categoryNameEn = wf_categoryNameEn;
	}
	public String getWf_parentId() {
		return wf_parentId;
	}
	public void setWf_parentId(String wf_parentId) {
		this.wf_parentId = wf_parentId;
	}
	
}
