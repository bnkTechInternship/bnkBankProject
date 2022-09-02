package com.service.hotplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Menu;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.MenuService;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.UserService;

@RestController
public class AdminController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("searchUser.do")
	public User searchUser(String userId) throws Exception {
		return userService.getUserById(userId);
	}
	
	@PostMapping("deleteUser.do")
	public String deleteUser(String userId) throws Exception{
		userService.deleteUser(userId);
		return "";
	}
	
	
	@PostMapping("updateInfoForAdmin.do")
	public User updateInfoForAdmin(User user) throws Exception{
		userService.updateUser(user);
		System.out.println(user);
		User reuser = userService.getUserById(user.getUserId());
		System.out.println(reuser);
		return reuser;
	}
	

	@PostMapping("searchBank.do")
	public Bank searchBank(String bankIdx) throws Exception {
		return bankService.getBank(Integer.parseInt(bankIdx));
	}
	
	
	@PostMapping("deleteBank.do")
	public String deleteBank(String bankIdx) throws Exception {
		bankService.deleteBank(Integer.parseInt(bankIdx));
		return "";
	}
	
	@PostMapping("updateBankInfoForAdmin.do")
	public Bank updateBankInfoForAdmin(Bank bank) throws Exception {
		bankService.updateBank(bank);
		
		return bankService.getBank(bank.getBankIdx());
	}
	
	@PostMapping("searchShop.do")
	public Shop searchShop(String shopIdx) throws Exception{
		return shopService.getShop(Integer.parseInt(shopIdx));
		
	}
	
	@PostMapping("deleteShop.do")
	public String deleteShop(String shopIdx) throws Exception {
		bankService.deleteBank(Integer.parseInt(shopIdx));
		return "";
	}
	
	@PostMapping("searchMenu.do")
	public Menu searchMenu(String menuIdx) throws Exception{
		Menu menu = menuService.getMenuByIdx(Integer.parseInt(menuIdx));
		//System.out.println(menu);
		return menu;
		
	}
	
	@PostMapping("deleteMenu.do")
	public String deleteMenu(String menuIdx) throws Exception {
		menuService.deleteMenu(Integer.parseInt(menuIdx));
		return "";
	}
	
	
	@PostMapping("updateShopInfoForAdmin.do")
	public Shop updateShopInfoForAdmin(Shop shop) throws Exception {
		shopService.updateShop(shop);
		return shopService.getShop(shop.getShopIdx());
	}
	
	@PostMapping("updateMenuInfoForAdmin.do")
	public Menu updateMenuInfoForAdmin(String menuIdx, String shopIdx, String menuName, String menuPrice ) throws Exception {
		Menu menu = new Menu(Integer.parseInt(menuIdx),menuName,Integer.parseInt(menuPrice),Integer.parseInt(shopIdx));
		System.out.println(menu);
		return menuService.getMenuByIdx(menu.getMenuIdx());
	}
}
