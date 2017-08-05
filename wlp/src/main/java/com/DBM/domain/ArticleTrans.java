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
 * @author maxiaocheng
 *20170315
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_article_trans")
public class ArticleTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_phone")
	private String userPhone;
	
	/**
	 * 资源库id
	 */
	@Column(name = "article_resId")
	private Integer articleResId;
	
	/**
	 * 文章id
	 */
	@Column(name = "article_id")
	private Integer articlId;
	
	@Column(name = "article_tittle")
	private String articlTittle;
	
	@Column(name = "article_journal")
	private String articlJournal;
	
	@Column(name = "article_abstract")
	private String articlAbstract;
	
	@Column(name = "article_author")
	private String articlAuthor;

	@Column(name = "article_balance")
	private Double articlBalance;
	
	@Column(name = "sub_time")
	private Date subTime;
	

	@Column(name = "hand_time")
	private Date handTime;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_path")
	private String filePath;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getSubTime() {
		return subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	public Date getHandTime() {
		return handTime;
	}

	public void setHandTime(Date handTime) {
		this.handTime = handTime;
	}
	
	public String getArticlJournal() {
		return articlJournal;
	}

	public void setArticlJournal(String articlJournal) {
		this.articlJournal = articlJournal;
	}

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getArticleResId() {
		return articleResId;
	}

	public void setArticleResId(Integer articleResId) {
		this.articleResId = articleResId;
	}

	public Integer getArticlId() {
		return articlId;
	}

	public void setArticlId(Integer articlId) {
		this.articlId = articlId;
	}

	public String getArticlTittle() {
		return articlTittle;
	}

	public void setArticlTittle(String articlTittle) {
		this.articlTittle = articlTittle;
	}

	public String getArticlAbstract() {
		return articlAbstract;
	}

	public void setArticlAbstract(String articlAbstract) {
		this.articlAbstract = articlAbstract;
	}

	public String getArticlAuthor() {
		return articlAuthor;
	}

	public void setArticlAuthor(String articlAuthor) {
		this.articlAuthor = articlAuthor;
	}

	public Double getArticlBalance() {
		return articlBalance;
	}

	public void setArticlBalance(Double articlBalance) {
		this.articlBalance = articlBalance;
	}
}
