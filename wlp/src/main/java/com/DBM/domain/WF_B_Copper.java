package com.DBM.domain;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 *<br><b>类描述:</b>
 *<pre>铜</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_copper")
public class WF_B_Copper {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>铜id  主键 自增长 </pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原有id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_ID",length=50)
    private String wf_ID;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>创建时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creatTime")
    private Date wf_creatTime;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>冶炼厂名称</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_E2")
    private String wf_E2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>运营者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E3")
    private String wf_E3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E4")
    private String wf_E4;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>地区</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E5")
    private String wf_E5;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营起始时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E6")
    private Date wf_E6;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营结束时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E7")
    private Date wf_E7;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>利用率</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E8")
    private Double wf_E8;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年生产能力</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E9")
    private Date wf_E9;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>E9-E11年</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year",length=50)
    private String wf_year;
		
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年年产量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E10")
    private String wf_E10;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年财务状况</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_E11")
    private String wf_E11;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>简介</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E12",length=65535)
    private String wf_E12;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键问题</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E13")
    private String wf_E13;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>明细图</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E14")
    private String wf_E14;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>参与方</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E15")
    private String wf_E15;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>流程图</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E16")
    private String wf_E16;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备料车间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E17")
    private String wf_E17;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>冶炼过程</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E18")
    private String wf_E18;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>辅助设备</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E19")
    private String wf_E19;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>产品产量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E20")
    private String wf_E20;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>产品配置</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E21")
    private String wf_E21;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>成本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E22")
    private String wf_E22;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>时间轴</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E23")
    private String wf_E23;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经济假设</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_E24")
    private String wf_E24;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>冶炼厂名称</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_F2")
    private String wf_F2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>运营者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F3")
    private String wf_F3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F4")
    private String wf_F4;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>地区</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F5")
    private String wf_F5;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营起始时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F6")
    private String wf_F6;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营结束时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F7")
    private String wf_F7;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>利用率</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F8")
    private String wf_F8;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年生产能力</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F9")
    private Date wf_F9;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年年产量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F10")
    private String wf_F10;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年财务状况</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_F11")
    private String wf_F11;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>简介</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F12")
    private String wf_F12;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键问题</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F13")
    private String wf_F13;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>明细图</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F14")
    private String wf_F14;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>参与方</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F15")
    private String wf_F15;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>流程图</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F16")
    private String wf_F16;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备料车间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F17")
    private String wf_F17;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>冶炼过程</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F18")
    private String wf_F18;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>辅助设备</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F19")
    private String wf_F19;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>产品产量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F20")
    private String wf_F20;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>产品配置</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F21")
    private String wf_F21;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>成本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F22")
    private String wf_F22;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>时间轴</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F23")
    private String wf_F23;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经济假设</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_F24")
    private String wf_F24;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>冶炼厂名称</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_G2")
    private String wf_G2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>运营者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G3")
    private String wf_G3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营状态</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G4")
    private String wf_G4;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>地区</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G5")
    private String wf_G5;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营起始时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G6")
    private String wf_G6;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经营结束时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G7")
    private String wf_G7;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>利用率</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G8")
    private String wf_G8;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年生产能力</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G9")
    private Date wf_G9;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年年产量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G10")
    private String wf_G10;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>2015年财务状况</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_G11")
    private String wf_G11;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>简介</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G12")
    private String wf_G12;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键问题</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G13")
    private String wf_G13;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>明细图</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G14")
    private String wf_G14;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>参与方</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G15")
    private String wf_G15;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>流程图</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G16")
    private String wf_G16;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备料车间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G17")
    private String wf_G17;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>冶炼过程</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G18")
    private String wf_G18;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>辅助设备</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G19")
    private String wf_G19;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>产品产量</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G20")
    private String wf_G20;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>产品配置</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G21")
    private String wf_G21;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>成本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G22")
    private String wf_G22;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>时间轴</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G23")
    private String wf_G23;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>经济假设</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_G24")
    private String wf_G24;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>技术经济指标id  外键</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_tei_id")
    private Integer wf_tei_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by1")
	private String wf_by1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by2")
	private String wf_by2;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by3")
	private String wf_by3;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by4")
	private String wf_by4;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>备用字段</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by5")
	private String wf_by5;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>语种、值为语种信息表的id值</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_lang")
    private Integer wf_lang;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>年、用于索引聚类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year_Index",length=50)
	private String wf_year_Index;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>值为数据库对应的id值、用于来源聚类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_resource_Index")
	private Integer wf_resource_Index;
	
