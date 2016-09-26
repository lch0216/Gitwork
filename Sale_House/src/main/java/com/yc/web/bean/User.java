package com.yc.web.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -4005877497153247233L;
	private  Integer id;
	private String name;
	private String password;    /*用户密码*/
	private String telephone ;  /*电话*/
	private String username  ;  /*真实名*/
	private String isadmin ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password
				+ ", telephone=" + telephone + ", username=" + username
				+ ", isadmin=" + isadmin + "]";
	}
	
}
