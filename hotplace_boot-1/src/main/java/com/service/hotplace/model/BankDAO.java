package com.service.hotplace.model;

import java.util.List;

import com.service.hotplace.domain.place.Bank;
import com.service.hotplace.domain.place.Shop;

public interface BankDAO {
	List<Bank> getBankList() throws Exception;
	Bank getBank(int bankIdx) throws Exception;
	List<Bank> getBankByName(String bankName) throws Exception;
	
	int registerBank(Bank bank) throws Exception;
	
	int deleteBank(int bankIdx) throws Exception;
	
	int updateBank(Bank bank) throws Exception;
	
	//현재 입장순번 +1 해주는 함수
	int updateBankEnternum(Bank bank) throws Exception;

	List<Bank> getPartData(int idx) throws Exception;
}
