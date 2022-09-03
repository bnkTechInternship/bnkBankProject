package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.model.LikeDAO;

@Repository
public class LikeDAOImpl implements LikeDAO {
	
	static final String NS="sql.like.mapper.";
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int setLikeShop(LikeShop likeShop) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"setLikeShop",likeShop);
	}

	@Override
	public int setLikeBank(LikeBank likeBank) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(NS+"setLikeBank",likeBank);
	}

	@Override
	public int deleteLikeShop(LikeShop likeShop) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(NS+"deleteLikeShop",likeShop);
	}

	@Override
	public int deleteLikeBannk(LikeBank likeBank) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(NS+"deleteLikeBannk",likeBank);
	}

	@Override
	public boolean checkLikeShop(LikeShop likeShop) throws Exception {
		
		boolean result= false;
		if(sqlsession.selectOne(NS+"checkLikeShop",likeShop)!=null) result=true;
		return result;
	}

	@Override
	public boolean checkLikeBank(LikeBank likeBank) throws Exception {
		
		boolean result= false;
		if(sqlsession.selectOne(NS+"checkLikeBank",likeBank)!=null) result=true;
		return result;
	}

	@Override
	public List<LikeShop> getLikeShops(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+"getLikeShops",userId);
	}

	@Override
	public List<LikeBank> getLikeBanks(String userId) throws Exception {
		return sqlsession.selectList(NS+"getLikeBanks", userId);
	}

	// 이거 맞음? 수정 
	@Override
	public List<LikeShop> getAllLikeShops(String userId) throws Exception {
		return sqlsession.selectList(NS+"getLikeShops", userId);
	}

	@Override
	public List<LikeShop> getAllShopLike() throws Exception {
		return sqlsession.selectList(NS+"getAllShopLike");
	}


}
