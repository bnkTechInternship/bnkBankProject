package com.service.hotplace.domain.person;

public class User {
	// fields
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userAddress;
	private String userNumber;
	private int userBalance;
	private int userPoint;
	private String registerDate;
	private String userGroup;
	
	// constructors
	public User() {}
	public User(String userId, String userPw, String userName, String userEmail, String userAddress, String userNumber,
			int userBalance, int userPoint, String registerDate, String userGroup) {
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
		this.userGroup = userGroup;
	}
	public User(String userId, String userPw, String userName, String userEmail, String userAddress, String userNumber,
			int userBalance, int userPoint, String userGroup) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userNumber = userNumber;
		this.userBalance = userBalance;
		this.userPoint = userPoint;
		this.userGroup = userGroup;
	}

	// getter
	public String getUserId() {	return userId; }
	public String getUserPw() {	return userPw;}
	public String getUserName() {return userName;}
	public String getUserEmail() {return userEmail;}
	public String getUserAddress() {return userAddress;}
	public String getUserNumber() {	return userNumber;}
	public int getUserBalance() {return userBalance;}
	public int getUserPoint() {	return userPoint;}
	public String getRegisterDate() {return registerDate;}
	public String getUserGroup() {return userGroup;}
	
	// setter
	public void setUserId(String userId) {this.userId = userId;	}
	public void setUserPw(String userPw) {this.userPw = userPw;	}
	public void setUserName(String userName) {this.userName = userName;}
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
	public void setUserAddress(String userAddress) {this.userAddress = userAddress;}
	public void setUserNumber(String userNumber) {this.userNumber = userNumber;}
	public void setUserBalance(int userBalance) {this.userBalance = userBalance;}
	public void setUserPoint(int userPoint) {this.userPoint = userPoint;}
	public void setRegisterDate(String registerDate) {this.registerDate = registerDate;}
	public void setUserGroup(String userGroup) {this.userGroup = userGroup;}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", userNumber=" + userNumber + ", userBalance=" + userBalance
				+ ", userPoint=" + userPoint + ", registerDate=" + registerDate + ", userGroup=" + userGroup + "]";
	};
}
