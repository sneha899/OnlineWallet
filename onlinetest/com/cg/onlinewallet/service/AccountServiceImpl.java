package com.cg.onlinewallet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.dao.AccountDao;
import com.cg.onlinewallet.dao.AccountDaoMapImpl;
import com.cg.onlinewallet.exception.*;

public class AccountServiceImpl implements AccountService
{
	
	private AccountDao accountDao;
	public AccountServiceImpl() 
	{
		accountDao = new AccountDaoMapImpl();
		
	}
    @Override
	public void fundTransfer(int accountId1 , int accountId2 , double amount) throws AccountException
	{
		

	
	}
	@Override
	public int createWalletAccount(WalletAccount account) throws AccountException
	  {
		Random random=new Random();
		int accountId=random.nextInt(100)+1000;
		


		
		account.setAccountId(accountId);
	
		return accountDao.createWalletAccount(account);
	}

	@Override
	public double withdraw(int accountId, double amount) throws AccountException {
		
		
		
		WalletAccount walletAccount = accountDao.find(accountId);
		WalletTransaction transaction = new WalletTransaction();
		
		List<WalletTransaction>   list = new ArrayList<WalletTransaction>();
		list.add(transaction);
		
		transaction.setDescription(" amount withdrawn ");
		
		Random random=new Random();
		int transactionId=random.nextInt(100)+1000;
		transaction.setTransactionId(transactionId);
		
		//walletAccount.addTransaction(transaction);
		double balance = accountDao.withdraw(accountId,amount);
		return balance ;
	}
		
	



	@Override
	public double deposit(int accountId, double amount) throws AccountException {
		
		return 0;
	}

	@Override
	public WalletAccount deleteAccount(int accountId) throws AccountException {
		
		return null;
		
	}
	public List<WalletTransaction> findAllTransaction(int accountId) throws AccountException
	{
		
		return null;
	}
	
}
