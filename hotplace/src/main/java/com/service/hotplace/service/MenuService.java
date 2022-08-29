package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;

public interface MenuService {
	int addMenu(Menu menu) throws Exception;
	int deleteMenu(int menuIdx) throws Exception;
	
	List<Menu> getMenuByName(String menuName) throws Exception;
	
	int updateMenu(Menu menu) throws Exception;
	
	Menu getMenuByIdx(int menuIdx) throws Exception;
	List<Menu> getMenuList(int shopIdx) throws Exception;
	

}
