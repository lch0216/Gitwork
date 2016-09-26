package com.yc.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.web.bean.House;
import com.yc.web.biz.HouseBiz;
import com.yc.web.model.HouseModel;
@Service
public class HouseBizImpl extends BaseBizImpl implements HouseBiz {
	// 得到页面用的bean 
	public HouseModel getHouseModel(HouseModel hm) {
		int count = baseDao.getCount(House.class, "getHouseCount");
		int total = count % hm.getSizePage() == 0 ? count/hm.getSizePage() : count/hm.getSizePage() + 1;
		hm.setTotal(total);
		hm.setTotalRecord(count);
		int offset = (hm.getCurrPage()-1) * hm.getSizePage();
		List<House> houses = baseDao.findList(House.class,null, "getHouse", offset, hm.getSizePage());
		hm.setHouses(houses);
		return hm;
	}
@Transactional(readOnly = false,isolation = Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
	public boolean addHouse(House house) {
		baseDao.save(house, "saveHouse");
		return true;
	}
@Transactional(readOnly = false,isolation = Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)

	public boolean updateHouse(House house) {
		baseDao.update(house, "updateHouse");
		return true;
	}
@Transactional(readOnly = false,isolation = Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
	public boolean delHouse(int id) {
		baseDao.del(House.class, id, "delHouse");
		return true;
	}
@Transactional(readOnly = false,isolation = Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
	public HouseModel searchHouse(Map<String, Object> map) {
		HouseModel hm = new HouseModel();
		int currPage = Integer.parseInt( map.get("currPage").toString() );
		int sizePage = Integer.parseInt( map.get("sizePage").toString() );
		int count = baseDao.getCount(House.class, map, "findHouseConditionCount");
		int total = count % hm.getSizePage() == 0 ? count/hm.getSizePage() : count/hm.getSizePage() + 1;
		hm.setTotal(total);
		hm.setTotalRecord(count);
		int offset = (currPage -1 ) * sizePage;
		List<House> hs = baseDao.findList(House.class, map, "findHouseCondition", offset, sizePage);
		hm.setHouses(hs);
		hm.setCurrPage(currPage);
		return hm;
	}

}
