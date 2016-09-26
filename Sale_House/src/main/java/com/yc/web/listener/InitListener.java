package com.yc.web.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.web.bean.District;
import com.yc.web.bean.HouseType;
import com.yc.web.biz.DistrictBiz;
import com.yc.web.biz.HouseTypeBiz;

public class InitListener implements ServletContextListener {
	
	private DistrictBiz districtBiz;
	private HouseTypeBiz houseTypeBiz;
	public void contextInitialized(ServletContextEvent sce) {
		// 通过 spring提供帮助类 获取     Spring  容器applictioncontext
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		if(ac != null){
			districtBiz = (DistrictBiz) ac.getBean("districtBizImpl");
			houseTypeBiz = (HouseTypeBiz) ac.getBean("houseTypeBizImpl");
			
			List<District> ds = this.districtBiz.findAllDistricts();
			List<HouseType> hs = this.houseTypeBiz.findAllTypes();
			sce.getServletContext().setAttribute("districtList", ds);
			sce.getServletContext().setAttribute("houseTypeList", hs);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
