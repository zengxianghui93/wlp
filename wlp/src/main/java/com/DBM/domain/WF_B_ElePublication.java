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
 *<br><b>类描述:</b>
 *<pre>电子出版物</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_elePublication")
public class WF_B_ElePublication {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电子出版物id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title")
    private String wf_title;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>原文（路径、）</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_original")
    private String wf_original;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>正文</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>关键字</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_keyword",length=65535)
    private String wf_keyword;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>年</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_year",length=50)
    private Integer wf_year;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>卷</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_volume",length=50)
    private String wf_volume;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>期</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_issue",length=50)
    private String wf_issue;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>作者</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_author")
    private String wf_author;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>作者机构</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_authorUnit",length=65535)
    private String wf_authorUnit;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_fl",length=65535)
    private String wf_fl;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>页码（范围）</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_page",length=50)
    private String wf_page;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>总页数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_totalpage")
    private String wf_totalpage;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>摘要</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_abstract",length=65535)
    private String wf_abstract;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>封面图片</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_coverPicture")
    private String wf_coverPicture;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>价格</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_price")
    private Double wf_price;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>折扣价格</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_afterDiscountPrice")
    private Double wf_afterDiscountPrice;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否有纸本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_paper_no")
    private String wf_paper_no;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>是否连续出版</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_continuousPub")
    private String wf_continuousPub;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>出版频率</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_pubFrequency")
    private String wf_pubFrequency;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>目录</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_directory",length=65535)
    private Integer wf_directory;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>版次</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_edition")
    private String wf_edition;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>字数</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_wordNumber")
    private String wf_wordNumber;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>开本</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_booksize")
    private String wf_booksize;
    /**
	 *<br><b>字段描述:</b>
	 *<pre>时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "createTime")
    private Date createTime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>评价</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_evaluate",length=65535)
    private String wf_evaluate;
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
    private String wf_lang;
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
	private String wf_resource_Index;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>聚类id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_b_elepubid")
	private Integer wf_b_elepubid;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>聚类id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "deleted")
	private Integer deleted;
	
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getWf_b_elepubid() {
		return wf_b_elepubid;
	}
	public void setWf_b_elepubid(Integer wf_b_elepubid) {
		this.wf_b_elepubid = wf_b_elepubid;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
	}
	public String getWf_original() {
		return wf_original;
	}
	public void setWf_original(String wf_original) {
		this.wf_original = wf_original;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_keyword() {
		return wf_keyword;
	}
	public void setWf_keyword(String wf_keyword) {
		this.wf_keyword = wf_keyword;
	}
	public Integer getWf_year() {
		return wf_year;
	}
	public void setWf_year(Integer wf_year) {
		this.wf_year = wf_year;
	}
	public String getWf_volume() {
		return wf_volume;
	}
	public void setWf_volume(String wf_volume) {
		this.wf_volume = wf_volume;
	}
	public String getWf_issue() {
		return wf_issue;
	}
	public void setWf_issue(String wf_issue) {
		this.wf_issue = wf_issue;
	}
	public String getWf_author() {
		return wf_author;
	}
	public void setWf_author(String wf_author) {
		this.wf_author = wf_author;
	}
	public String getWf_authorUnit() {
		return wf_authorUnit;
	}
	public void setWf_authorUnit(String wf_authorUnit) {
		this.wf_authorUnit = wf_authorUnit;
	}
	public String getWf_fl() {
		return wf_fl;
	}
	public void setWf_fl(String wf_fl) {
		this.wf_fl = wf_fl;
	}
	public String getWf_page() {
		return wf_page;
	}
	public void setWf_page(String wf_page) {
		this.wf_page = wf_page;
	}
	public String getWf_totalpage() {
		return wf_totalpage;
	}
	public void setWf_totalpage(String wf_totalpage) {
		this.wf_totalpage = wf_totalpage;
	}
	public String getWf_abstract() {
		return wf_abstract;
	}
	public void setWf_abstract(String wf_abstract) {
		this.wf_abstract = wf_abstract;
	}
	public String getWf_coverPicture() {
		return wf_coverPicture;
	}
	public void setWf_coverPicture(String wf_coverPicture) {
		this.wf_coverPicture = wf_coverPicture;
	}
	public Double getWf_price() {
		return wf_price;
	}
	public void setWf_price(Double wf_price) {
		this.wf_price = wf_price;
	}
	public Double getWf_afterDiscountPrice() {
		return wf_afterDiscountPrice;
	}
	public void setWf_afterDiscountPrice(Double wf_afterDiscountPrice) {
		this.wf_afterDiscountPrice = wf_afterDiscountPrice;
	}
	public String getWf_paper_no() {
		return wf_paper_no;
	}
	public void setWf_paper_no(String wf_paper_no) {
		this.wf_paper_no = wf_paper_no;
	}
	public String getWf_continuousPub() {
		return wf_continuousPub;
	}
	public void setWf_continuousPub(String wf_continuousPub) {
		this.wf_continuousPub = wf_continuousPub;
	}
	public String getWf_pubFrequency() {
		return wf_pubFrequency;
	}
	public void setWf_pubFrequency(String wf_pubFrequency) {
		this.wf_pubFrequency = wf_pubFrequency;
	}
	public Integer getWf_directory() {
		return wf_directory;
	}
	public void setWf_directory(Integer wf_directory) {
		this.wf_directory = wf_directory;
	}
	public String getWf_edition() {
		return wf_edition;
	}
	public void setWf_edition(String wf_edition) {
		this.wf_edition = wf_edition;
	}
	public String getWf_wordNumber() {
		return wf_wordNumber;
	}
	public void setWf_wordNumber(String wf_wordNumber) {
		this.wf_wordNumber = wf_wordNumber;
	}
	public String getWf_booksize() {
		return wf_booksize;
	}
	public void setWf_booksize(String wf_booksize) {
		this.wf_booksize = wf_booksize;
	}
	public String getWf_evaluate() {
		return wf_evaluate;
	}
	public void setWf_evaluate(String wf_evaluate) {
		this.wf_evaluate = wf_evaluate;
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
	public String getWf_lang() {
		return wf_lang;
	}
	public void setWf_lang(String wf_lang) {
		this.wf_lang = wf_lang;
	}
	public String getWf_year_Index() {
		return wf_year_Index;
	}
	public void setWf_year_Index(String wf_year_Index) {
		this.wf_year_Index = wf_year_Index;
	}
	public String getWf_resource_Index() {
		return wf_resource_Index;
	}
	public void setWf_resource_Index(String wf_resource_Index) {
		this.wf_resource_Index = wf_resource_Index;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
