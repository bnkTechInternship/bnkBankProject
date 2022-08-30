package com.service.hotplace.domain.place;

public class Menu {
	private int menuIdx;
	private String menuName;
	private int menuPrice;
	private int shopIdx;
	
	private Shop shop;
	
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

	public int getMenuIdx() {
		return menuIdx;
	}

	public void setMenuIdx(int menuIdx) {
		this.menuIdx = menuIdx;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getShopIdx() {
		return shopIdx;
	}

	public void setShopIdx(int shopIdx) {
		this.shopIdx = shopIdx;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Menu [menuIdx=" + menuIdx + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", shopIdx="
				+ shopIdx + ", shop=" + shop + "]";
	}
	
	

	

}
