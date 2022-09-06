package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.model.MenuDAO;
import com.service.hotplace.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDAO menuDAO;

	@Override
	public int addMenu(Menu menu) throws Exception {
		return menuDAO.addMenu(menu);
	}

	@Override
	public int deleteMenu(int menuIdx) throws Exception {
		return menuDAO.deleteMenu(menuIdx);
	}

	@Override
	public List<Menu> getMenuByName(String menuName) throws Exception {
		return menuDAO.getMenuByName(menuName);
	}

	@Override
	public int updateMenu(Menu menu) throws Exception {
		return menuDAO.updateMenu(menu);
	}

	@Override
	public Menu getMenuByIdx(int menuIdx) throws Exception {
		return menuDAO.getMenuByIdx(menuIdx);
	}

	@Override
	public List<Menu> getMenuList(int shopIdx) throws Exception {
		return menuDAO.getMenuList(shopIdx);
	}
}
