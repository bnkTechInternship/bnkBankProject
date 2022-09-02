package com.service.hotplace.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.LikeService;
import com.service.hotplace.service.ReviewService;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.WaitingService;

@Controller
public class MainController {
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	WaitingService waitingService;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	ReviewService reviewService;

	@GetMapping("/shop/init/data")
	@ResponseBody
	public List<Shop> sendInitData(String number) throws Exception {
		
		List<Shop>list = shopService.getPartData(Integer.parseInt(number));
		//List<Integer> list2 = waitingService.getPartNowWaitingCnt(Integer.parseInt(number));
		
		for(int i=0; i<list.size();i++) {
			Shop shop = shopService.getShop(Integer.parseInt(number)+i);
			int nowCnt = waitingService.getShopNowWaitingCnt(shop);
			list.get(i).setTotalCnt(nowCnt);
		}
		
		return list;
	}
	
	@ResponseBody
	@GetMapping("/shop/init/waitingCnt")
	public List<Integer> sendInitWaitingCnt(String number) throws Exception{
		System.out.println("=================================++");
		List<Integer> list = waitingService.getPartNowWaitingCnt(Integer.parseInt(number));
		System.out.println("=================================++"+list);
		return list;
	}
	
	@GetMapping("/recommand")
	public String sendRedirect() {
		return "redirect:recommand.html";
	}
	
	@GetMapping("/shop/allShop")
	@ResponseBody
	List<Shop> getAllShopController() throws Exception {
		return shopService.getShopList();
	}
	
	@GetMapping("/bank/allBank")
	@ResponseBody
	List<Bank> getAllBankController() throws Exception {
		return bankService.getBankList();
	}
	
	@RequestMapping("userInfo.do")
	String userInfoDo(HttpSession session) throws Exception{
		
		User user =(User)session.getAttribute("loginUser");
		
		if(user!= null) {
			return "redirect:reserve.html";
		}else {
			return "redirect:login.html";
		}
	}
	
	
	@ResponseBody
	@RequestMapping("searchShop.do")
	List<Shop> searchShop(String ShopName) throws Exception {
		System.out.println("======================가게 조회========================");
		List<Shop> list = shopService.getShopListByName(ShopName);
		System.out.println(list);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping("checkLike.do")
	boolean checkLike(LikeShop likeShop) throws Exception {
		boolean check = likeService.checkLikeShop(likeShop);
		//System.out.println("======================체크라이크호출@!!!!!!!!================================");
		//System.out.println(check);
		return check;
	}
	
	@ResponseBody
	@RequestMapping("getAvgScore.do")
	double getAvgScroe(String shopIdx){
		System.out.println("에버리지 스코어함수호출=================");
		double avg = 0;
		try {
			avg = reviewService.getScoreAvg(Integer.parseInt(shopIdx));
			System.out.println(avg);
		} catch (Exception e) {
			return 0.0;
		}
		return avg;
	}
}
