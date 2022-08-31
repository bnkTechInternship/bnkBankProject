package com.service.hotplace.domain.play;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;

public class WaitingBank {
	private String userId;
	private int bankIdx;
	private int waitingNum;
	private String waitingDate;
	
	private User user;
	private Bank bank;
	
	
	public WaitingBank() {}


	public WaitingBank(String userId, int bankIdx, int waitingNum, String waitingDate, User user,
			Bank bank) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingNum = waitingNum;
		this.waitingDate = waitingDate;
		this.user = user;
		this.bank = bank;
	}
	
	
	
	


	public WaitingBank(String userId, int bankIdx, int waitingNum) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingNum = waitingNum;
	}


	public WaitingBank(String userId, int bankIdx) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
	}


	public WaitingBank(String userId, int bankIdx, int waitingNum, String waitingDate) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingNum = waitingNum;
		this.waitingDate = waitingDate;
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


	public int getWaitingNum() {
		return waitingNum;
	}


	public void setWaitingNum(int waitingNum) {
		this.waitingNum = waitingNum;
	}


	public String getWaitingDate() {
		return waitingDate;
	}


	public void setWaitingDate(String waitingDate) {
		this.waitingDate = waitingDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	@Override
	public String toString() {
		return "WaitingBank [userId=" + userId + ", bankIdx=" + bankIdx + ", waitingNum=" + waitingNum
				+ ", waitingDate=" + waitingDate + ", user=" + user + ", bank=" + bank
				+ "]";
	}
	
	



}
