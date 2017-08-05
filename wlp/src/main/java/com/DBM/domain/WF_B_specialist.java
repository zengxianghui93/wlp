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
@Table(name = "wf_b_specialist")
public class WF_B_specialist {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>专家表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>数据来源</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_source")
    private String wf_source;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_name",length=50)
    private String wf_name;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>性别</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_sex",length=2)
    private String wf_sex;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出生日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_birthday")
    private Date wf_birthday;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出生地点</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_birthplace")
    private String wf_birthplace;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>教育程度</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_educationalStatus")
    private String wf_educationalStatus;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>院士</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_academician")
    private String wf_academician;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>职称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_positionName")
    private String wf_positionName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>地区</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_area")
    private String wf_area;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>通讯地址</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_mailingAddress")
    private String wf_mailingAddress;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>邮政编码</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_postCode",length=50)
    private String wf_postCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电子邮箱</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_Email",length=50)
    private String wf_Email;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电话</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tel")
    private String wf_tel;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>工作单位</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_jobUnit")
    private String wf_jobUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>工作职务</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_jobDuty")
    private String wf_jobDuty;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>学科分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_disciplineClassification")
    private String wf_disciplineClassification;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>专业领域</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_professionalField")
    private String wf_professionalField;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>研究领域</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_researchField",length=65535)
    private String wf_researchField;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>科研情况</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_scientificResearch",length=65535)
    private String wf_scientificResearch;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>所获荣誉</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_receivedHonor",length=65535)
    private String wf_receivedHonor;
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
	 *<pre>备注</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_note")
    private String wf_note;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>装库日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_enterdateTime")
    private Date wf_enterdateTime;
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
	 *<pre>头像</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_photo")
    private String wf_photo;
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
	public Date getWf_enterdateTime() {
		return wf_enterdateTime;
	}
	public void setWf_enterdateTime(Date wf_enterdateTime) {
		this.wf_enterdateTime = wf_enterdateTime;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
	public String getWf_photo() {
		return wf_photo;
	}
	public void setWf_photo(String wf_photo) {
		this.wf_photo = wf_photo;
	}
	public String getWf_source() {
		return wf_source;
	}
	public void setWf_source(String wf_source) {
		this.wf_source = wf_source;
	}
	public String getWf_name() {
		return wf_name;
	}
	public void setWf_name(String wf_name) {
		this.wf_name = wf_name;
	}
	public String getWf_sex() {
		return wf_sex;
	}
	public void setWf_sex(String wf_sex) {
		this.wf_sex = wf_sex;
	}
	public Date getWf_birthday() {
		return wf_birthday;
	}
	public void setWf_birthday(Date wf_birthday) {
		this.wf_birthday = wf_birthday;
	}
	public String getWf_birthplace() {
		return wf_birthplace;
	}
	public void setWf_birthplace(String wf_birthplace) {
		this.wf_birthplace = wf_birthplace;
	}
	public String getWf_educationalStatus() {
		return wf_educationalStatus;
	}
	public void setWf_educationalStatus(String wf_educationalStatus) {
		this.wf_educationalStatus = wf_educationalStatus;
	}
	public String getWf_academician() {
		return wf_academician;
	}
	public void setWf_academician(String wf_academician) {
		this.wf_academician = wf_academician;
	}
	public String getWf_positionName() {
		return wf_positionName;
	}
	public void setWf_positionName(String wf_positionName) {
		this.wf_positionName = wf_positionName;
	}
	public String getWf_area() {
		return wf_area;
	}
	public void setWf_area(String wf_area) {
		this.wf_area = wf_area;
	}
	public String getWf_mailingAddress() {
		return wf_mailingAddress;
	}
	public void setWf_mailingAddress(String wf_mailingAddress) {
		this.wf_mailingAddress = wf_mailingAddress;
	}
	public String getWf_postCode() {
		return wf_postCode;
	}
	public void setWf_postCode(String wf_postCode) {
		this.wf_postCode = wf_postCode;
	}
	public String getWf_Email() {
		return wf_Email;
	}
	public void setWf_Email(String wf_Email) {
		this.wf_Email = wf_Email;
	}
	public String getWf_tel() {
		return wf_tel;
	}
	public void setWf_tel(String wf_tel) {
		this.wf_tel = wf_tel;
	}
	public String getWf_jobUnit() {
		return wf_jobUnit;
	}
	public void setWf_jobUnit(String wf_jobUnit) {
		this.wf_jobUnit = wf_jobUnit;
	}
	public String getWf_jobDuty() {
		return wf_jobDuty;
	}
	public void setWf_jobDuty(String wf_jobDuty) {
		this.wf_jobDuty = wf_jobDuty;
	}
	public String getWf_disciplineClassification() {
		return wf_disciplineClassification;
	}
	public void setWf_disciplineClassification(String wf_disciplineClassification) {
		this.wf_disciplineClassification = wf_disciplineClassification;
	}
	public String getWf_professionalField() {
		return wf_professionalField;
	}
	public void setWf_professionalField(String wf_professionalField) {
		this.wf_professionalField = wf_professionalField;
	}
	public String getWf_researchField() {
		return wf_researchField;
	}
	public void setWf_researchField(String wf_researchField) {
		this.wf_researchField = wf_researchField;
	}
	public String getWf_scientificResearch() {
		return wf_scientificResearch;
	}
	public void setWf_scientificResearch(String wf_scientificResearch) {
		this.wf_scientificResearch = wf_scientificResearch;
	}
	public String getWf_receivedHonor() {
		return wf_receivedHonor;
	}
	public void setWf_receivedHonor(String wf_receivedHonor) {
		this.wf_receivedHonor = wf_receivedHonor;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_note() {
		return wf_note;
	}
	public void setWf_note(String wf_note) {
		this.wf_note = wf_note;
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
