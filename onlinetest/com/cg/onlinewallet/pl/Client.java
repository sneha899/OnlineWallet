package com.cg.onlinewallet.pl;


import java.util.List;
import java.util.Scanner;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.dao.AccountDao;
import com.cg.onlinewallet.dao.AccountDaoMapImpl;
import com.cg.onlinewallet.exception.AccountException;
import com.cg.onlinewallet.service.AccountService;
import com.cg.onlinewallet.service.AccountServiceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class Client {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		AccountService accountService=new AccountServiceImpl();
		AccountDao accountDao=new AccountDaoMapImpl();
		int choice=0;
		WalletAccount walletAccount=null;
		WalletTransaction walletTransaction=null;
		List<WalletTransaction> list=null;
		while(choice!=6)
		{
			System.out.println("1.create wallet account ");
			System.out.println("2.withdraw ");
			System.out.println("3.deposit");
			System.out.println("4.delete account");
			System.out.println("5.print Transactions");
			System.out.println("Enter your choice");
		
	        choice = scanner.nextInt();
	        
	        switch(choice)
	        {
	        case 1:
	        	//System.out.println("enter accountId");
	        	//int accountId = scanner.nextInt();
	        	System.out.println("enter balance");
	        	double balance = scanner.nextDouble();
	        	
	        	
	        	
	        	walletAccount = new WalletAccount();
	        	walletTransaction=new WalletTransaction();
	        	walletTransaction.setAccountBalance(balance);
	        	//walletAccount.setAccountId(accountId);
	        	walletAccount.setBalance(balance);
	        	
	        	try {
	        		int id = accountDao.createWalletAccount(walletAccount);
	        		System.out.println("Account id is "+id);
	        		
	        	}
	        	catch(AccountException  e)
	        	{
	        		System.err.println(e.getMessage());
	        	}
	        	break;
	        	
	        case 2:
	        	try {
	        	 System.out.println("Enter account Id");
	        	 
	        		 int id = scanner.nextInt();
	        		 System.out.println("enter amount to withdraw");
	        		 double amount = scanner.nextDouble();
	        		 double balance1= accountService.withdraw(id, amount);
	        		 

	 	        	
	 	        	walletAccount.setAccountId(id);
	 	        	walletAccount.setBalance(balance1);
	 	        	//walletTransaction=new WalletTransaction();
		        	//walletTransaction.setAmount(amount);
	        		 
	        		// double balance1=walletAccount.getBalance();
	        		 
	        	 }
	        	catch(AccountException  e)
	        	{
	        		System.err.println(e.getMessage());
	        	}
	        	break;
	        	
	        case 3:
	        	
	        	try {
		        	 System.out.println("Enter account Id");
		        	 
		        		 int id = scanner.nextInt();
		        		 System.out.println("enter amount to deposit");
		        		 double amount = scanner.nextDouble();
		        		double balance2 = accountService.deposit(id, amount);
		        		
		        		walletAccount = new WalletAccount();
		 	        	walletAccount.setAccountId(id);
		 	        	walletAccount.setBalance(balance2);
		 	        	walletTransaction=new WalletTransaction();
			        	walletTransaction.setAmount(amount);
		        		 
		        	 }
		        	catch(AccountException  e)
		        	{
		        		System.err.println(e.getMessage());
		        	}
		        	break;
		        	
	        case 4:  try 
	                 {
	                  System.out.println("Enter account id to delete");
	        	      int id = scanner.nextInt();
        		     
        		        walletAccount=accountService.deleteAccount(id);
	                  }
	              catch(AccountException  e)
        	     {
        		  System.err.println(e.getMessage());
        	     }
	             break;
	        
	       // case 5:try
	              // {
	        	//System.out.println("enter transaction id");
	        	//int transactionId = scanner.nextInt();
	        //	DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        	//LocalDate date=LocalDate.now();
	        //	DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("hh-mm-ssss");
	        //	LocalTime time=LocalTime.now();
	        	//  list=accountService.findAllTransaction(transactionId);
	              // for(WalletTransaction wt:list) {
	            //	   int id=wt.getTransactionId();
	            //	   String des=wt.getDescription();
	            	//   double amount=wt.getAmount();
	            	  // double accBal=wt.getAccountBalance();
	            	 //  wt.setDateOfTransaction(date);
	            	  // LocalDate d=wt.getDateOfTransaction();
	        	  //   System.out.println(" id is "+id + " amount is"+amount+ " description"+ des+" at" + time +"on" + date);
	           //    }
	             //  }
	          //       catch(AccountException  e)
   	                //   {
   		             //   System.err.println(e.getMessage());
   	                 // }
	                // break;
	        case 6:
	        	System.out.println("Thank you");
	        	return;
	        	}
	        }
	        
	        
	        	
		}
	}


