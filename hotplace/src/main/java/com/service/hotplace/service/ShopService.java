package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.place.Shop;

public interface ShopService {
	
	List<Shop> getShopList() throws Exception;
	Shop getShop(int shopIdx) throws Exception;
	List<Shop> getShopListByName(String ShopName) throws Exception;

}
