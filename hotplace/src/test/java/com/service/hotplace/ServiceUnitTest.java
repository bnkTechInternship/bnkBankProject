package com.service.hotplace;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;
import com.service.hotplace.model.ShopDAO;
import com.service.hotplace.model.UserDAO;
import com.service.hotplace.model.WaitingDAO;
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.LikeService;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ReviewService;
import com.service.hotplace.service.WaitingService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans/businessBean.xml"})
public class ServiceUnitTest {
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private WaitingDAO waitingDAO;
	
	@Autowired
	private WaitingService waitingService;
	
	@Autowired
	private ShopDAO shopDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Test
	public void unit() throws Exception {
		
		
		
		
		///////////BANKTEST////////////////
//		Bank bank = new Bank("부산은행정관","정관","052444","0930~1500",3,"위도","경도");
		//System.out.println(bankService.registerBank(bank));
		//bankService.deleteBank(9);
//		List<Bank> list = bankService.getBankList();
//		for(Bank b : list) System.out.println(b);
		
		//System.out.println(bankService.getBankByName("부산은행기장"));
		
//		Bank bank = new Bank(10,"부은해운대","해운대","052444","0930~1500",3,"위도","경도");
//		//bankService.updateBank(bank);
//		
//		bankService.updateBankEnternum(bank);
//		
//		List<Bank> list = bankService.getBankList();
//		for(Bank b : list) System.out.println(b);
		
		
		
		//////////LIKESERVICETEST////////////////////
//		LikeBank li = new LikeBank("id",10);
////		likeService.setLikeBank(li);
//		
//		LikeShop lii = new LikeShop("id",8);
////		likeService.setLikeShop(lii);
//		
////		System.out.println(likeService.checkLikeBank(li));
////		System.out.println(likeService.checkLikeShop(lii));
//		User u = new User();
//		u.setUserId("id");
//		
//		likeService.deleteLikeBannk(li);
//		likeService.deleteLikeShop(lii);
//		
//		List<LikeBank> list = likeService.getLikeBanks(u);
//		for(LikeBank b : list) System.out.println(u);
//		
//		List<LikeShop> lis = likeService.getLikeShops(u);
//		for(LikeShop b : lis) System.out.println(u);
		
		
	////////////MENU TEST/////////////////////
		//Menu me = new Menu(1,"못난핫도그",3000,1);
		//menuService.addMenu(me);
		
		//System.out.println(menuService.getMenuByName("감자"));
//		menuService.updateMenu(me);
//		
//		List<Menu> ml = menuService.getMenuList(1);
//		for(Menu m : ml) System.out.println(m);
		
		//System.out.println(menuService.getMenuByIdx(1));
		
		//menuService.deleteMenu(1);
		
		
		
		////////////////////REVIEW TEST///////////////
		Review re = new Review("i4d",2,4,"맛있");
		//System.out.println(re);
		//reviewService.addReview(re);
		//reviewService.updateseview(re);
		
//		List<Review> li = reviewService.getReviewListByShopIdx(1);
//		for(Review r : li) System.out.println(r);
		
		//System.out.println(reviewService.getScoreAvg(2));
		Bank b = new Bank();
		b.setBankIdx(12);
		//System.out.println(waitingService.getBankNowWaitingCnt(b));
		User u = new User();
		u.setUserId("id");
		WaitingBank wb = new WaitingBank();
		wb.setUserId("id");
		wb.setBankIdx(10);
		//System.out.println(waitingService.getBankUntilMyTurn(wb));
		
		//List<WaitingBank> li=waitingDAO.getNowWaitingBank(u.getUserId());
		
		//System.out.println(li);
		//for(WaitingBank bb : li )System.out.println(bb);
		
		//System.out.println(waitingService.getNowWaitingBank(u));
		
//		ArrayList<WaitingShop> li = waitingService.getNowWaitingShop(u);
//		for(WaitingShop jj : li) System.out.println(jj);
		
		WaitingShop ws = new WaitingShop();
		ws.setUserId("id");
		ws.setShopIdx(11);
		
		System.out.println(waitingService.getBankNowWaitingCnt(b));
		
		
		
//		ArrayList<ArrayList<WaitingShop>> li = waitingService.getWaitingShop(u);
//		//System.out.println(li.size());
//		for(ArrayList<WaitingShop> al : li) {
//			System.out.println(al.size());
//			for(WaitingShop a : al)
//				System.out.println(a);
//		}
//		
//		List<WaitingShop> aw= waitingDAO.getWaitingShop("id");
//		for(WaitingShop w : aw) System.out.println(w);
		
	      Shop shop = new Shop(3,"찹찹찹찹", "기장", "222", "1100-2000", 5, "30", "40", 3, "www");
	      //int result = shopDAO.registerShop(shop);
	      //System.out.println(result+ "개 shop 등록 완료");
	      
//	      int delete = shopDAO.deleteShop(4);
//	      System.out.println(delete+"개 shop 삭제 완료");
//	      
//	      int update = shopDAO.updateShop(shop);
//	      System.out.println(update+"개 업데이트 완료");

//	      int update = shopDAO.updateShopEnternum(shop);
//	      System.out.println(update+"명이 가게에 입장하였습니다.");
//	      
//	      List<Shop> list = shopDAO.getShopList();
//	      for(Shop sh : list) System.out.println(sh);
	      
//	      System.out.println(shopDAO.getShop(3));
	      
//	      List<Shop> list = shopDAO.getShopListByName("찹찹");
//	      for(Shop sh:list) System.out.println(sh);
	      
	      
	   //   User user = new User("bbb", "kkk", "b", "bb", "기장", "1234", 5000, 500, "");

	      
	      //int result = userDAO.registerUser(user);
	      //System.out.println(result+"명의 회원이 등록되었습니다.");
	      
//	      int update = userDAO.updateUser(user);
//	      System.out.println(update+"명 회원의 정보가 수정되었습니다.");

//	      int delete = userDAO.deleteUser(user.getUserId());
//	      System.out.println(delete+"명의 회원을 삭제하였습니다.");
	      
	      //System.out.println(userDAO.login(user));
	      
	     // System.out.println(userDAO.getUserById(user.getUserId()));
	      
//	      List<User> list = userDAO.getUserList();
//	      for(User us:list) System.out.println(us);
	      
	      //System.out.println(userDAO.findUserId(user.getUserEmail()));
	      
	     // System.out.println(userDAO.findUserPw(user));

	      

		
		
	
	
	}
	
}
