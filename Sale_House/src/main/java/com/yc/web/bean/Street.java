package com.yc.web.bean;

import java.io.Serializable;

public class Street implements Serializable{
	
	private static final long serialVersionUID = 7264141438509623808L;
	private Integer id ;
	private String name;
	private District district = new District();
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
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
	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name +  "]";
	}
	public Street(String name, Integer districtId) {
		this.name = name;
	}
	public Street() {
	}
	
}
