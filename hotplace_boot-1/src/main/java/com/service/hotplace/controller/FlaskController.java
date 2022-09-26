package com.service.hotplace.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.service.hotplace.domain.person.User;
import com.service.hotplace.service.BankService;
import com.service.hotplace.service.UserService;

@Controller
public class FlaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankService bankService;
	
	@ResponseBody
	@RequestMapping("test.do")
	public String testUser(User user) throws Exception {
		String url = "http://127.0.0.1:5000/tospring";
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
	
	
	// 아마 이걸 쓰면 될거임
	@ResponseBody
	@RequestMapping("test2.do")
	public ResponseEntity<String> testUser2(User user) throws Exception {

		String url = "http://127.0.0.1:5000/fromspring";
		// 임시로 user data 추가하는 코드
		// 파이썬에 모델 적용하기 위해서 필요한 정보 밑에 기입하고...
		user.setUserId("1101");
		user.setUserAddress("거제4동 815-59번지");
		user.setRegisterDate("2022/01/10");
		
		MultiValueMap<String, User> params = new LinkedMultiValueMap<>();
		params.add(user.getUserId(), user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("header", "header");
		HttpEntity<MultiValueMap<String, User>> entity = new HttpEntity<>(params, headers);
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> response = rt.exchange(
									url,
									HttpMethod.POST,
									entity,
									String.class
									);
		
		System.out.println(response); // response에 원하는 값 리턴
		
		// response 이용해서 service 호출하고...
		// 최종 결과 아래에서 리턴 아작스 처리
		
		return response;
	}
	

}
