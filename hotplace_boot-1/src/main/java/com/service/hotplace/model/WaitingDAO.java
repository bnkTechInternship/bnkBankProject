package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;

public interface WaitingDAO {
	
	//줄서기 Shop/Bank테이블에 totalCnt도 같이 업데이트 되어야함
	int registerWaitingBank(WaitingBank waitingBank) throws Exception;
	int registerWaitingShop(WaitingShop waitingShop) throws Exception;
	
	//이용내역 불러오기
	List<WaitingBank> getWaitingBank(String userId) throws Exception;
	List<WaitingShop> getWaitingShop(String userId) throws Exception;
	List<WaitingShop> getAllWaitingShop() throws Exception;
	
	//현재 줄서기 정보
	List<WaitingBank> getNowWaitingBank(String userId) throws Exception;
	List<WaitingShop> getNowWaitingShop(String userId) throws Exception;
	List<WaitingBank> getAllWaitingBank() throws Exception;
	
	//현재 줄서고 있는 가게 내 앞에 몇팀남았는지
	int getShopUntilMyTurn(WaitingShop waitingShop) throws Exception;
	int getBankUntilMyTurn(WaitingBank waitingBank) throws Exception;
	
	//가게별 현재 대기팀수
	int getShopNowWaitingCnt(Shop shop) throws Exception;
	int getBankNowWaitingCnt(Bank bank) throws Exception;
	
	//가게별 누적인원업데이트
	int updateTotalShopCnt(WaitingShop waitingShop) throws Exception;
	

}
