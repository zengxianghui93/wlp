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
 * @author maxiaocheng
 * 2017-5-26
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "zhuantimo")
public class ZhuanTiMo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zhuanTiId")
	private Integer zhuantiId;
	
	@Column(name = "knowCenterC")
	private String knowCenterC;
	
	@Column(name = "dataCenterC")
	private Integer dataCenterC;
	
	@Column(name = "productCenterC")
	private Integer productCenterC;
	
	@Column(name = "otherShow")
	private Integer otherShow;
	
	@Column(name = "otherCon")
	private String otherCon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKnowCenterC() {
		return knowCenterC;
	}

	public void setKnowCenterC(String knowCenterC) {
		this.knowCenterC = knowCenterC;
	}

	public Integer getDataCenterC() {
		return dataCenterC;
	}

	public void setDataCenterC(Integer dataCenterC) {
		this.dataCenterC = dataCenterC;
	}

	public Integer getProductCenterC() {
		return productCenterC;
	}

	public void setProductCenterC(Integer productCenterC) {
		this.productCenterC = productCenterC;
	}

	public Integer getZhuantiId() {
		return zhuantiId;
	}

	public void setZhuantiId(Integer zhuantiId) {
		this.zhuantiId = zhuantiId;
	}

	public Integer getOtherShow() {
		return otherShow;
	}

	public void setOtherShow(Integer otherShow) {
		this.otherShow = otherShow;
	}

	public String getOtherCon() {
		return otherCon;
	}

	public void setOtherCon(String otherCon) {
		this.otherCon = otherCon;
	}
	
}
