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
 *<pre>数据库表字段描述</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_tableFields")
public class WF_B_tableFields {
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
	 *<pre>字段名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fieldName")
    private String wf_fieldName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>该字段是否显示</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ifShow")
    private String wf_ifShow;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>数据库表的id 对应wf_b_dataTableInfo表的主键f_id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tableId")
    private Integer wf_tableId;
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

	public String getWf_fieldName() {
		return wf_fieldName;
	}

	public void setWf_fieldName(String wf_fieldName) {
		this.wf_fieldName = wf_fieldName;
	}

	public String getWf_ifShow() {
		return wf_ifShow;
	}

	public void setWf_ifShow(String wf_ifShow) {
		this.wf_ifShow = wf_ifShow;
	}

	public Integer getWf_tableId() {
		return wf_tableId;
	}

	public void setWf_tableId(Integer wf_tableId) {
		this.wf_tableId = wf_tableId;
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
