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
 *<pre>刊名维护</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_journalMaintain")
public class WF_B_journalMaintain {
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>刊名维护表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>曾用名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_oldName",length=65535)
    private String wf_oldName;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中文期刊id 外键</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_cj_id")
    private Integer wf_cj_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>馆藏文摘id 外键</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_la_id")
    private Integer wf_la_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>更新时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_modifytime")
    private Date wf_modifytime;
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

	public String getWf_oldName() {
		return wf_oldName;
	}

	public void setWf_oldName(String wf_oldName) {
		this.wf_oldName = wf_oldName;
	}

	public Integer getWf_cj_id() {
		return wf_cj_id;
	}

	public void setWf_cj_id(Integer wf_cj_id) {
		this.wf_cj_id = wf_cj_id;
	}

	public Integer getWf_la_id() {
		return wf_la_id;
	}

	public void setWf_la_id(Integer wf_la_id) {
		this.wf_la_id = wf_la_id;
	}

	public Date getWf_modifytime() {
		return wf_modifytime;
	}

	public void setWf_modifytime(Date wf_modifytime) {
		this.wf_modifytime = wf_modifytime;
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
