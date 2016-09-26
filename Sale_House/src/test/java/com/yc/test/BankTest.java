package com.yc.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.web.bean.District;
import com.yc.web.bean.House;
import com.yc.web.bean.HouseType;
import com.yc.web.bean.User;
import com.yc.web.biz.DistrictBiz;
import com.yc.web.biz.HouseBiz;
import com.yc.web.biz.HouseTypeBiz;
import com.yc.web.biz.UserBiz;
import com.yc.web.model.HouseModel;


public class BankTest {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
		User user = new User();
		user.setUsername("a");
		user.setPassword("a");
		user.setTelephone("1234566");
		user.setName("a");
		user.setIsadmin("0");
		User u = ub.login(user);
		System.out.println(u);
	}
	@Test
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DistrictBiz db = (DistrictBiz) ac.getBean("districtBizImpl");
		List<District> ds = db.findAllDistricts();
		for (District district : ds) {
			System.out.println(district);
		}
	}
	
	@Test
	public void testtypes() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseTypeBiz hb = (HouseTypeBiz) ac.getBean("houseTypeBizImpl");
		List<HouseType> hs = hb.findAllTypes();
		for (HouseType houseType : hs) {
			System.out.println(houseType);
		}
	}
	
	@Test
	public void testhouse() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseBiz hb = (HouseBiz) ac.getBean("houseBizImpl");
		HouseModel hm = new HouseModel();
		HouseModel hs = hb.getHouseModel(  hm );
		
	}
	@Test
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseBiz hb =  (HouseBiz) ac.getBean("houseBizImpl");
		//hb.getHouseModel(hm);
		Map<String ,Object> map = new HashMap<String, Object>();
		
	}
}
