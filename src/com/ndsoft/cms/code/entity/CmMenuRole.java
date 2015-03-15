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

@Entity(name = "CM_MENU_ROLE")
public class CmMenuRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private CmMenuRoleId id;
	private CmMenu cmMenu;
	private CmRole cmRole;

	public CmMenuRole() {
	}

	public CmMenuRole(CmMenuRoleId id) {
		this.id = id;
	}

	public CmMenuRole(CmMenuRoleId id, CmMenu cmMenu, CmRole cmRole) {
		this.id = id;
		this.cmMenu = cmMenu;
		this.cmRole = cmRole;
	}

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_MENU_ROLE")
	@SequenceGenerator(name = "S_CM_MENU_ROLE", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_MENU_ROLE")
	@AttributeOverrides({
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", scale = 0)),
			@AttributeOverride(name = "menuId", column = @Column(name = "MENU_ID", scale = 0)),
			@AttributeOverride(name = "addDate", column = @Column(name = "ADD_DATE", length = 7)),
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", scale = 0)),
			@AttributeOverride(name = "isDeleted", column = @Column(name = "IS_DELETED", precision = 1, scale = 0)) })
	public CmMenuRoleId getId() {
		return this.id;
	}

	public void setId(CmMenuRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmMenu getCmMenu() {
		return this.cmMenu;
	}

	public void setCmMenu(CmMenu cmMenu) {
		this.cmMenu = cmMenu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public CmRole getCmRole() {
		return this.cmRole;
	}

	public void setCmRole(CmRole cmRole) {
		this.cmRole = cmRole;
	}

}
