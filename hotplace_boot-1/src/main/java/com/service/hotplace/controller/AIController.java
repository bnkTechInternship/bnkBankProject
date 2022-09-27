package com.service.hotplace.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.hotplace.domain.AI.Survey;
import com.service.hotplace.domain.place.Shop;
import com.service.hotplace.service.ShopService;
import com.service.hotplace.service.SurveyService;

@Controller
public class AIController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private SurveyService surveyService;
	
	// 방문인원 유형별 가게 리스트 가져오기
	@ResponseBody
	@PostMapping("getShopMemberType.do")
	public List<Shop> getShopListByMemberType(int memberType) throws Exception {
		return shopService.getShopListByMemberType(memberType);
	}
	
	@PostMapping("recommand/confirm")
	@ResponseBody
	// 리턴타입 boolean말고 다른걸로 해서 머신러닝 결과값 넘겨주기
	public List<Shop> isExist(String userId) throws Exception {
//		boolean flag = surveyService.isExistSurvey(userId); // by 근영 이거 true 나오는데 왜 설문조사 뜨지?
//		String line = "";
//	    String path = System.getProperty("user.dir");
//
//		if(flag) { // 즉 등록된 데이터가 있다. 여기서 머신러닝 연결하고 데이터 받아오기
//			
//			Survey survey = surveyService.selectSurvey(userId);
//			
//			
//			ProcessBuilder builder;
//			BufferedReader br;
//			String arg2 = path+"\\src\\main\\python\\apply_model.py";
//			
//			// 인자 넣어주는 코드
//			builder = new ProcessBuilder("python", arg2,
//													""+survey.getAge(),
//													""+survey.getMaritalStatus(),
//													""+survey.getnFamily(),
//													""+survey.getGenerType(),
//													""+survey.getEduc(),
//													""+survey.getJob(),
//													""+survey.getEcMeantime(),
//													""+survey.getEcType(),
//													""+survey.getEatoutFreq(),
//													"0"
//													);
//			
//			builder.redirectErrorStream(true);
//			Process process = builder.start();
//			int exitval = process.waitFor();
//			br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
//			
//			line = br.readLine();
//			/*
//			while((line = br.readLine()) != null) 
//				System.out.println((">>> "+ line)); // 여기서 값 얻는다 지금은 "1"
//			*/
//			
//			if(exitval != 0)
//				return null;			
//			System.out.println(shopService.getShopListByMemberType(Integer.parseInt(line))); //line이 혼밥/가족 외/가족
//			return shopService.getShopListByMemberType(Integer.parseInt(line));
//		}
		return shopService.getShopList(); //test code
//		return null;
	}
	
	@GetMapping("recommand/registInfo")
	public String testFnc(Survey survey) throws Exception {
		surveyService.registerSurvey(survey);
		return "redirect:/recommand.html";
	}
	
}