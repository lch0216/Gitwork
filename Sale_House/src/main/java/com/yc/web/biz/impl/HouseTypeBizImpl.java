package com.yc.web.biz.impl;

import java.util.List;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.stereotype.Service;

import com.yc.web.bean.HouseType;
import com.yc.web.biz.HouseTypeBiz;
@Service
public class HouseTypeBizImpl extends BaseBizImpl implements HouseTypeBiz {

	public List<HouseType> findAllTypes() {
		return baseDao.findAll(HouseType.class, "getAllType");
	}

}
