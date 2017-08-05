package com.DBM.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 *<br><b>类描述:</b>
 *<pre>分类</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_category")
public class WF_B_category {
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
	 *<pre>0、1标识</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_isRootMenu",length=10)
    private String wf_isRootMenu;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>搜索分类号</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_categoryCode")
    private String wf_categoryCode;
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
	 *<pre>原有分类号、老分类号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_oldCategoryCode")
	private String wf_oldCategoryCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>前台是否显示 1显示、0不显示</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ifShow")
	private String wf_ifShow;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>图片</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_image")
	private String wf_image;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否删除  1删除 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_deleted")
	private String wf_deleted;
	
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
	
	public String getWf_ifShow() {
		return wf_ifShow;
	}
	public void setWf_ifShow(String wf_ifShow) {
		this.wf_ifShow = wf_ifShow;
	}
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
	public String getWf_isRootMenu() {
		return wf_isRootMenu;
	}
	public void setWf_isRootMenu(String wf_isRootMenu) {
		this.wf_isRootMenu = wf_isRootMenu;
	}
	public String getWf_categoryCode() {
		return wf_categoryCode;
	}
	public void setWf_categoryCode(String wf_categoryCode) {
		this.wf_categoryCode = wf_categoryCode;
	}
	public String getWf_oldCategoryCode() {
		return wf_oldCategoryCode;
	}
	public void setWf_oldCategoryCode(String wf_oldCategoryCode) {
		this.wf_oldCategoryCode = wf_oldCategoryCode;
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
	public String getWf_image() {
		return wf_image;
	}
	public void setWf_image(String wf_image) {
		this.wf_image = wf_image;
	}
	public String getWf_deleted() {
		return wf_deleted;
	}
	public void setWf_deleted(String wf_deleted) {
		this.wf_deleted = wf_deleted;
	}
	
}
