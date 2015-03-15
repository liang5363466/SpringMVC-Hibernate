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

@Entity(name = "CM_CLOTHING_REPLACE")
public class CmClothingReplace implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private CmClothing cmClothing;
	private CmStaff cmStaff;
	private Date replaceTime;
	private String remark;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;

	public CmClothingReplace() {
	}

	public CmClothingReplace(BigDecimal id) {
		this.id = id;
	}

	public CmClothingReplace(BigDecimal id, CmClothing cmClothing,
			CmStaff cmStaff, Date replaceTime, String remark, Date addDate,
			BigDecimal userId, Boolean isDeleted) {
		this.id = id;
		this.cmClothing = cmClothing;
		this.cmStaff = cmStaff;
		this.replaceTime = replaceTime;
		this.remark = remark;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_CLOTHING_REPLACE")
	@SequenceGenerator(name = "S_CM_CLOTHING_REPLACE", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_CLOTHING_REPLACE")
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
	public CmStaff getCmStaff() {
		return this.cmStaff;
	}

	public void setCmStaff(CmStaff cmStaff) {
		this.cmStaff = cmStaff;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REPLACE_TIME", length = 7)
	public Date getReplaceTime() {
		return this.replaceTime;
	}

	public void setReplaceTime(Date replaceTime) {
		this.replaceTime = replaceTime;
	}

	@Column(name = "REMARK", length = 500)
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

}
