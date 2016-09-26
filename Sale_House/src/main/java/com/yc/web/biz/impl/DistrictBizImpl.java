package com.yc.web.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.web.bean.District;
import com.yc.web.biz.DistrictBiz;
import com.yc.web.dao.BaseDao;
@Service
public class DistrictBizImpl extends BaseBizImpl implements DistrictBiz {
	public List<District> findAllDistricts() {
		List<District> districts = null;
		districts= baseDao.findAll(District.class, "getAllDistrict");
		return districts;
	}

}
