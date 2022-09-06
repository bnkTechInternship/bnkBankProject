package com.service.hotplace.domain.place;

public class Menu {
	// fields
	private int menuIdx;
	private String menuName;
	private int menuPrice;
	private int shopIdx;
	private Shop shop;

	// constructors
	public Menu() {}
	public Menu(int menuIdx, String menuName, int menuPrice, int shopIdx, Shop shop) {
		super();
		this.menuIdx = menuIdx;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.shopIdx = shopIdx;
		this.shop = shop;
	}
	public Menu(int menuIdx, String menuName, int menuPrice, int shopIdx) {
		super();
		this.menuIdx = menuIdx;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.shopIdx = shopIdx;
	}
	public Menu(String menuName, int menuPrice, int shopIdx) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.shopIdx = shopIdx;
	}

	// getter
	public int getMenuIdx() {return menuIdx;}
	public String getMenuName() {return menuName;}
	public int getMenuPrice() {return menuPrice;}
	public int getShopIdx() {return shopIdx;}
	public Shop getShop() {return shop;}
	
	// setter
	public void setMenuIdx(int menuIdx) {this.menuIdx = menuIdx;}
	public void setMenuName(String menuName) {this.menuName = menuName;}
	public void setMenuPrice(int menuPrice) {this.menuPrice = menuPrice;}
	public void setShopIdx(int shopIdx) {this.shopIdx = shopIdx;}
	public void setShop(Shop shop) {this.shop = shop;}

	@Override
	public String toString() {
		return "Menu [menuIdx=" + menuIdx + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", shopIdx="
				+ shopIdx + ", shop=" + shop + "]";
	}
}
