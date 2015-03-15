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

@Entity(name = "CM_BRANCH")
public class CmBranch implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String name;
	private String address;
	private String tel;
	private BigDecimal parent;
	private String remark;
	private Long scort;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;
	private Set<CmStaff> cmStaffs = new HashSet<CmStaff>(0);

	public CmBranch() {
	}

	public CmBranch(BigDecimal id) {
		this.id = id;
	}

	public CmBranch(BigDecimal id, String name, String address, String tel,
			BigDecimal parent, String remark, Long scort, Date addDate,
			BigDecimal userId, Boolean isDeleted, Set<CmStaff> cmStaffs) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.parent = parent;
		this.remark = remark;
		this.scort = scort;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
		this.cmStaffs = cmStaffs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_BRANCH")
	@SequenceGenerator(name = "S_CM_BRANCH", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_BRANCH")
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

	@Column(name = "ADDRESS", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "TEL", length = 50)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "PARENT", scale = 0)
	public BigDecimal getParent() {
		return this.parent;
	}

	public void setParent(BigDecimal parent) {
		this.parent = parent;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SCORT", precision = 10, scale = 0)
	public Long getScort() {
		return this.scort;
	}

	public void setScort(Long scort) {
		this.scort = scort;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmBranch")
	public Set<CmStaff> getCmStaffs() {
		return this.cmStaffs;
	}

	public void setCmStaffs(Set<CmStaff> cmStaffs) {
		this.cmStaffs = cmStaffs;
	}

}
