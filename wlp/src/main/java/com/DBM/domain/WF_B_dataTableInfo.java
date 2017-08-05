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
 *<br><b>类描述:</b>
 *<pre>数据库表信息描述</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_dataTableInfo")
public class WF_B_dataTableInfo {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>表名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableName")
    private String wf_tableName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>表名称中文描述</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableNameDes")
    private String wf_tableNameDes;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>页面显示信息</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableNameShow")
    private String wf_tableNameShow;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>字段显示设置，每个库在知识中心显示什么字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tablefieldShow")
    private String wf_tablefieldShow;
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

	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getWf_tableName() {
		return wf_tableName;
	}

	public void setWf_tableName(String wf_tableName) {
		this.wf_tableName = wf_tableName;
	}

	public String getWf_tableNameDes() {
		return wf_tableNameDes;
	}

	public void setWf_tableNameDes(String wf_tableNameDes) {
		this.wf_tableNameDes = wf_tableNameDes;
	}

	public String getWf_tableNameShow() {
		return wf_tableNameShow;
	}

	public void setWf_tableNameShow(String wf_tableNameShow) {
		this.wf_tableNameShow = wf_tableNameShow;
	}

	public String getWf_tablefieldShow() {
		return wf_tablefieldShow;
	}

	public void setWf_tablefieldShow(String wf_tablefieldShow) {
		this.wf_tablefieldShow = wf_tablefieldShow;
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
