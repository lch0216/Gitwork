package com.yc.web.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yc.web.bean.District;
import com.yc.web.bean.HouseType;
import com.yc.web.biz.DistrictBiz;
import com.yc.web.biz.HouseTypeBiz;
import com.yc.web.model.JsonModel;
@Controller
@Scope(value="prototype")

@Namespace("/")
@ParentPackage("struts-default")
public class DistrictAction extends BaseAction {
	private static final long serialVersionUID = 6210472729868755809L;
	private DistrictBiz districtBiz;
	private List<District> ds;
	@Resource(name = "districtBizImpl")
	public void setDistrictBiz(DistrictBiz districtBiz) {
		this.districtBiz = districtBiz;
	}
	@Action(value="/district_findAll")
	public void findAll() throws IOException{
		if(ServletActionContext.getServletContext().getAttribute("districtList") != null ){
			ds = (List<District>) ServletActionContext.getServletContext().getAttribute("districtList");
		}
		ds = this.districtBiz.findAllDistricts();
		jsonModel.setCode( 1 );
		jsonModel.setObj( ds );
		super.outJson( jsonModel, ServletActionContext.getResponse() );
	}
}
