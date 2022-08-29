package com.service.hotplace.domain.place;

public class Bank {
	private int bankIdx;
	private String bankName;
	private String bankAddress;
	private String bankNumber;
	private String bankOper;
	private int bankEnternum;
	private String bankLat;
	private String bankLong;
	
	

	public Bank() {}



	public Bank(int bankIdx, String bankName, String bankAddress, String bankNumber, String bankOper, int bankEnternum,
			String bankLat, String bankLong) {
		super();
		this.bankIdx = bankIdx;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.bankNumber = bankNumber;
		this.bankOper = bankOper;
		this.bankEnternum = bankEnternum;
		this.bankLat = bankLat;
		this.bankLong = bankLong;
	}



	public int getBankIdx() {
		return bankIdx;
	}



	public void setBankIdx(int bankIdx) {
		this.bankIdx = bankIdx;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getBankAddress() {
		return bankAddress;
	}



	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}



	public String getBankNumber() {
		return bankNumber;
	}



	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}



	public String getBankOper() {
		return bankOper;
	}



	public void setBankOper(String bankOper) {
		this.bankOper = bankOper;
	}



	public int getBankEnternum() {
		return bankEnternum;
	}



	public void setBankEnternum(int bankEnternum) {
		this.bankEnternum = bankEnternum;
	}



	public String getBankLat() {
		return bankLat;
	}



	public void setBankLat(String bankLat) {
		this.bankLat = bankLat;
	}



	public String getBankLong() {
		return bankLong;
	}



	public void setBankLong(String bankLong) {
		this.bankLong = bankLong;
	}



	@Override
	public String toString() {
		return "Bank [bankIdx=" + bankIdx + ", bankName=" + bankName + ", bankAddress=" + bankAddress + ", bankNumber="
				+ bankNumber + ", bankOper=" + bankOper + ", bankEnternum=" + bankEnternum + ", bankLat=" + bankLat
				+ ", bankLong=" + bankLong + "]";
	};
	
	
	
	

}
