package com.service.hotplace.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.model.BankDAO;



@Repository
public class BankDAOImpl implements BankDAO{
	
	static final String NS="sql.bank.mapper.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<Bank> getBankList() throws Exception {
		return sqlSession.selectList(NS+"getBankList");
	}

	@Override
	public Bank getBank(int bankIdx) throws Exception {
		return sqlSession.selectOne(NS+ "getBankByIdx",bankIdx);
	}

	@Override
	public int registerBank(Bank bank) throws Exception {
		return sqlSession.insert(NS+"registerBank",bank);
	}

	@Override
	public int deleteBank(int bankIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NS+"deleteBank",bankIdx);
	}

	@Override
	public List<Bank> getBankByName(String bankName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"getBankByName",bankName);
	}

	@Override
	public int updateBankEnternum(Bank bank) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateBankEnternum",bank);
	}

	@Override
	public int updateBank(Bank bank) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateBank",bank);
	}

	@Override
	public List<Bank> getPartData(int idx) throws Exception {
		List<Bank>list = sqlSession.selectList(NS + "getBankPart",idx);
		System.out.println("DAO 리턴값 : " + list);
		return list;
	}

}
