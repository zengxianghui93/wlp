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
@Table(name = "tb_unesco_column")
public class ColumnInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "column_id")
	private String columid;
	@Column(name = "column_name")
	private String column_name;
	@Column(name = "ismenu")
	private int ismenu;




	public String getColumid() {
		return columid;
	}

	public void setColumid(String columid) {
		this.columid = columid;
	}
	
	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	
	public int getIsmenu() {
		return ismenu;
	}

	public void setIsmenu(int ismenu) {
		this.ismenu = ismenu;
	}


}
