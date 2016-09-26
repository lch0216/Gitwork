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

import com.yc.web.bean.HouseType;
import com.yc.web.biz.HouseTypeBiz;
import com.yc.web.model.JsonModel;
@Controller
@Scope(value="prototype")

@Namespace("/")
@ParentPackage("struts-default")
public class HouseTypeAction extends BaseAction {
	private static final long serialVersionUID = 6210472729868755809L;
	private HouseTypeBiz houseTypeBiz;
	private List<HouseType> types ;
	private JsonModel jsonModel;
	@Resource(name = "houseTypeBizImpl")
	public void setHouseTypeBiz(HouseTypeBiz houseTypeBiz) {
		this.houseTypeBiz = houseTypeBiz;
	}
	@Action(value="/houseType_findAll")
	public void findAll() throws IOException{
		jsonModel = new JsonModel();
		if( ServletActionContext.getServletContext().getAttribute("houseTypeList") == null ){
			 types = this.houseTypeBiz.findAllTypes();
			jsonModel.setCode(1);
			jsonModel.setObj(types);
		}else{
			types = this.houseTypeBiz.findAllTypes();
			jsonModel.setCode(1);
			jsonModel.setObj(types);
		}
		super.outJson( jsonModel, ServletActionContext.getResponse() );
	}
}
