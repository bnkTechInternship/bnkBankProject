package com.service.hotplace.domain.play;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;

public class WaitingBank {
	private String userId;
	private int bankIdx;
	private int waitingNum;
	private String waitingDate;
	private int waitingCnt;
	
	private User user;
	private Bank bank;
	
	
	public WaitingBank() {}


	public WaitingBank(String userId, int bankIdx, int waitingNum, String waitingDate, int waitingCnt, User user,
			Bank bank) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingNum = waitingNum;
		this.waitingDate = waitingDate;
		this.waitingCnt = waitingCnt;
		this.user = user;
		this.bank = bank;
	}
	
	
	
	


	public WaitingBank(String userId, int bankIdx, int waitingNum, int waitingCnt) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingNum = waitingNum;
		this.waitingCnt = waitingCnt;
	}


	public WaitingBank(String userId, int bankIdx, int waitingCnt) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingCnt = waitingCnt;
	}


	public WaitingBank(String userId, int bankIdx, int waitingNum, String waitingDate, int waitingCnt) {
		super();
		this.userId = userId;
		this.bankIdx = bankIdx;
		this.waitingNum = waitingNum;
		this.waitingDate = waitingDate;
		this.waitingCnt = waitingCnt;
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


	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	@Override
	public String toString() {
		return "WaitingBank [userId=" + userId + ", bankIdx=" + bankIdx + ", waitingNum=" + waitingNum
				+ ", waitingDate=" + waitingDate + ", waitingCnt=" + waitingCnt + ", user=" + user + ", bank=" + bank
				+ "]";
	}
	
	



}
