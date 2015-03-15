package com.ndsoft.cms.code.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.ndsoft.cms.code.dao.CmBranchDao;
import com.ndsoft.cms.code.entity.CmBranch;
import com.ndsoft.cms.shared.AbstractDao;


@Repository("CmBranchDao")
public class CmBranchDaoImpl extends AbstractDao<CmBranch> implements CmBranchDao{

	@Override
	public Class<CmBranch> getChildClass() {
		return CmBranch.class;
	}

	@Override
	public BigDecimal addBranch(CmBranch branch) {
		return (BigDecimal) add(branch);
	}
}
