package com.yc.bean;

public class Product {
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Product(Address address) {
		super();
		this.address = address;
	}

	public Product() {
		super();
	}
}
