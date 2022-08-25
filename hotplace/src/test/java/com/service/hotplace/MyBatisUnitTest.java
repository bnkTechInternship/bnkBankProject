package com.service.hotplace;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.domain.play.LikeBank;
import com.service.hotplace.domain.play.LikeShop;
import com.service.hotplace.domain.play.Review;
import com.service.hotplace.domain.play.WaitingBank;
import com.service.hotplace.domain.play.WaitingShop;


public class MyBatisUnitTest {
	

	@Test
	public void unit() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
//		
//		Bank tmp = new Bank("해운대점","기장군","334","ㅇㅇ",4,44,"위도","경도");
//		System.out.println(tmp);
//		
//		int result=session.insert("sql.bank.mapper.registerBank",tmp);
//		session.commit();
//		System.out.println(result);
		
//		System.out.println(session.delete("sql.hotplace.mapper.deleteBank","5"));
//		session.commit();
		
//		Bank tmp = new Bank();
//		tmp.setBankIdx(8);
//		
//		Bank b = session.selectOne("sql.bank.mapper.getBank",tmp);
		//System.out.println(b);
//		for(Bank b : list)
//			System.out.println(b);
		
		
		
		//LikeBank tmp = new LikeBank("id",7);
//		int result=session.insert("sql.like.mapper.addLikeBank",tmp);
//		session.commit();
//		System.out.println(result);
		
//		int resul=session.delete("sql.like.mapper.deleteLikeBank",tmp);
//		session.commit();
//		System.out.println(resul);
		
		//session.selectOne("sql.like.mapper.checkLikeBank",tmp);
//		System.out.println((String)session.selectOne("sql.like.mapper.checkLikeBank",tmp));
//		
//		List<LikeBank> list = session.selectList("sql.like.mapper.getLikeBankList",tmp.getUserId());
//		for(LikeBank b : list) System.out.println(b);
		
		Menu menu = new Menu("짜장면",5000,1);
//		
//		int in = session.insert("sql.menu.mapper.addMenu", menu);
//		session.commit();
//		System.out.println(in);
		
//		Menu re = session.selectOne("sql.menu.mapper.getMenuByIdx",menu.getMenuIdx());
//		session.commit();
		
//		List<Menu> list = session.selectList("sql.menu.mapper.getMenuList",menu.getShopIdx());
//		session.commit();
//		for(Menu m : list) System.out.println(m);
//		
//		session.delete("sql.menu.mapper.deleteMenu",menu.getMenuIdx());
//		session.commit();
		
		Review review = new Review("id",1,4.7,"맛있어요!");
//		session.insert("sql.review.mapper.addReview",review);
//		session.commit();
		
//		review.setComm("냠냐미");
//		session.update("sql.review.mapper.updateReview", review);
//		session.commit();
		
//		List<Review> list =session.selectList("sq]l.review.mapper.getReviewListByUserId", review.getUserId());
//		
//		for(Review kk : list) System.out.println(kk);
		
//		List<Review> list =session.selectList("sql.review.mapper.getReviewListByShopIdx", review.getShopIdx());
//		for(Review kk : list) System.out.println(kk);
		
		WaitingBank wb = new WaitingBank("aaa",7,3);
		//System.out.println(wb.getBankIdx());
//		session.insert("sql.waiting.mapper.registerWaitingBank",wb);
//		session.commit();
//		
		WaitingShop ws = new WaitingShop("id",1,1,1,2,"2022-08-24",2);

//		System.out.println(ws.getShopIdx());
//		session.insert("sql.waiting.mapper.registerWaitingShop",ws);
//		session.commit();
//		List<WaitingBank> list = session.selectList("sql.waiting.mapper.getBankListByUserId","id");
//		for(WaitingBank w : list) System.out.println(w);
		
//		List<WaitingShop> list = session.selectList("sql.waiting.mapper.getShopListByUserId","id");
//		for(WaitingShop w : list) System.out.println(w);
		
		
       Shop shop = new Shop("누들차브","기장군","333","auctl싯ㅋ",4,40,"ㅇㄴㅇ","경도",10,"www");
//      int result=session.insert("sql.hotplace.mapper.registerShop",shop);
//      session.commit();
      
//      List<Shop> shop1 = session.selectList("sql.hotplace.mapper.getShop");
//      for(Shop s : shop1)
//         System.out.println(s);
      
      User user = new User("aaa","aaa","aaa","aa","서울","1234",5000,500,"");
//      int result=session.insert("sql.hotplace.mapper.registerUser",user);
//      System.out.println(result);
//      session.commit();
      
//      int result=session.delete("sql.hotplace.mapper.deleteUser",user);
//      System.out.println(result);
//      session.commit();
      
//      List<User> user1 = session.selectList("sql.hotplace.mapper.getUser",user);
//      for(User u : user1)
//         System.out.println(u);
//      
//      List<User> user2 = session.selectList("sql.hotplace.mapper.login",user);
//      for(User u : user2)
//         System.out.println(u);
      
//      List<User> user3 = session.selectList("sql.hotplace.mapper.getUserId","aa");
//      for(User u : user3)
//         System.out.println(u);
      
//      List<User> user4 = session.selectList("sql.hotplace.mapper.getUserPw",user);
//      for(User u : user4)
//         System.out.println(u);
		
		
//		List<Shop> list = session.selectList("sql.hotplace.mapper.getShopListByName","누들");
//		for(Shop s: list) System.out.println(s);
      
      List<WaitingShop> list = session.selectList("sql.waiting.mapper.getNowWaitingShop","id");
      
      //for(WaitingShop ws : list) System.out.println(ws);
		
//      String st = session.selectOne("sql.waiting.mapper.getNowWaitingShop","id");
//	  System.out.println(st);
      
      
//      int re = session.selectOne("sql.waiting.mapper.getBankUntilMyTurn",wb);
//      System.out.println(re);
//      
//      
      int re = session.update("sql.waiting.mapper.updateTotalShopCnt",ws);
      System.out.println(re);
      System.out.println(ws);
//      
//      
      
	
	}
	
}
