package com.ndsoft.cms.code.logic;

import com.ndsoft.cms.api.Result;
import com.ndsoft.cms.code.entity.CmUser;
import com.ndsoft.cms.model.LoginModel;


public interface CmUserLogic {
	void addUser(CmUser user);
	Result<CmUser> userLogin(LoginModel loginVM);
}
