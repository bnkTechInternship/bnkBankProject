package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.model.UserDAO;
import com.service.hotplace.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserDAO userDAO;

	@Override
	public int registerUser(User user) throws Exception {
		return userDAO.registerUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userDAO.updateUser(user);
	}

	@Override
	public int deleteUser(String userId) throws Exception {
		return userDAO.deleteUser(userId);
	}

	@Override
	public User login(User user) throws Exception {
		return userDAO.login(user);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		return userDAO.getUserById(userId);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return userDAO.getUserList();
	}

	@Override
	public String findUserId(String userEmail) throws Exception {
		return userDAO.findUserId(userEmail);
	}

	@Override
	public String findUserPw(User user) throws Exception {
		return userDAO.findUserPw(user);
	}

	@Override
	public boolean isIdExist(String userId) throws Exception {
		boolean exist = false;
		if(userDAO.isIdExist(userId) != null) exist=true;
		return exist;
	}

	@Override
	public void withDrawMoney(User user) throws Exception {
		userDAO.withDrawMoney(user);
	}

	@Override
	public void depositMoney(User user) throws Exception {
		userDAO.depositMoney(user);
	}
}
