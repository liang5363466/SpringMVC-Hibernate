package com.ndsoft.cms.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ndsoft.cms.api.RequestBean;
import com.ndsoft.cms.api.Result;
import com.ndsoft.cms.code.entity.CmUser;
import com.ndsoft.cms.model.LoginModel;
import com.ndsoft.cms.shared.AbstractController;

@Controller
@RequestMapping("/User/")
public class UserController extends AbstractController {

	@RequestMapping(value = "/Login", method = { RequestMethod.GET,RequestMethod.POST })
	public String login(@RequestBean LoginModel user) {
		if (user.getLoginName() == null) {
			return "login";
		}
		Result<CmUser> result = userLogic.userLogin(user);
		if (result.getData() != null) {
			session("USERINFO",result.getData());
			return "redirect:Main";
		} else {
			result.setMessage("用户名或密码错误！");
		}
		return "login";
	}
}
