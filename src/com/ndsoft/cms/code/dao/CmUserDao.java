package com.ndsoft.cms.code.dao;

import java.math.BigDecimal;

import com.ndsoft.cms.code.entity.CmUser;


public interface CmUserDao {
	BigDecimal addUser(CmUser user);
	CmUser getUser(String loginName,String password);
}
