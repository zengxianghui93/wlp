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
 * 资源库数据审核编辑任务
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tb_task_data")
public class TaskData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//任务类型
	@Column(name = "task_type")
	private String taskType;
	
	//任务名称
	@Column(name = "task_name")
	private String taskName;
	
	//任务描述
	@Column(name = "task_desc")
	private String taskDesc;
	
	//任务处理人id
	@Column(name = "task_userId")
	private Integer taskUserId;
	//任务处理人名称
	@Column(name = "task_userName")
	private String taskUserName;
	
	//文章开始id
	@Column(name = "res_begin")
	private String resBegin;
	
	//文章结束id
	@Column(name = "res_end")
	private String resEnd;
	
	//任务处理开始时间
	@Column(name = "hand_begin_time")
	private Date handBeginTime;

	//任务处理结束时间
	@Column(name = "hand_end_time")
	private Date handEndTime;

	//任务库
	@Column(name = "task_table_name")
	private String taskTableName;
	
	//任务处理结束时间
	@Column(name = "creat_time")
	private Date creatTime;
	
	//方式
	@Column(name = "task_way")
	private String taskWay;
	
	//采集类型
	@Column(name = "task_isGather")
	private String taskIsGather;
	
	//字段名称
	@Column(name = "task_resFldName")
	private String taskResFldName;
	//字段值
	@Column(name = "task_resKeyword")
	private String taskResKeyword;
	
	//数量
	@Column(name = "task_resNums")
	private Integer taskResNums;
	
	//所有文章id
	@Column(name = "task_resIds")
	private String taskResIds;
	
	public String getTaskResIds() {
		return taskResIds;
	}

	public void setTaskResIds(String taskResIds) {
		this.taskResIds = taskResIds;
	}

	public Integer getTaskResNums() {
		return taskResNums;
	}

	public void setTaskResNums(Integer taskResNums) {
		this.taskResNums = taskResNums;
	}

	public String getTaskWay() {
		return taskWay;
	}

	public void setTaskWay(String taskWay) {
		this.taskWay = taskWay;
	}

	public String getTaskIsGather() {
		return taskIsGather;
	}

	public void setTaskIsGather(String taskIsGather) {
		this.taskIsGather = taskIsGather;
	}

	public String getTaskResFldName() {
		return taskResFldName;
	}

	public void setTaskResFldName(String taskResFldName) {
		this.taskResFldName = taskResFldName;
	}

	public String getTaskResKeyword() {
		return taskResKeyword;
	}

	public void setTaskResKeyword(String taskResKeyword) {
		this.taskResKeyword = taskResKeyword;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getTaskUserName() {
		return taskUserName;
	}

	public void setTaskUserName(String taskUserName) {
		this.taskUserName = taskUserName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Integer getTaskUserId() {
		return taskUserId;
	}

	public void setTaskUserId(Integer taskUserId) {
		this.taskUserId = taskUserId;
	}

	public String getResBegin() {
		return resBegin;
	}

	public void setResBegin(String resBegin) {
		this.resBegin = resBegin;
	}

	public String getResEnd() {
		return resEnd;
	}

	public void setResEnd(String resEnd) {
		this.resEnd = resEnd;
	}

	public Date getHandBeginTime() {
		return handBeginTime;
	}

	public void setHandBeginTime(Date handBeginTime) {
		this.handBeginTime = handBeginTime;
	}

	public Date getHandEndTime() {
		return handEndTime;
	}

	public void setHandEndTime(Date handEndTime) {
		this.handEndTime = handEndTime;
	}

	public String getTaskTableName() {
		return taskTableName;
	}

	public void setTaskTableName(String taskTableName) {
		this.taskTableName = taskTableName;
	}
	
}
