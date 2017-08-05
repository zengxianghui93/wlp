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
 *<pre>专家表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_achievement")
public class WF_B_achievement {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>成果表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>作者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_author")
    private String wf_author;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>提供者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_provider")
    private String wf_provider;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>路径</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_url")
    private String wf_url;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>文摘</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract",length=65535)
    private String wf_abstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键字</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword",length=65535)
    private String wf_keyword;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>一级分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_class_1")
    private String wf_class_1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>二级分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_class_2")
    private String wf_class_2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>三级分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_class_3")
    private String wf_class_3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>总数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_number")
    private Integer wf_number;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>年</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year",length=50)
    private String wf_year;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>作者地址</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnit")
    private String wf_authorUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title")
    private String wf_title;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原有ID</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID",length=50)
    private String wf_ID;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>装库日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatTime")
    private Date wf_creatTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类导航</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fl_zsdh",length=65535)
    private String wf_fl_zsdh;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>语种、值为语种信息表的id值</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang")
    private Integer wf_lang;
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
	/**
	 *<br><b>字段描述:</b>
	 *<pre>年、用于索引聚类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year_Index",length=50)
	private String wf_year_Index;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>值为数据库对应的id值、用于来源聚类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource_Index")
	private Integer wf_resource_Index;
	
	public String getWf_year_Index() {
		return wf_year_Index;
	}
	public void setWf_year_Index(String wf_year_Index) {
		this.wf_year_Index = wf_year_Index;
	}
	public Integer getWf_resource_Index() {
		return wf_resource_Index;
	}
	public void setWf_resource_Index(Integer wf_resource_Index) {
		this.wf_resource_Index = wf_resource_Index;
	}
	public Integer getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(Integer wf_lang) {
		this.wf_lang = wf_lang;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Integer getWf_number() {
		return wf_number;
	}
	public void setWf_number(Integer wf_number) {
		this.wf_number = wf_number;
	}
	public Date getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(Date wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_provider() {
		return wf_provider;
	}
	public void setWf_provider(String wf_provider) {
		this.wf_provider = wf_provider;
	}
	public String getWf_url() {
		return wf_url;
	}
	public void setWf_url(String wf_url) {
		this.wf_url = wf_url;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
	}
	public String getWf_keyword() {
		return wf_keyword;
	}
	public void setWf_keyword(String wf_keyword) {
		this.wf_keyword = wf_keyword;
	}
	public String getWf_class_1() {
		return wf_class_1;
	}
	public void setWf_class_1(String wf_class_1) {
		this.wf_class_1 = wf_class_1;
	}
	public String getWf_class_2() {
		return wf_class_2;
	}
	public void setWf_class_2(String wf_class_2) {
		this.wf_class_2 = wf_class_2;
	}
	public String getWf_class_3() {
		return wf_class_3;
	}
	public void setWf_class_3(String wf_class_3) {
		this.wf_class_3 = wf_class_3;
	}
	public String getWf_year() {
		return wf_year;
	}
	public void setWf_year(String wf_year) {
		this.wf_year = wf_year;
	}
	public String getWf_authorUnit() {
		return wf_authorUnit;
	}
	public void setWf_authorUnit(String wf_authorUnit) {
		this.wf_authorUnit = wf_authorUnit;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
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
	
}
