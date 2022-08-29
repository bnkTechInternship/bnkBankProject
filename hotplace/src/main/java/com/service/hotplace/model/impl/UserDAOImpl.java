package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.model.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	static final String NS="sql.hotplace.mapper.";
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"registerUser",user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(NS+"updateUser",user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(NS+"deleteUser",user);
	}

	@Override
	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"login",user);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getUserById",userId);
	}

	@Override
	public List<User> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getUserList");
	}

	@Override
	public String findUserId(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getUserId",userEmail);
	}

	@Override
	public String findUserPw(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getUserPw",user);
	}
	
	
}
