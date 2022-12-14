package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.model.ShopDAO;
import com.service.hotplace.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDAO shopDAO;

	@Override
	public List<Shop> getShopList() throws Exception {
		return shopDAO.getShopList();
	}

	@Override
	public Shop getShop(int shopIdx) throws Exception {
		return shopDAO.getShop(shopIdx);
	}

	@Override
	public List<Shop> getShopListByName(String ShopName) throws Exception {
		return shopDAO.getShopListByName(ShopName);
	}

	@Override
	public int registerShop(Shop shop) throws Exception {
		return shopDAO.registerShop(shop);
	}

	@Override
	public int deleteShop(int shopIdx) throws Exception {
		return shopDAO.deleteShop(shopIdx);
	}

	@Override
	public int updateShop(Shop shop) throws Exception {
		return shopDAO.updateShop(shop);
	}

	@Override
	public int updateShopEnternum(Shop shop) throws Exception {
		return shopDAO.updateShopEnternum(shop);
	}

	@Override
	public List<Shop> getPartData(int idx) throws Exception {
		return shopDAO.getPartData(idx);
	}

	@Override
	public List<Shop> getShopListByMemberType(int memberType) throws Exception {
		return shopDAO.getShopListByMemberType(memberType);
	}
}
