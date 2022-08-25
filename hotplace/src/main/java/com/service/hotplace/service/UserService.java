package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;

public interface UserService {
	int registerUser(User user)throws Exception;
	int updateUser(User user)throws Exception;
	
	User login(User user) throws Exception;
	User getUserById(String userId)throws Exception;
	List<User> getUserList()throws Exception;
	
	String getUserId(String userEmail)throws Exception;
	String getUserPw(User user)throws Exception;

}
