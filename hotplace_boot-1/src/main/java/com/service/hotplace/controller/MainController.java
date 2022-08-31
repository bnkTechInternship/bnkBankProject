package com.service.hotplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.ShopService;

@Controller
public class MainController {
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	BankService bankService;

	@GetMapping("/shop/init")
	@ResponseBody
	public List<Shop> sendInitData(String number) throws Exception {
		
		List<Shop>list = shopService.getPartData(Integer.parseInt(number));
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
}
