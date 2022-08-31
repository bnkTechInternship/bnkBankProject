package com.service.hotplace.domain.play;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;

public class LikeBank {
	private int likeIdx;
	private String userId;
	private int bankIdx;
	private Bank bank;
	private User user;

	public LikeBank() {
	}

	public LikeBank(int likeIdx, String userId, int bankIdx, Bank bank, User user) {
		super();
		this.likeIdx = likeIdx;
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.bank = bank;
		this.user = user;
	}

	public LikeBank(int likeIdx, String userId, int bankIdx) {
		super();
		this.likeIdx = likeIdx;
		this.userId = userId;
		this.bankIdx = bankIdx;
	}
	
	

	public LikeBank(String userId, int bankIdx) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
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

	public int getBankIdx() {
		return bankIdx;
	}

	public void setBankIdx(int bankIdx) {
		this.bankIdx = bankIdx;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LikeBank [likeIdx=" + likeIdx + ", userId=" + userId + ", bankIdx=" + bankIdx + ", bank=" + bank
				+ ", user=" + user + "]";
	}

}
