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
 *<pre>标准</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_standard")
public class WF_B_standard {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准id 主键  自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
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
	 *<pre>计划号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_planCode")
    private String wf_planCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>Flash路径+文件名</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_flashName")
    private String wf_flashName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>附件</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_attachment")
    private String wf_attachment;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>排序</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_sort")
    private String wf_sort;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准类型</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardType")
    private String wf_standardType;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准级别</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardGrade")
    private String wf_standardGrade;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>历次版本发布情况</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_historyPub")
    private String wf_historyPub;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准型号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardTypeCode")
    private String wf_standardTypeCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准水平</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardLevel")
    private String wf_standardLevel;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中国标准分类号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CNstandardFLc")
    private String wf_CNstandardFLc;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardStatus")
    private String wf_standardStatus;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际标准分类号</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_iStandardFLcode")
    private String wf_iStandardFLcode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准类别</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardCategory")
    private String wf_standardCategory;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>采标名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_adoptName")
    private String wf_adoptName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>采用国际标准号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_useIstandardc")
    private String wf_useIstandardc;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>复审确认时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_reviewTime")
    private Date wf_reviewTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>首次发布日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_firstPubDate")
    private Date wf_firstPubDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>起草单位</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_draftUnit")
    private String wf_draftUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>技术归口单位</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_TechnologyReturnUnit")
    private String wf_TechnologyReturnUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>发布日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_pubDate")
    private Date wf_pubDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>英文标准名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ENstandardName")
    private String wf_ENstandardName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>实施日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_implementDate")
    private Date wf_implementDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>采用标准</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_useStandard")
    private String wf_useStandard;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>采用程度</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_useDegree")
    private String wf_useDegree;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>代替标准号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_replaceStandardc")
    private String wf_replaceStandardc;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文标准名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CNstandardName")
    private String wf_CNstandardName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_standardCode")
    private String wf_standardCode;
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
	 *<pre>装库日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_enterTime")
    private String wf_enterTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原TRS数据库中的ID</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID")
    private String wf_ID;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>标准正文文本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>编号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_serialNumber")
    private String wf_serialNumber;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原文(文件名)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
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
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Date getWf_reviewTime() {
		return wf_reviewTime;
	}
	public void setWf_reviewTime(Date wf_reviewTime) {
		this.wf_reviewTime = wf_reviewTime;
	}
	public String getWf_enterTime() {
		return wf_enterTime;
	}
	public void setWf_enterTime(String wf_enterTime) {
		this.wf_enterTime = wf_enterTime;
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
	public String getWf_serialNumber() {
		return wf_serialNumber;
	}
	public void setWf_serialNumber(String wf_serialNumber) {
		this.wf_serialNumber = wf_serialNumber;
	}
	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
	}
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
	}
	public Integer getWf_totalpage() {
		return wf_totalpage;
	}
	public void setWf_totalpage(Integer wf_totalpage) {
		this.wf_totalpage = wf_totalpage;
	}
	public String getWf_planCode() {
		return wf_planCode;
	}
	public void setWf_planCode(String wf_planCode) {
		this.wf_planCode = wf_planCode;
	}
	public String getWf_flashName() {
		return wf_flashName;
	}
	public void setWf_flashName(String wf_flashName) {
		this.wf_flashName = wf_flashName;
	}
	public String getWf_attachment() {
		return wf_attachment;
	}
	public void setWf_attachment(String wf_attachment) {
		this.wf_attachment = wf_attachment;
	}
	public String getWf_sort() {
		return wf_sort;
	}
	public void setWf_sort(String wf_sort) {
		this.wf_sort = wf_sort;
	}
	public String getWf_standardType() {
		return wf_standardType;
	}
	public void setWf_standardType(String wf_standardType) {
		this.wf_standardType = wf_standardType;
	}
	public String getWf_standardGrade() {
		return wf_standardGrade;
	}
	public void setWf_standardGrade(String wf_standardGrade) {
		this.wf_standardGrade = wf_standardGrade;
	}
	public String getWf_historyPub() {
		return wf_historyPub;
	}
	public void setWf_historyPub(String wf_historyPub) {
		this.wf_historyPub = wf_historyPub;
	}
	public String getWf_standardTypeCode() {
		return wf_standardTypeCode;
	}
	public void setWf_standardTypeCode(String wf_standardTypeCode) {
		this.wf_standardTypeCode = wf_standardTypeCode;
	}
	public String getWf_standardLevel() {
		return wf_standardLevel;
	}
	public void setWf_standardLevel(String wf_standardLevel) {
		this.wf_standardLevel = wf_standardLevel;
	}
	public String getWf_CNstandardFLc() {
		return wf_CNstandardFLc;
	}
	public void setWf_CNstandardFLc(String wf_CNstandardFLc) {
		this.wf_CNstandardFLc = wf_CNstandardFLc;
	}
	public String getWf_standardStatus() {
		return wf_standardStatus;
	}
	public void setWf_standardStatus(String wf_standardStatus) {
		this.wf_standardStatus = wf_standardStatus;
	}
	public String getWf_iStandardFLcode() {
		return wf_iStandardFLcode;
	}
	public void setWf_iStandardFLcode(String wf_iStandardFLcode) {
		this.wf_iStandardFLcode = wf_iStandardFLcode;
	}
	public String getWf_standardCategory() {
		return wf_standardCategory;
	}
	public void setWf_standardCategory(String wf_standardCategory) {
		this.wf_standardCategory = wf_standardCategory;
	}
	public String getWf_adoptName() {
		return wf_adoptName;
	}
	public void setWf_adoptName(String wf_adoptName) {
		this.wf_adoptName = wf_adoptName;
	}
	public String getWf_useIstandardc() {
		return wf_useIstandardc;
	}
	public void setWf_useIstandardc(String wf_useIstandardc) {
		this.wf_useIstandardc = wf_useIstandardc;
	}
	public Date getWf_firstPubDate() {
		return wf_firstPubDate;
	}
	public void setWf_firstPubDate(Date wf_firstPubDate) {
		this.wf_firstPubDate = wf_firstPubDate;
	}
	public String getWf_draftUnit() {
		return wf_draftUnit;
	}
	public void setWf_draftUnit(String wf_draftUnit) {
		this.wf_draftUnit = wf_draftUnit;
	}
	public String getWf_TechnologyReturnUnit() {
		return wf_TechnologyReturnUnit;
	}
	public void setWf_TechnologyReturnUnit(String wf_TechnologyReturnUnit) {
		this.wf_TechnologyReturnUnit = wf_TechnologyReturnUnit;
	}
	public Date getWf_pubDate() {
		return wf_pubDate;
	}
	public void setWf_pubDate(Date wf_pubDate) {
		this.wf_pubDate = wf_pubDate;
	}
	public String getWf_ENstandardName() {
		return wf_ENstandardName;
	}
	public void setWf_ENstandardName(String wf_ENstandardName) {
		this.wf_ENstandardName = wf_ENstandardName;
	}
	public Date getWf_implementDate() {
		return wf_implementDate;
	}
	public void setWf_implementDate(Date wf_implementDate) {
		this.wf_implementDate = wf_implementDate;
	}
	public String getWf_useStandard() {
		return wf_useStandard;
	}
	public void setWf_useStandard(String wf_useStandard) {
		this.wf_useStandard = wf_useStandard;
	}
	public String getWf_useDegree() {
		return wf_useDegree;
	}
	public void setWf_useDegree(String wf_useDegree) {
		this.wf_useDegree = wf_useDegree;
	}
	public String getWf_replaceStandardc() {
		return wf_replaceStandardc;
	}
	public void setWf_replaceStandardc(String wf_replaceStandardc) {
		this.wf_replaceStandardc = wf_replaceStandardc;
	}
	public String getWf_CNstandardName() {
		return wf_CNstandardName;
	}
	public void setWf_CNstandardName(String wf_CNstandardName) {
		this.wf_CNstandardName = wf_CNstandardName;
	}
	public String getWf_standardCode() {
		return wf_standardCode;
	}
	public void setWf_standardCode(String wf_standardCode) {
		this.wf_standardCode = wf_standardCode;
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
}
