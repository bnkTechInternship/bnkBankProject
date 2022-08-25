package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;

public interface WaitingDAO {
	
	//줄서기
	int registerWaitingBank(WaitingBank waitingBank) throws Exception;
	int registerWaitingShop(WaitingShop waitingShop) throws Exception;
	
	//이용내역 불러오기
	List<WaitingBank> getWaitingBank(String userId) throws Exception;
	List<WaitingShop> getWaitingShop(String userId) throws Exception;
	
	//현재 줄서기 정보
	WaitingBank getNowWaitingBank(String userId) throws Exception;
	WaitingShop getNowWaitingShop(String userId) throws Exception;
	
	 
	
	
	

}
