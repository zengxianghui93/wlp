package com.DBM.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 知识发布，支持用户上传文献等资源
 * @author longbiao
 *
 */
@Entity
@Table(name="wf_sharedoc")
public class ShareDoc {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//文献上传人
	private int userID;
	//文献上传时间
	private Date createTime;
	//文献标题
	private String title;
	//作者
	private String author;
	//摘要
	private String abstracts;
	//关键字
	private String keyword;
	//出版社
	private String publisher;
	//刊名
	private String journalName;
	//出版年
	private String pubYear;
	//卷
	private String volume;
	//版次
	private String issue;
	//语种
	private String docLan;
	//类型
	private String docType;
	//描述
	@Lob
	@Basic(fetch=FetchType.EAGER)
	@Column(name="description")
	private String description;
	//是否共享
	private boolean share;
	//是否审核
	private boolean audit;
	//审核日期
	private Date auditTime;
	//审核人
	private int auditPersonId;
	//附件
	private String attachment;
	
	public ShareDoc() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the share
	 */
	public boolean isShare() {
		return share;
	}

	/**
	 * @param share the share to set
	 */
	public void setShare(boolean share) {
		this.share = share;
	}

	/**
	 * @return the audit
	 */
	public boolean isAudit() {
		return audit;
	}

	/**
	 * @param audit the audit to set
	 */
	public void setAudit(boolean audit) {
		this.audit = audit;
	}

	/**
	 * @return the auditTime
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @param auditTime the auditTime to set
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getPubYear() {
		return pubYear;
	}

	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDocLan() {
		return docLan;
	}

	public void setDocLan(String docLan) {
		this.docLan = docLan;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public int getAuditPersonId() {
		return auditPersonId;
	}

	public void setAuditPersonId(int auditPersonId) {
		this.auditPersonId = auditPersonId;
	}
	
	
	
}

