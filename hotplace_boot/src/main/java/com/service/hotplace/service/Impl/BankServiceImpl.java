package com.service.hotplace.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.model.BankDAO;
import com.service.hotplace.model.impl.BankDAOImpl;
import com.service.hotplace.service.BankService;


@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankDAO bankDAO;
	
	@Override
	public List<Bank> getBankList() throws Exception {
		// TODO Auto-generated method stub
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

	@Override
	public int registerBank(Bank bank) throws Exception {
		// TODO Auto-generated method stub
		return bankDAO.registerBank(bank);
	}

	@Override
	public int deleteBank(int bankIdx) throws Exception {
		// TODO Auto-generated method stub
		return bankDAO.deleteBank(bankIdx);
	}

	@Override
	public int updateBank(Bank bank) throws Exception {
		// TODO Auto-generated method stub
		return bankDAO.updateBank(bank);
	}

	@Override
	public int updateBankEnternum(Bank bank) throws Exception {
		// TODO Auto-generated method stub
		return bankDAO.updateBankEnternum(bank);
	}



}
