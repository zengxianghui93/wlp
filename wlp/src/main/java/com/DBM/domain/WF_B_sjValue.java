package com.DBM.domain;





import java.sql.Date;

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
@Table(name = "wf_b_sjValue")
public class WF_B_sjValue extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sj_id")
	private Integer sj_id;
	
	@Column(name = "sj_date")
	private Date sj_date;
	
	
	@Column(name = "sj_value")
	private String sj_value;
	
	@Column(name = "index_id")
	private Integer index_id;

	public Integer getSj_id() {
		return sj_id;
	}

	public void setSj_id(Integer sj_id) {
		this.sj_id = sj_id;
	}

	public Date getSj_date() {
		return sj_date;
	}

	public void setSj_date(Date sj_date) {
		this.sj_date = sj_date;
	}

	public String getSj_value() {
		return sj_value;
	}

	public void setSj_value(String sj_value) {
		this.sj_value = sj_value;
	}

	public Integer getIndex_id() {
		return index_id;
	}

	public void setIndex_id(Integer index_id) {
		this.index_id = index_id;
	}
	
	
	
}
