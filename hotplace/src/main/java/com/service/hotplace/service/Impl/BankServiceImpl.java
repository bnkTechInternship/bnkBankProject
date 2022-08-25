package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.model.BankDAO;
import com.service.hotplace.service.BankService;


@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankDAO bankDAO;

	@Override
	public List<Bank> getBankList() throws Exception {
		return bankDAO.getBankList();
	}

	@Override
	public Bank getBank(int bankIdx) throws Exception {
		// TODO Auto-generated method stub
		return bankDAO.getBank(bankIdx);
	}

	@Override
	public List<Bank> getBankByName(String bankName) throws Exception {
		// TODO Auto-generated method stub
		return bankDAO.getBankByName(bankName);
	}

}
