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
 *<pre>产品新闻表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_newInfo")
public class WF_B_newInfo {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>新闻表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>新闻标题</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_newtitle")
    private String wf_newtitle;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>新闻内容</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_newcontent")
    private String wf_newcontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>新闻发布时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_newDate")
    private Date wf_newDate;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>新闻产地</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_province")
    private String wf_province;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>年、用于索引聚类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year_Index",length=50)
	private String wf_year_Index;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>值为数据库对应的id值、用于来源聚类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource_Index")
	private Integer wf_resource_Index;
	
	public String getWf_year_Index() {
		return wf_year_Index;
	}
	public void setWf_year_Index(String wf_year_Index) {
		this.wf_year_Index = wf_year_Index;
	}
	public Integer getWf_resource_Index() {
		return wf_resource_Index;
	}
	public void setWf_resource_Index(Integer wf_resource_Index) {
		this.wf_resource_Index = wf_resource_Index;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_newtitle() {
		return wf_newtitle;
	}
	public void setWf_newtitle(String wf_newtitle) {
		this.wf_newtitle = wf_newtitle;
	}
	public String getWf_newcontent() {
		return wf_newcontent;
	}
	public void setWf_newcontent(String wf_newcontent) {
		this.wf_newcontent = wf_newcontent;
	}
	public Date getWf_newDate() {
		return wf_newDate;
	}
	public void setWf_newDate(Date wf_newDate) {
		this.wf_newDate = wf_newDate;
	}
	public String getWf_province() {
		return wf_province;
	}
	public void setWf_province(String wf_province) {
		this.wf_province = wf_province;
	}
	
}
