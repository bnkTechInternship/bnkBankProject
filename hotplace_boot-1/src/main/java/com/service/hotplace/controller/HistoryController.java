package com.service.hotplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.WaitingService;

@Controller
public class HistoryController {
	
	@Autowired
	WaitingService waitingService;
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	MenuService menuService;
	
	
	@ResponseBody
	@PostMapping("getWaitingList.do")
	public List<ArrayList<WaitingShop>> getWaitingList(String userId) throws Exception{
		System.out.println("함수호출=========================="+userId);
		User user = new User();
		user.setUserId(userId);
		List<ArrayList<WaitingShop>> list = waitingService.getWaitingShop(user);
		
		for(ArrayList<WaitingShop> wslist : list) {
			System.out.println(wslist);
			int shopIdx = wslist.get(0).getShopIdx();
			//System.out.println(wslist);
			Shop shop = shopService.getShop(shopIdx);
			for(WaitingShop ws: wslist) {
				int menuIdx = ws.getMenuIdx();
				Menu menu = menuService.getMenuByIdx(menuIdx);
				ws.setShop(shop);
				ws.setMenu(menu);
				
			}
		}
		
		return list;
	}
	
	

}
