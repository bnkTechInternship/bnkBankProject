package com.service.hotplace.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.UserService;

@Controller
public class FlaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankService bankService;
	
	@RequestMapping("test.do")
	public String testUser(User user) throws Exception {
		String url = "http://127.0.0.1:5000/fromspring";
		String sb = "";
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			
			String line = null;
			
			while ((line = br.readLine()) != null) {
				sb = sb + line + "\n";
			}
			System.out.println("========br======" + sb.toString());
			if (sb.toString().contains("ok")) {
				System.out.println("test");
				
			}
			br.close();

			System.out.println("파이썬 출력:" + sb.toString());
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return sb;
	}
	

}
