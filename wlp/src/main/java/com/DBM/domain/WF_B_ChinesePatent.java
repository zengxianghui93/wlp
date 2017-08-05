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
 *<pre>中文专利</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_chinesePatent")
public class WF_B_ChinesePatent {
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文专利id 主键  自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分案原申请号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fayApplicationCode")
    private String wf_fayApplicationCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>专利类型</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_patentType")
    private String wf_patentType;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>主分类号 </pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_mainflCode")
    private String wf_mainflCode;
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
	 *<pre>CPC</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CPC",length=65535)
    private String wf_CPC;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>邮编</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_postCode",length=50)
    private String wf_postCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>授权日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorizationDay")
    private Date wf_authorizationDay;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>源数据文件名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_sourceFileName")
    private String wf_sourceFileName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>导入人员</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ImportPersonnel")
    private String wf_ImportPersonnel;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>数据导入时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_dataImportTime")
    private Date wf_dataImportTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>公开号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_openCode")
    private String wf_openCode;
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
	 *<pre>进入国家阶段日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_EnterNationalPhwf_ase")
    private Date wf_EnterNationalPhase;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际申请日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_iad")
    private Date wf_iad;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际申请号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_iac")
    private String wf_iac;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际公布语言</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ipl")
    private String wf_ipl;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际公布日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ipd")
    private Date wf_ipd;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际公布号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ipn",length=65535)
    private String wf_ipn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>PCT</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_PCT")
    private String wf_PCT;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>说明书光盘卷号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_smsVolumeCode")
    private String wf_smsVolumeCode;
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
	 *<pre>附图数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ftNumber")
    private Integer wf_ftNumber;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>权利要求项数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_claimNumber")
    private Integer wf_claimNumber;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>范畴分类号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fcflCode")
    private String wf_fcflCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>法律状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lawStatus")
    private String wf_lawStatus;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>审批历史</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_spHistory")
    private String wf_spHistory;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>代理人</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_agent")
    private String wf_agent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>代理机构地址</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_agencyUnitAddress")
    private String wf_agencyUnitAddress;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>代理机构</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_agencyUnit")
    private String wf_agencyUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>优先权</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_yxq",length=65535)
    private String wf_yxq;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>摘要</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract",length=65535)
    private String wf_abstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>权利要求</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_claim")
    private String wf_claim;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国际分类号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ipc")
    private String wf_ipc;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>审定公告</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_judgementCode")
    private String wf_judgementCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>授权公告日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorizationPubDay")
    private Date wf_authorizationPubDay;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>公告日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_pubDay")
    private Date wf_pubDay;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>公开日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_openDay")
    private Date wf_openDay;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>公告号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_pubCode")
    private String wf_pubCode;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>发明名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_inventName")
    private String wf_inventName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>联系地址</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_contactAddress")
    private String wf_contactAddress;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>国家省市</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_nationalpc")
    private String wf_nationalpc;/**
	 *<br><b>字段描述:</b>
	 *<pre>发明人</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_inventpeople")
    private String wf_inventpeople;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>申请人</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_applypeople")
    private String wf_applypeople;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>申请日</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_applyDay")
    private Date wf_applyDay;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>申请号</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_applyCode")
    private String wf_applyCode;
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
	 *<pre>原TRS数据库中的ID</pre>
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
	@Column(name = "wf_doccontent")
	private String wf_doccontent;
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
	public String getWf_fayApplicationCode() {
		return wf_fayApplicationCode;
	}
	public void setWf_fayApplicationCode(String wf_fayApplicationCode) {
		this.wf_fayApplicationCode = wf_fayApplicationCode;
	}
	public String getWf_patentType() {
		return wf_patentType;
	}
	public void setWf_patentType(String wf_patentType) {
		this.wf_patentType = wf_patentType;
	}
	public String getWf_mainflCode() {
		return wf_mainflCode;
	}
	public void setWf_mainflCode(String wf_mainflCode) {
		this.wf_mainflCode = wf_mainflCode;
	}
	public String getWf_IKC_no() {
		return wf_IKC_no;
	}
	public void setWf_IKC_no(String wf_IKC_no) {
		this.wf_IKC_no = wf_IKC_no;
	}
	public String getWf_CPC() {
		return wf_CPC;
	}
	public void setWf_CPC(String wf_CPC) {
		this.wf_CPC = wf_CPC;
	}
	public String getWf_postCode() {
		return wf_postCode;
	}
	public void setWf_postCode(String wf_postCode) {
		this.wf_postCode = wf_postCode;
	}
	public Date getWf_authorizationDay() {
		return wf_authorizationDay;
	}
	public void setWf_authorizationDay(Date wf_authorizationDay) {
		this.wf_authorizationDay = wf_authorizationDay;
	}
	public String getWf_sourceFileName() {
		return wf_sourceFileName;
	}
	public void setWf_sourceFileName(String wf_sourceFileName) {
		this.wf_sourceFileName = wf_sourceFileName;
	}
	public String getWf_ImportPersonnel() {
		return wf_ImportPersonnel;
	}
	public void setWf_ImportPersonnel(String wf_ImportPersonnel) {
		this.wf_ImportPersonnel = wf_ImportPersonnel;
	}
	public Date getWf_dataImportTime() {
		return wf_dataImportTime;
	}
	public void setWf_dataImportTime(Date wf_dataImportTime) {
		this.wf_dataImportTime = wf_dataImportTime;
	}
	public String getWf_openCode() {
		return wf_openCode;
	}
	public void setWf_openCode(String wf_openCode) {
		this.wf_openCode = wf_openCode;
	}
	public Date getWf_EnterNationalPhase() {
		return wf_EnterNationalPhase;
	}
	public void setWf_EnterNationalPhase(Date wf_EnterNationalPhase) {
		this.wf_EnterNationalPhase = wf_EnterNationalPhase;
	}
	public Date getWf_iad() {
		return wf_iad;
	}
	public void setWf_iad(Date wf_iad) {
		this.wf_iad = wf_iad;
	}
	public String getWf_iac() {
		return wf_iac;
	}
	public void setWf_iac(String wf_iac) {
		this.wf_iac = wf_iac;
	}
	
	public Date getWf_ipd() {
		return wf_ipd;
	}
	public void setWf_ipd(Date wf_ipd) {
		this.wf_ipd = wf_ipd;
	}
	public String getWf_ipc() {
		return wf_ipc;
	}
	public void setWf_ipc(String wf_ipc) {
		this.wf_ipc = wf_ipc;
	}
	public String getWf_ipl() {
		return wf_ipl;
	}
	public void setWf_ipl(String wf_ipl) {
		this.wf_ipl = wf_ipl;
	}
	public String getWf_PCT() {
		return wf_PCT;
	}
	public void setWf_PCT(String wf_PCT) {
		this.wf_PCT = wf_PCT;
	}
	public String getWf_smsVolumeCode() {
		return wf_smsVolumeCode;
	}
	public void setWf_smsVolumeCode(String wf_smsVolumeCode) {
		this.wf_smsVolumeCode = wf_smsVolumeCode;
	}
	public Integer getWf_totalpage() {
		return wf_totalpage;
	}
	public void setWf_totalpage(Integer wf_totalpage) {
		this.wf_totalpage = wf_totalpage;
	}
	public Integer getWf_ftNumber() {
		return wf_ftNumber;
	}
	public void setWf_ftNumber(Integer wf_ftNumber) {
		this.wf_ftNumber = wf_ftNumber;
	}
	public Integer getWf_claimNumber() {
		return wf_claimNumber;
	}
	public void setWf_claimNumber(Integer wf_claimNumber) {
		this.wf_claimNumber = wf_claimNumber;
	}
	public String getWf_fcflCode() {
		return wf_fcflCode;
	}
	public void setWf_fcflCode(String wf_fcflCode) {
		this.wf_fcflCode = wf_fcflCode;
	}
	public String getWf_lawStatus() {
		return wf_lawStatus;
	}
	public void setWf_lawStatus(String wf_lawStatus) {
		this.wf_lawStatus = wf_lawStatus;
	}
	public String getWf_spHistory() {
		return wf_spHistory;
	}
	public void setWf_spHistory(String wf_spHistory) {
		this.wf_spHistory = wf_spHistory;
	}
	public String getWf_agent() {
		return wf_agent;
	}
	public void setWf_agent(String wf_agent) {
		this.wf_agent = wf_agent;
	}
	public String getWf_agencyUnitAddress() {
		return wf_agencyUnitAddress;
	}
	public void setWf_agencyUnitAddress(String wf_agencyUnitAddress) {
		this.wf_agencyUnitAddress = wf_agencyUnitAddress;
	}
	public String getWf_agencyUnit() {
		return wf_agencyUnit;
	}
	public void setWf_agencyUnit(String wf_agencyUnit) {
		this.wf_agencyUnit = wf_agencyUnit;
	}
	public String getWf_yxq() {
		return wf_yxq;
	}
	public void setWf_yxq(String wf_yxq) {
		this.wf_yxq = wf_yxq;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
	}
	public String getWf_judgementCode() {
		return wf_judgementCode;
	}
	public void setWf_judgementCode(String wf_judgementCode) {
		this.wf_judgementCode = wf_judgementCode;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_ipn() {
		return wf_ipn;
	}
	public void setWf_ipn(String wf_ipn) {
		this.wf_ipn = wf_ipn;
	}
	public String getWf_claim() {
		return wf_claim;
	}
	public void setWf_claim(String wf_claim) {
		this.wf_claim = wf_claim;
	}
	public Date getWf_authorizationPubDay() {
		return wf_authorizationPubDay;
	}
	public void setWf_authorizationPubDay(Date wf_authorizationPubDay) {
		this.wf_authorizationPubDay = wf_authorizationPubDay;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
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
	public Date getWf_pubDay() {
		return wf_pubDay;
	}
	public void setWf_pubDay(Date wf_pubDay) {
		this.wf_pubDay = wf_pubDay;
	}
	public Date getWf_openDay() {
		return wf_openDay;
	}
	public void setWf_openDay(Date wf_openDay) {
		this.wf_openDay = wf_openDay;
	}
	public String getWf_pubCode() {
		return wf_pubCode;
	}
	public void setWf_pubCode(String wf_pubCode) {
		this.wf_pubCode = wf_pubCode;
	}
	public String getWf_inventName() {
		return wf_inventName;
	}
	public void setWf_inventName(String wf_inventName) {
		this.wf_inventName = wf_inventName;
	}
	public String getWf_contactAddress() {
		return wf_contactAddress;
	}
	public void setWf_contactAddress(String wf_contactAddress) {
		this.wf_contactAddress = wf_contactAddress;
	}
	public String getWf_nationalpc() {
		return wf_nationalpc;
	}
	public void setWf_nationalpc(String wf_nationalpc) {
		this.wf_nationalpc = wf_nationalpc;
	}
	public String getWf_inventpeople() {
		return wf_inventpeople;
	}
	public void setWf_inventpeople(String wf_inventpeople) {
		this.wf_inventpeople = wf_inventpeople;
	}
	public String getWf_applypeople() {
		return wf_applypeople;
	}
	public void setWf_applypeople(String wf_applypeople) {
		this.wf_applypeople = wf_applypeople;
	}
	public Date getWf_applyDay() {
		return wf_applyDay;
	}
	public void setWf_applyDay(Date wf_applyDay) {
		this.wf_applyDay = wf_applyDay;
	}
	public String getWf_applyCode() {
		return wf_applyCode;
	}
	public void setWf_applyCode(String wf_applyCode) {
		this.wf_applyCode = wf_applyCode;
	}
	public String getWf_fl_zsdh() {
		return wf_fl_zsdh;
	}
	public void setWf_fl_zsdh(String wf_fl_zsdh) {
		this.wf_fl_zsdh = wf_fl_zsdh;
	}
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public Integer getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(Integer wf_lang) {
		this.wf_lang = wf_lang;
	}
	
}
