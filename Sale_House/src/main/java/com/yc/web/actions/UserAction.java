package com.yc.web.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.web.bean.User;
import com.yc.web.biz.UserBiz;
import com.yc.web.model.JsonModel;

@Controller
@Scope(value="prototype")

@Namespace("/")
@ParentPackage("struts-default")
public class UserAction extends BaseAction implements ModelDriven<User>{
	private User user;
	private UserBiz userBiz;
	private HttpSession session ;
	@Resource(name = "userBizImpl")
	public void setCustomerBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public UserAction(){
		session = ServletActionContext.getRequest().getSession();
	}
	public void validatReg() throws IOException{
		if( this.userBiz.validate(user) ){
			jsonModel.setCode(0);
			jsonModel.setMsg(" username is in used  .... ");
			//出错之后还是会执行reg方法
			//super.outJson( jsonModel, ServletActionContext.getResponse() );
			//return;
		}
	}
	
	public void validateLogin() throws IOException{
		if( user.getUsername() == null  || "".equals( user.getUsername( ) )){
			jsonModel.setCode(0);
			jsonModel.setMsg(" username can't be null  .... ");
			//super.outJson( jsonModel, ServletActionContext.getResponse() );
			//return;// 打断运行 否则会继续进入到login 方法
		}else if( user.getPassword() == null || "".equals( user.getPassword() )){
			jsonModel.setCode(0);
			jsonModel.setMsg("password can't be null  .... ");
			//super.outJson( jsonModel, ServletActionContext.getResponse() );
			//return ;
		}
	}
	@Action(value="/user_login")
	public void login() throws IOException{
		User loginUser = this.userBiz.login(user);
		if(loginUser != null ){
			jsonModel.setCode(1);
			session.setAttribute("loginUser", loginUser);
			jsonModel.setObj(loginUser);
			jsonModel.setMsg("success .... ");
		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("user not find ....");
		}
		super.outJson( jsonModel, ServletActionContext.getResponse() );
	}
	
	
	@Action(value="/user_checklogin")
	public void checklogin() throws IOException{
			
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser != null ){
			jsonModel.setCode(1);
			jsonModel.setObj(loginUser);
		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("you have not login  ....");
		}
		super.outJson( jsonModel, ServletActionContext.getResponse() );
	}
	
	@Action(value="/user_reg")
	public void reg() throws IOException{
		if(jsonModel.getCode() == null ){
			this.userBiz.register(user);
			jsonModel.setCode(1);
			jsonModel.setMsg("reg success .... ");
		}
		super.outJson( jsonModel, ServletActionContext.getResponse() );
	}
	
	
	@Action(value="/user_logout")
	public void logout() throws IOException{
		if(jsonModel.getCode() == null){
			if(session.getAttribute("loginUser") != null){
				session.removeAttribute("loginUser");
				jsonModel.setCode(1);
			}else{
				jsonModel.setCode(0);
				jsonModel.setMsg("have not login user.... ");
			}
		}
		super.outJson( jsonModel, ServletActionContext.getResponse() );
		
	}
	
	public User getModel() {
		user = new User();
		return user;
	}
}
