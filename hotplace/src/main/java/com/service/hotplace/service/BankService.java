package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.place.Bank;

public interface BankService {
	
	List<Bank> getBankList() throws Exception;
	Bank getBank(int bankIdx) throws Exception;
	List<Bank> getBankByName(String bankName) throws Exception;

}
