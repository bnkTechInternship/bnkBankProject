package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.model.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSession sqlsession;
	static final String NS="sql.hotplace.mapper.";

	@Override
	public int registerUser(User user) throws Exception {
		return sqlsession.insert(NS+"registerUser",user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return sqlsession.update(NS+"updateUser",user);
	}

	@Override
	public int deleteUser(String userId) throws Exception {
		return sqlsession.delete(NS+"deleteUser",userId);
	}

	@Override
	public User login(User user) throws Exception {
		return sqlsession.selectOne(NS+"login",user);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		return sqlsession.selectOne(NS+"getUserById",userId);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return sqlsession.selectList(NS+"getUserList");
	}

	@Override
	public String findUserId(String userEmail) throws Exception {
		return sqlsession.selectOne(NS+"findUserId",userEmail);
	}

	@Override
	public String findUserPw(User user) throws Exception {
		return sqlsession.selectOne(NS+"findUserPw",user);
	}

	@Override
	public String isIdExist(String userId) throws Exception {
		return sqlsession.selectOne(NS+"isIdExist",userId);
	}

	@Override
	public int withDrawMoney(User user) throws Exception {
		return sqlsession.update(NS + "withDrawMoney",user);
	}

	@Override
	public int depositMoney(User user) throws Exception {		
		return sqlsession.update(NS + "depositMoney",user);
	}
}
