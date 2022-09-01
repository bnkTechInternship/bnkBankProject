package com.service.hotplace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.service.UserService;

@Controller
public class UserInfoController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	//@RequestMapping("userInfo.do")
	public String userInfoDo(HttpSession session, Model model) {
		
		System.out.println("userInfodo호출!!!!");
		User user =(User)session.getAttribute("user");
		
		if(user!= null) {
			model.addAttribute("user",user);
			return "User";
		}else {
			return "";
		}
		
		//System.out.println(user);
		//return user;
	}
	
	

}
