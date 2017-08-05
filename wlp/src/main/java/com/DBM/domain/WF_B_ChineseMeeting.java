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
 *<pre>中文会议表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_chineseMeeting")
public class WF_B_ChineseMeeting {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文会议id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>装库日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_enterDate")
    private Date wf_enterDate;
	
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
	 *<pre>会议地点</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingSite")
    private String wf_meetingSite;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议年</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingYear",length=50)
    private String wf_meetingYear;
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
	 *<pre>作者单位</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnit",length=65535)
    private String wf_authorUnit;
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
	 *<pre>原文(路径)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>ISBN(国际标准图书编号)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ISBN")
    private String wf_ISBN;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>ISSN（国际标准期刊编号）</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ISSN")
    private String wf_ISSN;
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
	 *<pre>页码</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_page")
    private String wf_page;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议录文集名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingrCorpusName")
    private String wf_meetingrCorpusName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>正题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title")
    private String wf_title;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>记录号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_recordCode",length=50)
    private String wf_recordCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>文本内容(longtext)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
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
	 *<pre>技术经济指标id  外键</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tei_id")
    private Integer wf_tei_id;
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
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_meetingYear() {
		return wf_meetingYear;
	}
	public void setWf_meetingYear(String wf_meetingYear) {
		this.wf_meetingYear = wf_meetingYear;
	}
	public String getWf_CNLibraryClassification() {
		return wf_CNLibraryClassification;
	}
	public void setWf_CNLibraryClassification(String wf_CNLibraryClassification) {
		this.wf_CNLibraryClassification = wf_CNLibraryClassification;
	}
	public Date getWf_enterDate() {
		return wf_enterDate;
	}
	public void setWf_enterDate(Date wf_enterDate) {
		this.wf_enterDate = wf_enterDate;
	}
	public String getWf_keyword() {
		return wf_keyword;
	}
	public void setWf_keyword(String wf_keyword) {
		this.wf_keyword = wf_keyword;
	}
	public String getWf_meetingSite() {
		return wf_meetingSite;
	}
	public void setWf_meetingSite(String wf_meetingSite) {
		this.wf_meetingSite = wf_meetingSite;
	}
	
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_authorUnit() {
		return wf_authorUnit;
	}
	public void setWf_authorUnit(String wf_authorUnit) {
		this.wf_authorUnit = wf_authorUnit;
	}

	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
	}
	public String getWf_ISBN() {
		return wf_ISBN;
	}
	public void setWf_ISBN(String wf_ISBN) {
		this.wf_ISBN = wf_ISBN;
	}
	public String getWf_ISSN() {
		return wf_ISSN;
	}
	public void setWf_ISSN(String wf_ISSN) {
		this.wf_ISSN = wf_ISSN;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
	}
	public String getWf_page() {
		return wf_page;
	}
	public void setWf_page(String wf_page) {
		this.wf_page = wf_page;
	}
	public String getWf_meetingrCorpusName() {
		return wf_meetingrCorpusName;
	}
	public void setWf_meetingrCorpusName(String wf_meetingrCorpusName) {
		this.wf_meetingrCorpusName = wf_meetingrCorpusName;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_recordCode() {
		return wf_recordCode;
	}
	public void setWf_recordCode(String wf_recordCode) {
		this.wf_recordCode = wf_recordCode;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
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
	public Integer getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(Integer wf_lang) {
		this.wf_lang = wf_lang;
	}
	
}
