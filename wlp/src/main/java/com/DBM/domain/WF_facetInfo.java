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
 *<pre>聚类信息表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_facetInfo")
public class WF_facetInfo {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类id 主键  自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>聚类名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_facetName")
    private String wf_facetName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>聚类词：WF_AUTHOR</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_facetWord")
    private String wf_facetWord;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>聚类词：WF_AUTHOR</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_facetDes")
    private String wf_facetDes;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>模块：知识中心</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ifShowM1",length=2)
    private String wf_ifShowM1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>模块：文献中心</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ifShowM2",length=2)
    private String wf_ifShowM2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>模块：MI情报</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ifShowM3",length=2)
    private String wf_ifShowM3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是不是MI系统</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ifMI",length=2)
    private String wf_ifMI;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>数据来源</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource_Index")
	private String wf_resource_Index;
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
	public String getWf_facetName() {
		return wf_facetName;
	}
	public void setWf_facetName(String wf_facetName) {
		this.wf_facetName = wf_facetName;
	}
	public String getWf_facetWord() {
		return wf_facetWord;
	}
	public void setWf_facetWord(String wf_facetWord) {
		this.wf_facetWord = wf_facetWord;
	}
	public String getWf_facetDes() {
		return wf_facetDes;
	}
	public void setWf_facetDes(String wf_facetDes) {
		this.wf_facetDes = wf_facetDes;
	}
	public String getWf_resource_Index() {
		return wf_resource_Index;
	}
	public void setWf_resource_Index(String wf_resource_Index) {
		this.wf_resource_Index = wf_resource_Index;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
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
	public String getWf_ifShowM1() {
		return wf_ifShowM1;
	}
	public void setWf_ifShowM1(String wf_ifShowM1) {
		this.wf_ifShowM1 = wf_ifShowM1;
	}
	public String getWf_ifShowM2() {
		return wf_ifShowM2;
	}
	public void setWf_ifShowM2(String wf_ifShowM2) {
		this.wf_ifShowM2 = wf_ifShowM2;
	}
	public String getWf_ifShowM3() {
		return wf_ifShowM3;
	}
	public void setWf_ifShowM3(String wf_ifShowM3) {
		this.wf_ifShowM3 = wf_ifShowM3;
	}
	public String getWf_ifMI() {
		return wf_ifMI;
	}
	public void setWf_ifMI(String wf_ifMI) {
		this.wf_ifMI = wf_ifMI;
	}
	
}
