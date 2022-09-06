package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.person.User;

public interface UserDAO {
	// create
	int registerUser(User user)throws Exception;
	
	// read
	List<User> getUserList()throws Exception;
	
	String findUserId(String userEmail)throws Exception;
	String findUserPw(User user)throws Exception;
	String isIdExist(String userId) throws Exception;	
	
	User login(User user) throws Exception;
	User getUserById(String userId)throws Exception;
		
	// update
	int updateUser(User user)throws Exception;
	int withDrawMoney(User user) throws Exception; // 유저 돈 차감
		
	// delete
	int deleteUser(String userId)throws Exception;
}
