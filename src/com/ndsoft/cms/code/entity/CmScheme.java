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

@Entity(name = "CM_SCHEME")
public class CmScheme implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String name;
	private Date startDate;
	private Date endDate;
	private String remark;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;
	private Set<CmStaffScheme> cmStaffSchemes = new HashSet<CmStaffScheme>(0);
	private Set<CmSchemeClothing> cmSchemeClothings = new HashSet<CmSchemeClothing>(
			0);

	public CmScheme() {
	}

	public CmScheme(BigDecimal id) {
		this.id = id;
	}

	public CmScheme(BigDecimal id, String name, Date startDate, Date endDate,
			String remark, Date addDate, BigDecimal userId, Boolean isDeleted,
			Set<CmStaffScheme> cmStaffSchemes,
			Set<CmSchemeClothing> cmSchemeClothings) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remark = remark;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
		this.cmStaffSchemes = cmStaffSchemes;
		this.cmSchemeClothings = cmSchemeClothings;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_SCHEME")
	@SequenceGenerator(name = "S_CM_SCHEME", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_SCHEME")
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

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", length = 7)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", length = 7)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmScheme")
	public Set<CmStaffScheme> getCmStaffSchemes() {
		return this.cmStaffSchemes;
	}

	public void setCmStaffSchemes(Set<CmStaffScheme> cmStaffSchemes) {
		this.cmStaffSchemes = cmStaffSchemes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmScheme")
	public Set<CmSchemeClothing> getCmSchemeClothings() {
		return this.cmSchemeClothings;
	}

	public void setCmSchemeClothings(Set<CmSchemeClothing> cmSchemeClothings) {
		this.cmSchemeClothings = cmSchemeClothings;
	}

}
