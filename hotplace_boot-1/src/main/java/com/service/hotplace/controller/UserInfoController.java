package com.service.hotplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.service.LikeService;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ReviewService;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.UserService;
import com.service.hotplace.service.WaitingService;

@Controller
public class UserInfoController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private WaitingService waitingService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LikeService likeService;
	
	@RequestMapping("checkCurrWaiting.do")
	public String checkCurrWaiting(User user) throws Exception{
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		if(waitingshops == null)  
			return "redirect:reserve2.html";
		return "redirect:reserve.html";
	}
	
	@ResponseBody
	@PostMapping("getReviews.do")
	public List<Review> getReviewsDo(User user) throws Exception {
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		int shopIdx = waitingshops.get(0).getShopIdx();
		return reviewService.getReviewListByShopIdx(shopIdx);
	}
	
	@ResponseBody
	@PostMapping("getShopInfo.do")
	public Shop getShopinfoDo(User user) throws Exception{
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		int shopIdx = waitingshops.get(0).getShopIdx();
		return shopService.getShop(shopIdx);
	}
	
	@ResponseBody
	@PostMapping("getOrder.do")
	public List<WaitingShop> getOrderDo(User user) throws Exception{
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		for(WaitingShop ws : waitingshops) {
			Menu menu = menuService.getMenuByIdx(ws.getMenuIdx());
			ws.setWaitingDate(menu.getMenuName());
			ws.setWaitingCnt(menu.getMenuPrice());
		}
		return waitingshops;
	}
	
	@ResponseBody
	@PostMapping("getRealWaiting.do")
	public int getRealWaiting(User user) throws Exception{
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		int untilCnt= waitingService.getShopUntilMyTurn(waitingshops.get(0));
		return untilCnt;
	}
	
	@ResponseBody
	@PostMapping("updateInfo.do")
	public User updateInfoDo(User user) throws Exception{
		userService.updateUser(user);
		return userService.getUserById(user.getUserId());
	}
	
	@ResponseBody
	@GetMapping("likeShop.do")
	public String likeShopDo(LikeShop likeShop) throws Exception{
		int result = likeService.setLikeShop(likeShop);
		return "";
	}

	@ResponseBody
	@GetMapping("unlikeShop.do")
	public String unlikeShopDo(LikeShop likeShop) throws Exception{
		int result = likeService.deleteLikeShop(likeShop);
		return "";
	}
	
	@ResponseBody
	@PostMapping("getLikeList.do")
	public List<LikeShop> getLikeList(User user) throws Exception{
		List<LikeShop> list=likeService.getLikeShops(user);
		for(LikeShop ls: list) {
			Shop shop = shopService.getShop(ls.getShopIdx());
			ls.setShop(shop);
		}
		return list;
	}
	
	@PostMapping("getSpecificUser")
	@ResponseBody
	public User getSpecificUser(String userId) throws Exception {
		return userService.getUserById(userId);
	}
}
