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

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tb_log")
public class LogInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private int logId;
	
	@Column(name = "log_type")
	private int logType;
	
	@Column(name = "log_time")
	private Date logTime;
	
	@Column(name = "log_resId")
	private int logResId;
	
	@Column(name = "log_infoId")
	private int logInfoId;
	
	@Column(name = "log_input")
	private String  logInput;
	
	@Column(name = "log_output")
	private String  logOutput;
	
	@Column(name = "log_userId")
	private int  logUserId;
	
	@Column(name = "log_userName")
	private String  logUserName;
	
	@Column(name = "log_cate")
	private String  logCate;
	
	@Column(name = "log_DB")
	private int  logDB;
	
	@Column(name = "log_IP")
	private String  logIP;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public int getLogResId() {
		return logResId;
	}

	public void setLogResId(int logResId) {
		this.logResId = logResId;
	}

	public int getLogInfoId() {
		return logInfoId;
	}

	public void setLogInfoId(int logInfoId) {
		this.logInfoId = logInfoId;
	}

	public String getLogInput() {
		return logInput;
	}

	public void setLogInput(String logInput) {
		this.logInput = logInput;
	}

	public String getLogOutput() {
		return logOutput;
	}

	public void setLogOutput(String logOutput) {
		this.logOutput = logOutput;
	}

	public int getLogUserId() {
		return logUserId;
	}

	public void setLogUserId(int logUserId) {
		this.logUserId = logUserId;
	}

	public String getLogUserName() {
		return logUserName;
	}

	public void setLogUserName(String logUserName) {
		this.logUserName = logUserName;
	}

	public String getLogCate() {
		return logCate;
	}

	public void setLogCate(String logCate) {
		this.logCate = logCate;
	}

	public int getLogDB() {
		return logDB;
	}

	public void setLogDB(int logDB) {
		this.logDB = logDB;
	}

	public String getLogIP() {
		return logIP;
	}

	public void setLogIP(String logIP) {
		this.logIP = logIP;
	}
	
}
