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
@Table(name = "tb_operation")
public class OperationInfo {
	
	@Id
	@Column(name = "op_id")
	private String opId;
	
	@Column(name = "op_name")
	private String opName;
	
	@Column(name = "op_desc")
	private String opDesc;
	
	@Column(name = "op_url")
	private String opUrl;
	
	@Column(name = "op_enable")
	private int opEnable;
	
	@Column(name = "op_type")
	private int opType;

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}

	public String getOpUrl() {
		return opUrl;
	}

	public void setOpUrl(String opUrl) {
		this.opUrl = opUrl;
	}

	public int getOpEnable() {
		return opEnable;
	}

	public void setOpEnable(int opEnable) {
		this.opEnable = opEnable;
	}
	
	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}
	
}
