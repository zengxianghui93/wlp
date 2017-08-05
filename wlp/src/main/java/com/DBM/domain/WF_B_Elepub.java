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
 *<pre>电子出版物子表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_elepub")
public class WF_B_Elepub {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>电子聚类id</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>分类书籍名称</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_title")
    private String wf_title;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>时间</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_creattime")
    private Date wf_creattime;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>位置</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by1")
    private String wf_by1;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>题名</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_by2")
    private String wf_by2;
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
	 *<pre>聚类id</pre>
	 *@see
	 *@since
	 */
	@Column(name = "f_id")
	private Integer f_id;
	
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
	 *<pre>正文</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_doccontent",length=2147483647)
    private String wf_doccontent;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>最低价格</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_priceminx",length=2147483647)
    private Double wf_priceminx;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>最低价格</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_prices")
    private Double wf_prices;
    
	public Double getWf_prices() {
		return wf_prices;
	}
	public void setWf_prices(Double wf_prices) {
		this.wf_prices = wf_prices;
	}
	public Double getWf_priceminx() {
		return wf_priceminx;
	}
	public void setWf_priceminx(Double wf_priceminx) {
		this.wf_priceminx = wf_priceminx;
	}
	public String getWf_doccontent() {
		return wf_doccontent;
	}
	public void setWf_doccontent(String wf_doccontent) {
		this.wf_doccontent = wf_doccontent;
	}
	public String getWf_paper_no() {
		return wf_paper_no;
	}
	public void setWf_paper_no(String wf_paper_no) {
		this.wf_paper_no = wf_paper_no;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
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
	public Date getWf_creattime() {
		return wf_creattime;
	}
	public void setWf_creattime(Date wf_creattime) {
		this.wf_creattime = wf_creattime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWf_title() {
		return wf_title;
	}
	public void setWf_title(String wf_title) {
		this.wf_title = wf_title;
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
}
