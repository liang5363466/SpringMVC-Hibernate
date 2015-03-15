package com.ndsoft.cms.code.logic.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndsoft.cms.code.dao.CmBranchDao;
import com.ndsoft.cms.code.dao.impl.CmBranchDaoImpl;
import com.ndsoft.cms.code.entity.CmBranch;
import com.ndsoft.cms.code.logic.CmBranchLogic;

@Service("CmBranchLogic")
@Transactional
public class CmBranchLogicImpl implements CmBranchLogic{
	
	@Resource(type = CmBranchDaoImpl.class)
	private CmBranchDao dao;
	
	@Override
	public void addBranch(CmBranch branch) {
		dao.addBranch(branch);
	}
}
