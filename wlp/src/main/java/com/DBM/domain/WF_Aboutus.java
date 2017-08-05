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
@Table(name = "wf_aboutus")
public class WF_Aboutus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "wf_about")
	private String wf_about;
	
	@Column(name = "wf_by")
	private String wf_by;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWf_about() {
		return wf_about;
	}

	public void setWf_about(String wf_about) {
		this.wf_about = wf_about;
	}

	public String getWf_by() {
		return wf_by;
	}

	public void setWf_by(String wf_by) {
		this.wf_by = wf_by;
	}
}
