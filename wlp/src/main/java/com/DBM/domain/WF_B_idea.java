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
 *<pre>意见建议表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_idea")
public class WF_B_idea {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>意见id主键  自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>意见内容</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ideaContent")
    private String wf_ideaContent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户ID</pre>
	 *@see
	 *@since
	 */
	@Column(name = "userId")
    private int userId;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "username")
    private String username;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>意见类型</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ideaType")
    private int wf_ideaType;

	/**
	 *<br><b>字段描述:</b>
	 *<pre>意见时间</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_ideaDate")
    private Date wf_ideaDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by1")
	private int wf_by1;
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

	public String getWf_ideaContent() {
		return wf_ideaContent;
	}

	public void setWf_ideaContent(String wf_ideaContent) {
		this.wf_ideaContent = wf_ideaContent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWf_ideaType() {
		return wf_ideaType;
	}

	public void setWf_ideaType(int wf_ideaType) {
		this.wf_ideaType = wf_ideaType;
	}

	public Date getWf_ideaDate() {
		return wf_ideaDate;
	}

	public void setWf_ideaDate(Date wf_ideaDate) {
		this.wf_ideaDate = wf_ideaDate;
	}

	public int getWf_by1() {
		return wf_by1;
	}

	public void setWf_by1(int wf_by1) {
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
