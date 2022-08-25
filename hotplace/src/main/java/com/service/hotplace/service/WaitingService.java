package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;

public interface WaitingService {
	//줄서기
	int registerWaitingBank(WaitingBank waitingBank) throws Exception;
	int registerWaitingShop(WaitingShop waitingShop) throws Exception;
	
	//이용내역 불러오기
	List<WaitingBank> getWaitingBank(User user) throws Exception;
	List<WaitingShop> getWaitingShop(User user) throws Exception;
	
	//현재 줄서기 정보
	WaitingBank getNowWaitingBank(User user) throws Exception;
	WaitingShop getNowWaitingShop(User user) throws Exception;
	
	

}
