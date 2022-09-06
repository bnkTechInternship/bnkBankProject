package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.play.Review;
import com.service.hotplace.model.ReviewDAO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	private SqlSession sqlsession;
	static final String NS="sql.review.mapper.";
	
	@Override
	public int addReview(Review review) throws Exception {
		return sqlsession.insert(NS+"addReview",review);
	}

	@Override
	public int deleteReview(Review review) throws Exception {
		return sqlsession.delete(NS+"deleteReview",review);
	}

	@Override
	public int updateReview(Review review) throws Exception {
		return sqlsession.update(NS+"updateReview",review);
	}

	@Override
	public List<Review> getReviewListByUserId(String userId) throws Exception {
		return sqlsession.selectList(NS+"getReviewListByUserId",userId);
	}

	@Override
	public List<Review> getReviewListByShopIdx(int shopIdx) throws Exception {
		return sqlsession.selectList(NS+"getReviewListByShopIdx",shopIdx);
	}

	@Override
	public double getScoreAvg(int ShopIdx) throws Exception {
		return sqlsession.selectOne(NS+"getScoreAvg",ShopIdx);
	}

	@Override
	public List<Review> getAllReview() throws Exception {
		return sqlsession.selectList(NS+"getAllReview");
	}
	
	@Override
	public List<Review> getOneShopReview(int shopIdx) throws Exception {
		return sqlsession.selectList(NS+"getOneShopReview",shopIdx);
	}
}
