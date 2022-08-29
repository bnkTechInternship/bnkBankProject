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
		// TODO Auto-generated method stub
		return menuDAO.addMenu(menu);
	}

	@Override
	public int deleteMenu(int menuIdx) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.deleteMenu(menuIdx);
	}

	@Override
	public List<Menu> getMenuByName(String menuName) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.getMenuByName(menuName);
	}

	@Override
	public int updateMenu(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.updateMenu(menu);
	}

	@Override
	public Menu getMenuByIdx(int menuIdx) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.getMenuByIdx(menuIdx);
	}

	@Override
	public List<Menu> getMenuList(int shopIdx) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.getMenuList(shopIdx);
	}


	

}
