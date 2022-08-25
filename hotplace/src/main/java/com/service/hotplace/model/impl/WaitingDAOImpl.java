package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.model.WaitingDAO;

@Repository
public class WaitingDAOImpl implements WaitingDAO {
	static final String NS="sql.waiting.mapper.";
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int registerWaitingBank(WaitingBank waitingBank) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"registerWaitingBank",waitingBank);
	}

	@Override
	public int registerWaitingShop(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"registerWaitingShop",waitingShop);
	}

	@Override
	public List<WaitingBank> getWaitingBank(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getWaitingBank",userId);
	}

	@Override
	public List<WaitingShop> getWaitingShop(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getWaitingShop",userId);
	}

	@Override
	public WaitingBank getNowWaitingBank(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getNowWaitingBank",userId);
	}

	@Override
	public WaitingShop getNowWaitingShop(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getNowWaitingShop",userId);
	}

}
