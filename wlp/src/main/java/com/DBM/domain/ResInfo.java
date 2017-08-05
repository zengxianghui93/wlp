package com.DBM.domain;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tb_res")
public class ResInfo extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resId")
	private int resId;
	
	@Column(name = "resName")
	private String resName;
	
	@Column(name = "resTblName")
	private String resTblName;
	
	@Column(name = "resDesc")
	private String resDesc;
	
	/*@Column(name = "resFlow")
	private int resFlow;*/
	
	@Column(name = "resFlow")
	private Integer resFlow;
	
	@Column(name = "resDate")
	private Date resDate;
	
	@Column(name = "resType")
	private String resType;
	
	@Basic(fetch=FetchType.LAZY)
	@Lob
	@Column(name = "resTemplate",length=16777216)
	private String resTemplate;
	
	@Column(name = "showTemp",length=16777216)
	private String showTemp;
	
	@Column(name = "resAccount")
	private Integer resAccount;
	
	@Column(name = "resUpdateTime")
	private Date resUpdateTime;
	
	@Column(name = "resBalance")
	private Double resBalance;
	
	@Column(name = "resImage")
	private String resImage;
	
	@Column(name = "indexName")
	private String indexName;
	
	@Column(name = "indexIfSearch_lc")
	private String indexIfSearch_lc;
	
	@Column(name = "indexIfSearch_kc")
	private String indexIfSearch_kc;
	
	public Double getResBalance() {
		return resBalance;
	}

	public void setResBalance(Double resBalance) {
		this.resBalance = resBalance;
	}

	public Integer getResAccount() {
		return resAccount;
	}

	public void setResAccount(Integer resAccount) {
		this.resAccount = resAccount;
	}

	public Date getResUpdateTime() {
		return resUpdateTime;
	}

	public void setResUpdateTime(Date resUpdateTime) {
		this.resUpdateTime = resUpdateTime;
	}

	public String getShowTemp() {
		return showTemp;
	}

	public void setShowTemp(String showTemp) {
		this.showTemp = showTemp;
	}

	public String getResTemplate() {
		return resTemplate;
	}

	public void setResTemplate(String resTemplate) {
		this.resTemplate = resTemplate;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResTblName() {
		return resTblName;
	}

	public void setResTblName(String resTblName) {
		this.resTblName = resTblName;
	}

	public String getResDesc() {
		return resDesc;
	}

	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public Integer getResFlow() {
		return resFlow;
	}

	public void setResFlow(Integer resFlow) {
		this.resFlow = resFlow;
	}

	public String getResImage() {
		return resImage;
	}

	public void setResImage(String resImage) {
		this.resImage = resImage;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexIfSearch_lc() {
		return indexIfSearch_lc;
	}

	public void setIndexIfSearch_lc(String indexIfSearch_lc) {
		this.indexIfSearch_lc = indexIfSearch_lc;
	}

	public String getIndexIfSearch_kc() {
		return indexIfSearch_kc;
	}

	public void setIndexIfSearch_kc(String indexIfSearch_kc) {
		this.indexIfSearch_kc = indexIfSearch_kc;
	}

	
}
