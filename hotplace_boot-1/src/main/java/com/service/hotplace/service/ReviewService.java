package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;

public interface ReviewService {
	// create
	int addReview(Review review) throws Exception; //리뷰작성
	
	
	// read
	List<Review> getReviewListByUserId(String userId) throws Exception; //리뷰불러오기
	List<Review> getReviewListByShopIdx(int shopIdx) throws Exception;  //리뷰불러오기
	List<Review> getAllReview() throws Exception;					    //리뷰불러오기
	List<Review> getOneShopReview(int shopIdx) throws Exception;        //리뷰불러오기
	
	double getScoreAvg(int ShopIdx) throws Exception;
	
	// update
	int updateReview(Review review) throws Exception; //리뷰수정
	
	// delete
	int deleteReview(Review review) throws Exception; //리뷰삭제
}
