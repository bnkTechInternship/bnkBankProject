package com.service.hotplace.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.model.WaitingDAO;
import com.service.hotplace.service.WaitingService;

@Service
public class WaitingServiceImpl implements WaitingService{
	@Autowired
	private WaitingDAO waitingDAO;

	@Override
	public int registerWaitingBank(WaitingBank waitingBank) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.registerWaitingBank(waitingBank);
	}

	@Override
	public int registerWaitingShop(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.registerWaitingShop(waitingShop);
	}

	@Override
	public List<WaitingBank> getWaitingBank(User user) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.getWaitingBank(user.getUserId());
	}

	@Override
	public ArrayList<ArrayList<WaitingShop>> getWaitingShop(User user) throws Exception {
		List<WaitingShop> wslist= waitingDAO.getWaitingShop(user.getUserId());
		ArrayList<ArrayList<WaitingShop>> returnlist = new ArrayList<ArrayList<WaitingShop>>();
		
		int currShopIdx = wslist.get(0).getShopIdx();
		ArrayList<WaitingShop> tmp = new ArrayList<WaitingShop>();
		for(WaitingShop ws : wslist) {
			if(ws.getShopIdx() == currShopIdx) {
				System.out.println("샵번호 같아 tmp에 삽입함");
				tmp.add(ws);
			}else {
				returnlist.add(tmp);
				tmp.clear();
				currShopIdx = ws.getShopIdx();
				tmp.add(ws);
			}
		}
		returnlist.add(tmp);
		return returnlist;
	}

	@Override
	public WaitingBank getNowWaitingBank(User user) throws Exception {
		// TODO Auto-generated method stub
		List<WaitingBank> relist = waitingDAO.getNowWaitingBank(user.getUserId());
		for(WaitingBank wb : relist) {
			if( wb.getWaitingNum() - wb.getBank().getBankEnternum() >=0)
				return wb;
		}
		return null;
		
	}

	@Override
	public ArrayList<WaitingShop> getNowWaitingShop(User user) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<WaitingShop> returnlist = new ArrayList<WaitingShop>();
		
		List<WaitingShop> relist = waitingDAO.getNowWaitingShop(user.getUserId());
		for(WaitingShop ws : relist) {
			if( ws.getWaitingNum() - ws.getShop().getShopEnternum() >=0)
				returnlist.add(ws);
		}
		if(returnlist.isEmpty()) return null;
		return returnlist;
	}

	@Override
	public int getShopUntilMyTurn(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.getShopUntilMyTurn(waitingShop);
	}

	@Override
	public int getBankUntilMyTurn(WaitingBank waitingBank) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.getBankUntilMyTurn(waitingBank);
	}

	@Override
	public int getShopNowWaitingCnt(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("서비스 함수 호출:::::::::"+waitingDAO.getShopNowWaitingCnt(shop));
		return waitingDAO.getShopNowWaitingCnt(shop);
	}

	@Override
	public int getBankNowWaitingCnt(Bank bank) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.getBankNowWaitingCnt(bank);
	}

	@Override
	public int updateTotalShopCnt(WaitingShop waitingShop) throws Exception {
		// TODO Auto-generated method stub
		return waitingDAO.updateTotalShopCnt(waitingShop);
	}

	@Override
	public List<Integer> getPartNowWaitingCnt(int idx) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(idx);
		for(int i=idx ; i<idx+3; i++) {
			Shop shop = new Shop();
			shop.setShopIdx(i);
			System.out.println("=================================서비스임플 포문 안");
			int cnt = getShopNowWaitingCnt(shop);
			System.out.println("=================================서비스임플 출력값"+cnt);
			list.add(cnt);
		}
		return list;
	}

}
