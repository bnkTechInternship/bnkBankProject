package com.service.hotplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.service.ShopService;

@Controller
public class ManageController {
	@Autowired
	private ShopService shopService;
	
	@ResponseBody
	@GetMapping("shopName.do")
	public Shop shopNameDo(int shopIdx) throws Exception{
		return shopService.getShop(shopIdx);
	}
	
	@ResponseBody
	@GetMapping("updateEnter.do")
	public int updateEnterDo(int shopIdx) throws Exception{
		Shop shop = shopService.getShop(shopIdx);
		int result = shopService.updateShopEnternum(shop);
		return result;
	}
}