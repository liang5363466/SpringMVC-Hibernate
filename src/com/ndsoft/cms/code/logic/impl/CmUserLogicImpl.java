package com.ndsoft.cms.code.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndsoft.cms.api.Result;
import com.ndsoft.cms.code.dao.CmUserDao;
import com.ndsoft.cms.code.dao.impl.CmUserDaoImpl;
import com.ndsoft.cms.code.entity.CmUser;
import com.ndsoft.cms.code.logic.CmUserLogic;
import com.ndsoft.cms.model.LoginModel;
import com.ndsoft.cms.util.MD5Util;

@Service("CmUserLogic")
@Transactional
public class CmUserLogicImpl implements CmUserLogic{
	
	@Resource(type = CmUserDaoImpl.class)
	private CmUserDao dao;

	@Override
	public void addUser(CmUser user) {
		dao.addUser(user);
	}

	@Override
	public Result<CmUser> userLogin(LoginModel loginVM) {
		Result<CmUser> result = new Result<CmUser>();
		try {
			CmUser user = dao.getUser(loginVM.getLoginName(), MD5Util.MD5(loginVM.getPassword()));
			result.setData(user);
			result.setSuccess(user == null);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
}
