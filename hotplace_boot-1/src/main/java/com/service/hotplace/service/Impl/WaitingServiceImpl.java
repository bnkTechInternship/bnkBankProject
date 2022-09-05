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
	public HashMap<Integer, ArrayList<WaitingShop>> getWaitingShop(User user) throws Exception {
		List<WaitingShop> wslist= waitingDAO.getWaitingShop(user.getUserId());
		
		wslist.get(0).getShopIdx();
		wslist.get(0).getMenuIdx();
		
		//ArrayList<ArrayList<WaitingShop>> returnlist = new ArrayList<ArrayList<WaitingShop>>();
		
		int currShopIdx = wslist.get(0).getShopIdx();
	//	ArrayList<WaitingShop> tmp = new ArrayList<WaitingShop>();
		//System.out.println(wslist);
		
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
		
		
		
		
		
		
//		tmp.add(wslist.get(0)); // 같은거끼리 묶을 1차원배열
//		
//		for(int i=1; i<wslist.size(); i++) {
//			if(tmp.get(0).getShopIdx() == wslist.get(i).getShopIdx()) {
//				tmp.add(wslist.get(i));
//
//			}else {
//				ArrayList<WaitingShop> tmp2 = new ArrayList<WaitingShop>();
//				tmp2 = tmp;
//				returnlist.add(new);
//				System.out.println(returnlist);
//				tmp.clear();
//				tmp.add(wslist.get(i));
//			}
//			
//		}
//		returnlist.add(tmp);
		
		
//		for(WaitingShop ws : wslist) {
//			System.out.println(ws);
//			if(ws.getShopIdx() == currShopIdx) {
//				System.out.println("샵번호 같아 tmp에 삽입함");
//				tmp.add(ws);
//			}else {
//				returnlist.add(tmp);
//				tmp.clear();
//				currShopIdx = ws.getShopIdx();
//				tmp.add(ws);
//			}
//		}
//		returnlist.add(tmp);
		

		return hash;
	}

	@Override
	public WaitingBank getNowWaitingBank(User user) throws Exception {
		// TODO Auto-generated method stub
		List<WaitingBank> relist = waitingDAO.getWaitingBank(user.getUserId());
		for(WaitingBank wb : relist) {
			Bank bank = BankService.getBank(wb.getBankIdx());
			if( wb.getWaitingNum() - bank.getBankEnternum() >=0)
				return wb;
		}
		return null;
		
	}

	@Override
	public ArrayList<WaitingShop> getNowWaitingShop(User user) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<WaitingShop> returnlist = new ArrayList<WaitingShop>();
		
		List<WaitingShop> relist = waitingDAO.getWaitingShop(user.getUserId());
		for(WaitingShop ws : relist) {
			Shop shop = shopservice.getShop(ws.getShopIdx());
			if( ws.getWaitingNum() - shop.getShopEnternum() >=0) {
				ws.setShop(shop);
				returnlist.add(ws);
			}
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
			//System.out.println("=================================서비스임플 포문 안");
			int cnt = getShopNowWaitingCnt(shop);
			//System.out.println("=================================서비스임플 출력값"+cnt);
			list.add(cnt);
		}
		return list;
	}

	@Override
	public List<WaitingShop> getAllWaitingShop() throws Exception {
		return waitingDAO.getAllWaitingShop();
	}

}
