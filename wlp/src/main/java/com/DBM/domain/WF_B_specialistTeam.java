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
 *<pre>专家团队表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_specialistTeam")
public class WF_B_specialistTeam {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>id主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_name")
    private String wf_name;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>性别</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_sex")
    private String wf_sex;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>单位</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_unit")
    private String wf_unit;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>专家照片</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_photo",length=65535)
    private String wf_photo;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>介绍，简介</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract",length=65535)
    private String wf_abstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>职称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by1")
    private String wf_by1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>专家团队</pre>
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
	 *<pre>介绍，简介</pre>
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
	/**
	 *<br><b>字段描述:</b>
	 *<pre>排序id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "p_id")
    private Integer p_id;
	
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
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
	public String getWf_name() {
		return wf_name;
	}
	public void setWf_name(String wf_name) {
		this.wf_name = wf_name;
	}
	public String getWf_by5() {
		return wf_by5;
	}
	public void setWf_by5(String wf_by5) {
		this.wf_by5 = wf_by5;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_sex() {
		return wf_sex;
	}
	public void setWf_sex(String wf_sex) {
		this.wf_sex = wf_sex;
	}
	public String getWf_unit() {
		return wf_unit;
	}
	public void setWf_unit(String wf_unit) {
		this.wf_unit = wf_unit;
	}
	public String getWf_photo() {
		return wf_photo;
	}
	public void setWf_photo(String wf_photo) {
		this.wf_photo = wf_photo;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
	}
	
}
