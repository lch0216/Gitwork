package com.yc.web.biz.impl;

import javax.annotation.Resource;

import com.yc.web.dao.BaseDao;

public class BaseBizImpl {
	protected BaseDao baseDao;
	@Resource(name = "baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
