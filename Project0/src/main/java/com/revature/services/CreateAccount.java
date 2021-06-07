package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.models.User;
import com.revature.repos.AccountDAO;
import com.revature.repos.UserDAO;
public class CreateAccount {
//could create an instance of userdao here and 
	//then check to see if there are duplicates.
	public void createAccount() {
		Scanner in = new Scanner(System.in);
		List<User> users = new ArrayList<User>();
		UserDAO udao = new UserDAO();
		AccountDAO adao = new AccountDAO();
		users = udao.getAll();
		System.out.println("please type in a username you want");
		String username = in.next();
		for(User u : users) {
			if(u.getUsername().equals(username)) {
				System.out.println("please chose a different username");
				createAccount();
			}
		}
		
		System.out.println("Please type a password you want");
		String password = in.next();
		System.out.println("Type out the balance you want to give to your account");
		double amount = in.nextDouble();
		String role = "user";
		//this is a hacky way to hard code this.
		adao.createUser(username, password,role, amount); 
		System.out.println("your account request has been sent in");
		
		
	}
	
}
