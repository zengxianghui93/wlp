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
 *<pre>馆藏文摘</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_libraryAbstract")
public class WF_B_LibraryAbstract {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>馆藏文摘id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>题名_机器翻译(extend1)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title_m")
    private String wf_title_m;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>摘要_机器翻译(extend2)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract_m",length=65535)
    private String wf_abstract_m;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键词_机器翻译(extend3)</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_keyword_m",length=65535)
    private String wf_keyword_m;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用于后天标识是否提取过数据</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_extend6")
    private String wf_extend6;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>卷期ID号非唯一标识</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_vpID")
    private String wf_vpID;
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
	 *<pre>期刊编号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_journalCode")
    private String wf_journalCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议时间(文本格式)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingTime")
    private String wf_meetingTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议地点 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingSite")
    private String wf_meetingSite;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>入库日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_enterDate")
    private Date wf_enterDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>止页</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_endPage",length=50)
    private Integer wf_endPage;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>起页</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_startPage",length=50)
    private Integer wf_startPage;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>其它语种文摘</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_otherLangAbstract",length=65535)
    private String wf_otherLangAbstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>母体文献记录标识</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingwxjlbs")
    private String wf_meetingwxjlbs;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>馆藏单位代</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_libraryUnitd")
    private String wf_libraryUnitd;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>记录唯一标识号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_recordOnlybsc")
    private String wf_recordOnlybsc;
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
	 *<pre>期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_issue",length=50)
    private Integer wf_issue;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中图分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CNLibraryClassification")
    private String wf_CNLibraryClassification;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>馆藏单位</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_gcunit")
    private String wf_gcunit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>西文关键词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword_en",length=65535)
    private String wf_keyword_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文关键词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword_cn",length=65535)
    private String wf_keyword_cn;
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
	 *<pre>ISBN</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ISBN")
    private String wf_ISBN;
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
	 *<pre>语种 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang")
    private String wf_lang;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>文献类型</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doctype")
    private String wf_doctype;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出版年</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year",length=50)
    private String wf_year;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>文集文献名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CorpusLiteratureName")
    private String wf_CorpusLiteratureName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议文献名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingLiteratureName")
    private String wf_meetingLiteratureName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>页码（范围）</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_page",length=50)
    private String wf_page;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>卷</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_volume",length=50)
    private Integer wf_volume;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>期刊名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_journalName")
    private String wf_journalName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中图公司订刊号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CCOSN")
    private String wf_CCOSN;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title_cn")
    private String wf_title_cn;
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
	 *<pre>记录号</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_recordCode")
    private String wf_recordCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议地点_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingSite_cn")
    private String wf_meetingSite_cn;
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
	 *<pre>会议录文集名_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingrCorpusName_cn")
    private String wf_meetingrCorpusName_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>会议年</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_meetingYear")
    private Date wf_meetingYear;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_Fl",length=65535)
    private String wf_Fl;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>作者单位 </pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnit",length=65535)
    private String wf_authorUnit;
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
	 *<pre>文本内容</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private Date wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>更新时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_modifytime")
    private Date wf_modifytime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>更新人(对应用户信息表)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_modifyUserid")
    private String wf_modifyUserid;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>创建者(对应用户信息表)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatUserid")
    private String wf_creatUserid;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原始文件名（入库人工命名 ）</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_originalDocName")
    private String wf_originalDocName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>并列题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_parallelTitle")
    private String wf_parallelTitle;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>期刊状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_journalStatus",length=10)
    private Integer wf_journalStatus;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否提取指标</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_extractIndex_no")
    private String wf_extractIndex_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>期刊id号/pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_journalId")
    private String wf_journalId;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>v状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_state")
    private String wf_state;
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
	 *<pre>作者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_author")
    private String wf_author;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>团体作者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_groupAuthor")
    private String wf_groupAuthor;
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
	 *<pre>馆藏文摘库来源（1外文期刊 2外文会议）</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_source")
	private String wf_source;
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
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Date getWf_modifytime() {
		return wf_modifytime;
	}
	public Date getWf_enterDate() {
		return wf_enterDate;
	}
	public void setWf_enterDate(Date wf_enterDate) {
		this.wf_enterDate = wf_enterDate;
	}
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_groupAuthor() {
		return wf_groupAuthor;
	}
	public void setWf_groupAuthor(String wf_groupAuthor) {
		this.wf_groupAuthor = wf_groupAuthor;
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
	public void setWf_modifytime(Date wf_modifytime) {
		this.wf_modifytime = wf_modifytime;
	}
	public String getWf_title_m() {
		return wf_title_m;
	}
	public void setWf_title_m(String wf_title_m) {
		this.wf_title_m = wf_title_m;
	}
	public String getWf_abstract_m() {
		return wf_abstract_m;
	}
	public void setWf_abstract_m(String wf_abstract_m) {
		this.wf_abstract_m = wf_abstract_m;
	}
	public String getWf_keyword_m() {
		return wf_keyword_m;
	}
	public void setWf_keyword_m(String wf_keyword_m) {
		this.wf_keyword_m = wf_keyword_m;
	}
	public String getWf_extend6() {
		return wf_extend6;
	}
	public void setWf_extend6(String wf_extend6) {
		this.wf_extend6 = wf_extend6;
	}
	public String getWf_vpID() {
		return wf_vpID;
	}
	public void setWf_vpID(String wf_vpID) {
		this.wf_vpID = wf_vpID;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
	public String getWf_journalCode() {
		return wf_journalCode;
	}
	public void setWf_journalCode(String wf_journalCode) {
		this.wf_journalCode = wf_journalCode;
	}
	public String getWf_meetingTime() {
		return wf_meetingTime;
	}
	public void setWf_meetingTime(String wf_meetingTime) {
		this.wf_meetingTime = wf_meetingTime;
	}
	public String getWf_meetingSite() {
		return wf_meetingSite;
	}
	public void setWf_meetingSite(String wf_meetingSite) {
		this.wf_meetingSite = wf_meetingSite;
	}
	public Integer getWf_endPage() {
		return wf_endPage;
	}
	public void setWf_endPage(Integer wf_endPage) {
		this.wf_endPage = wf_endPage;
	}
	public Integer getWf_startPage() {
		return wf_startPage;
	}
	public void setWf_startPage(Integer wf_startPage) {
		this.wf_startPage = wf_startPage;
	}
	public String getWf_otherLangAbstract() {
		return wf_otherLangAbstract;
	}
	public void setWf_otherLangAbstract(String wf_otherLangAbstract) {
		this.wf_otherLangAbstract = wf_otherLangAbstract;
	}
	public String getWf_meetingwxjlbs() {
		return wf_meetingwxjlbs;
	}
	public void setWf_meetingwxjlbs(String wf_meetingwxjlbs) {
		this.wf_meetingwxjlbs = wf_meetingwxjlbs;
	}
	public String getWf_libraryUnitd() {
		return wf_libraryUnitd;
	}
	public void setWf_libraryUnitd(String wf_libraryUnitd) {
		this.wf_libraryUnitd = wf_libraryUnitd;
	}
	public String getWf_recordOnlybsc() {
		return wf_recordOnlybsc;
	}
	public void setWf_recordOnlybsc(String wf_recordOnlybsc) {
		this.wf_recordOnlybsc = wf_recordOnlybsc;
	}
	public Integer getWf_totalpage() {
		return wf_totalpage;
	}
	public void setWf_totalpage(Integer wf_totalpage) {
		this.wf_totalpage = wf_totalpage;
	}
	public Integer getWf_issue() {
		return wf_issue;
	}
	public void setWf_issue(Integer wf_issue) {
		this.wf_issue = wf_issue;
	}
	public String getWf_CNLibraryClassification() {
		return wf_CNLibraryClassification;
	}
	public void setWf_CNLibraryClassification(String wf_CNLibraryClassification) {
		this.wf_CNLibraryClassification = wf_CNLibraryClassification;
	}
	public String getWf_gcunit() {
		return wf_gcunit;
	}
	public void setWf_gcunit(String wf_gcunit) {
		this.wf_gcunit = wf_gcunit;
	}
	public String getWf_keyword_en() {
		return wf_keyword_en;
	}
	public void setWf_keyword_en(String wf_keyword_en) {
		this.wf_keyword_en = wf_keyword_en;
	}
	public String getWf_keyword_cn() {
		return wf_keyword_cn;
	}
	public void setWf_keyword_cn(String wf_keyword_cn) {
		this.wf_keyword_cn = wf_keyword_cn;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
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
	public String getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(String wf_lang) {
		this.wf_lang = wf_lang;
	}
	public String getWf_doctype() {
		return wf_doctype;
	}
	public void setWf_doctype(String wf_doctype) {
		this.wf_doctype = wf_doctype;
	}
	public String getWf_year() {
		return wf_year;
	}
	public void setWf_year(String wf_year) {
		this.wf_year = wf_year;
	}
	public String getWf_CorpusLiteratureName() {
		return wf_CorpusLiteratureName;
	}
	public void setWf_CorpusLiteratureName(String wf_CorpusLiteratureName) {
		this.wf_CorpusLiteratureName = wf_CorpusLiteratureName;
	}
	public String getWf_meetingLiteratureName() {
		return wf_meetingLiteratureName;
	}
	public void setWf_meetingLiteratureName(String wf_meetingLiteratureName) {
		this.wf_meetingLiteratureName = wf_meetingLiteratureName;
	}
	public String getWf_page() {
		return wf_page;
	}
	public void setWf_page(String wf_page) {
		this.wf_page = wf_page;
	}
	public Integer getWf_volume() {
		return wf_volume;
	}
	public void setWf_volume(Integer wf_volume) {
		this.wf_volume = wf_volume;
	}
	public String getWf_journalName() {
		return wf_journalName;
	}
	public void setWf_journalName(String wf_journalName) {
		this.wf_journalName = wf_journalName;
	}
	public String getWf_CCOSN() {
		return wf_CCOSN;
	}
	public void setWf_CCOSN(String wf_CCOSN) {
		this.wf_CCOSN = wf_CCOSN;
	}
	public String getWf_title_cn() {
		return wf_title_cn;
	}
	public void setWf_title_cn(String wf_title_cn) {
		this.wf_title_cn = wf_title_cn;
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
	public String getWf_meetingSite_cn() {
		return wf_meetingSite_cn;
	}
	public void setWf_meetingSite_cn(String wf_meetingSite_cn) {
		this.wf_meetingSite_cn = wf_meetingSite_cn;
	}
	public String getWf_meetingrCorpusName() {
		return wf_meetingrCorpusName;
	}
	public void setWf_meetingrCorpusName(String wf_meetingrCorpusName) {
		this.wf_meetingrCorpusName = wf_meetingrCorpusName;
	}
	public String getWf_meetingrCorpusName_cn() {
		return wf_meetingrCorpusName_cn;
	}
	public void setWf_meetingrCorpusName_cn(String wf_meetingrCorpusName_cn) {
		this.wf_meetingrCorpusName_cn = wf_meetingrCorpusName_cn;
	}
	public Date getWf_meetingYear() {
		return wf_meetingYear;
	}
	public void setWf_meetingYear(Date wf_meetingYear) {
		this.wf_meetingYear = wf_meetingYear;
	}
	public String getWf_Fl() {
		return wf_Fl;
	}
	public void setWf_Fl(String wf_Fl) {
		this.wf_Fl = wf_Fl;
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
	public Date getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(Date wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_modifyUserid() {
		return wf_modifyUserid;
	}
	public void setWf_modifyUserid(String wf_modifyUserid) {
		this.wf_modifyUserid = wf_modifyUserid;
	}
	public String getWf_creatUserid() {
		return wf_creatUserid;
	}
	public void setWf_creatUserid(String wf_creatUserid) {
		this.wf_creatUserid = wf_creatUserid;
	}
	public String getWf_originalDocName() {
		return wf_originalDocName;
	}
	public void setWf_originalDocName(String wf_originalDocName) {
		this.wf_originalDocName = wf_originalDocName;
	}
	public String getWf_parallelTitle() {
		return wf_parallelTitle;
	}
	public void setWf_parallelTitle(String wf_parallelTitle) {
		this.wf_parallelTitle = wf_parallelTitle;
	}
	public Integer getWf_journalStatus() {
		return wf_journalStatus;
	}
	public void setWf_journalStatus(Integer wf_journalStatus) {
		this.wf_journalStatus = wf_journalStatus;
	}
	public String getWf_extractIndex_no() {
		return wf_extractIndex_no;
	}
	public void setWf_extractIndex_no(String wf_extractIndex_no) {
		this.wf_extractIndex_no = wf_extractIndex_no;
	}
	public String getWf_journalId() {
		return wf_journalId;
	}
	public void setWf_journalId(String wf_journalId) {
		this.wf_journalId = wf_journalId;
	}
	public String getWf_state() {
		return wf_state;
	}
	public void setWf_state(String wf_state) {
		this.wf_state = wf_state;
	}
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public String getWf_source() {
		return wf_source;
	}
	public void setWf_source(String wf_source) {
		this.wf_source = wf_source;
	}

}
