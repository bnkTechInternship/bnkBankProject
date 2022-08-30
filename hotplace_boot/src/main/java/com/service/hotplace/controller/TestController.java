package com.service.hotplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.hotplace.domain.person.User;

@Controller
public class TestController {
	
	@PostMapping("login")
	public String testDo(User user,Model model) {
		System.out.println("로그인 요청들어옴");
		System.out.println(user);
		model.addAttribute("data",user);
		return "login_result";
	}

}
