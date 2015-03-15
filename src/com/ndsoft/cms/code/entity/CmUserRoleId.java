package com.ndsoft.cms.code.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CmUserRoleId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal roleUser;
	private BigDecimal roleId;
	private Date addDate;
	private BigDecimal userId;
	private Boolean isDeleted;

	public CmUserRoleId() {
	}

	public CmUserRoleId(BigDecimal roleUser, BigDecimal roleId, Date addDate,
			BigDecimal userId, Boolean isDeleted) {
		this.roleUser = roleUser;
		this.roleId = roleId;
		this.addDate = addDate;
		this.userId = userId;
		this.isDeleted = isDeleted;
	}

	@Column(name = "ROLE_USER", scale = 0)
	public BigDecimal getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(BigDecimal roleUser) {
		this.roleUser = roleUser;
	}

	@Column(name = "ROLE_ID", scale = 0)
	public BigDecimal getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CmUserRoleId))
			return false;
		CmUserRoleId castOther = (CmUserRoleId) other;

		return ((this.getRoleUser() == castOther.getRoleUser()) || (this
				.getRoleUser() != null && castOther.getRoleUser() != null && this
				.getRoleUser().equals(castOther.getRoleUser())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getAddDate() == castOther.getAddDate()) || (this
						.getAddDate() != null && castOther.getAddDate() != null && this
						.getAddDate().equals(castOther.getAddDate())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getIsDeleted() == castOther.getIsDeleted()) || (this
						.getIsDeleted() != null
						&& castOther.getIsDeleted() != null && this
						.getIsDeleted().equals(castOther.getIsDeleted())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleUser() == null ? 0 : this.getRoleUser().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getAddDate() == null ? 0 : this.getAddDate().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getIsDeleted() == null ? 0 : this.getIsDeleted().hashCode());
		return result;
	}

}
