package com.DBM.domain;

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
 *<br><b>类描述:</b>
 *<pre>专家团队表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_specialistteamstatus")
public class WF_B_specialistteamstatus {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>id主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>专家团队</pre>
	 *@see
	 *@since
	 */
	@Column(name = "specialistteam")
    private String specialistteam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecialistteam() {
		return specialistteam;
	}
	public void setSpecialistteam(String specialistteam) {
		this.specialistteam = specialistteam;
	}
}
