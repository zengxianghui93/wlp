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
 *<pre>MI情报</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_mi")
public class WF_B_MI {
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
	 *<pre>创建时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatTime")
    private Date wf_creatTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatuser")
    private String wf_creatuser;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_docChanNel")
    private String wf_docChanNel;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID")
    private String wf_ID;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword")
    private String wf_keyword;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_pubTime")
    private Date wf_pubTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_puburl")
    private String wf_puburl;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_docReltime")
    private Date wf_docReltime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_source")
    private String wf_source;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title")
    private String wf_title;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_docHTMLcon")
    private String wf_docHTMLcon;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_author",length=65535)
    private String wf_author;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract",length=65535)
    private String wf_abstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_newfl",length=65535)
    private String wf_newfl;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fl_zsdh",length=65535)
    private String wf_fl_zsdh;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tei_id")
    private Integer wf_tei_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title_cn")
    private String wf_title_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract_cn",length=65535)
    private String wf_abstract_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword_cn",length=65535)
    private String wf_keyword_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract_m",length=65535)
    private String wf_abstract_m;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword_m",length=65535)
    private String wf_keyword_m;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource")
    private String wf_resource;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year")
    private String wf_year;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_volume")
    private String wf_volume;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_issue")
    private String wf_issue;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_getAuthorInfo_no")
    private String wf_getAuthorInfo_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_IKC_no")
    private String wf_IKC_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_extractIndex_no")
    private String wf_extractIndex_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CNLibraryClassification")
    private String wf_CNLibraryClassification;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract_en")
    private String wf_abstract_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword_en",length=65535)
    private String wf_keyword_en;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title_en")
    private String wf_title_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_journalName")
    private String wf_journalName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnit",length=65535)
    private String wf_authorUnit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_page")
    private String wf_page;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_CN")
    private String wf_CN;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ISSN")
    private String wf_ISSN;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_note")
    private String wf_note;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_contactAddress_en")
    private String wf_contactAddress_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_txAddress_cn")
    private String wf_txAddress_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_zbAddress_en")
    private String wf_zbAddress_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_zbAddress_cn")
    private String wf_zbAddress_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_chargePerson_en")
    private String wf_chargePerson_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_chargePerson_cn")
    private String wf_chargePerson_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ownership_en")
    private String wf_ownership_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_syq_cn")
    private String wf_syq_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_brand_en")
    private String wf_brand_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_brand_cn")
    private String wf_brand_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authentication_en")
    private String wf_authentication_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authentication_cn")
    private String wf_authentication_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_overheadInfo_en")
    private String wf_overheadInfo_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_overheadInfo_cn")
    private String wf_overheadInfo_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_remouldAndBuild_en")
    private String wf_remouldAndBuild_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_remouldAndBuild_cn")
    private String wf_remouldAndBuild_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tradeAssociationMember_en")
    private String wf_tradeAssociationMember_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tradeAssociationMember_cn")
    private String wf_tradeAssociationMember_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fbzgs_en")
    private String wf_fbzgs_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fbzgs_cn")
    private String wf_fbzgs_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_firstLetter")
    private String wf_firstLetter;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_countryName_en")
    private String wf_countryName_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_countryName_cn")
    private String wf_countryName_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_showCNEN_no")
    private String wf_showCNEN_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_product_en")
    private String wf_product_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_product_cn")
    private String wf_product_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_mainJob_en")
    private String wf_mainJob_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_mainJob_cn")
    private String wf_mainJob_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_annualCapacity_en")
    private String wf_annualCapacity_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_annualCapacity_cn")
    private String wf_annualCapacity_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_capital_en")
    private String wf_capital_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_capital_cn")
    private String wf_capital_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_employeeNumber_en")
    private String wf_employeeNumber_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_employeeNumber_cn")
    private String wf_employeeNumber_cn;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_establishTime_en")
    private String wf_establishTime_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_establishTime_cn")
    private String wf_establishTime_cn;
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
	@Column(name = "wf_companyName_en")
    private String wf_companyName_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_companyName_cn")
    private String wf_companyName_cn;
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
	@Column(name = "wf_class1")
    private String wf_class1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_class2")
    private String wf_class2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_class3")
    private String wf_class3;
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
    private String wf_companyIntro;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_companyProperty")
    private String wf_companyProperty;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_businessNature")
    private String wf_businessNature;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_JointVenturePartners")
    private String wf_JointVenturePartners;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_corporateRankings")
    private String wf_corporateRankings;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_registeredCapital")
    private Double wf_registeredCapital;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fixedAssets")
    private Double wf_fixedAssets;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_annualSaleVolume")
    private Double wf_annualSaleVolume;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_totalProfit")
    private Double wf_totalProfit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_artisan")
    private Integer wf_artisan;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_rightImportExport")
    private String wf_rightImportExport;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_stockCode")
    private String wf_stockCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_brand")
    private String wf_brand;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_postCode")
    private String wf_postCode;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_productlineEquipment ")
    private String wf_productlineEquipment ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_developStrategy")
    private String wf_developStrategy;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_technology ")
    private String wf_technology ;
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
	@Column(name = "wf_standard")
    private String wf_standard;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_patent")
    private String wf_patent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_enterpriseDynamic ")
    private String wf_enterpriseDynamic ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang")
    private Integer wf_lang;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year_Index")
    private String wf_year_Index;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource_Index")
    private String wf_resource_Index;
	/**
	 *<br><b>字段描述:新闻图片</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_photo")
    private String wf_photo;
    /**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by1")
    private String wf_by1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by2")
    private String wf_by2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by3")
    private String wf_by3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by4")
    private String wf_by4;
	/**
	 *<br><b>字段描述:</b>
	 *<pre></pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by5")
    private String wf_by5;
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
	public String getWf_creatuser() {
		return wf_creatuser;
	}
	public void setWf_creatuser(String wf_creatuser) {
		this.wf_creatuser = wf_creatuser;
	}
	public String getWf_docChanNel() {
		return wf_docChanNel;
	}
	public void setWf_docChanNel(String wf_docChanNel) {
		this.wf_docChanNel = wf_docChanNel;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public String getWf_keyword() {
		return wf_keyword;
	}
	public void setWf_keyword(String wf_keyword) {
		this.wf_keyword = wf_keyword;
	}
	public Date getWf_pubTime() {
		return wf_pubTime;
	}
	public void setWf_pubTime(Date wf_pubTime) {
		this.wf_pubTime = wf_pubTime;
	}
	public String getWf_puburl() {
		return wf_puburl;
	}
	public void setWf_puburl(String wf_puburl) {
		this.wf_puburl = wf_puburl;
	}
	public Date getWf_docReltime() {
		return wf_docReltime;
	}
	public void setWf_docReltime(Date wf_docReltime) {
		this.wf_docReltime = wf_docReltime;
	}
	public String getWf_source() {
		return wf_source;
	}
	public void setWf_source(String wf_source) {
		this.wf_source = wf_source;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_docHTMLcon() {
		return wf_docHTMLcon;
	}
	public void setWf_docHTMLcon(String wf_docHTMLcon) {
		this.wf_docHTMLcon = wf_docHTMLcon;
	}
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
	}
	public String getWf_newfl() {
		return wf_newfl;
	}
	public void setWf_newfl(String wf_newfl) {
		this.wf_newfl = wf_newfl;
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
	public String getWf_title_cn() {
		return wf_title_cn;
	}
	public void setWf_title_cn(String wf_title_cn) {
		this.wf_title_cn = wf_title_cn;
	}
	public String getWf_abstract_cn() {
		return wf_abstract_cn;
	}
	public void setWf_abstract_cn(String wf_abstract_cn) {
		this.wf_abstract_cn = wf_abstract_cn;
	}
	public String getWf_keyword_cn() {
		return wf_keyword_cn;
	}
	public void setWf_keyword_cn(String wf_keyword_cn) {
		this.wf_keyword_cn = wf_keyword_cn;
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
	public String getWf_resource() {
		return wf_resource;
	}
	public void setWf_resource(String wf_resource) {
		this.wf_resource = wf_resource;
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
	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
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
	public void setWf_extractIndex_no(String wf_extractIndex_no) {
		this.wf_extractIndex_no = wf_extractIndex_no;
	}
	public String getWf_CNLibraryClassification() {
		return wf_CNLibraryClassification;
	}
	public void setWf_CNLibraryClassification(String wf_CNLibraryClassification) {
		this.wf_CNLibraryClassification = wf_CNLibraryClassification;
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
	public String getWf_title_en() {
		return wf_title_en;
	}
	public void setWf_title_en(String wf_title_en) {
		this.wf_title_en = wf_title_en;
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
	public String getWf_page() {
		return wf_page;
	}
	public void setWf_page(String wf_page) {
		this.wf_page = wf_page;
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
	public String getWf_contactAddress_en() {
		return wf_contactAddress_en;
	}
	public void setWf_contactAddress_en(String wf_contactAddress_en) {
		this.wf_contactAddress_en = wf_contactAddress_en;
	}
	public String getWf_txAddress_cn() {
		return wf_txAddress_cn;
	}
	public void setWf_txAddress_cn(String wf_txAddress_cn) {
		this.wf_txAddress_cn = wf_txAddress_cn;
	}
	public String getWf_zbAddress_en() {
		return wf_zbAddress_en;
	}
	public void setWf_zbAddress_en(String wf_zbAddress_en) {
		this.wf_zbAddress_en = wf_zbAddress_en;
	}
	public String getWf_zbAddress_cn() {
		return wf_zbAddress_cn;
	}
	public void setWf_zbAddress_cn(String wf_zbAddress_cn) {
		this.wf_zbAddress_cn = wf_zbAddress_cn;
	}
	public String getWf_chargePerson_en() {
		return wf_chargePerson_en;
	}
	public void setWf_chargePerson_en(String wf_chargePerson_en) {
		this.wf_chargePerson_en = wf_chargePerson_en;
	}
	public String getWf_chargePerson_cn() {
		return wf_chargePerson_cn;
	}
	public void setWf_chargePerson_cn(String wf_chargePerson_cn) {
		this.wf_chargePerson_cn = wf_chargePerson_cn;
	}
	public String getWf_ownership_en() {
		return wf_ownership_en;
	}
	public void setWf_ownership_en(String wf_ownership_en) {
		this.wf_ownership_en = wf_ownership_en;
	}
	public String getWf_syq_cn() {
		return wf_syq_cn;
	}
	public void setWf_syq_cn(String wf_syq_cn) {
		this.wf_syq_cn = wf_syq_cn;
	}
	public String getWf_brand_en() {
		return wf_brand_en;
	}
	public void setWf_brand_en(String wf_brand_en) {
		this.wf_brand_en = wf_brand_en;
	}
	public String getWf_brand_cn() {
		return wf_brand_cn;
	}
	public void setWf_brand_cn(String wf_brand_cn) {
		this.wf_brand_cn = wf_brand_cn;
	}
	public String getWf_authentication_en() {
		return wf_authentication_en;
	}
	public void setWf_authentication_en(String wf_authentication_en) {
		this.wf_authentication_en = wf_authentication_en;
	}
	public String getWf_authentication_cn() {
		return wf_authentication_cn;
	}
	public void setWf_authentication_cn(String wf_authentication_cn) {
		this.wf_authentication_cn = wf_authentication_cn;
	}
	public String getWf_overheadInfo_en() {
		return wf_overheadInfo_en;
	}
	public void setWf_overheadInfo_en(String wf_overheadInfo_en) {
		this.wf_overheadInfo_en = wf_overheadInfo_en;
	}
	public String getWf_overheadInfo_cn() {
		return wf_overheadInfo_cn;
	}
	public void setWf_overheadInfo_cn(String wf_overheadInfo_cn) {
		this.wf_overheadInfo_cn = wf_overheadInfo_cn;
	}
	public String getWf_remouldAndBuild_en() {
		return wf_remouldAndBuild_en;
	}
	public void setWf_remouldAndBuild_en(String wf_remouldAndBuild_en) {
		this.wf_remouldAndBuild_en = wf_remouldAndBuild_en;
	}
	public String getWf_remouldAndBuild_cn() {
		return wf_remouldAndBuild_cn;
	}
	public void setWf_remouldAndBuild_cn(String wf_remouldAndBuild_cn) {
		this.wf_remouldAndBuild_cn = wf_remouldAndBuild_cn;
	}
	public String getWf_tradeAssociationMember_en() {
		return wf_tradeAssociationMember_en;
	}
	public void setWf_tradeAssociationMember_en(String wf_tradeAssociationMember_en) {
		this.wf_tradeAssociationMember_en = wf_tradeAssociationMember_en;
	}
	public String getWf_tradeAssociationMember_cn() {
		return wf_tradeAssociationMember_cn;
	}
	public void setWf_tradeAssociationMember_cn(String wf_tradeAssociationMember_cn) {
		this.wf_tradeAssociationMember_cn = wf_tradeAssociationMember_cn;
	}
	public String getWf_fbzgs_en() {
		return wf_fbzgs_en;
	}
	public void setWf_fbzgs_en(String wf_fbzgs_en) {
		this.wf_fbzgs_en = wf_fbzgs_en;
	}
	public String getWf_fbzgs_cn() {
		return wf_fbzgs_cn;
	}
	public void setWf_fbzgs_cn(String wf_fbzgs_cn) {
		this.wf_fbzgs_cn = wf_fbzgs_cn;
	}
	public String getWf_firstLetter() {
		return wf_firstLetter;
	}
	public void setWf_firstLetter(String wf_firstLetter) {
		this.wf_firstLetter = wf_firstLetter;
	}
	public String getWf_countryName_en() {
		return wf_countryName_en;
	}
	public void setWf_countryName_en(String wf_countryName_en) {
		this.wf_countryName_en = wf_countryName_en;
	}
	public String getWf_countryName_cn() {
		return wf_countryName_cn;
	}
	public void setWf_countryName_cn(String wf_countryName_cn) {
		this.wf_countryName_cn = wf_countryName_cn;
	}
	public String getWf_showCNEN_no() {
		return wf_showCNEN_no;
	}
	public void setWf_showCNEN_no(String wf_showCNEN_no) {
		this.wf_showCNEN_no = wf_showCNEN_no;
	}
	public String getWf_product_en() {
		return wf_product_en;
	}
	public void setWf_product_en(String wf_product_en) {
		this.wf_product_en = wf_product_en;
	}
	public String getWf_product_cn() {
		return wf_product_cn;
	}
	public void setWf_product_cn(String wf_product_cn) {
		this.wf_product_cn = wf_product_cn;
	}
	public String getWf_mainJob_en() {
		return wf_mainJob_en;
	}
	public void setWf_mainJob_en(String wf_mainJob_en) {
		this.wf_mainJob_en = wf_mainJob_en;
	}
	public String getWf_mainJob_cn() {
		return wf_mainJob_cn;
	}
	public void setWf_mainJob_cn(String wf_mainJob_cn) {
		this.wf_mainJob_cn = wf_mainJob_cn;
	}
	public String getWf_annualCapacity_en() {
		return wf_annualCapacity_en;
	}
	public void setWf_annualCapacity_en(String wf_annualCapacity_en) {
		this.wf_annualCapacity_en = wf_annualCapacity_en;
	}
	public String getWf_annualCapacity_cn() {
		return wf_annualCapacity_cn;
	}
	public void setWf_annualCapacity_cn(String wf_annualCapacity_cn) {
		this.wf_annualCapacity_cn = wf_annualCapacity_cn;
	}
	public String getWf_capital_en() {
		return wf_capital_en;
	}
	public void setWf_capital_en(String wf_capital_en) {
		this.wf_capital_en = wf_capital_en;
	}
	public String getWf_capital_cn() {
		return wf_capital_cn;
	}
	public void setWf_capital_cn(String wf_capital_cn) {
		this.wf_capital_cn = wf_capital_cn;
	}
	public String getWf_employeeNumber_en() {
		return wf_employeeNumber_en;
	}
	public void setWf_employeeNumber_en(String wf_employeeNumber_en) {
		this.wf_employeeNumber_en = wf_employeeNumber_en;
	}
	public String getWf_employeeNumber_cn() {
		return wf_employeeNumber_cn;
	}
	public void setWf_employeeNumber_cn(String wf_employeeNumber_cn) {
		this.wf_employeeNumber_cn = wf_employeeNumber_cn;
	}
	public String getWf_establishTime_en() {
		return wf_establishTime_en;
	}
	public void setWf_establishTime_en(String wf_establishTime_en) {
		this.wf_establishTime_en = wf_establishTime_en;
	}
	public String getWf_establishTime_cn() {
		return wf_establishTime_cn;
	}
	public void setWf_establishTime_cn(String wf_establishTime_cn) {
		this.wf_establishTime_cn = wf_establishTime_cn;
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
	public String getWf_companyName_en() {
		return wf_companyName_en;
	}
	public void setWf_companyName_en(String wf_companyName_en) {
		this.wf_companyName_en = wf_companyName_en;
	}
	public String getWf_companyName_cn() {
		return wf_companyName_cn;
	}
	public void setWf_companyName_cn(String wf_companyName_cn) {
		this.wf_companyName_cn = wf_companyName_cn;
	}
	public String getWf_institutionType() {
		return wf_institutionType;
	}
	public void setWf_institutionType(String wf_institutionType) {
		this.wf_institutionType = wf_institutionType;
	}
	public String getWf_class1() {
		return wf_class1;
	}
	public void setWf_class1(String wf_class1) {
		this.wf_class1 = wf_class1;
	}
	public String getWf_class2() {
		return wf_class2;
	}
	public void setWf_class2(String wf_class2) {
		this.wf_class2 = wf_class2;
	}
	public String getWf_class3() {
		return wf_class3;
	}
	public void setWf_class3(String wf_class3) {
		this.wf_class3 = wf_class3;
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
	public String getWf_businessNature() {
		return wf_businessNature;
	}
	public void setWf_businessNature(String wf_businessNature) {
		this.wf_businessNature = wf_businessNature;
	}
	public String getWf_JointVenturePartners() {
		return wf_JointVenturePartners;
	}
	public void setWf_JointVenturePartners(String wf_JointVenturePartners) {
		this.wf_JointVenturePartners = wf_JointVenturePartners;
	}
	public String getWf_corporateRankings() {
		return wf_corporateRankings;
	}
	public void setWf_corporateRankings(String wf_corporateRankings) {
		this.wf_corporateRankings = wf_corporateRankings;
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
	public String getWf_productlineEquipment() {
		return wf_productlineEquipment;
	}
	public void setWf_productlineEquipment(String wf_productlineEquipment) {
		this.wf_productlineEquipment = wf_productlineEquipment;
	}
	public Double getWf_registeredCapital() {
		return wf_registeredCapital;
	}
	public void setWf_registeredCapital(Double wf_registeredCapital) {
		this.wf_registeredCapital = wf_registeredCapital;
	}
	public Double getWf_fixedAssets() {
		return wf_fixedAssets;
	}
	public void setWf_fixedAssets(Double wf_fixedAssets) {
		this.wf_fixedAssets = wf_fixedAssets;
	}
	public Double getWf_annualSaleVolume() {
		return wf_annualSaleVolume;
	}
	public void setWf_annualSaleVolume(Double wf_annualSaleVolume) {
		this.wf_annualSaleVolume = wf_annualSaleVolume;
	}
	public Double getWf_totalProfit() {
		return wf_totalProfit;
	}
	public void setWf_totalProfit(Double wf_totalProfit) {
		this.wf_totalProfit = wf_totalProfit;
	}
	public Integer getWf_artisan() {
		return wf_artisan;
	}
	public void setWf_artisan(Integer wf_artisan) {
		this.wf_artisan = wf_artisan;
	}
	public String getWf_developStrategy() {
		return wf_developStrategy;
	}
	public void setWf_developStrategy(String wf_developStrategy) {
		this.wf_developStrategy = wf_developStrategy;
	}
	public String getWf_technology() {
		return wf_technology;
	}
	public void setWf_technology(String wf_technology) {
		this.wf_technology = wf_technology;
	}
	public String getWf_product() {
		return wf_product;
	}
	public void setWf_product(String wf_product) {
		this.wf_product = wf_product;
	}
	public String getWf_standard() {
		return wf_standard;
	}
	public void setWf_standard(String wf_standard) {
		this.wf_standard = wf_standard;
	}
	public String getWf_patent() {
		return wf_patent;
	}
	public void setWf_patent(String wf_patent) {
		this.wf_patent = wf_patent;
	}
	public String getWf_enterpriseDynamic() {
		return wf_enterpriseDynamic;
	}
	public void setWf_enterpriseDynamic(String wf_enterpriseDynamic) {
		this.wf_enterpriseDynamic = wf_enterpriseDynamic;
	}
	public Integer getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(Integer wf_lang) {
		this.wf_lang = wf_lang;
	}
	public String getWf_year_Index() {
		return wf_year_Index;
	}
	public void setWf_year_Index(String wf_year_Index) {
		this.wf_year_Index = wf_year_Index;
	}
	public String getWf_resource_Index() {
		return wf_resource_Index;
	}
	public void setWf_resource_Index(String wf_resource_Index) {
		this.wf_resource_Index = wf_resource_Index;
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
	public String getWf_photo() {
		return wf_photo;
	}
	public void setWf_photo(String wf_photo) {
		this.wf_photo = wf_photo;
	}
	
}
