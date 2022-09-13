package com.service.hotplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.service.BankService;
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
	
	@Autowired
	private BankService bankService;
	
	@RequestMapping("checkCurrWaiting.do")
	public String checkCurrWaiting(User user) throws Exception{
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		if(waitingshops == null)  
			return "redirect:reserve.html";
		return "redirect:reserve.html";
	}
	
	@ResponseBody
	@PostMapping("getReviews.do")
	public List<Review> getReviewsDo(User user) throws Exception {
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		if(waitingshops!=null && waitingshops.size() != 0) {
			int shopIdx = waitingshops.get(0).getShopIdx();
			return reviewService.getReviewListByShopIdx(shopIdx);
		}
		
		return null;
	}
	
	@ResponseBody
	@PostMapping("getShopInfo.do")
	public Shop getShopinfoDo(User user) throws Exception{
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		System.out.println("getShopInfo.do");
		if(waitingshops!=null && waitingshops.size() != 0) {
			int shopIdx = waitingshops.get(0).getShopIdx();
			return shopService.getShop(shopIdx);
		}
		return null;
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
		System.out.println("========Controller::getRealWaiting=======");
		System.out.println(user);
		List<WaitingShop> waitingshops = waitingService.getNowWaitingShop(user);
		if(waitingshops!=null && waitingshops.size() != 0) {
			int untilCnt= waitingService.getShopUntilMyTurn(waitingshops.get(0));
			return untilCnt;
		}
		
		return 0;
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
		likeService.setLikeShop(likeShop);
		return "";
	}

	@ResponseBody
	@GetMapping("unlikeShop.do")
	public String unlikeShopDo(LikeShop likeShop) throws Exception{
		likeService.deleteLikeShop(likeShop);
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
	
	@PostMapping("deleteWaitingInfo.do")
	@ResponseBody
	public int deleteWaitingShop(WaitingShop waitingShop) throws Exception{
		return waitingService.deleteWaitingShop(waitingShop);
	}
	
	@PostMapping("getBankInfo.do")
	@ResponseBody
	public List<Object> getBankInfo(User user) throws Exception {
		System.out.println("======Controller:: getRBankInfo========");
		WaitingBank waitingBank = waitingService.getNowWaitingBank(user);
		Bank bank = bankService.getBank(waitingBank.getBankIdx());
		ArrayList<Object> al1 = new ArrayList<>();
		al1.add(bank);
		al1.add(waitingBank);
		return al1;
	}
	
	@PostMapping("getRealWaitingBank.do")
	@ResponseBody
	public int getRealWaitingBank(User user) throws Exception{
		System.out.println("========Controller::getRealWaitingBank=======");
		WaitingBank waitingBank = waitingService.getNowWaitingBank(user);
		int untilCnt= waitingService.getBankUntilMyTurn(waitingBank);
		return untilCnt;
	}
	
	@PostMapping("deleteWaitingBankInfo.do")
	@ResponseBody
	public int deleteWaitingBank(WaitingBank waitingBank) throws Exception{
		System.out.println("==============deleteWaitingBankInfo.do================");
		System.out.println("====controller::"+waitingBank);
		int result = waitingService.deleteWaitingBank(waitingBank);
		return result;
	}
	
	@PostMapping("bothWaiting.do")
	@ResponseBody
	public List<Object> bothWaiting(User user) throws Exception{
	
		List<Object> list = new ArrayList<Object>();
		WaitingBank waitingBank = waitingService.getNowWaitingBank(user);
		ArrayList<WaitingShop> waitingShop = waitingService.getNowWaitingShop(user);
		
		if(waitingShop != null && waitingShop.size() != 0) {
			
			System.out.println("========shop받아오기========");
			
			list.add(waitingShop.get(0)); // 웨이팅 샵
			list.add(shopService.getShop(waitingShop.get(0).getShopIdx()));
			list.add(waitingService.getShopUntilMyTurn(waitingShop.get(0)));
			
		}else if(waitingBank != null ) {
			
			list.add(waitingBank);
			list.add(bankService.getBank(waitingBank.getBankIdx()));
			list.add(waitingService.getBankUntilMyTurn(waitingBank));
			
		}else  	return null;
		
		return list;
	}
	
	
	
	@PostMapping("/info/addMoney")
	@ResponseBody
	public void addUserMoney(User user) throws Exception {
		userService.depositMoney(user);
		System.out.println(user.getUserBalance() + "만큼 증가");
	}
}
