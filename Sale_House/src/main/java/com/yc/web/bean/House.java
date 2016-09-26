package com.yc.web.bean;

import java.io.Serializable;
import java.sql.Date;

public class House implements Serializable {
	private static final long serialVersionUID = -5851102218172238989L;
	private Integer id; /* 信息id */
	private String title; /* 信息标题 */
	private String description; /* 描述 */
	private double price; /* 价格 */
	private Date pubdate; /* 发布日期 */
	private Double floorage; /* 面积 */
	private String contact; /* 联系方式 */
	private User user = new User();
	private Street street = new Street();
	
	private HouseType houseType = new HouseType();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public HouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Double getFloorage() {
		return floorage;
	}

	public void setFloorage(Double floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public House(Integer id, String title, String description, double price,
			Date pubdate, Double floorage, String contact, User user,
			Street street, HouseType houseType) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
		this.user = user;
		this.street = street;
		this.houseType = houseType;
	}

	public House() {
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubdate=" + pubdate
				+ ", floorage=" + floorage + ", contact=" + contact
				+ ", houseType=" + houseType + ", user=" + user + ", street="
				+ street + "]";
	}

}
