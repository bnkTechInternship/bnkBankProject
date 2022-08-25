package com.service.hotplace.model;
import java.util.List;

import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;

public interface LikeDAO {
	
	//찜하기
	int setLikeShop(LikeShop likeShop) throws Exception;
	int setLikeBank(LikeBank likeBank) throws Exception;

	//찜 삭제
	int deleteLikeShop(LikeShop likeShop) throws Exception;
	int deleteLikeBannk(LikeBank likeBank) throws Exception;
	
	//찜 확인 없으면 있으면 like_idx값, 없으면 null반환!!
	boolean checkLikeShop(LikeShop likeShop) throws Exception;
	boolean checkLikeBank(LikeBank likeBank) throws Exception;
	
	//찜목록보기
	List<LikeShop> getLikeShops(String userId) throws Exception;
	List<LikeBank> getLikeBanks(String userId) throws Exception;
	
	
}
