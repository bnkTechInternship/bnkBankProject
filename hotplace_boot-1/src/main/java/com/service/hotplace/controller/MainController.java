package com.service.hotplace.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Market;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
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
	
	@GetMapping("/login.html/*") 
	public String redirect(HttpServletRequest req) {
		String url = req.getRequestURI().substring(12);
		System.out.println(url);
		
		return "redirect:/main.html?data=" + url;
	}
	

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
		
		System.out.println("shop/init/data 결과  : " + list);
		
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
			return "redirect:checkCurrWaiting.do?userId="+user.getUserId();
		}else {
			return "redirect:login.html";
		}
	}
	
	
	@ResponseBody
	@PostMapping("searchShopName.do")
	List<Shop> searchShop(String shopName) throws Exception {
		System.out.println(shopName);
		System.out.println("======================가게 조회========================");
		List<Shop> list = shopService.getShopListByName(shopName);
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
	
	@GetMapping("/shop/review")
	@ResponseBody
	List<Review>getAllReview() throws Exception {
		List<Review>list = reviewService.getAllReview();
		System.out.println("list값 : " + list);
		return list;
	}
	
	@GetMapping("/bank/init/data")
	@ResponseBody
	// throws Exception은 Controller에서 다 try,catch로 바꿔야함 나중에 
	List<Bank> sendBankInitData(String number) throws Exception {
		int idx = Integer.parseInt(number);
		return bankService.getPartData(idx);
	}
	
	@GetMapping("/shop/allWaiting")
	@ResponseBody
	List<WaitingShop> getAllShopWaiting() throws Exception {
		return waitingService.getAllWaitingShop();
	}
	
	@GetMapping("/bank/allWaiting")
	@ResponseBody
	List<WaitingBank> getAllBankWaiting() throws Exception {
		return waitingService.getAllWaitingBank();
	}
	
	@GetMapping("/shop/allLike")
	@ResponseBody
	List<LikeShop> getAllShopLike() throws Exception {
		List<LikeShop>list = likeService.getAllShopLike();
		for(LikeShop item : list)
			System.out.println(item);
		return list;
	}
	
	@PostMapping("/getDetail")
	@ResponseBody
	Object getDetails(Market market) throws Exception {
		Object obj = null;
		int idx = Integer.parseInt(market.getIdx());
		if(market.getCategory().equals("shop")) 
			obj = shopService.getShop(idx);
		else obj = bankService.getBank(idx);

		System.out.println("받은 정보" + obj);
		
		return obj;
	}
	
}