	public String getWf_year_Index() {
		return wf_year_Index;
	}
	public void setWf_year_Index(String wf_year_Index) {
		this.wf_year_Index = wf_year_Index;
	}
	public Integer getWf_resource_Index() {
		return wf_resource_Index;
	}
	public void setWf_resource_Index(Integer wf_resource_Index) {
		this.wf_resource_Index = wf_resource_Index;
	}
	public Integer getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(Integer wf_lang) {
		this.wf_lang = wf_lang;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_F2() {
		return wf_F2;
	}
	public void setWf_F2(String wf_F2) {
		this.wf_F2 = wf_F2;
	}
	public String getWf_F3() {
		return wf_F3;
	}
	public void setWf_F3(String wf_F3) {
		this.wf_F3 = wf_F3;
	}
	public String getWf_F4() {
		return wf_F4;
	}
	public void setWf_F4(String wf_F4) {
		this.wf_F4 = wf_F4;
	}
	public String getWf_F5() {
		return wf_F5;
	}
	public void setWf_F5(String wf_F5) {
		this.wf_F5 = wf_F5;
	}
	public String getWf_F6() {
		return wf_F6;
	}
	public void setWf_F6(String wf_F6) {
		this.wf_F6 = wf_F6;
	}
	public String getWf_F7() {
		return wf_F7;
	}
	public void setWf_F7(String wf_F7) {
		this.wf_F7 = wf_F7;
	}
	public String getWf_F8() {
		return wf_F8;
	}
	public void setWf_F8(String wf_F8) {
		this.wf_F8 = wf_F8;
	}
	public Date getWf_F9() {
		return wf_F9;
	}
	public void setWf_F9(Date wf_F9) {
		this.wf_F9 = wf_F9;
	}
	public String getWf_F10() {
		return wf_F10;
	}
	public void setWf_F10(String wf_F10) {
		this.wf_F10 = wf_F10;
	}
	public String getWf_F11() {
		return wf_F11;
	}
	public void setWf_F11(String wf_F11) {
		this.wf_F11 = wf_F11;
	}
	public String getWf_F12() {
		return wf_F12;
	}
	public void setWf_F12(String wf_F12) {
		this.wf_F12 = wf_F12;
	}
	public String getWf_F13() {
		return wf_F13;
	}
	public void setWf_F13(String wf_F13) {
		this.wf_F13 = wf_F13;
	}
	public String getWf_F14() {
		return wf_F14;
	}
	public void setWf_F14(String wf_F14) {
		this.wf_F14 = wf_F14;
	}
	public String getWf_F15() {
		return wf_F15;
	}
	public void setWf_F15(String wf_F15) {
		this.wf_F15 = wf_F15;
	}
	public String getWf_F16() {
		return wf_F16;
	}
	public void setWf_F16(String wf_F16) {
		this.wf_F16 = wf_F16;
	}
	public String getWf_F17() {
		return wf_F17;
	}
	public void setWf_F17(String wf_F17) {
		this.wf_F17 = wf_F17;
	}
	public String getWf_F18() {
		return wf_F18;
	}
	public void setWf_F18(String wf_F18) {
		this.wf_F18 = wf_F18;
	}
	public String getWf_F19() {
		return wf_F19;
	}
	public void setWf_F19(String wf_F19) {
		this.wf_F19 = wf_F19;
	}
	public String getWf_F20() {
		return wf_F20;
	}
	public void setWf_F20(String wf_F20) {
		this.wf_F20 = wf_F20;
	}
	public String getWf_F21() {
		return wf_F21;
	}
	public void setWf_F21(String wf_F21) {
		this.wf_F21 = wf_F21;
	}
	public String getWf_F22() {
		return wf_F22;
	}
	public void setWf_F22(String wf_F22) {
		this.wf_F22 = wf_F22;
	}
	public String getWf_F23() {
		return wf_F23;
	}
	public void setWf_F23(String wf_F23) {
		this.wf_F23 = wf_F23;
	}
	public String getWf_F24() {
		return wf_F24;
	}
	public void setWf_F24(String wf_F24) {
		this.wf_F24 = wf_F24;
	}
	public String getWf_G2() {
		return wf_G2;
	}
	public void setWf_G2(String wf_G2) {
		this.wf_G2 = wf_G2;
	}
	public String getWf_G3() {
		return wf_G3;
	}
	public void setWf_G3(String wf_G3) {
		this.wf_G3 = wf_G3;
	}
	public String getWf_G4() {
		return wf_G4;
	}
	public void setWf_G4(String wf_G4) {
		this.wf_G4 = wf_G4;
	}
	public String getWf_G5() {
		return wf_G5;
	}
	public void setWf_G5(String wf_G5) {
		this.wf_G5 = wf_G5;
	}
	public String getWf_G6() {
		return wf_G6;
	}
	public void setWf_G6(String wf_G6) {
		this.wf_G6 = wf_G6;
	}
	public String getWf_G7() {
		return wf_G7;
	}
	public void setWf_G7(String wf_G7) {
		this.wf_G7 = wf_G7;
	}
	public String getWf_G8() {
		return wf_G8;
	}
	public void setWf_G8(String wf_G8) {
		this.wf_G8 = wf_G8;
	}
	public Date getWf_G9() {
		return wf_G9;
	}
	public void setWf_G9(Date wf_G9) {
		this.wf_G9 = wf_G9;
	}
	public String getWf_G10() {
		return wf_G10;
	}
	public void setWf_G10(String wf_G10) {
		this.wf_G10 = wf_G10;
	}
	public String getWf_G11() {
		return wf_G11;
	}
	public void setWf_G11(String wf_G11) {
		this.wf_G11 = wf_G11;
	}
	public String getWf_G12() {
		return wf_G12;
	}
	public void setWf_G12(String wf_G12) {
		this.wf_G12 = wf_G12;
	}
	public String getWf_G13() {
		return wf_G13;
	}
	public void setWf_G13(String wf_G13) {
		this.wf_G13 = wf_G13;
	}
	public String getWf_G14() {
		return wf_G14;
	}
	public void setWf_G14(String wf_G14) {
		this.wf_G14 = wf_G14;
	}
	public String getWf_G15() {
		return wf_G15;
	}
	public void setWf_G15(String wf_G15) {
		this.wf_G15 = wf_G15;
	}
	public String getWf_G16() {
		return wf_G16;
	}
	public void setWf_G16(String wf_G16) {
		this.wf_G16 = wf_G16;
	}
	public String getWf_G17() {
		return wf_G17;
	}
	public void setWf_G17(String wf_G17) {
		this.wf_G17 = wf_G17;
	}
	public String getWf_G18() {
		return wf_G18;
	}
	public void setWf_G18(String wf_G18) {
		this.wf_G18 = wf_G18;
	}
	public String getWf_G19() {
		return wf_G19;
	}
	public void setWf_G19(String wf_G19) {
		this.wf_G19 = wf_G19;
	}
	public String getWf_G20() {
		return wf_G20;
	}
	public void setWf_G20(String wf_G20) {
		this.wf_G20 = wf_G20;
	}
	public String getWf_G21() {
		return wf_G21;
	}
	public void setWf_G21(String wf_G21) {
		this.wf_G21 = wf_G21;
	}
	public String getWf_G22() {
		return wf_G22;
	}
	public void setWf_G22(String wf_G22) {
		this.wf_G22 = wf_G22;
	}
	public String getWf_G23() {
		return wf_G23;
	}
	public void setWf_G23(String wf_G23) {
		this.wf_G23 = wf_G23;
	}
	public String getWf_G24() {
		return wf_G24;
	}
	public void setWf_G24(String wf_G24) {
		this.wf_G24 = wf_G24;
	}
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
	}
	public String getWf_by1() {
		return wf_by1;
	}
	public void setWf_by1(String wf_by1) {
		this.wf_by1 = wf_by1;
	}
	public String getWf_by2() {
		return wf_by2;
	}
	public void setWf_by2(String wf_by2) {
		this.wf_by2 = wf_by2;
	}
	public String getWf_by3() {
		return wf_by3;
	}
	public void setWf_by3(String wf_by3) {
		this.wf_by3 = wf_by3;
	}
	public String getWf_by4() {
		return wf_by4;
	}
	public void setWf_by4(String wf_by4) {
		this.wf_by4 = wf_by4;
	}
	public String getWf_by5() {
		return wf_by5;
	}
	public void setWf_by5(String wf_by5) {
		this.wf_by5 = wf_by5;
	}
	public String getWf_ID() {
		return wf_ID;
	}
	public void setWf_ID(String wf_ID) {
		this.wf_ID = wf_ID;
	}
	public Date getWf_creatTime() {
		return wf_creatTime;
	}
	public void setWf_creatTime(Date wf_creatTime) {
		this.wf_creatTime = wf_creatTime;
	}
	public String getWf_E2() {
		return wf_E2;
	}
	public void setWf_E2(String wf_E2) {
		this.wf_E2 = wf_E2;
	}
	public String getWf_E3() {
		return wf_E3;
	}
	public void setWf_E3(String wf_E3) {
		this.wf_E3 = wf_E3;
	}
	public String getWf_E4() {
		return wf_E4;
	}
	public void setWf_E4(String wf_E4) {
		this.wf_E4 = wf_E4;
	}
	public String getWf_E5() {
		return wf_E5;
	}
	public void setWf_E5(String wf_E5) {
		this.wf_E5 = wf_E5;
	}
	public Date getWf_E6() {
		return wf_E6;
	}
	public void setWf_E6(Date wf_E6) {
		this.wf_E6 = wf_E6;
	}
	public Date getWf_E7() {
		return wf_E7;
	}
	public void setWf_E7(Date wf_E7) {
		this.wf_E7 = wf_E7;
	}
	public Double getWf_E8() {
		return wf_E8;
	}
	public void setWf_E8(Double wf_E8) {
		this.wf_E8 = wf_E8;
	}
	public Date getWf_E9() {
		return wf_E9;
	}
	public void setWf_E9(Date wf_E9) {
		this.wf_E9 = wf_E9;
	}
	public String getWf_year() {
		return wf_year;
	}
	public void setWf_year(String wf_year) {
		this.wf_year = wf_year;
	}
	public String getWf_E10() {
		return wf_E10;
	}
	public void setWf_E10(String wf_E10) {
		this.wf_E10 = wf_E10;
	}
	public String getWf_E11() {
		return wf_E11;
	}
	public void setWf_E11(String wf_E11) {
		this.wf_E11 = wf_E11;
	}
	public String getWf_E12() {
		return wf_E12;
	}
	public void setWf_E12(String wf_E12) {
		this.wf_E12 = wf_E12;
	}
	public String getWf_E13() {
		return wf_E13;
	}
	public void setWf_E13(String wf_E13) {
		this.wf_E13 = wf_E13;
	}
	public String getWf_E14() {
		return wf_E14;
	}
	public void setWf_E14(String wf_E14) {
		this.wf_E14 = wf_E14;
	}
	public String getWf_E15() {
		return wf_E15;
	}
	public void setWf_E15(String wf_E15) {
		this.wf_E15 = wf_E15;
	}
	public String getWf_E16() {
		return wf_E16;
	}
	public void setWf_E16(String wf_E16) {
		this.wf_E16 = wf_E16;
	}
	public String getWf_E17() {
		return wf_E17;
	}
	public void setWf_E17(String wf_E17) {
		this.wf_E17 = wf_E17;
	}
	public String getWf_E18() {
		return wf_E18;
	}
	public void setWf_E18(String wf_E18) {
		this.wf_E18 = wf_E18;
	}
	public String getWf_E19() {
		return wf_E19;
	}
	public void setWf_E19(String wf_E19) {
		this.wf_E19 = wf_E19;
	}
	public String getWf_E20() {
		return wf_E20;
	}
	public void setWf_E20(String wf_E20) {
		this.wf_E20 = wf_E20;
	}
	public String getWf_E21() {
		return wf_E21;
	}
	public void setWf_E21(String wf_E21) {
		this.wf_E21 = wf_E21;
	}
	public String getWf_E22() {
		return wf_E22;
	}
	public void setWf_E22(String wf_E22) {
		this.wf_E22 = wf_E22;
	}
	public String getWf_E23() {
		return wf_E23;
	}
	public void setWf_E23(String wf_E23) {
		this.wf_E23 = wf_E23;
	}
	public String getWf_E24() {
		return wf_E24;
	}
	public void setWf_E24(String wf_E24) {
		this.wf_E24 = wf_E24;
	}

}
