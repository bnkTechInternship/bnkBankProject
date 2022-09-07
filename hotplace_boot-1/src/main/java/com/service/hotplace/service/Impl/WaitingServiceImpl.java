package com.service.hotplace.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.WaitingService;

@Service
public class WaitingServiceImpl implements WaitingService{
	@Autowired
	private WaitingDAO waitingDAO;
	
	@Autowired
	private ShopService shopservice;
	
	@Autowired
	private BankService BankService;

	@Override
	public int registerWaitingBank(WaitingBank waitingBank) throws Exception {
		return waitingDAO.registerWaitingBank(waitingBank);
	}

	@Override
	public int registerWaitingShop(WaitingShop waitingShop) throws Exception {
		return waitingDAO.registerWaitingShop(waitingShop);
	}

	@Override
	public List<WaitingBank> getWaitingBank(User user) throws Exception {
		return waitingDAO.getWaitingBank(user.getUserId());
	}

	@Override
	public HashMap<Integer, ArrayList<WaitingShop>> getWaitingShop(User user) throws Exception {
		List<WaitingShop> wslist= waitingDAO.getWaitingShop(user.getUserId());
		wslist.get(0).getShopIdx();
		wslist.get(0).getMenuIdx();
		int currShopIdx = wslist.get(0).getShopIdx();
		HashMap<Integer, ArrayList<WaitingShop>> hash = new HashMap<>();
		
		for(int i = 0 ; i < wslist.size(); i++) {
			if(hash.containsKey(wslist.get(i).getShopIdx())) {
				hash.get(wslist.get(i).getShopIdx()).add(wslist.get(i));
			} else {
				ArrayList<WaitingShop>temp = new ArrayList<WaitingShop>();
				temp.add(wslist.get(i));
				hash.put(wslist.get(i).getShopIdx(),temp);
			}
		}

		return hash;
	}

	@Override
	public WaitingBank getNowWaitingBank(User user) throws Exception {
		System.out.println("=======servcie:: getNowWaitingBank");
		List<WaitingBank> relist = waitingDAO.getWaitingBank(user.getUserId());
		
		System.out.println(relist);
		for(WaitingBank wb : relist) {
			Bank bank = BankService.getBank(wb.getBankIdx());
			if( wb.getWaitingNum() - bank.getBankEnternum() >=0) {
				return wb;
			}
				}
		return null;
	}

	@Override
	public ArrayList<WaitingShop> getNowWaitingShop(User user) throws Exception {
		ArrayList<WaitingShop> returnlist = new ArrayList<WaitingShop>();
		List<WaitingShop> relist = waitingDAO.getWaitingShop(user.getUserId());
		
		for(WaitingShop ws : relist) { // 아 이거 현재 입장 번호가 가게의 입장번호보다 높아야 뜨는거였음 바보 멍청이 김근영....
			Shop shop = shopservice.getShop(ws.getShopIdx());
			if( ws.getWaitingNum() - shop.getShopEnternum() >=0) {
				ws.setShop(shop);
				returnlist.add(ws);
			}
		}
		
		if(returnlist.isEmpty()) 
			return null;
		return returnlist;
	}

	@Override
	public int getShopUntilMyTurn(WaitingShop waitingShop) throws Exception {
		return waitingDAO.getShopUntilMyTurn(waitingShop);
	}

	@Override
	public int getBankUntilMyTurn(WaitingBank waitingBank) throws Exception {
		return waitingDAO.getBankUntilMyTurn(waitingBank);
	}

	@Override
	public int getShopNowWaitingCnt(Shop shop) throws Exception {
		return waitingDAO.getShopNowWaitingCnt(shop);
	}

	@Override
	public int getBankNowWaitingCnt(Bank bank) throws Exception {
		return waitingDAO.getBankNowWaitingCnt(bank);
	}

	@Override
	public int updateTotalShopCnt(WaitingShop waitingShop) throws Exception {
		return waitingDAO.updateTotalShopCnt(waitingShop);
	}

	@Override
	public List<Integer> getPartNowWaitingCnt(int idx) throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=idx ; i<idx+3; i++) {
			Shop shop = new Shop();
			shop.setShopIdx(i);
			int cnt = getShopNowWaitingCnt(shop);
			list.add(cnt);
		}
		return list;
	}

	@Override
	public List<WaitingShop> getAllWaitingShop() throws Exception {
		return waitingDAO.getAllWaitingShop();
	}

	@Override
	public List<WaitingBank> getAllWaitingBank() throws Exception {
		return waitingDAO.getAllWaitingBank();
	}

	@Override
	public int deleteWaitingShop(WaitingShop waitingShop) throws Exception {
		return waitingDAO.deleteWaitingShop(waitingShop);
	}
	
	@Override
	public int deleteWaitingBank(WaitingBank waitingBank) throws Exception {
		return waitingDAO.deleteWaitingBank(waitingBank);
	}
}
