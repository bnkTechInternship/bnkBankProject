package com.service.hotplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	// 설문조사 DB 저장
	public int registerSurvey(Survey survey) throws Exception{
		int result = surveyService.registerSurvey(survey);
		return result;
	}
}