package com.DBM.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "context")
	private String context;
	
	@Column(name = "count_time")
	private String countTime;
	
	@Column(name = "count_language")
	private String countLanguage;
	
	@Column(name = "count_database")
	private String countDatabase;
	
	@Column(name = "count_author")
	private String countAuthor;
	
	@Column(name = "count_org")
	private String countOrg;
	
	@Column(name = "count_serial")
	private String countSerial;
	
	@Column(name = "num_limit")
	private Integer numLimit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getCountTime() {
		return countTime;
	}
	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}
	public String getCountLanguage() {
		return countLanguage;
	}
	public void setCountLanguage(String countLanguage) {
		this.countLanguage = countLanguage;
	}
	public String getCountDatabase() {
		return countDatabase;
	}
	public void setCountDatabase(String countDatabase) {
		this.countDatabase = countDatabase;
	}
	public String getCountAuthor() {
		return countAuthor;
	}
	public void setCountAuthor(String countAuthor) {
		this.countAuthor = countAuthor;
	}
	public String getCountOrg() {
		return countOrg;
	}
	public void setCountOrg(String countOrg) {
		this.countOrg = countOrg;
	}
	public String getCountSerial() {
		return countSerial;
	}
	public void setCountSerial(String countSerial) {
		this.countSerial = countSerial;
	}
	public Integer getNumLimit() {
		return numLimit;
	}
	public void setNumLimit(Integer numLimit) {
		this.numLimit = numLimit;
	}
}
