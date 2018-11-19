package com.cg.kyc.service;

import java.util.List;

import com.cg.kyc.dto.Wallet;

public interface Iwalletservice {
	public Wallet createAccount(Wallet wallet);
    public Wallet withdrawAmount(String mobno,double amount);
	public List<Wallet> showAccount();
	public Wallet depositAmt(String mobno,double amount);
}
