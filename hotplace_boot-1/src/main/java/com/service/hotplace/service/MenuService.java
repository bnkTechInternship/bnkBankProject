package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;

public interface MenuService {
	// create
	int addMenu(Menu menu) throws Exception;
	
	// read
	List<Menu> getMenuByName(String menuName) throws Exception;
	List<Menu> getMenuList(int shopIdx) throws Exception;
	
	Menu getMenuByIdx(int menuIdx) throws Exception;
		
	// update
	int updateMenu(Menu menu) throws Exception;
		
	// delete
	int deleteMenu(int menuIdx) throws Exception;
}
