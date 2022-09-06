package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;

public interface LikeService {
	// create
	int setLikeShop(LikeShop likeShop) throws Exception; //찜하기
	int setLikeBank(LikeBank likeBank) throws Exception; //찜하기
	
	// read
	List<LikeShop> getLikeShops(User user) throws Exception; //찜목록보기
	List<LikeBank> getLikeBanks(User user) throws Exception; //찜목록보기
	List<LikeShop> getAllShopLike() throws Exception;
	
	boolean checkLikeShop(LikeShop likeShop) throws Exception; //찜 확인 없으면 있으면 like_idx값, 없으면 null반환!!
	boolean checkLikeBank(LikeBank likeBank) throws Exception; //찜 확인 없으면 있으면 like_idx값, 없으면 null반환!!
	
	// update
	
	// delete
	int deleteLikeShop(LikeShop likeShop) throws Exception;  //찜 삭제
	int deleteLikeBannk(LikeBank likeBank) throws Exception; //찜 삭제
}
