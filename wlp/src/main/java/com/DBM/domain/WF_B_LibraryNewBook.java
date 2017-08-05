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
 *<pre>馆藏新书</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_libraryNewBook")
public class WF_B_LibraryNewBook {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>馆藏新书id   主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原TRS库中的ID</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID")
    private String wf_ID;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>正文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文名称</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_title")
    private String wf_title;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>外文名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title_en")
    private String wf_title_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原文(路径+文件名)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>路径+名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_flashName")
    private String wf_flashName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>创建时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatTime")
    private Date wf_creatTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出版年 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year",length=50)
    private String wf_year;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出版机构</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_pubUnit")
    private String wf_pubUnit;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>总页数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_totalpage")
    private Integer wf_totalpage;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类导航</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fl_zsdh")
    private String wf_fl_zsdh;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>目录</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_directory")
    private String wf_directory;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>技术经济指标id  外键</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tei_id")
    private Integer wf_tei_id;
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
	}
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
	 *<pre>语种、值为语种信息表的id值</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang")
    private Integer wf_lang;
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
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
	}
	public String getWf_pubUnit() {
		return wf_pubUnit;
	}
	public void setWf_pubUnit(String wf_pubUnit) {
		this.wf_pubUnit = wf_pubUnit;
	}
	public Integer getWf_totalpage() {
		return wf_totalpage;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public String getWf_flashName() {
		return wf_flashName;
	}
	public void setWf_flashName(String wf_flashName) {
		this.wf_flashName = wf_flashName;
	}
	public Date getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(Date wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	public String getWf_directory() {
		return wf_directory;
	}
	public void setWf_directory(String wf_directory) {
		this.wf_directory = wf_directory;
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
	public void setWf_totalpage(Integer wf_totalpage) {
		this.wf_totalpage = wf_totalpage;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_title_en() {
		return wf_title_en;
	}
	public void setWf_title_en(String wf_title_en) {
		this.wf_title_en = wf_title_en;
	}
	public String getWf_year() {
		return wf_year;
	}
	public void setWf_year(String wf_year) {
		this.wf_year = wf_year;
	}
	

}
