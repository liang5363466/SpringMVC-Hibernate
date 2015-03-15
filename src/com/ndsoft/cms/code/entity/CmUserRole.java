package com.ndsoft.cms.code.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity(name = "CM_USER_ROLE")
public class CmUserRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private CmUserRoleId id;
	private CmStaff cmStaff;
	private CmRole cmRole;

	public CmUserRole() {
	}

	public CmUserRole(CmUserRoleId id) {
		this.id = id;
	}

	public CmUserRole(CmUserRoleId id, CmStaff cmStaff, CmRole cmRole) {
		this.id = id;
		this.cmStaff = cmStaff;
		this.cmRole = cmRole;
	}

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_USER_ROLE")
	@SequenceGenerator(name = "S_CM_USER_ROLE", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_USER_ROLE")
	@AttributeOverrides({
			@AttributeOverride(name = "roleUser", column = @Column(name = "ROLE_USER", scale = 0)),
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", scale = 0)),
			@AttributeOverride(name = "addDate", column = @Column(name = "ADD_DATE", length = 7)),
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", scale = 0)),
			@AttributeOverride(name = "isDeleted", column = @Column(name = "IS_DELETED", precision = 1, scale = 0)) })
	public CmUserRoleId getId() {
		return this.id;
	}

	public void setId(CmUserRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmStaff getCmStaff() {
		return this.cmStaff;
	}

	public void setCmStaff(CmStaff cmStaff) {
		this.cmStaff = cmStaff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmRole getCmRole() {
		return this.cmRole;
	}

	public void setCmRole(CmRole cmRole) {
		this.cmRole = cmRole;
	}

}
