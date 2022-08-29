package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.service.WaitingService;

@Service
public class WaitingServiceImpl implements WaitingService{
	@Autowired
	private WaitingService waitingService;

	@Override
	public int registerWaitingBank(WaitingBank waitingBank) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.registerWaitingBank(waitingBank);
	}

	@Override
	public int registerWaitingShop(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.registerWaitingShop(waitingShop);
	}

	@Override
	public List<WaitingBank> getWaitingBank(User user) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getWaitingBank(user);
	}

	@Override
	public List<WaitingShop> getWaitingShop(User user) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getWaitingShop(user);
	}

	@Override
	public WaitingBank getNowWaitingBank(User user) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getNowWaitingBank(user);
	}

	@Override
	public WaitingShop getNowWaitingShop(User user) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getNowWaitingShop(user);
	}

	@Override
	public int getShopUntilMyTurn(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getShopUntilMyTurn(waitingShop);
	}

	@Override
	public int getBankUntilMyTurn(WaitingBank waitingBank) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getBankUntilMyTurn(waitingBank);
	}

	@Override
	public int getShopNowWaitingCnt(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getShopNowWaitingCnt(waitingShop);
	}

	@Override
	public int getBankNowWaitingCnt(WaitingBank waitingBank) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.getBankNowWaitingCnt(waitingBank);
	}

	@Override
	public int updateTotalShopCnt(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingService.updateTotalShopCnt(waitingShop);
	}

}
