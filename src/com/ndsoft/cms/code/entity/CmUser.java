package com.ndsoft.cms.code.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity(name = "CM_USER")
public class CmUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String loginName;
	private String displayName;
	private String pwd;
	private BigDecimal userId;
	private Date addDate;
	private Boolean isDeleted;
	private Boolean isAdmin;

	public CmUser() {
	}

	public CmUser(BigDecimal id) {
		this.id = id;
	}

	public CmUser(BigDecimal id, String loginName, String displayName,
			String pwd, BigDecimal userId, Date addDate, Boolean isDeleted,
			Boolean isAdmin) {
		this.id = id;
		this.loginName = loginName;
		this.displayName = displayName;
		this.pwd = pwd;
		this.userId = userId;
		this.addDate = addDate;
		this.isDeleted = isDeleted;
		this.isAdmin = isAdmin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_USER")
	@SequenceGenerator(name = "S_CM_USER", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_USER")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "LOGIN_NAME", length = 100)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "DISPLAY_NAME", length = 100)
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "PWD", length = 100)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "USER_ID", scale = 0)
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ADD_DATE", length = 7)
	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@Column(name = "IS_DELETED", precision = 1, scale = 0)
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "IS_ADMIN", precision = 1, scale = 0)
	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
