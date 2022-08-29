package com.service.hotplace.domain.place;

public class Shop {
	private int shopIdx;
	private String shopName;
	private String shopAddress;
	private String shopNumber;
	private String shopOper;
	private int shopEnternum;
	private String shopLat;
	private String shopLong;
	private int totalCnt;
	private String web_address;
	
	public Shop() {}

	public Shop(int shopIdx, String shopName, String shopAddress, String shopNumber, String shopOper, int shopEnternum,
			String shopLat, String shopLong, int totalCnt, String web_address) {
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
		this.web_address = web_address;
	}

	public int getShopIdx() {
		return shopIdx;
	}

	public void setShopIdx(int shopIdx) {
		this.shopIdx = shopIdx;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getShopOper() {
		return shopOper;
	}

	public void setShopOper(String shopOper) {
		this.shopOper = shopOper;
	}

	public int getShopEnternum() {
		return shopEnternum;
	}

	public void setShopEnternum(int shopEnternum) {
		this.shopEnternum = shopEnternum;
	}

	public String getShopLat() {
		return shopLat;
	}

	public void setShopLat(String shopLat) {
		this.shopLat = shopLat;
	}

	public String getShopLong() {
		return shopLong;
	}

	public void setShopLong(String shopLong) {
		this.shopLong = shopLong;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public String getWeb_address() {
		return web_address;
	}

	public void setWeb_address(String web_address) {
		this.web_address = web_address;
	}

	@Override
	public String toString() {
		return "Shop [shopIdx=" + shopIdx + ", shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopNumber="
				+ shopNumber + ", shopOper=" + shopOper + ", shopEnternum=" + shopEnternum + ", shopLat=" + shopLat
				+ ", shopLong=" + shopLong + ", totalCnt=" + totalCnt + ", web_address=" + web_address + "]";
	};
	

}
