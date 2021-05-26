package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Users implements Account{
		String userName, password;
		int Balance;
		List<Account> userAccounts = new ArrayList<Account>();
		
}
