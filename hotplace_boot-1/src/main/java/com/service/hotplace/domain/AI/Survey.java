package com.service.hotplace.domain.AI;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Shop;

public class Survey {	
	private String userId;
	private int age;
	private int maritalStatus;
	private int nFamily;
	private int generType;
	private int educ;
	private int job;
	private int ecMeantime;
	private int ecType;
	private int eatoutFreq;
	
	private User user;
	
	public Survey() {}
	
	public Survey(String userId, int age, int maritalStatus, int nFamily, int generType, int educ, int job,
			int ecMeantime, int ecType, int eatoutFreq, User user) {
		super();
		this.userId = userId;
		this.age = age;
		this.maritalStatus = maritalStatus;
		this.nFamily = nFamily;
		this.generType = generType;
		this.educ = educ;
		this.job = job;
		this.ecMeantime = ecMeantime;
		this.ecType = ecType;
		this.eatoutFreq = eatoutFreq;
		this.user = user;
	}

	public Survey(String userId, int age, int maritalStatus, int nFamily, int generType, int educ, int job,
			int ecMeantime, int ecType, int eatoutFreq) {
		super();
		this.userId = userId;
		this.age = age;
		this.maritalStatus = maritalStatus;
		this.nFamily = nFamily;
		this.generType = generType;
		this.educ = educ;
		this.job = job;
		this.ecMeantime = ecMeantime;
		this.ecType = ecType;
		this.eatoutFreq = eatoutFreq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getnFamily() {
		return nFamily;
	}

	public void setnFamily(int nFamily) {
		this.nFamily = nFamily;
	}

	public int getGenerType() {
		return generType;
	}

	public void setGenerType(int generType) {
		this.generType = generType;
	}

	public int getEduc() {
		return educ;
	}

	public void setEduc(int educ) {
		this.educ = educ;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}

	public int getEcMeantime() {
		return ecMeantime;
	}

	public void setEcMeantime(int ecMeantime) {
		this.ecMeantime = ecMeantime;
	}

	public int getEcType() {
		return ecType;
	}

	public void setEcType(int ecType) {
		this.ecType = ecType;
	}

	public int getEatoutFreq() {
		return eatoutFreq;
	}

	public void setEatoutFreq(int eatoutFreq) {
		this.eatoutFreq = eatoutFreq;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Survey [userId=" + userId + ", age=" + age + ", maritalStatus=" + maritalStatus + ", nFamily=" + nFamily
				+ ", generType=" + generType + ", educ=" + educ + ", job=" + job + ", ecMeantime=" + ecMeantime
				+ ", ecType=" + ecType + ", eatoutFreq=" + eatoutFreq + ", user=" + user + "]";
	}
	
}
