package com.service.hotplace.domain.play;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Shop;

public class LikeShop {
	
	private int likeIdx;
	private String userId;
	private int shopIdx;
	
	
	private User user;
	private Shop shop;

	public LikeShop() {}

	public LikeShop(int likeIdx, String userId, int shopIdx, User user, Shop shop) {
		super();
		this.likeIdx = likeIdx;
		this.userId = userId;
		this.shopIdx = shopIdx;
		this.user = user;
		this.shop = shop;
	}

	public LikeShop(int likeIdx, String userId, int shopIdx) {
		super();
		this.likeIdx = likeIdx;
		this.userId = userId;
		this.shopIdx = shopIdx;
	}
	
	

	public LikeShop(String userId, int shopIdx) {
		super();
		this.userId = userId;
		this.shopIdx = shopIdx;
	}

	public int getLikeIdx() {
		return likeIdx;
	}

	public void setLikeIdx(int likeIdx) {
		this.likeIdx = likeIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getShopIdx() {
		return shopIdx;
	}

	public void setShopIdx(int shopIdx) {
		this.shopIdx = shopIdx;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "LikeShop [likeIdx=" + likeIdx + ", userId=" + userId + ", shopIdx=" + shopIdx + ", user=" + user
				+ ", shop=" + shop + "]";
	}


}
