package com.ndsoft.cms.code.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity(name = "CM_SCHEME_CLOTHING")
public class CmSchemeClothing implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private CmClothing cmClothing;
	private CmScheme cmScheme;
	private BigDecimal count;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;

	public CmSchemeClothing() {
	}

	public CmSchemeClothing(BigDecimal id) {
		this.id = id;
	}

	public CmSchemeClothing(BigDecimal id, CmClothing cmClothing,
			CmScheme cmScheme, BigDecimal count, Date addDate,
			BigDecimal userId, Boolean isDeleted) {
		this.id = id;
		this.cmClothing = cmClothing;
		this.cmScheme = cmScheme;
		this.count = count;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_SCHEME_CLOTHING")
	@SequenceGenerator(name = "S_CM_SCHEME_CLOTHING", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_SCHEME_CLOTHING")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmClothing getCmClothing() {
		return this.cmClothing;
	}

	public void setCmClothing(CmClothing cmClothing) {
		this.cmClothing = cmClothing;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmScheme getCmScheme() {
		return this.cmScheme;
	}

	public void setCmScheme(CmScheme cmScheme) {
		this.cmScheme = cmScheme;
	}

	@Column(name = "COUNT", precision = 22, scale = 0)
	public BigDecimal getCount() {
		return this.count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
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

}
