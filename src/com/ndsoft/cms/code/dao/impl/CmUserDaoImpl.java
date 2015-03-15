package com.ndsoft.cms.code.dao.impl;

import java.math.BigDecimal;
import java.util.Collection;

import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.ndsoft.cms.api.DbParameter;
import com.ndsoft.cms.code.dao.CmUserDao;
import com.ndsoft.cms.code.entity.CmUser;
import com.ndsoft.cms.shared.AbstractDao;


@Repository("CmUserDao")
public class CmUserDaoImpl extends AbstractDao<CmUser> implements CmUserDao{

	@Override
	public Class<CmUser> getChildClass() {
		return CmUser.class;
	}

	@Override
	public BigDecimal addUser(CmUser user) {
		return (BigDecimal) add(user);
	}

	@Override
	public CmUser getUser(String loginName, String password) {
		String hql = " from CM_USER u where u.loginName = :loginName and u.pwd = :password";
		DbParameter [] params = {
			new DbParameter("loginName",StandardBasicTypes.STRING,loginName),
			new DbParameter("password",StandardBasicTypes.STRING,password)
		};
		Collection<CmUser> users = query(hql, params);
		return users.size() > 0 ? users.iterator().next() : null;
	}

}
