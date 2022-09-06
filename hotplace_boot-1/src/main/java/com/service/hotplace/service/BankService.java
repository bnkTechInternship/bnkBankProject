package com.service.hotplace.service;

import java.util.List;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;

public interface BankService {
	// create
	int registerBank(Bank bank) throws Exception;
	
	// read
	List<Bank> getBankList() throws Exception;
	List<Bank> getBankByName(String bankName) throws Exception;
	List<Bank> getPartData(int idx) throws Exception;
	
	Bank getBank(int bankIdx) throws Exception;
	
	// update
	int updateBank(Bank bank) throws Exception;
	int updateBankEnternum(Bank bank) throws Exception; //현재 입장순번 +1 해주는 함수
	
	// delete
	int deleteBank(int bankIdx) throws Exception;
}
