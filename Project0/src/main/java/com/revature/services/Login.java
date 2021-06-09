package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.repos.AccountDAO;
import com.revature.repos.TransactionDAO;
import com.revature.repos.UserDAO;

public class Login {
//While thi is names login this is what the user can do once logged in
	//we pass the username and password to set it to the userdao.
	public void LoginUser(String username, String password) {
		
		System.out.println("Please type Deposit and then an amount to deposit an amount in you account");
		System.out.println("\n Type Withdraw to withdraw an amount");
		System.out.println("\n Type Access to see your accounts value");
		System.out.println("\n Type Create to create another bank account assocaited with your user");
		System.out.println("\n Type Transfer to transfer money between accounts");
		System.out.println("\n Type Logout to leave");
		Scanner in = new Scanner(System.in);
		double depositAmt, withdrawAmt;
		AccountDAO adao = new AccountDAO();
		UserDAO udao = new UserDAO();
		//grab the userdata then assign it to an object of
		//type user in order to maniupulate how we want
		
		boolean running = true;
		User u = new User();
		u = udao.getUser(username, password);
		TransactionDAO tdao = new TransactionDAO();
		String transaction = "";
		int transactionId ;
		while(running) {
		switch(in.next()) {
		case "Deposit" :
			System.out.println("type the amount you wish to deposit");
			depositAmt = in.nextDouble();
			System.out.println("please type the account you want to deposit into");
			String userAccountName = in.next();
			int userId = u.getId();
			adao.deposit(depositAmt, userId, userAccountName);
			transaction = "You have deposited " + depositAmt + " into "+userAccountName+" account";
			System.out.println(transaction);
			//the thir dvalue has to be what account number they are.
			transactionId = adao.getAccountId(u.getId(), userAccountName);
			tdao.createTransaction(username, transaction, transactionId);
			break;
		case "Withdraw" :
			System.out.println("Type the amount you wish to withdraw");
			withdrawAmt = in.nextDouble();
			
			
			System.out.println("Type the account name you want to withdraw from");
			String accountName = in.next();
			int id = u.getId();
			adao.withdraw(withdrawAmt, id,accountName);
			transaction = "you have withdrawn "+withdrawAmt+" from your "+accountName+" account";
			System.out.println(transaction);
			transactionId = adao.getAccountId(u.getId(), accountName);
			tdao.createTransaction(username, transaction, transactionId);
			
			break;
		case "Access":
			//Perhaps add a way to see each individual account
			int user_id = u.getId();
			for(int i =0;i<adao.getBalance(user_id).size();i++) {
				System.out.println("your account balances are "+
			adao.getBalance(user_id).get(i) +" "+
			adao.getAccountNames(user_id).get(i)
			+" account");
			}
			transaction ="User has accessed their accounts";
			transactionId = adao.getAccountId(u.getId(), "Checkings");
			tdao.createTransaction(username, transaction, transactionId);
			break;
		case "Create":
			System.out.println("Please type either Checkings or Savings for type of account you want to create");
			String newAccountName = in.next();
			System.out.println("Type the amount you want in it");
			double accountDeposit = in.nextDouble();
			int temp_id = u.getId();
			//i ran out of ideas for var names 
			adao.createAccount(accountDeposit, newAccountName, temp_id);
			transaction = "User has attempted to create a transaction";
			//not sure how to pass a default value.
			tdao.createTransaction(username, transaction, 1);
			break;
		case "Transfer":
			int u_id = u.getId();
			if(adao.getAccountNames(u_id).size() ==1) {
				System.out.println("please create another account before transferring");
				return;
			}
			System.out.println("Type the account to transfer from");
			String firstAccount = in.next();
			System.out.println("Type the account to transer to");
			String secondAccount = in.next();
			System.out.println("Type how much you want to transfer");
			double transferAmt = in.nextDouble();
			double whatTransfered = adao.transfer(transferAmt, u_id, firstAccount, secondAccount);
			transaction = whatTransfered + " was transferred";
			transactionId = adao.getAccountId(u_id, firstAccount);
			System.out.println(transaction);
			tdao.createTransaction(username, transaction, transactionId);
			break;
		case "Logout":
			System.out.println("Have a good day!");
			break;
			default : 
				System.out.println("Please try something else");
				
		}
		}
	}
	
}
