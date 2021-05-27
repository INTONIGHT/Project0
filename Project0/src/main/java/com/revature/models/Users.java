package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Users implements Account{
		String userName, password , employeeName;
		int Balance;
		List<Account> AccountList = new ArrayList<Account>();
		public void User(String userName, String password, String employeeName, int balance) {
			this.userName = userName;
			this.password = password;
			this.employeeName = employeeName;
			this.Balance = balance;
		}
		
}
