package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.model.WaitingDAO;

@Repository
public class WaitingDAOImpl implements WaitingDAO {
	@Autowired
	private SqlSession sqlsession;
	static final String NS="sql.waiting.mapper.";
	
	@Override
	public int registerWaitingBank(WaitingBank waitingBank) throws Exception {
		return sqlsession.insert(NS+"registerWaitingBank",waitingBank);
	}

	@Override
	public int registerWaitingShop(WaitingShop waitingShop) throws Exception {
		return sqlsession.insert(NS+"registerWaitingShop",waitingShop);
	}

	@Override
	public List<WaitingBank> getWaitingBank(String userId) throws Exception {
		return sqlsession.selectList(NS+"getWaitingBank",userId);
	}

	@Override
	public List<WaitingShop> getWaitingShop(String userId) throws Exception {
		return sqlsession.selectList(NS+"getWaitingShop",userId);
	}

	@Override
	public List<WaitingBank> getNowWaitingBank(String userId) throws Exception {
		return sqlsession.selectList(NS+"getNowWaitingBank",userId);
	}

	@Override
	public List<WaitingShop> getNowWaitingShop(String userId) throws Exception {
		return sqlsession.selectList(NS+"getNowWaitingShop",userId);
	}

	@Override
	public int getShopUntilMyTurn(WaitingShop waitingShop) throws Exception {
		return sqlsession.selectOne(NS+"getShopUntilMyTurn",waitingShop);
	}

	@Override
	public int getBankUntilMyTurn(WaitingBank waitingBank) throws Exception {
		return sqlsession.selectOne(NS+"getBankUntilMyTurn",waitingBank);
	}

	@Override
	public int getShopNowWaitingCnt(Shop shop) throws Exception {
		return sqlsession.selectOne(NS+"getShopNowWaitingCnt",shop);
	}

	@Override
	public int getBankNowWaitingCnt(Bank bank) throws Exception {
		return sqlsession.selectOne(NS+"getBankNowWaitingCnt",bank);
	}

	@Override
	public int updateTotalShopCnt(WaitingShop waitingShop) throws Exception {
		return sqlsession.update(NS+"updateTotalCnt",waitingShop);
	}

	@Override
	public List<WaitingShop> getAllWaitingShop() throws Exception {		
		return sqlsession.selectList(NS+"getAllShopWaiting");
	}

	@Override
	public List<WaitingBank> getAllWaitingBank() throws Exception {
		return sqlsession.selectList(NS + "getAllWaitingBank");
	}
	
	@Override
	public int deleteWaitingShop(WaitingShop waitingShop) throws Exception{
		return sqlsession.delete(NS+"deleteWaitingShop", waitingShop);
	}

	@Override
	public int deleteWaitingBank(WaitingBank waitingBank) throws Exception {
		return sqlsession.delete(NS+"deleteWaitingBank", waitingBank);// 수정
	}
}
