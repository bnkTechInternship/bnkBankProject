package com.service.hotplace.controller;
//김병관 바보
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
		System.out.println("=============================로그인 요청===============================");		
		//System.out.println(user);
		User loginUser = userService.login(user);
		System.out.println(loginUser);
		if(loginUser!=null) {
			httpSession.setAttribute("loginUser", loginUser);
			System.out.println(loginUser);
			return loginUser;
		}else return null;
	}
	
	@ResponseBody
	@PostMapping("idExist.do")
	public boolean idExistDo(String id) throws Exception {
		boolean check = userService.isIdExist(id);
		//model.addAttribute("check", check);
		System.out.println(id);
		return check;
	}
	
	@PostMapping("register.do")
	public String registerDo(User user, HttpSession httpSession) throws Exception {
		System.out.println("===============================회원가입==================================");
		userService.registerUser(user);
		return "redirect:login.html";
	}
	
	
	@ResponseBody
	@RequestMapping("findId.do")
	public String findIdDo(User user) throws Exception {
		System.out.println("=================================================아이디 찾기======================================");
		String userId = userService.findUserId(user.getUserEmail());
		User user2 = userService.getUserById(userId);
		if(user2.getUserName().contentEquals(user.getUserName()))
			return userId;
		else
			return "error";
	}
	
	@ResponseBody
	@PostMapping("findPw.do")
	public String findPwDo(User user, Model model) throws Exception{
		System.out.println("===============================================비밀번호 찾기======================================");
		String userId2 = userService.findUserId(user.getUserEmail());
		User user2 = userService.getUserById(userId2);
		if(user.getUserId().equals(user2.getUserId()) )
			return user2.getUserPw();
		else
			return "error";
		
	}
	
	
	
	

}
