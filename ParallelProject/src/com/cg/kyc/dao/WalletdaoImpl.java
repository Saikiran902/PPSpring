package com.cg.kyc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.kyc.dto.Wallet;

@Repository("walDao")
public class WalletdaoImpl implements Iwalletdao {
    
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Wallet createAccount(Wallet wallet) {
		// TODO Auto-generated method stub
		em.persist(wallet);
		em.flush();
		

		return wallet;
	}

	@Override
	public List<Wallet> showAccount() {
		// TODO Auto-generated method stub
		Query queryOne = em.createQuery("FROM Wallet");
		List<Wallet> myList= queryOne.getResultList();
		return myList;
	
	}

	@Override
	public Wallet getAccountDetails(String mobno) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Wallet wal = em.find(Wallet.class, mobno);
		em.getTransaction().commit();
		return wal;
	}

	@Override
	public Wallet setAccountDetails(String mobno,double amt) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
	
}
