package com.DBM.domain;

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
 *<pre>机构库</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_mechanism")
public class WF_B_mechanism {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_product")
    private String wf_product;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_mainJob")
    private String wf_mainJob;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_employeeNum")
    private String wf_employeeNum;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_establishTime")
    private String wf_establishTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_chargePerson")
    private String wf_chargePerson;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_URL")
    private String wf_URL;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_Email")
    private String wf_Email;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tel")
    private String wf_tel;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fax")
    private String wf_fax;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_address")
    private String wf_address;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_companyName")
    private String wf_companyName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_institutionType")
    private String wf_institutionType;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_formerName")
    private String wf_formerName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_industryCategory")
    private String wf_industryCategory;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_companyIntro")
    private String wf_companyIntro ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_companyProperty")
    private String wf_companyProperty ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_partner ")
    private String wf_partner ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_corporateRankings")
    private String wf_corporateRankings ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_registeredCapital")
    private String wf_registeredCapital ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fixedAssets")
    private String wf_fixedAssets ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_annualSaleVolume")
    private String wf_annualSaleVolume ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_totalProfit")
    private String wf_totalProfit ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_artisan")
    private String wf_artisan ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_rightImportExport")
    private String wf_rightImportExport ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_stockCode")
    private String wf_stockCode ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_brand")
    private String wf_brand ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_postCode")
    private String wf_postCode ;
    /**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_belongAddress")
    private String wf_belongAddress ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_logo")
    private String wf_logo ;
    /**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatTime")
    private String wf_creatTime ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang")
    private String wf_lang ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource_index")
    private String wf_resource_index ;
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_product() {
		return wf_product;
	}
	public void setWf_product(String wf_product) {
		this.wf_product = wf_product;
	}
	public String getWf_mainJob() {
		return wf_mainJob;
	}
	public void setWf_mainJob(String wf_mainJob) {
		this.wf_mainJob = wf_mainJob;
	}
	public String getWf_employeeNum() {
		return wf_employeeNum;
	}
	public void setWf_employeeNum(String wf_employeeNum) {
		this.wf_employeeNum = wf_employeeNum;
	}
	public String getWf_establishTime() {
		return wf_establishTime;
	}
	public void setWf_establishTime(String wf_establishTime) {
		this.wf_establishTime = wf_establishTime;
	}
	public String getWf_chargePerson() {
		return wf_chargePerson;
	}
	public void setWf_chargePerson(String wf_chargePerson) {
		this.wf_chargePerson = wf_chargePerson;
	}
	public String getWf_URL() {
		return wf_URL;
	}
	public void setWf_URL(String wf_URL) {
		this.wf_URL = wf_URL;
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
	public String getWf_fax() {
		return wf_fax;
	}
	public void setWf_fax(String wf_fax) {
		this.wf_fax = wf_fax;
	}
	public String getWf_address() {
		return wf_address;
	}
	public void setWf_address(String wf_address) {
		this.wf_address = wf_address;
	}
	public String getWf_companyName() {
		return wf_companyName;
	}
	public void setWf_companyName(String wf_companyName) {
		this.wf_companyName = wf_companyName;
	}
	public String getWf_institutionType() {
		return wf_institutionType;
	}
	public void setWf_institutionType(String wf_institutionType) {
		this.wf_institutionType = wf_institutionType;
	}
	public String getWf_formerName() {
		return wf_formerName;
	}
	public void setWf_formerName(String wf_formerName) {
		this.wf_formerName = wf_formerName;
	}
	public String getWf_industryCategory() {
		return wf_industryCategory;
	}
	public void setWf_industryCategory(String wf_industryCategory) {
		this.wf_industryCategory = wf_industryCategory;
	}
	public String getWf_companyIntro() {
		return wf_companyIntro;
	}
	public void setWf_companyIntro(String wf_companyIntro) {
		this.wf_companyIntro = wf_companyIntro;
	}
	public String getWf_companyProperty() {
		return wf_companyProperty;
	}
	public void setWf_companyProperty(String wf_companyProperty) {
		this.wf_companyProperty = wf_companyProperty;
	}
	public String getWf_partner() {
		return wf_partner;
	}
	public void setWf_partner(String wf_partner) {
		this.wf_partner = wf_partner;
	}
	public String getWf_corporateRankings() {
		return wf_corporateRankings;
	}
	public void setWf_corporateRankings(String wf_corporateRankings) {
		this.wf_corporateRankings = wf_corporateRankings;
	}
	public String getWf_registeredCapital() {
		return wf_registeredCapital;
	}
	public void setWf_registeredCapital(String wf_registeredCapital) {
		this.wf_registeredCapital = wf_registeredCapital;
	}
	public String getWf_fixedAssets() {
		return wf_fixedAssets;
	}
	public void setWf_fixedAssets(String wf_fixedAssets) {
		this.wf_fixedAssets = wf_fixedAssets;
	}
	public String getWf_annualSaleVolume() {
		return wf_annualSaleVolume;
	}
	public void setWf_annualSaleVolume(String wf_annualSaleVolume) {
		this.wf_annualSaleVolume = wf_annualSaleVolume;
	}
	public String getWf_totalProfit() {
		return wf_totalProfit;
	}
	public void setWf_totalProfit(String wf_totalProfit) {
		this.wf_totalProfit = wf_totalProfit;
	}
	public String getWf_artisan() {
		return wf_artisan;
	}
	public void setWf_artisan(String wf_artisan) {
		this.wf_artisan = wf_artisan;
	}
	public String getWf_rightImportExport() {
		return wf_rightImportExport;
	}
	public void setWf_rightImportExport(String wf_rightImportExport) {
		this.wf_rightImportExport = wf_rightImportExport;
	}
	public String getWf_stockCode() {
		return wf_stockCode;
	}
	public void setWf_stockCode(String wf_stockCode) {
		this.wf_stockCode = wf_stockCode;
	}
	public String getWf_brand() {
		return wf_brand;
	}
	public void setWf_brand(String wf_brand) {
		this.wf_brand = wf_brand;
	}
	public String getWf_postCode() {
		return wf_postCode;
	}
	public void setWf_postCode(String wf_postCode) {
		this.wf_postCode = wf_postCode;
	}
	public String getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(String wf_lang) {
		this.wf_lang = wf_lang;
	}
	public String getWf_resource_index() {
		return wf_resource_index;
	}
	public void setWf_resource_index(String wf_resource_index) {
		this.wf_resource_index = wf_resource_index;
	}
	public String getWf_belongAddress() {
		return wf_belongAddress;
	}
	public void setWf_belongAddress(String wf_belongAddress) {
		this.wf_belongAddress = wf_belongAddress;
	}
	public String getWf_logo() {
		return wf_logo;
	}
	public void setWf_logo(String wf_logo) {
		this.wf_logo = wf_logo;
	}
	public String getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(String wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	
}
