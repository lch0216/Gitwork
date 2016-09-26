package com.yc.web.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.web.bean.House;
import com.yc.web.bean.User;
import com.yc.web.biz.HouseBiz;
import com.yc.web.model.HouseModel;

@Controller
@Scope(value="prototype")

@Namespace("/")
@ParentPackage("struts-default")
public class HouseAction extends BaseAction implements ModelDriven<HouseModel>{
	private static final long serialVersionUID = 1674651909700140844L;
	private HouseModel  houseModel;
	private HouseBiz houseBiz;
	private HttpSession session;
	public HouseAction(){
		session = ServletActionContext.getRequest().getSession();
	}
	
	public HouseModel getModel() {
		this.houseModel= new HouseModel();
		return houseModel;
	}
	@Resource(name = "houseBizImpl")
	public void setHouseBiz(HouseBiz houseBiz) {
		this.houseBiz = houseBiz;
	}
	@Action(value="/house_findAll")
	public void findAll() throws IOException{
		houseModel = this.houseBiz.getHouseModel(houseModel);
		jsonModel.setCode(1);
		jsonModel.setObj( houseModel ); 
		session.setAttribute("houseModel", houseModel);
		super.outJson(jsonModel, ServletActionContext.getResponse());
	}
	
	@Action(value="/house_findHouseById")
	public void findHouseById() throws IOException{
		if(session.getAttribute("loginUser") != null){
			HouseModel houseModel = (HouseModel) session.getAttribute("houseModel");
			List<House> hs = houseModel.getHouses();
			Integer id = Integer.parseInt( ServletActionContext.getRequest().getParameter("house.id") );
			for (House house : hs) {
				if(house.getId() == id ){
					jsonModel.setObj(house);
					break;
				}
			}
			jsonModel.setCode(1);
		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("you have not login...");
		}
		super.outJson(jsonModel, ServletActionContext.getResponse());
	}
	
	
	
	@Action(value="/house_add")
	public void add() throws IOException{
		User user = (User) session.getAttribute("loginUser");
		houseModel.getHouse().setUser(user);
		this.houseBiz.addHouse( houseModel.getHouse() );
		jsonModel.setCode(1);
		super.outJson(jsonModel, ServletActionContext.getResponse());
	}
	
	// 添加 订单
	@Action(value="/house_search")
	public void search() throws IOException{
		Map<String ,Object> map = new HashMap<String, Object>();
		if( session.getAttribute("loginUser") != null ){
			User user =  (User) session.getAttribute("loginUser") ;
			map.put( "currPage", houseModel.getCurrPage() );
			map.put( "sizePage", houseModel.getSizePage() );
			map.put( "userId", user.getId() );
			map.put( "title",houseModel.getHouse().getTitle());
			map.put( "typeId",houseModel.getHouse().getHouseType().getId() );
			map.put( "minPrice", houseModel.getMinPrice() );
			map.put( "maxPrice", houseModel.getMaxPrice());
			map.put( "minFloorage", houseModel.getMinFloorage() );
			map.put( "maxFloorage", houseModel.getMaxFloorage() );
			houseModel = this.houseBiz.searchHouse(map);
			houseModel.setHouse(null);
			jsonModel.setCode(1);
			jsonModel.setObj(houseModel);
		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("search error...");
		}
		super.outJson(jsonModel, ServletActionContext.getResponse());
	}
	
	@Action(value="/house_del")
	public void del() throws IOException{
		this.houseBiz.delHouse( houseModel.getHouse().getId() );
		jsonModel.setCode(1);
		super.outJson(jsonModel, ServletActionContext.getResponse());
	}
	@Action(value="/house_update")
	public void update() throws IOException{
		if ( session.getAttribute("loginUser") != null){
			User user = (User) session.getAttribute("loginUser");
			houseModel.getHouse().setUser(user);
			this.houseBiz.updateHouse( houseModel.getHouse() );
			jsonModel.setCode(1);
		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("you have not login ..");
		}
		super.outJson(jsonModel, ServletActionContext.getResponse());
	}
	
}
