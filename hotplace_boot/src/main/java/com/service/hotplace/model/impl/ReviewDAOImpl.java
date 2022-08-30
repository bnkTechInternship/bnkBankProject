package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.play.Review;
import com.service.hotplace.model.ReviewDAO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	static final String NS="sql.review.mapper.";
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int addReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"addReview",review);
	}

	@Override
	public int deleteReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(NS+"deleteReview",review);
	}

	@Override
	public int updateReview(Review review) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(NS+"updateReview",review);
	}

	@Override
	public List<Review> getReviewListByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getReviewListByUserId",userId);
	}

	@Override
	public List<Review> getReviewListByShopIdx(int shopIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getReviewListByShopIdx",shopIdx);
	}

	@Override
	public double getScoreAvg(int ShopIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+"getScoreAvg",ShopIdx);
	}

}
