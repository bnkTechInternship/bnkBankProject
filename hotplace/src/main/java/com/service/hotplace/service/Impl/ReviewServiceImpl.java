package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.play.Review;
import com.service.hotplace.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewService reviewService;

	@Override
	public int addReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return reviewService.addReview(review);
	}

	@Override
	public int deleteReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return reviewService.deleteReview(review);
	}

	@Override
	public int updateReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return reviewService.updateReview(review);
	}

	@Override
	public List<Review> getReviewListByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return reviewService.getReviewListByUserId(userId);
	}

	@Override
	public List<Review> getReviewListByShopIdx(int shopIdx) throws Exception {
		// TODO Auto-generated method stub
		return reviewService.getReviewListByShopIdx(shopIdx);
	}

	@Override
	public double getScoreAvg(int ShopIdx) throws Exception {
		// TODO Auto-generated method stub
		return reviewService.getScoreAvg(ShopIdx);
	}

}
