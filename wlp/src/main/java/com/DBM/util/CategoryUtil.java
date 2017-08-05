package com.DBM.util;

import java.io.Serializable;
import java.util.List;

import com.DBM.domain.WF_B_MIcategory;
import com.DBM.domain.WF_B_category;

/**
 * 
 *<br><b>类描述:</b>
 *<pre>知识导航分类操作工具类</pre>
 *
 */
public class CategoryUtil implements Serializable{

	private static final long serialVersionUID = 1L;

	private  List<WF_B_category> twoCateList = null;
	
	private  List<WF_B_category> threeCateList = null;
	
	private Integer f_id;
	
	private String wf_categoryName;
	
	private String wf_categoryCode;
	
	private String wf_searchStrategy;
	
	private String wf_ifShow;
	
	private String wf_deleted;
	
	private String wf_image;
	
	private String wf_by1;
	
	private String wf_by2;
	
	private String wf_by3;
	
	private String wf_by4;
	
	private String wf_by5;


	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getWf_categoryName() {
		return wf_categoryName;
	}

	public void setWf_categoryName(String wf_categoryName) {
		this.wf_categoryName = wf_categoryName;
	}

	public String getWf_searchStrategy() {
		return wf_searchStrategy;
	}

	public void setWf_searchStrategy(String wf_searchStrategy) {
		this.wf_searchStrategy = wf_searchStrategy;
	}

	public List<WF_B_category> getTwoCateList() {
		return twoCateList;
	}

	public void setTwoCateList(List<WF_B_category> twoCateList) {
		this.twoCateList = twoCateList;
	}

	public List<WF_B_category> getThreeCateList() {
		return threeCateList;
	}

	public void setThreeCateList(List<WF_B_category> threeCateList) {
		this.threeCateList = threeCateList;
	}

	public String getWf_ifShow() {
		return wf_ifShow;
	}

	public void setWf_ifShow(String wf_ifShow) {
		this.wf_ifShow = wf_ifShow;
	}

	public String getWf_deleted() {
		return wf_deleted;
	}

	public void setWf_deleted(String wf_deleted) {
		this.wf_deleted = wf_deleted;
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

	public String getWf_categoryCode() {
		return wf_categoryCode;
	}

	public void setWf_categoryCode(String wf_categoryCode) {
		this.wf_categoryCode = wf_categoryCode;
	}

	public String getWf_image() {
		return wf_image;
	}

	public void setWf_image(String wf_image) {
		this.wf_image = wf_image;
	}
	
	
}
