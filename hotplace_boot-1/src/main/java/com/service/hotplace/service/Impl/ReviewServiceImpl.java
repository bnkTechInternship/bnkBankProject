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
		return reviewDAO.addReview(review);
	}

	@Override
	public int deleteReview(Review review) throws Exception {
		return reviewDAO.deleteReview(review);
	}

	@Override
	public int updateReview(Review review) throws Exception {
		return reviewDAO.updateReview(review);
	}

	@Override
	public List<Review> getReviewListByUserId(String userId) throws Exception {
		return reviewDAO.getReviewListByUserId(userId);
	}

	@Override
	public List<Review> getReviewListByShopIdx(int shopIdx) throws Exception {
		return reviewDAO.getReviewListByShopIdx(shopIdx);
	}

	@Override
	public double getScoreAvg(int ShopIdx) throws Exception {
		return reviewDAO.getScoreAvg(ShopIdx);
	}

	@Override
	public List<Review> getAllReview() throws Exception {
		return reviewDAO.getAllReview();
	}

	@Override
	public List<Review> getOneShopReview(int shopIdx) throws Exception {
		return reviewDAO.getOneShopReview(shopIdx);
	}
}
