package com.ndsoft.cms.code.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity(name = "CM_STAFF")
public class CmStaff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private CmBranch cmBranch;
	private String name;
	private BigDecimal sex;
	private Long age;
	private String tel;
	private Boolean status;
	private Date joinDate;
	private Date leaveDate;
	private String remark;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;
	private Set<CmClothingReplace> cmClothingReplaces = new HashSet<CmClothingReplace>(
			0);
	private Set<CmStaffScheme> cmStaffSchemes = new HashSet<CmStaffScheme>(0);
	private Set<CmUserRole> cmUserRoles = new HashSet<CmUserRole>(0);

	public CmStaff() {
	}

	public CmStaff(BigDecimal id) {
		this.id = id;
	}

	public CmStaff(BigDecimal id, CmBranch cmBranch, String name,
			BigDecimal sex, Long age, String tel, Boolean status,
			Date joinDate, Date leaveDate, String remark, Date addDate,
			BigDecimal userId, Boolean isDeleted,
			Set<CmClothingReplace> cmClothingReplaces,
			Set<CmStaffScheme> cmStaffSchemes, Set<CmUserRole> cmUserRoles) {
		this.id = id;
		this.cmBranch = cmBranch;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.status = status;
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
		this.remark = remark;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
		this.cmClothingReplaces = cmClothingReplaces;
		this.cmStaffSchemes = cmStaffSchemes;
		this.cmUserRoles = cmUserRoles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_STAFF")
	@SequenceGenerator(name = "S_CM_STAFF", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_STAFF")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmBranch getCmBranch() {
		return this.cmBranch;
	}

	public void setCmBranch(CmBranch cmBranch) {
		this.cmBranch = cmBranch;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEX", precision = 22, scale = 0)
	public BigDecimal getSex() {
		return this.sex;
	}

	public void setSex(BigDecimal sex) {
		this.sex = sex;
	}

	@Column(name = "AGE", precision = 10, scale = 0)
	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Column(name = "TEL", length = 50)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "STATUS", precision = 1, scale = 0)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "JOIN_DATE", length = 7)
	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LEAVE_DATE", length = 7)
	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmStaff")
	public Set<CmClothingReplace> getCmClothingReplaces() {
		return this.cmClothingReplaces;
	}

	public void setCmClothingReplaces(Set<CmClothingReplace> cmClothingReplaces) {
		this.cmClothingReplaces = cmClothingReplaces;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmStaff")
	public Set<CmStaffScheme> getCmStaffSchemes() {
		return this.cmStaffSchemes;
	}

	public void setCmStaffSchemes(Set<CmStaffScheme> cmStaffSchemes) {
		this.cmStaffSchemes = cmStaffSchemes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmStaff")
	public Set<CmUserRole> getCmUserRoles() {
		return this.cmUserRoles;
	}

	public void setCmUserRoles(Set<CmUserRole> cmUserRoles) {
		this.cmUserRoles = cmUserRoles;
	}

}
