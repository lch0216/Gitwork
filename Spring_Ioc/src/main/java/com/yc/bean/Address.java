package com.yc.bean;

public class Address {
	private String province;
	public void init(){
		System.out.println("初始化方法....");
	}
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Address(String province) {
		super();
		this.province = province;
	}

	public Address() {
		super();
	}
	
}
