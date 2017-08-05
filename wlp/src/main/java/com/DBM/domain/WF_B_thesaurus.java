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
 *<pre>主题词表</pre>
 *@see
 *@since
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "wf_b_thesaurus")
public class WF_B_thesaurus {
	/**
	 *<br><b>字段描述:</b>
	 *<pre>主题词表id 主键 自增长</pre>
	 *@see
	 *@since
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer f_id;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>主题词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_thesaurus")
	private String wf_thesaurus;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>缩略词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_acronym")
    private String wf_acronym;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>被缩略词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_byAcronym")
    private String wf_byAcronym;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>等同词</pre>
	 *@see
	 *@since
	 */	
	@Column(name = "wf_EquivalentWord",length=65535)
    private String wf_EquivalentWord;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>上位词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_hypernym",length=65535)
    private String wf_hypernym;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>替代词(用代词)</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_usePronouns",length=65535)
    private String wf_usePronouns;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>外文等同词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_EquivalentWord_en",length=65535)
    private String wf_EquivalentWord_en;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>下位词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_hyponym",length=65535)
    private String wf_hyponym;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>相关词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_relatedWord",length=65535)
    private String wf_relatedWord;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>族首词</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_raceFirstWord")
    private String wf_raceFirstWord;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>组合概念</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_combinedConcept")
    private String wf_combinedConcept;
	
	/**
	 *<br><b>字段描述:</b>
	 *<pre>历史注释</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_historyNote")
    private String wf_historyNote;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>后组配概念</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_afterConcept")
    private String wf_afterConcept;
	/**
	 *<br><b>字段描述:</b>
	 *<pre>范围注释</pre>
	 *@see
	 *@since
	 */
	@Column(name = "wf_rangeNote")
    private String wf_rangeNote;
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
	
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Integer getWf_tei_id() {
		return wf_tei_id;
	}
	public void setWf_tei_id(Integer wf_tei_id) {
		this.wf_tei_id = wf_tei_id;
	}
	public String getWf_acronym() {
		return wf_acronym;
	}
	public void setWf_acronym(String wf_acronym) {
		this.wf_acronym = wf_acronym;
	}
	public String getWf_byAcronym() {
		return wf_byAcronym;
	}
	public void setWf_byAcronym(String wf_byAcronym) {
		this.wf_byAcronym = wf_byAcronym;
	}
	public String getWf_EquivalentWord() {
		return wf_EquivalentWord;
	}
	public void setWf_EquivalentWord(String wf_EquivalentWord) {
		this.wf_EquivalentWord = wf_EquivalentWord;
	}
	public String getWf_hypernym() {
		return wf_hypernym;
	}
	public void setWf_hypernym(String wf_hypernym) {
		this.wf_hypernym = wf_hypernym;
	}
	public String getWf_usePronouns() {
		return wf_usePronouns;
	}
	public void setWf_usePronouns(String wf_usePronouns) {
		this.wf_usePronouns = wf_usePronouns;
	}
	public String getWf_EquivalentWord_en() {
		return wf_EquivalentWord_en;
	}
	public void setWf_EquivalentWord_en(String wf_EquivalentWord_en) {
		this.wf_EquivalentWord_en = wf_EquivalentWord_en;
	}
	public String getWf_hyponym() {
		return wf_hyponym;
	}
	public void setWf_hyponym(String wf_hyponym) {
		this.wf_hyponym = wf_hyponym;
	}
	public String getWf_relatedWord() {
		return wf_relatedWord;
	}
	public void setWf_relatedWord(String wf_relatedWord) {
		this.wf_relatedWord = wf_relatedWord;
	}
	public String getWf_raceFirstWord() {
		return wf_raceFirstWord;
	}
	public void setWf_raceFirstWord(String wf_raceFirstWord) {
		this.wf_raceFirstWord = wf_raceFirstWord;
	}
	public String getWf_combinedConcept() {
		return wf_combinedConcept;
	}
	public void setWf_combinedConcept(String wf_combinedConcept) {
		this.wf_combinedConcept = wf_combinedConcept;
	}
	public String getWf_historyNote() {
		return wf_historyNote;
	}
	public void setWf_historyNote(String wf_historyNote) {
		this.wf_historyNote = wf_historyNote;
	}
	public String getWf_afterConcept() {
		return wf_afterConcept;
	}
	public void setWf_afterConcept(String wf_afterConcept) {
		this.wf_afterConcept = wf_afterConcept;
	}
	public String getWf_rangeNote() {
		return wf_rangeNote;
	}
	public void setWf_rangeNote(String wf_rangeNote) {
		this.wf_rangeNote = wf_rangeNote;
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
	public String getWf_thesaurus() {
		return wf_thesaurus;
	}
	public void setWf_thesaurus(String wf_thesaurus) {
		this.wf_thesaurus = wf_thesaurus;
	}
	
}
