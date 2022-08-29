package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserService userService;

	@Override
	public int registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.registerUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.updateUser(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.deleteUser(user);
	}

	@Override
	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.login(user);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userService.getUserById(userId);
	}

	@Override
	public List<User> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return userService.getUserList();
	}

	@Override
	public String findUserId(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return userService.findUserId(userEmail);
	}

	@Override
	public String findUserPw(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.findUserPw(user);
	}
	


}
