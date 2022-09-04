package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.model.LikeDAO;
import com.service.hotplace.service.LikeService;


@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	private LikeDAO likeDAO;

	@Override
	public int setLikeShop(LikeShop likeShop) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.setLikeShop(likeShop);
	}

	@Override
	public int setLikeBank(LikeBank likeBank) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.setLikeBank(likeBank);
	}

	@Override
	public int deleteLikeShop(LikeShop likeShop) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.deleteLikeShop(likeShop);
	}

	@Override
	public int deleteLikeBannk(LikeBank likeBank) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.deleteLikeBannk(likeBank);
	}

	@Override
	public boolean checkLikeShop(LikeShop likeShop) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.checkLikeShop(likeShop);
	}

	@Override
	public boolean checkLikeBank(LikeBank likeBank) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.checkLikeBank(likeBank);
	}

	@Override
	public List<LikeShop> getLikeShops(User user) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.getLikeShops(user.getUserId());
	}

	@Override
	public List<LikeBank> getLikeBanks(User user) throws Exception {
		// TODO Auto-generated method stub
		return likeDAO.getLikeBanks(user.getUserId());
	}

	@Override
	public List<LikeShop> getAllShopLike() throws Exception {
		return likeDAO.getAllShopLike();
	}

}
