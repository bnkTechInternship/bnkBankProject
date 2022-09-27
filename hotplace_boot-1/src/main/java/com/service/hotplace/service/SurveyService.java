package com.service.hotplace.service;
import java.util.List;

import com.service.hotplace.domain.AI.Survey;
import com.service.hotplace.domain.place.Shop;

public interface SurveyService {
	//create
	int registerSurvey(Survey survey) throws Exception;
	
	//read
	boolean isExistSurvey(String userId) throws Exception;
	
	Survey selectSurvey(String userId) throws Exception;
}
