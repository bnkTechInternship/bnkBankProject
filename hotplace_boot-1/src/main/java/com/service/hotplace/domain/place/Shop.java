package com.service.hotplace.domain.place;

public class Shop {
	// fields
	private int shopIdx;
	private String shopName;
	private String shopAddress;
	private String shopNumber;
	private String shopOper;
	private int shopEnternum;
	private String shopLat;
	private String shopLong;
	private int totalCnt;
	private String webAddress;
	
	// constructors
	public Shop() {}
	public Shop(int shopIdx, String shopName, String shopAddress, String shopNumber, String shopOper, int shopEnternum,
			String shopLat, String shopLong, int totalCnt, String webAddress) {
		super();
		this.shopIdx = shopIdx;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopNumber = shopNumber;
		this.shopOper = shopOper;
		this.shopEnternum = shopEnternum;
		this.shopLat = shopLat;
		this.shopLong = shopLong;
		this.totalCnt = totalCnt;
		this.webAddress = webAddress;
	}
	public Shop(int shopIdx, int shopEnternum) {
		super();
		this.shopIdx = shopIdx;
		this.shopEnternum = shopEnternum;
	}
	public Shop(String shopName, String shopAddress, String shopNumber, String shopOper, int shopEnternum,
			String shopLat, String shopLong, int totalCnt, String webAddress) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopNumber = shopNumber;
		this.shopOper = shopOper;
		this.shopEnternum = shopEnternum;
		this.shopLat = shopLat;
		this.shopLong = shopLong;
		this.totalCnt = totalCnt;
		this.webAddress = webAddress;
	}

	// getter
	public int getShopIdx() {return shopIdx;}
	public String getShopName() {return shopName;}
	public String getShopAddress() {return shopAddress;}
	public String getShopNumber() {return shopNumber;}
	public String getShopOper() {return shopOper;}
	public int getShopEnternum() {return shopEnternum;}
	public String getShopLat() {return shopLat;}
	public String getWebAddress() {return webAddress;}
	public int getTotalCnt() {return totalCnt;}
	public String getShopLong() {return shopLong;}
	
	// setter
	public void setShopIdx(int shopIdx) {this.shopIdx = shopIdx;}
	public void setShopName(String shopName) {this.shopName = shopName;}
	public void setShopAddress(String shopAddress) {this.shopAddress = shopAddress;}
	public void setShopNumber(String shopNumber) {this.shopNumber = shopNumber;}
	public void setShopOper(String shopOper) {this.shopOper = shopOper;}
	public void setShopEnternum(int shopEnternum) {this.shopEnternum = shopEnternum;}
	public void setShopLat(String shopLat) {this.shopLat = shopLat;}
	public void setShopLong(String shopLong) {this.shopLong = shopLong;}
	public void setTotalCnt(int totalCnt) {this.totalCnt = totalCnt;}
	public void setWebAddress(String webAddress) {this.webAddress = webAddress;}

	@Override
	public String toString() {
		return "Shop [shopIdx=" + shopIdx + ", shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopNumber="
				+ shopNumber + ", shopOper=" + shopOper + ", shopEnternum=" + shopEnternum + ", shopLat=" + shopLat
				+ ", shopLong=" + shopLong + ", totalCnt=" + totalCnt + ", webAddress=" + webAddress + "]";
	};
}
