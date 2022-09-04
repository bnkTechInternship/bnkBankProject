package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.play.Review;

public interface ReviewDAO {
	//리뷰작성
	int addReview(Review review) throws Exception;
	
	//리뷰삭제
	int deleteReview(Review review) throws Exception;
	
	//리뷰수정
	int updateReview(Review review) throws Exception;
	
	//리뷰불러오기
	List<Review> getReviewListByUserId(String userId) throws Exception;
	List<Review> getReviewListByShopIdx(int shopIdx) throws Exception;
	List<Review> getAllReview() throws Exception;
	List<Review> getOneShopReview(int shopIdx) throws Exception;
	
	double getScoreAvg(int ShopIdx) throws Exception;
	

}
