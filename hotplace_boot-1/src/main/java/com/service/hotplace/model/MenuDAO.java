package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.place.Menu;

public interface MenuDAO {
	// create
	int addMenu(Menu menu) throws Exception;
	
	// read
	List<Menu> getMenuByName(String menuName) throws Exception;
	Menu getMenuByIdx(int menuIdx) throws Exception;
	List<Menu> getMenuList(int shopIdx) throws Exception;
	
	// update
	int updateMenu(Menu menu) throws Exception;
	
	// delete
	int deleteMenu(int menuIdx) throws Exception;
}
