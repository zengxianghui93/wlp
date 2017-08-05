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
 *<pre>技术经济指标</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_technicalEconomicIndi")
public class WF_B_technicalEconomicIndi {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>技术经济指标id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
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
	 *<pre>存储图片文件路径</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableFigure")
    private String wf_tableFigure;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储flash文件路径</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_tableContentFlash")
    private String wf_tableContentFlash;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)计量单位信息_外文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_unitOfParameter_en")
    private String wf_unitOfParameter_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)计量单位信息_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_unitOfParameter_cn")
    private String wf_unitOfParameter_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)种类信息_外文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_Parameter_en")
    private String wf_Parameter_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>指标)种类信息_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_Parameter_cn")
    private String wf_Parameter_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)设备等信息_外文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_equipmentOfParameter_en")
    private String wf_equipmentOfParameter_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)设备等信息_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_equipmentOfParameter_cn")
    private String wf_equipmentOfParameter_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)机构等信息_外文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_departmentOfParameter_en")
    private String wf_departmentOfParameter_en;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)机构等信息_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_departmentOfParameter_cn")
    private String wf_departmentOfParameter_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)时间信息_外文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_timeOfParameter_en")
    private String wf_timeOfParameter_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>(指标)时间信息_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_timeOfParameter_cn")
    private String wf_timeOfParameter_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储表格标题文本_外文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableTitleByProcessor_en")
    private String wf_tableTitleByProcessor_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储表格标题文本_中文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableTitleByProcessor_cn")
    private String wf_tableTitleByProcessor_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储jpg文件路径</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableSnapShot")
    private String wf_tableSnapShot;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储word文件路径</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableContentWord")
    private String wf_tableContentWord;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储表格文本内容</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableContentTxt",length=2147483647)
    private String wf_tableContentTxt;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储表格标题后3行文本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableTitleAfter",length=65535)
    private String wf_tableTitleAfter;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储表格标题前3行文本</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_tableTitleBefore",length=65535)
    private String wf_tableTitleBefore;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>存储表格标题文本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableTitleByProgram",length=65535)
    private String wf_tableTitleByProgram;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>序列号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_serialNumber")
    private String wf_serialNumber;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>加工人员</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_processPersonnel")
    private String wf_processPersonnel;
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
	 *<pre>收稿时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fileReceivedTime")
    private Date wf_fileReceivedTime;
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
	 *<pre>备注 </pre>
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
	public Date getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(Date wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	public String getWf_tableFigure() {
		return wf_tableFigure;
	}
	public void setWf_tableFigure(String wf_tableFigure) {
		this.wf_tableFigure = wf_tableFigure;
	}
	public String getWf_tableContentFlash() {
		return wf_tableContentFlash;
	}
	public void setWf_tableContentFlash(String wf_tableContentFlash) {
		this.wf_tableContentFlash = wf_tableContentFlash;
	}
	public String getWf_unitOfParameter_en() {
		return wf_unitOfParameter_en;
	}
	public void setWf_unitOfParameter_en(String wf_unitOfParameter_en) {
		this.wf_unitOfParameter_en = wf_unitOfParameter_en;
	}
	public String getWf_unitOfParameter_cn() {
		return wf_unitOfParameter_cn;
	}
	public void setWf_unitOfParameter_cn(String wf_unitOfParameter_cn) {
		this.wf_unitOfParameter_cn = wf_unitOfParameter_cn;
	}
	public String getWf_Parameter_en() {
		return wf_Parameter_en;
	}
	public void setWf_Parameter_en(String wf_Parameter_en) {
		this.wf_Parameter_en = wf_Parameter_en;
	}
	public String getWf_Parameter_cn() {
		return wf_Parameter_cn;
	}
	public void setWf_Parameter_cn(String wf_Parameter_cn) {
		this.wf_Parameter_cn = wf_Parameter_cn;
	}
	public String getWf_equipmentOfParameter_en() {
		return wf_equipmentOfParameter_en;
	}
	public void setWf_equipmentOfParameter_en(String wf_equipmentOfParameter_en) {
		this.wf_equipmentOfParameter_en = wf_equipmentOfParameter_en;
	}
	public String getWf_equipmentOfParameter_cn() {
		return wf_equipmentOfParameter_cn;
	}
	public void setWf_equipmentOfParameter_cn(String wf_equipmentOfParameter_cn) {
		this.wf_equipmentOfParameter_cn = wf_equipmentOfParameter_cn;
	}
	public String getWf_departmentOfParameter_en() {
		return wf_departmentOfParameter_en;
	}
	public void setWf_departmentOfParameter_en(String wf_departmentOfParameter_en) {
		this.wf_departmentOfParameter_en = wf_departmentOfParameter_en;
	}
	public String getWf_departmentOfParameter_cn() {
		return wf_departmentOfParameter_cn;
	}
	public void setWf_departmentOfParameter_cn(String wf_departmentOfParameter_cn) {
		this.wf_departmentOfParameter_cn = wf_departmentOfParameter_cn;
	}
	public String getWf_timeOfParameter_en() {
		return wf_timeOfParameter_en;
	}
	public void setWf_timeOfParameter_en(String wf_timeOfParameter_en) {
		this.wf_timeOfParameter_en = wf_timeOfParameter_en;
	}
	public String getWf_timeOfParameter_cn() {
		return wf_timeOfParameter_cn;
	}
	public void setWf_timeOfParameter_cn(String wf_timeOfParameter_cn) {
		this.wf_timeOfParameter_cn = wf_timeOfParameter_cn;
	}
	public String getWf_tableTitleByProcessor_en() {
		return wf_tableTitleByProcessor_en;
	}
	public void setWf_tableTitleByProcessor_en(String wf_tableTitleByProcessor_en) {
		this.wf_tableTitleByProcessor_en = wf_tableTitleByProcessor_en;
	}
	public String getWf_tableTitleByProcessor_cn() {
		return wf_tableTitleByProcessor_cn;
	}
	public void setWf_tableTitleByProcessor_cn(String wf_tableTitleByProcessor_cn) {
		this.wf_tableTitleByProcessor_cn = wf_tableTitleByProcessor_cn;
	}
	public String getWf_tableSnapShot() {
		return wf_tableSnapShot;
	}
	public void setWf_tableSnapShot(String wf_tableSnapShot) {
		this.wf_tableSnapShot = wf_tableSnapShot;
	}
	public String getWf_tableContentWord() {
		return wf_tableContentWord;
	}
	public void setWf_tableContentWord(String wf_tableContentWord) {
		this.wf_tableContentWord = wf_tableContentWord;
	}
	public String getWf_tableContentTxt() {
		return wf_tableContentTxt;
	}
	public void setWf_tableContentTxt(String wf_tableContentTxt) {
		this.wf_tableContentTxt = wf_tableContentTxt;
	}
	public String getWf_tableTitleAfter() {
		return wf_tableTitleAfter;
	}
	public void setWf_tableTitleAfter(String wf_tableTitleAfter) {
		this.wf_tableTitleAfter = wf_tableTitleAfter;
	}
	public String getWf_tableTitleBefore() {
		return wf_tableTitleBefore;
	}
	public void setWf_tableTitleBefore(String wf_tableTitleBefore) {
		this.wf_tableTitleBefore = wf_tableTitleBefore;
	}
	public String getWf_tableTitleByProgram() {
		return wf_tableTitleByProgram;
	}
	public void setWf_tableTitleByProgram(String wf_tableTitleByProgram) {
		this.wf_tableTitleByProgram = wf_tableTitleByProgram;
	}
	public String getWf_serialNumber() {
		return wf_serialNumber;
	}
	public void setWf_serialNumber(String wf_serialNumber) {
		this.wf_serialNumber = wf_serialNumber;
	}
	public String getWf_processPersonnel() {
		return wf_processPersonnel;
	}
	public void setWf_processPersonnel(String wf_processPersonnel) {
		this.wf_processPersonnel = wf_processPersonnel;
	}
	public String getWf_source() {
		return wf_source;
	}
	public void setWf_source(String wf_source) {
		this.wf_source = wf_source;
	}
	public Date getWf_fileReceivedTime() {
		return wf_fileReceivedTime;
	}
	public void setWf_fileReceivedTime(Date wf_fileReceivedTime) {
		this.wf_fileReceivedTime = wf_fileReceivedTime;
	}
	public String getWf_IKC_no() {
		return wf_IKC_no;
	}
	public void setWf_IKC_no(String wf_IKC_no) {
		this.wf_IKC_no = wf_IKC_no;
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
