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

@Entity(name = "CM_MENU")
public class CmMenu implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String iconCls;
	private String name;
	private String url;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;
	private Set<CmMenuRole> cmMenuRoles = new HashSet<CmMenuRole>(0);

	public CmMenu() {
	}

	public CmMenu(BigDecimal id) {
		this.id = id;
	}

	public CmMenu(BigDecimal id, String iconCls, String name, String url,
			Date addDate, BigDecimal userId, Boolean isDeleted,
			Set<CmMenuRole> cmMenuRoles) {
		this.id = id;
		this.iconCls = iconCls;
		this.name = name;
		this.url = url;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
		this.cmMenuRoles = cmMenuRoles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CM_MENU")
	@SequenceGenerator(name = "S_CM_MENU", allocationSize = 1, initialValue = 1, sequenceName = "S_CM_MENU")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "ICON_CLS", length = 100)
	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "URL", length = 500)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmMenu")
	public Set<CmMenuRole> getCmMenuRoles() {
		return this.cmMenuRoles;
	}

	public void setCmMenuRoles(Set<CmMenuRole> cmMenuRoles) {
		this.cmMenuRoles = cmMenuRoles;
	}

}
