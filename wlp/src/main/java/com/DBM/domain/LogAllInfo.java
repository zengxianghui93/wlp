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
 *20170224
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_log_info")
public class LogAllInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int logId;
	
	/**
	 * 日志类型
	 */
	@Column(name = "log_type")
	private Integer logType;
	
	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private Integer userId;
	
	/**
	 * 用户名称
	 */
	@Column(name = "user_name")
	private String userName;
	
	/**
	 * 用户ip地址
	 */
	@Column(name = "user_ip")
	private String userIp;
	
	/**
	 * 日志记录时间
	 */
	@Column(name = "log_time")
	private Date logTime;
	
	/**
	 * 用户检索内容
	 */
	@Column(name = "input")
	private String input;
	
	/**
	 * 检索结果记录数
	 */
	@Column(name = "output")
	private Integer output;
	
	/**
	 * 访问资源
	 */
	@Column(name = "log_res")
	private String logRes;
	
	/**
	 * 文章id
	 */
	@Column(name = "log_resId")
	private String logResId;
	
	/**
	 * 文章标题
	 */
	@Column(name = "log_resTitle")
	private String logResTitle;
	
	/**
	 * 日志类型名称（不要写入日志表）
	 */
	private String logTypeName;
	/**
	 * 资源库名称（不要写入日志表）
	 */
	private String logResName;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
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

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Integer getOutput() {
		return output;
	}

	public void setOutput(Integer output) {
		this.output = output;
	}

	public String getLogRes() {
		return logRes;
	}

	public void setLogRes(String logRes) {
		this.logRes = logRes;
	}

	public String getLogResId() {
		return logResId;
	}

	public void setLogResId(String logResId) {
		this.logResId = logResId;
	}

	public String getLogResTitle() {
		return logResTitle;
	}

	public void setLogResTitle(String logResTitle) {
		this.logResTitle = logResTitle;
	}

	public String getLogTypeName() {
		return logTypeName;
	}

	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}

	public String getLogResName() {
		return logResName;
	}

	public void setLogResName(String logResName) {
		this.logResName = logResName;
	}
	
	
}
