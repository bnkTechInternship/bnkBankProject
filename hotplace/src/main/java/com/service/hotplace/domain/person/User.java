package com.service.hotplace.domain.person;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userAddress;
	private String userNumber;
	private int userBalance;
	private int userPoint;
	private String registerDate;
	
	public User() {};
	public User(String userId, String userPw, String userName, String userEmail, String userAddress, String userNumber,
			int userBalance, int userPoint, String registerDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userNumber = userNumber;
		this.userBalance = userBalance;
		this.userPoint = userPoint;
		this.registerDate = registerDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", userNumber=" + userNumber + ", userBalance=" + userBalance
				+ ", userPoint=" + userPoint + ", registerDate=" + registerDate + "]";
	}
	
	
	

}
