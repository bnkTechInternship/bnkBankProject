package com.service.hotplace.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;

public interface WaitingService {
	//줄서기
	int registerWaitingBank(WaitingBank waitingBank) throws Exception;
	int registerWaitingShop(WaitingShop waitingShop) throws Exception;
	
	//이용내역 불러오기
	List<WaitingBank> getWaitingBank(User user) throws Exception;
	HashMap<Integer, ArrayList<WaitingShop>> getWaitingShop(User user) throws Exception;
	
	//현재 줄서기 정보 ( 있으면 객체반환, 없으면 null반환
	WaitingBank getNowWaitingBank(User user) throws Exception;
	ArrayList<WaitingShop> getNowWaitingShop(User user) throws Exception;
	List<WaitingShop>getAllWaitingShop() throws Exception;
	
	//현재 줄서고 있는 가게 내 앞에 몇팀남았는지
	int getShopUntilMyTurn(WaitingShop waitingShop) throws Exception;
	int getBankUntilMyTurn(WaitingBank waitingBank) throws Exception;
	
	//가게별 현재 대기팀수
	int getShopNowWaitingCnt(Shop shop) throws Exception;
	int getBankNowWaitingCnt(Bank bank) throws Exception;
	
	//가게별 누적인원업데이트
	int updateTotalShopCnt(WaitingShop waitingShop) throws Exception;
	
	List<Integer> getPartNowWaitingCnt(int idx) throws Exception;
	
	
	

}
