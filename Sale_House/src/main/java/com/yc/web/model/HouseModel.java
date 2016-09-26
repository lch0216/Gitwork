package com.yc.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yc.web.bean.House;

//符合前台页面要求的bean
public class HouseModel implements Serializable{

	private static final long serialVersionUID = -5242585985807465726L;
	private Integer total = 1;
	private Integer currPage =1;
	private Integer sizePage =5;
	private List<House> houses;
	private Double minPrice;
	private Double maxPrice;
	private Double minFloorage;
	private Double maxFloorage;
	private int totalRecord ;// 总记录数
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Double getMinFloorage() {
		return minFloorage;
	}

	public void setMinFloorage(Double minFloorage) {
		this.minFloorage = minFloorage;
	}

	public Double getMaxFloorage() {
		return maxFloorage;
	}

	public void setMaxFloorage(Double maxFloorage) {
		this.maxFloorage = maxFloorage;
	}

	public HouseModel() {
	}
	public HouseModel(Integer total, Integer currPage, Integer sizePage,
			List<House> houses, House house) {
		this.total = total;
		this.currPage = currPage;
		this.sizePage = sizePage;
		this.houses = houses;
		this.house = house;
	}
	private House house = new House();
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getCurrPage() {
		
		if(currPage == null || currPage <0 ){
			currPage = 1;
		}else if( currPage >= total){
			currPage = total;
		}
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getSizePage() {
		if(this.sizePage == null || this.sizePage ==0){
			this.sizePage = 5;
		}
		return sizePage;
	}
	public void setSizePage(Integer sizePage) {
		this.sizePage = sizePage;
	}
	public List<House> getHouses() {
		return houses;
	}
	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}

	@Override
	public String toString() {
		return "HouseModel [total=" + total + ", currPage=" + currPage
				+ ", sizePage=" + sizePage + ", houses=" + houses
				+ ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", minFloorage=" + minFloorage + ", maxFloorage="
				+ maxFloorage + ", house=" + house + "]";
	}
	
}
