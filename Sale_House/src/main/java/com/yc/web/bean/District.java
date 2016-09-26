package com.yc.web.bean;

import java.io.Serializable;
import java.util.List;

public class District implements Serializable{
	
	private static final long serialVersionUID = 4809360656402097039L;
	private Integer id ;
	private String name;
	private List<Street> streets;
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}
	public District( String name) {
		this.name = name;
	}
	public District() {
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
		return "HouseType [id=" + id + ", name=" + name + "]";
	}
	
	
}
