package com.yc.web.biz;

import java.util.Map;

import com.yc.web.bean.House;
import com.yc.web.model.HouseModel;

public interface HouseBiz {
	public HouseModel getHouseModel(HouseModel hm );
	public boolean addHouse (House house);
	public boolean updateHouse (House house);
	public boolean delHouse (int id );
	public HouseModel searchHouse (Map<String,Object> map);
}
