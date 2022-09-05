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
	
//	@ResponseBody
//	//@RequestMapping("userInfo.do")
//	public String userInfoDo(HttpSession session, Model model) {
//		
//		System.out.println("userInfodo호출!!!!");
//		User user =(User)session.getAttribute("user");
//		
//		if(user!= null) {
//			model.addAttribute("user",user);
//			return "User";
//		}else {
//			return "";
//		}
//		
//		//System.out.println(user);
//		//return user;
//	}
	
	@RequestMapping("checkCurrWaiting.do")
	public String checkCurrWaiting(String userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		System.out.println("&&&&&&&&&&&&&&&&&웨이팅샵여부::"+ waitingshops);
		if(waitingshops ==null) { return "redirect:reserve2.html";}
		return "redirect:reserve.html";
	}
	
	
	
	@ResponseBody
	@PostMapping("getReviews.do")
	public List<Review> getReviewsDo(String userId) throws Exception {
		System.out.println(userId);
		User user = new User();
		user.setUserId(userId);
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		System.out.println(waitingshops);
		int shopIdx = waitingshops.get(0).getShopIdx();
		List<Review> list = reviewService.getReviewListByShopIdx(shopIdx);
		return list;
	}
	
	@ResponseBody
	@PostMapping("getShopInfo.do")
	public Shop getShopinfoDo(String userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		int shopIdx = waitingshops.get(0).getShopIdx();
		Shop shop = shopService.getShop(shopIdx);
		return shop;
	}
	
	
	@ResponseBody
	@PostMapping("getOrder.do")
	public List<WaitingShop> getOrderDo(String userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
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
	public int getRealWaiting(String userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		int untilCnt= waitingService.getShopUntilMyTurn(waitingshops.get(0));
		System.out.println(untilCnt);
		return untilCnt;
	}
	
	
	@ResponseBody
	@PostMapping("updateInfo.do")
	public User updateInfoDo(User user) throws Exception{
		userService.updateUser(user);
		User reuser = userService.getUserById(user.getUserId());
		System.out.println(reuser);
		return reuser;
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
		System.out.println(likeShop);
		int result = likeService.deleteLikeShop(likeShop);
		return "";
	}
	
	
	@ResponseBody
	@PostMapping("getLikeList.do")
	public List<LikeShop> getLikeList(String userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
		List<LikeShop> list=likeService.getLikeShops(user);
		for(LikeShop ls: list) {
			Shop shop = shopService.getShop(ls.getShopIdx());
			ls.setShop(shop);
		}
		return list;
	}
	
}
