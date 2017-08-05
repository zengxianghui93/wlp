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
@Table(name = "wf_b_sjIndex")
public class WF_B_sjIndex extends BaseDomain {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	
	/**
	 * 是否节点
	 */
	@Column(name = "isParent")
	private Integer isParent;
	
	//父节点id
	@Column(name = "pId")
	private Integer pId;
	
	//数据来源
	@Column(name = "datasource")
	private String datasource;
	
	//数据来源id
	@Column(name = "datasouceId")
	private String datasouceId;
	
	//单位
	@Column(name = "unit")
	private String unit;
	
	//数据频率
	@Column(name = "pl")
	private String pl;
	
	//数据范围开始  每次数据更新后，查询写入
	@Column(name = "start")
	private String start;
	
	//数据范围结束  每次数据更新后，查询写入
	@Column(name = "end")
	private String end;
	
	//指标说明
	@Column(name = "intro")
	private String intro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getDatasouceId() {
		return datasouceId;
	}

	public void setDatasouceId(String datasouceId) {
		this.datasouceId = datasouceId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	
}
