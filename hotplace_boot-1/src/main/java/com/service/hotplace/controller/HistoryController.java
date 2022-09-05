package com.service.hotplace.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ReviewService;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.WaitingService;
import com.service.hotplace.service.Impl.ShopServiceImpl;

@Controller
public class HistoryController {
	
	@Autowired
	WaitingService waitingService;
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ReviewService reviewService;
	
	
	@ResponseBody
	@PostMapping("addReview.do")
	public int addReivew(String userId, String shopIdx, String score, String comment) throws Exception{
		return reviewService.addReview(new Review(userId, Integer.parseInt(shopIdx.trim()), Double.parseDouble(score.trim()), comment.trim()));
	}

	@ResponseBody
	@PostMapping("getWaitingList.do")
	public ArrayList<ArrayList<String>> getWaitingList(String userId) throws Exception{
		System.out.println("========getWaitingList::Controller========");
		User user = new User();
		user.setUserId(userId);
		
		HashMap<Integer, ArrayList<WaitingShop>> list =  waitingService.getWaitingShop(user);
		
		
		int price = 0;
		String menulist = "";
		int score = 0;
		String comment = "";
		String date = "";
		String shopName = "";
		String shopWebAddress = "";
		int shopIdx = 0;
		ArrayList<ArrayList<String>> histroy = new ArrayList<ArrayList<String>>();
		
		
		for(int key : list.keySet()) {
			
			for(WaitingShop ws : list.get(key)) {
				
				Menu menu = menuService.getMenuByIdx(ws.getMenuIdx()); // 쿼리문을 여러번 도는게 좋은지...? 포문을 여러번 도는게 좋은지...?
				Shop shop = shopService.getShop(ws.getShopIdx()); // 나중에 쿼리문 한번만 돌게 수정하기
				List<Review> review = reviewService.getReviewListByUserId(userId);
				
				for(Review rv : review)
						if(rv.getShopIdx()==shop.getShopIdx())
						{
							score = (int) (rv.getScore()*2);
							comment = rv.getComm();
							System.out.println(score);
						}
				
				price += menu.getMenuPrice()*ws.getQuantity();
				
				menulist += menu.getMenuName();
				menulist += new String(" " + ws.getQuantity()+"EA ");				
				
				date = ws.getWaitingDate(); 
				
				shopName = shop.getShopName();
				shopWebAddress = shop.getWebAddress();
				shopIdx = shop.getShopIdx();
				System.out.println(shop.getWebAddress());
			}

			String[] arr = new String[] { ""+price, menulist, ""+score, comment, date, shopName, shopWebAddress, ""+shopIdx };
	        histroy.add((ArrayList<String>) Stream.of(arr)
                .collect(Collectors.toList()));
			
			menulist = "";
			price = 0;
			date = "";
			score = 0;
			comment = "";
			shopIdx = 0;
			
			
		}

		return histroy;
	}
	
	

}
