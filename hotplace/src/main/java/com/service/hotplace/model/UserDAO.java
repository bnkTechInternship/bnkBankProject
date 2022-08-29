package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.person.User;

public interface UserDAO {
	int registerUser(User user)throws Exception;
	int updateUser(User user)throws Exception;
	int deleteUser(User user)throws Exception;
	User login(User user) throws Exception;
	User getUserById(String userId)throws Exception;
	List<User> getUserList()throws Exception;
	
	String findUserId(String userEmail)throws Exception;
	String findUserPw(User user)throws Exception;
}
