package com.service.hotplace.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.AI.Survey;
import com.service.hotplace.model.SurveyDAO;
import com.service.hotplace.service.SurveyService;

@Repository
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyDAO surveyDAO;

	@Override
	public int registerSurvey(Survey survey) throws Exception {
		return surveyDAO.registerSurvey(survey);
	}

}
