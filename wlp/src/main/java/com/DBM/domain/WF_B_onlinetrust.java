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
 *<pre>科技查新</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_onlinetrust")
public class WF_B_onlinetrust {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>查新表id  主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>项目名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_projectname")
    private String wf_projectname;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>项目名称英文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_projectnameEnglish")
    private String wf_projectnameEnglish;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>机构名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_institution")
    private String wf_institution;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>负责人</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_head")
    private String wf_head ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>通信地址</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_address")
    private String wf_address ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>邮政编码</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_zipcode")
    private String wf_zipcode ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>联系人</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_contact")
    private String wf_contact ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电话</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_phone")
    private String wf_phone ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>传真</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fax")
    private String wf_fax ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电子邮箱</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_email")
    private String wf_email ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>查新范围</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_searchscope")
    private String wf_searchscope ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>范围</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_scopeof")
    private String wf_scopeof ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>技术要点</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_technicalpoints")
    private String wf_technicalpoints ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>其他</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_other")
    private String wf_other ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "userid")
    private int userid ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "username")
    private String username ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_kjcxstatus")
    private int wf_kjcxstatus ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "createTime")
    private Date createTime ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "pubFlag")
    private int pubFlag ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "categoryId")
    private String categoryId ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>用户姓名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "editTime")
    private Date editTime ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>查新技术要点</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_chaxindian")
    private String wf_chaxindian ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>委托人资料</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_data")
    private String wf_data ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>委托人其他资料</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_weituoother")
    private String wf_weituoother ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>密级</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_secret")
    private String wf_secret ;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>份数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_share")
    private String wf_share ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>发表论文</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fabiao")
    private String wf_fabiao ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>参考文献</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_cankao")
    private String wf_cankao ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>中英文检索词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_jiansuo")
    private String wf_jiansuo ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备注</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_beizhu")
    private String wf_beizhu ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>要求完成日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_datetmie")
    private String wf_datetmie ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>付费金额</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_money")
    private String wf_money ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>实际完成日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_datetmies")
    private String wf_datetmies ;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>付费日期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_newdate")
    private String wf_newdate ;
	
	public String getWf_chaxindian() {
		return wf_chaxindian;
	}
	public void setWf_chaxindian(String wf_chaxindian) {
		this.wf_chaxindian = wf_chaxindian;
	}
	public String getWf_data() {
		return wf_data;
	}
	public void setWf_data(String wf_data) {
		this.wf_data = wf_data;
	}
	public String getWf_weituoother() {
		return wf_weituoother;
	}
	public void setWf_weituoother(String wf_weituoother) {
		this.wf_weituoother = wf_weituoother;
	}
	public String getWf_secret() {
		return wf_secret;
	}
	public void setWf_secret(String wf_secret) {
		this.wf_secret = wf_secret;
	}
	public String getWf_share() {
		return wf_share;
	}
	public void setWf_share(String wf_share) {
		this.wf_share = wf_share;
	}
	public String getWf_fabiao() {
		return wf_fabiao;
	}
	public void setWf_fabiao(String wf_fabiao) {
		this.wf_fabiao = wf_fabiao;
	}
	public String getWf_cankao() {
		return wf_cankao;
	}
	public void setWf_cankao(String wf_cankao) {
		this.wf_cankao = wf_cankao;
	}
	public String getWf_jiansuo() {
		return wf_jiansuo;
	}
	public void setWf_jiansuo(String wf_jiansuo) {
		this.wf_jiansuo = wf_jiansuo;
	}
	public String getWf_beizhu() {
		return wf_beizhu;
	}
	public void setWf_beizhu(String wf_beizhu) {
		this.wf_beizhu = wf_beizhu;
	}
	public String getWf_datetmie() {
		return wf_datetmie;
	}
	public void setWf_datetmie(String wf_datetmie) {
		this.wf_datetmie = wf_datetmie;
	}
	public String getWf_money() {
		return wf_money;
	}
	public void setWf_money(String wf_money) {
		this.wf_money = wf_money;
	}
	public String getWf_datetmies() {
		return wf_datetmies;
	}
	public void setWf_datetmies(String wf_datetmies) {
		this.wf_datetmies = wf_datetmies;
	}
	public String getWf_newdate() {
		return wf_newdate;
	}
	public void setWf_newdate(String wf_newdate) {
		this.wf_newdate = wf_newdate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getPubFlag() {
		return pubFlag;
	}
	public void setPubFlag(int pubFlag) {
		this.pubFlag = pubFlag;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	public int getWf_kjcxstatus() {
		return wf_kjcxstatus;
	}
	public void setWf_kjcxstatus(int wf_kjcxstatus) {
		this.wf_kjcxstatus = wf_kjcxstatus;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWf_other() {
		return wf_other;
	}
	public void setWf_other(String wf_other) {
		this.wf_other = wf_other;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWf_projectname() {
		return wf_projectname;
	}
	public void setWf_projectname(String wf_projectname) {
		this.wf_projectname = wf_projectname;
	}
	public String getWf_projectnameEnglish() {
		return wf_projectnameEnglish;
	}
	public void setWf_projectnameEnglish(String wf_projectnameEnglish) {
		this.wf_projectnameEnglish = wf_projectnameEnglish;
	}
	public String getWf_institution() {
		return wf_institution;
	}
	public void setWf_institution(String wf_institution) {
		this.wf_institution = wf_institution;
	}
	public String getWf_head() {
		return wf_head;
	}
	public void setWf_head(String wf_head) {
		this.wf_head = wf_head;
	}
	public String getWf_address() {
		return wf_address;
	}
	public void setWf_address(String wf_address) {
		this.wf_address = wf_address;
	}
	public String getWf_zipcode() {
		return wf_zipcode;
	}
	public void setWf_zipcode(String wf_zipcode) {
		this.wf_zipcode = wf_zipcode;
	}
	public String getWf_contact() {
		return wf_contact;
	}
	public void setWf_contact(String wf_contact) {
		this.wf_contact = wf_contact;
	}
	public String getWf_phone() {
		return wf_phone;
	}
	public void setWf_phone(String wf_phone) {
		this.wf_phone = wf_phone;
	}
	public String getWf_fax() {
		return wf_fax;
	}
	public void setWf_fax(String wf_fax) {
		this.wf_fax = wf_fax;
	}
	public String getWf_email() {
		return wf_email;
	}
	public void setWf_email(String wf_email) {
		this.wf_email = wf_email;
	}
	public String getWf_searchscope() {
		return wf_searchscope;
	}
	public void setWf_searchscope(String wf_searchscope) {
		this.wf_searchscope = wf_searchscope;
	}
	public String getWf_scopeof() {
		return wf_scopeof;
	}
	public void setWf_scopeof(String wf_scopeof) {
		this.wf_scopeof = wf_scopeof;
	}
	public String getWf_technicalpoints() {
		return wf_technicalpoints;
	}
	public void setWf_technicalpoints(String wf_technicalpoints) {
		this.wf_technicalpoints = wf_technicalpoints;
	}
	
}
