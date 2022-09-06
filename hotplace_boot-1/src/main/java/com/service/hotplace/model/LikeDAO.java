package com.service.hotplace.model;
import java.util.List;

import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.WaitingShop;

public interface LikeDAO {
	// create
	int setLikeShop(LikeShop likeShop) throws Exception; //찜하기
	int setLikeBank(LikeBank likeBank) throws Exception; //찜하기
	
	// read
	List<LikeShop> getLikeShops(String userId) throws Exception;    //찜목록보기
	List<LikeShop> getAllLikeShops(String userId) throws Exception; //찜목록보기
	List<LikeBank> getLikeBanks(String userId) throws Exception;    //찜목록보기
	List<LikeShop> getAllShopLike() throws Exception;				//찜목록보기

	boolean checkLikeShop(LikeShop likeShop) throws Exception; //찜 확인 없으면 있으면 like_idx값, 없으면 null반환!!
	boolean checkLikeBank(LikeBank likeBank) throws Exception; //찜 확인 없으면 있으면 like_idx값, 없으면 null반환!!
	
	// update
	
	// delete
	int deleteLikeShop(LikeShop likeShop) throws Exception;
	int deleteLikeBannk(LikeBank likeBank) throws Exception;
}
