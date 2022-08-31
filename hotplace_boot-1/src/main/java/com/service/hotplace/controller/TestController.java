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
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("login.do")
	public String loginDo(User user,HttpSession httpSession,HttpServletResponse response) throws Exception {
		System.out.println("=============================로그인 요청===============================");		
		if(userService.login(user)!=null) {
			httpSession.setAttribute("user", user);
			return "redirect:main.html";
		}else return "redirect:login.html";
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
	public String registerDo(User user) throws Exception {
		System.out.println("===============================회원가입==================================");
		System.out.println(user);
		userService.registerUser(user);
		return "redirect:main.html";
	}
	
	@RequestMapping("findId.do")
	public String findIdDo(User user,Model model) throws Exception {
		System.out.println("=================================================아이디 찾기======================================");
		String userId = userService.findUserId(user.getUserEmail());
		System.out.println(userId);
		model.addAttribute("userId",userId);
		return "find_id_result.html";
	}
	
	@PostMapping("findPw.do")
	public String findPwDo(User user, Model model) throws Exception{
		System.out.println("===============================================비밀번호 찾기======================================");
		String userPw = userService.findUserPw(user);
		return "redirect:login.html";
	}

}