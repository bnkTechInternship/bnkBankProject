package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.play.Review;
import com.service.hotplace.model.ReviewDAO;
import com.service.hotplace.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public int addReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.addReview(review);
	}

	@Override
	public int deleteReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.deleteReview(review);
	}

	@Override
	public int updateReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.updateReview(review);
	}

	@Override
	public List<Review> getReviewListByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.getReviewListByUserId(userId);
	}

	@Override
	public List<Review> getReviewListByShopIdx(int shopIdx) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.getReviewListByShopIdx(shopIdx);
	}

	@Override
	public double getScoreAvg(int ShopIdx) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.getScoreAvg(ShopIdx);
	}

}
