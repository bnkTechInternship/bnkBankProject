package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;

public interface ShopDAO {
	// create
	int registerShop(Shop shop) throws Exception;
	
	// read
	List<Shop> getShopList() throws Exception;
	List<Shop> getShopListByName(String name) throws Exception;
	List<Shop> getPartData(int idx) throws Exception;
	List<Shop> getShopListByMemberType(int memberType) throws Exception;
	
	Shop getShop(int shopIdx) throws Exception;
	
	// update
	int updateShop(Shop shop) throws Exception;
	int updateShopEnternum(Shop shop) throws Exception; //현재입장순번 업데이트 +1 해주는 함수
	
	// delete
	int deleteShop(int shopIdx) throws Exception;
}
