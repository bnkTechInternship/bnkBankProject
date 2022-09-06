package com.service.hotplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ReviewService;
import com.service.hotplace.service.UserService;
import com.service.hotplace.service.WaitingService;

@Controller
public class InfoController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	WaitingService waitingService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/info/getAllMenu")
	@ResponseBody
	public List<Menu> getAllList(Shop shop) throws Exception {
		return menuService.getMenuList(shop.getShopIdx());
	}
	
	@GetMapping("/info/getShopReview")
	@ResponseBody
	public List<Review> getShopReview(Shop shop) throws Exception {
		List<Review>list = reviewService.getOneShopReview(shop.getShopIdx());
		for(Review item : list)
			System.out.println(item);
		return list;
	}
	
	@PostMapping("/info/registWaiting")
	@ResponseBody
	public String registWaitingShop(WaitingShop shop) throws Exception {
		waitingService.registerWaitingShop(shop);
		return "";
	}
	
	@GetMapping("bankReserve.do")
	@ResponseBody
	public String registWaitingBank(WaitingBank waitingBank) throws Exception {
		System.out.println("받은 waitingBank :" + waitingBank);
		waitingService.registerWaitingBank(waitingBank);
		return "";
	}
	
	@PostMapping("/info/getSpecificUser")
	@ResponseBody
	public User getSpecificUserById(String userId) throws Exception{
		return userService.getUserById(userId);
	}
	
	@PostMapping("/info/withDraw")
	@ResponseBody
	public boolean withDrawMoney(User user) throws Exception {
		System.out.println("info/withdraw 받은 데이터  : " + user );
		userService.withDrawMoney(user);
		return true;
	}
}
