package com.DBM.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tb_res_fld")
public class ResFldInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fldId")
	private int fldId;

	@Column(name = "fldName")
	private String fldName;

	@Column(name = "resId")
	private int resId;

	@Column(name = "fldType")
	private String fldType;

	@Column(name = "fldLength")
	private int fldLength;

	@Column(name = "fldIsNull")
	private int fldIsNull;

	@Column(name = "fldIsKey")
	private int fldIsKey;

	@Column(name = "fldDesc")
	private String fldDesc;

	@Column(name = "fldSearch")
	private int fldSearch;

	@Column(name = "fldList")
	private int fldList;

	@Column(name = "fldDetail")
	private int fldDetail;

	@Column(name = "fldInputType")
	private String fldInputType;

	// html标签
	private String fldHtmlTag;
	// 对应标签类型
	private String fldTagType;
	// html标签的类型补充
	private String tagAdditional;
	// 标签默认值
	private String tagdefaultValue;
	//置顶显示
	private long top;
	
	private int fldIsEnter;

	public int getFldIsEnter() {
		return fldIsEnter;
	}

	public void setFldIsEnter(int fldIsEnter) {
		this.fldIsEnter = fldIsEnter;
	}

	public String getFldHtmlTag() {
		return fldHtmlTag;
	}

	public void setFldHtmlTag(String fldHtmlTag) {
		this.fldHtmlTag = fldHtmlTag;
	}

	public String getFldTagType() {
		return fldTagType;
	}

	public void setFldTagType(String fldTagType) {
		this.fldTagType = fldTagType;
	}

	public String getTagAdditional() {
		return tagAdditional;
	}

	public void setTagAdditional(String tagAdditional) {
		this.tagAdditional = tagAdditional;
	}

	public String getTagdefaultValue() {
		return tagdefaultValue;
	}

	public void setTagdefaultValue(String tagdefaultValue) {
		this.tagdefaultValue = tagdefaultValue;
	}

	public int getFldId() {
		return fldId;
	}

	public void setFldId(int fldId) {
		this.fldId = fldId;
	}

	public String getFldName() {
		return fldName;
	}

	public void setFldName(String fldName) {
		this.fldName = fldName;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getFldType() {
		return fldType;
	}

	public void setFldType(String fldType) {
		this.fldType = fldType;
	}

	public int getFldLength() {
		return fldLength;
	}

	public void setFldLength(int fldLength) {
		this.fldLength = fldLength;
	}

	public int getFldIsNull() {
		return fldIsNull;
	}

	public void setFldIsNull(int fldIsNull) {
		this.fldIsNull = fldIsNull;
	}

	public int getFldIsKey() {
		return fldIsKey;
	}

	public void setFldIsKey(int fldIsKey) {
		this.fldIsKey = fldIsKey;
	}

	public String getFldDesc() {
		return fldDesc;
	}

	public void setFldDesc(String fldDesc) {
		this.fldDesc = fldDesc;
	}

	public int getFldSearch() {
		return fldSearch;
	}

	public void setFldSearch(int fldSearch) {
		this.fldSearch = fldSearch;
	}

	public int getFldList() {
		return fldList;
	}

	public void setFldList(int fldList) {
		this.fldList = fldList;
	}

	public int getFldDetail() {
		return fldDetail;
	}

	public void setFldDetail(int fldDetail) {
		this.fldDetail = fldDetail;
	}

	public String getFldInputType() {
		return fldInputType;
	}

	public void setFldInputType(String fldInputType) {
		this.fldInputType = fldInputType;
	}

	public long getTop() {
		return top;
	}

	public void setTop(long top) {
		this.top = top;
	}

}
