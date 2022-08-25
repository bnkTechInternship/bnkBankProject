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
	public List<Menu> getMenuByName(String menuName) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.getMenuByName(menuName);
	}

	@Override
	public Menu getMenuByIdx(int menuIdx) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.getMenuByIdx(menuIdx);
	}

	@Override
	public List<Menu> getMenuList(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
