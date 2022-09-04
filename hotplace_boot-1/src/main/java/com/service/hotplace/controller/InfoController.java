package com.service.hotplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ReviewService;

@Controller
public class InfoController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/info/getAllMenu")
	@ResponseBody
	public List<Menu> getAllList(Shop shop) throws Exception {
		return menuService.getMenuList(shop.getShopIdx());
	}
	
	@GetMapping("/info/getShopReview")
	@ResponseBody
	public List<Review> getShopReview(Shop shop) throws Exception {
		return reviewService.getOneShopReview(shop.getShopIdx());
	}
}
