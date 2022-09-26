package com.service.hotplace.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.AI.Survey;
import com.service.hotplace.model.SurveyDAO;

@Repository
public class SurveyDAOImpl implements SurveyDAO {
	
	@Autowired
	private SqlSession sqlsession;
	static final String NS="sql.hotplace.mapper2.";

	@Override
	public int registerSurvey(Survey survey) throws Exception {
		return sqlsession.insert(NS+"registerSurvey", survey);
	}

	@Override
	public boolean isExistSurvey(String userId) throws Exception {
		Survey survey = sqlsession.selectOne(NS + "selectSurvey",userId);
		if(survey != null) return true;
		return false;
	}

}
