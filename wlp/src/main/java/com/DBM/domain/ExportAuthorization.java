package com.DBM.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="wf_export_authorization")
public class ExportAuthorization implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5840395610138315928L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int roleId;
	
	private int exptAuthId;
	
	
	public ExportAuthorization() {
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
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}


	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	/**
	 * @return the exptAuthId
	 */
	public int getExptAuthId() {
		return exptAuthId;
	}


	/**
	 * @param exptAuthId the exptAuthId to set
	 */
	public void setExptAuthId(int exptAuthId) {
		this.exptAuthId = exptAuthId;
	}
	
	
	
	
}
