package com.service.hotplace.domain.play;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;

public class WaitingShop {
	private String userId;
	private int menuIdx;
	private int shopIdx;
	private int waitingNum;
	private int quantity;
	private String waitingDate;
	private int waitingCnt;
	
	
	private User user;
	private Menu menu;
	private Shop shop;
	

	public WaitingShop() {}

	
	
	

	public WaitingShop(String userId, int menuIdx, int shopIdx, int quantity, int waitingCnt) {
		super();
		this.userId = userId;
		this.menuIdx = menuIdx;
		this.shopIdx = shopIdx;
		this.quantity = quantity;
		this.waitingCnt = waitingCnt;
	}





	public WaitingShop(String userId, int menuIdx, int shopIdx, int waitingNum, int quantity, String waitingDate,
			int waitingCnt, User user, Menu menu, Shop shop) {
		super();
		this.userId = userId;
		this.menuIdx = menuIdx;
		this.shopIdx = shopIdx;
		this.waitingNum = waitingNum;
		this.quantity = quantity;
		this.waitingDate = waitingDate;
		this.waitingCnt = waitingCnt;
		this.user = user;
		this.menu = menu;
		this.shop = shop;
	}


	public WaitingShop(String userId, int menuIdx, int shopIdx, int waitingNum, int quantity, int waitingCnt) {
		super();
		this.userId = userId;
		this.menuIdx = menuIdx;
		this.shopIdx = shopIdx;
		this.waitingNum = waitingNum;
		this.quantity = quantity;
		this.waitingCnt = waitingCnt;
	}


	public WaitingShop(String userId, int menuIdx, int shopIdx, int waitingNum, int quantity, String waitingDate,
			int waitingCnt) {
		super();
		this.userId = userId;
		this.menuIdx = menuIdx;
		this.shopIdx = shopIdx;
		this.waitingNum = waitingNum;
		this.quantity = quantity;
		this.waitingDate = waitingDate;
		this.waitingCnt = waitingCnt;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getMenuIdx() {
		return menuIdx;
	}


	public void setMenuIdx(int menuIdx) {
		this.menuIdx = menuIdx;
	}


	public int getShopIdx() {
		return shopIdx;
	}


	public void setShopIdx(int shopIdx) {
		this.shopIdx = shopIdx;
	}


	public int getWaitingNum() {
		return waitingNum;
	}


	public void setWaitingNum(int waitingNum) {
		this.waitingNum = waitingNum;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getWaitingDate() {
		return waitingDate;
	}


	public void setWaitingDate(String waitingDate) {
		this.waitingDate = waitingDate;
	}


	public int getWaitingCnt() {
		return waitingCnt;
	}


	public void setWaitingCnt(int waitingCnt) {
		this.waitingCnt = waitingCnt;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	@Override
	public String toString() {
		return "WaitingShop [userId=" + userId + ", menuIdx=" + menuIdx + ", shopIdx=" + shopIdx + ", waitingNum="
				+ waitingNum + ", quantity=" + quantity + ", waitingDate=" + waitingDate + ", waitingCnt=" + waitingCnt
				+ ", user=" + user + ", menu=" + menu + ", shop=" + shop + "]";
	}

}
