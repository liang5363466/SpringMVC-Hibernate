package com.ndsoft.cms.shared;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ndsoft.cms.api.GZIPResponseWrapper;
import com.ndsoft.cms.code.logic.CmBranchLogic;
import com.ndsoft.cms.code.logic.CmUserLogic;

public abstract class AbstractController extends MultiActionController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@Resource
	protected CmUserLogic userLogic;
	@Resource
	protected CmBranchLogic branchLogic;
	
	@ModelAttribute
	protected void beforeExecuting(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		enableGZIP();
	}

	protected Object request(String key) {
		return request.getAttribute(key);
	}

	protected void request(String key, Object obj) {
		request.setAttribute(key, obj);
	}

	protected Object session(String key) {
		return session.getAttribute(key);
	}

	protected void session(String key, Object obj) {
		session.setAttribute(key, obj);
	}
	
	/**为页面启用GZIP压缩*/
	private void enableGZIP(){
		String ae = request.getHeader("accept-encoding");
		if (ae != null && ae.indexOf("gzip") != -1) {
			GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
			wrappedResponse.finishResponse();
		}
	}
}
