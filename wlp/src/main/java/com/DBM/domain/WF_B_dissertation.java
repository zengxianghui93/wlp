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
 *<pre> 学位论文</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_dissertation")
public class WF_B_dissertation {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>学位论文id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原TRS中的ID</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID")
    private String  wf_ID;
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
	 *<pre>授予学位</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_awardDegree")
    private String wf_awardDegree;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>学科专业</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_diciplineProfession")
    private String wf_diciplineProfession;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>学位年度</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_degreeYear",length=50)
    private String wf_degreeYear;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>语种</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang",length=50)
    private String wf_lang;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>学位授予单位</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_degreeConferUnit")
    private String wf_degreeConferUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>全文(longtext)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原文路径</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>文摘(text)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract",length=65535)
    private String wf_abstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword",length=65535)
    private String wf_keyword;
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
	 *<pre>作者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_author")
    private String wf_author;
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
	 *<pre>中图分类号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CNLibraryClassification")
	private String wf_CNLibraryClassification;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>技术经济指标id  外键</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tei_id")
	private Integer wf_tei_id;
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
	
	
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public Date getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(Date wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	public String getWf_awardDegree() {
		return wf_awardDegree;
	}
	public void setWf_awardDegree(String wf_awardDegree) {
		this.wf_awardDegree = wf_awardDegree;
	}
	public String getWf_diciplineProfession() {
		return wf_diciplineProfession;
	}
	public void setWf_diciplineProfession(String wf_diciplineProfession) {
		this.wf_diciplineProfession = wf_diciplineProfession;
	}
	public String getWf_degreeYear() {
		return wf_degreeYear;
	}
	public void setWf_degreeYear(String wf_degreeYear) {
		this.wf_degreeYear = wf_degreeYear;
	}
	public String getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(String wf_lang) {
		this.wf_lang = wf_lang;
	}
	public String getWf_degreeConferUnit() {
		return wf_degreeConferUnit;
	}
	public void setWf_degreeConferUnit(String wf_degreeConferUnit) {
		this.wf_degreeConferUnit = wf_degreeConferUnit;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
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
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_CNLibraryClassification() {
		return wf_CNLibraryClassification;
	}
	public void setWf_CNLibraryClassification(String wf_CNLibraryClassification) {
		this.wf_CNLibraryClassification = wf_CNLibraryClassification;
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
	public void setWf_keyword(String wf_keyword) {
		this.wf_keyword = wf_keyword;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
	}
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
	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
	}
	
}
