package com.service.hotplace.controller;

import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@PostMapping("login.do")
	public User loginDo(User user,HttpSession httpSession) throws Exception {
		User loginUser = userService.login(user);
		if(loginUser!=null) {
			httpSession.setAttribute("loginUser", loginUser);
			return loginUser;
		}
		return null;
	}
	
	@ResponseBody
	@PostMapping("idExist.do")
	public boolean idExistDo(String id) throws Exception {
		return userService.isIdExist(id);
	}
	
	@PostMapping("register.do")
	public String registerDo(User user, HttpSession httpSession) throws Exception {
		userService.registerUser(user);
		return "redirect:login.html";
	}
	
	@ResponseBody
	@RequestMapping("findId.do")
	public String findIdDo(User user) throws Exception {
		String userId = userService.findUserId(user.getUserEmail());
		User user2 = userService.getUserById(userId);
		if(user2.getUserName().contentEquals(user.getUserName()))
			return userId;
		return "error";
	}
	
	@ResponseBody
	@PostMapping("findPw.do")
	public String findPwDo(User user, Model model) throws Exception{
		String userId2 = userService.findUserId(user.getUserEmail());
		User user2 = userService.getUserById(userId2);
		if(user.getUserId().equals(user2.getUserId()))
			return user2.getUserPw();
		return "error";
	}
}
