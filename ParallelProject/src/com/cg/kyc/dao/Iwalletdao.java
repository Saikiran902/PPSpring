package com.cg.kyc.dao;

import java.util.List;

import com.cg.kyc.dto.Wallet;

public interface Iwalletdao {
  public Wallet createAccount(Wallet wallet);

public List<Wallet> showAccount();
public Wallet getAccountDetails(String mobno);
public Wallet setAccountDetails(String mobno,double amt);
}