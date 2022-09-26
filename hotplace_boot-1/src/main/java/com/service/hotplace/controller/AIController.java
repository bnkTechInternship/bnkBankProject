package com.service.hotplace.controller;

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
	public boolean isExist(String userId) throws Exception {
		boolean flag = surveyService.isExistSurvey(userId);
		if(flag) { // 즉 등록된 데이터가 있다. 여기서 머신러닝 연결하고 데이터 받아오기
			
		}
		return flag;
	}
	
	@GetMapping("recommand/registInfo")
	public String testFnc(Survey survey) throws Exception {
		surveyService.registerSurvey(survey);
		return "redirect:/recommand.html";
	}
	
}