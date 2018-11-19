package com.cg.kyc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kyc.dao.Iwalletdao;
import com.cg.kyc.dto.Wallet;

@Service("walSer")
@Transactional
public class WalletserviceImpl implements Iwalletservice {
	@Autowired
	Iwalletdao walDao;

	@Override
	public Wallet createAccount(Wallet wallet) {
		// TODO Auto-generated method stub
		return walDao.createAccount(wallet);
	}

	@Override
	public List<Wallet> showAccount() {
		// TODO Auto-generated method stub
		return walDao.showAccount();
	}

	@Override
	public Wallet withdrawAmount(String mobno, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wallet depositAmt(String mobno, double amount) {
		// TODO Auto-generated method stub
		Wallet walDeposit = walDao.getAccountDetails(mobno);
		double balance=walDeposit.getBalance()+amount;
		walDao.setAccountDetails(mobno, balance);
		return walDao.getAccountDetails(mobno);
	}

	

	
  
}
