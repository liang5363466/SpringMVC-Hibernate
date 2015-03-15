package com.ndsoft.cms.code.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity(name = "CM_CLOTHING")
public class CmClothing implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String name;
	private Long year;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;
	private Set<CmClothingReplace> cmClothingReplaces = new HashSet<CmClothingReplace>(
			0);
	private Set<CmStaffScheme> cmStaffSchemes = new HashSet<CmStaffScheme>(0);
	private Set<CmSchemeClothing> cmSchemeClothings = new HashSet<CmSchemeClothing>(
			0);

	public CmClothing() {
	}

	public CmClothing(BigDecimal id) {
		this.id = id;
	}

	public CmClothing(BigDecimal id, String name, Long year, Date addDate,
			BigDecimal userId, Boolean isDeleted,
			Set<CmClothingReplace> cmClothingReplaces,
			Set<CmStaffScheme> cmStaffSchemes,
			Set<CmSchemeClothing> cmSchemeClothings) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
		this.cmClothingReplaces = cmClothingReplaces;
		this.cmStaffSchemes = cmStaffSchemes;
		this.cmSchemeClothings = cmSchemeClothings;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_CLOTHING")
	@SequenceGenerator(name = "S_CM_CLOTHING", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_CLOTHING")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "YEAR", precision = 10, scale = 0)
	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ADD_DATE", length = 7)
	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@Column(name = "USER_ID", scale = 0)
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Column(name = "IS_DELETED", precision = 1, scale = 0)
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmClothing")
	public Set<CmClothingReplace> getCmClothingReplaces() {
		return this.cmClothingReplaces;
	}

	public void setCmClothingReplaces(Set<CmClothingReplace> cmClothingReplaces) {
		this.cmClothingReplaces = cmClothingReplaces;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmClothing")
	public Set<CmStaffScheme> getCmStaffSchemes() {
		return this.cmStaffSchemes;
	}

	public void setCmStaffSchemes(Set<CmStaffScheme> cmStaffSchemes) {
		this.cmStaffSchemes = cmStaffSchemes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmClothing")
	public Set<CmSchemeClothing> getCmSchemeClothings() {
		return this.cmSchemeClothings;
	}

	public void setCmSchemeClothings(Set<CmSchemeClothing> cmSchemeClothings) {
		this.cmSchemeClothings = cmSchemeClothings;
	}

}
