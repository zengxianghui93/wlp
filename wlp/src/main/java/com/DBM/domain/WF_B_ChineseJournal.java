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
 *<pre> 中文期刊</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_chineseJournal")
public class WF_B_ChineseJournal {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文期刊id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原TRS中的ID</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID",length=50)
    private String wf_ID;
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
	 *<pre>是否提取作者信息</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_getAuthorInfo_no",length=10)
    private String wf_getAuthorInfo_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否发知识中心</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_IKC_no",length=10)
    private String wf_IKC_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否提取指标</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_extractIndex_no",length=10)
    private String wf_extractIndex_no;
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
	 *<pre>正文(longtext)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>英文文摘(text)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract_en",length=65535)
    private String wf_abstract_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>英文关键词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword_en",length=65535)
    private String wf_keyword_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>英文题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title_en")
    private String wf_title_en;
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
	 *<pre>刊名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_journalName")
    private String wf_journalName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>机构</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnit")
    private String wf_authorUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>作者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_author",length=65535)
    private String wf_author;
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
	 *<pre>页码</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_page",length=50)
    private String wf_page;
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
	 *<pre>卷</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_volume",length=50)
    private String wf_volume;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_issue",length=50)
    private String wf_issue;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>CN号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CN")
    private String wf_CN;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>ISSN</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ISSN")
    private String wf_ISSN;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备注</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_note")
    private String wf_note;
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
	 *<pre>备用</pre>
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
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public String getWf_getAuthorInfo_no() {
		return wf_getAuthorInfo_no;
	}
	public void setWf_getAuthorInfo_no(String wf_getAuthorInfo_no) {
		this.wf_getAuthorInfo_no = wf_getAuthorInfo_no;
	}
	public String getWf_IKC_no() {
		return wf_IKC_no;
	}
	public void setWf_IKC_no(String wf_IKC_no) {
		this.wf_IKC_no = wf_IKC_no;
	}
	public String getWf_extractIndex_no() {
		return wf_extractIndex_no;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
	}
	public Date getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(Date wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	public String getWf_title_en() {
		return wf_title_en;
	}
	public void setWf_title_en(String wf_title_en) {
		this.wf_title_en = wf_title_en;
	}
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
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
	public void setWf_extractIndex_no(String wf_extractIndex_no) {
		this.wf_extractIndex_no = wf_extractIndex_no;
	}
	public String getWf_CNLibraryClassification() {
		return wf_CNLibraryClassification;
	}
	public void setWf_CNLibraryClassification(String wf_CNLibraryClassification) {
		this.wf_CNLibraryClassification = wf_CNLibraryClassification;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_abstract_en() {
		return wf_abstract_en;
	}
	public void setWf_abstract_en(String wf_abstract_en) {
		this.wf_abstract_en = wf_abstract_en;
	}
	public String getWf_keyword_en() {
		return wf_keyword_en;
	}
	public void setWf_keyword_en(String wf_keyword_en) {
		this.wf_keyword_en = wf_keyword_en;
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
	public String getWf_journalName() {
		return wf_journalName;
	}
	public void setWf_journalName(String wf_journalName) {
		this.wf_journalName = wf_journalName;
	}
	public String getWf_authorUnit() {
		return wf_authorUnit;
	}
	public void setWf_authorUnit(String wf_authorUnit) {
		this.wf_authorUnit = wf_authorUnit;
	}
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_page() {
		return wf_page;
	}
	public void setWf_page(String wf_page) {
		this.wf_page = wf_page;
	}
	public String getWf_year() {
		return wf_year;
	}
	public void setWf_year(String wf_year) {
		this.wf_year = wf_year;
	}
	public String getWf_volume() {
		return wf_volume;
	}
	public void setWf_volume(String wf_volume) {
		this.wf_volume = wf_volume;
	}
	public String getWf_issue() {
		return wf_issue;
	}
	public void setWf_issue(String wf_issue) {
		this.wf_issue = wf_issue;
	}
	public String getWf_CN() {
		return wf_CN;
	}
	public void setWf_CN(String wf_CN) {
		this.wf_CN = wf_CN;
	}
	public String getWf_ISSN() {
		return wf_ISSN;
	}
	public void setWf_ISSN(String wf_ISSN) {
		this.wf_ISSN = wf_ISSN;
	}
	public String getWf_note() {
		return wf_note;
	}
	public void setWf_note(String wf_note) {
		this.wf_note = wf_note;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
}
