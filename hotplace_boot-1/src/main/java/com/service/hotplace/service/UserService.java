package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;

public interface UserService {
	// create
	int registerUser(User user)throws Exception;
	
	// read
	List<User> getUserList()throws Exception;
	
	User login(User user) throws Exception;
	User getUserById(String userId)throws Exception;
	
	String findUserId(String userEmail)throws Exception;
	String findUserPw(User user)throws Exception;
	boolean isIdExist(String userId) throws Exception;
		
	// update
	int updateUser(User user)throws Exception;
	void withDrawMoney(User user) throws Exception;
	void depositMoney(User user) throws Exception;  // 유저 돈 증가

		
	// delete
	int deleteUser(String userId)throws Exception;
}
