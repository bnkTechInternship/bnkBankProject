package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.play.Review;

public interface ReviewDAO {
	// create
	int addReview(Review review) throws Exception;
	
	// read
	List<Review> getReviewListByUserId(String userId) throws Exception;
	List<Review> getReviewListByShopIdx(int shopIdx) throws Exception;
	List<Review> getAllReview() throws Exception;
	List<Review> getOneShopReview(int shopIdx) throws Exception;
	
	double getScoreAvg(int ShopIdx) throws Exception;
	
	// update
	int updateReview(Review review) throws Exception;
	
	// delete
	int deleteReview(Review review) throws Exception;
}
