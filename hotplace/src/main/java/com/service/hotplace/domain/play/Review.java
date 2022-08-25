package com.service.hotplace.domain.play;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Shop;

public class Review {
	private String userId;
	private int shopIdx;
	private double score;
	private String comm;
	
	private Shop shop;
	private User user;
	
	
	
	public Review() {}



	public Review(String userId, int shopIdx, double score, String comm, Shop shop, User user) {
		super();
		this.userId = userId;
		this.shopIdx = shopIdx;
		this.score = score;
		this.comm = comm;
		this.shop = shop;
		this.user = user;
	}



	public Review(String userId, int shopIdx, double score, String comm) {
		super();
		this.userId = userId;
		this.shopIdx = shopIdx;
		this.score = score;
		this.comm = comm;
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



	public double getScore() {
		return score;
	}



	public void setScore(double score) {
		this.score = score;
	}



	public String getComm() {
		return comm;
	}



	public void setComm(String comm) {
		this.comm = comm;
	}



	public Shop getShop() {
		return shop;
	}



	public void setShop(Shop shop) {
		this.shop = shop;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Review [userId=" + userId + ", shopIdx=" + shopIdx + ", score=" + score + ", comm=" + comm + ", shop="
				+ shop + ", user=" + user + "]";
	}
	
	

	

}
