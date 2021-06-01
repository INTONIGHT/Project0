package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.repos.EmployeeRepository;
import com.revature.repos.UserRepository;
import com.revature.utils.MockDB;
import com.revature.services.CreateAccount;
public class ProcessInput {

	public void processString() {
		//try to change this logic to fit what Ive designed.
		Scanner in = new Scanner(System.in);
		//for now this is dummy data later on we will change this
		UserRepository ur = new UserRepository();
		EmployeeRepository er = new EmployeeRepository();
		CreateAccount ca = new CreateAccount();
		boolean running = true;
		String username, password ;
		User realUser; 
		int findUser ,switchCase ;
		//might change this
		boolean findPass;
		//ints to find the username and password in the list maybe.
		//ideally we want a way to close this while loop.
		//ok it doesnt let you log out yet.
		
		while(running) {
			System.out.println("Type 1 to create an account 2 to login 3 to logout");
			switchCase = in.nextInt();
			switch(switchCase) {
			case 1:
				ca.createAccount();
				break;
			case 2 :
				//it looks like username is set to the in.nextInt()
				System.out.println("Please type in your user name:");
				username = in.next();
				System.out.println("Please type in your password:");
				password = in.next();
				
				findUser = ur.getUsername(username);
				//now it should return a boolean.
				findPass = ur.getPassword(username,password);
				
				realUser = ur.getById(findUser);
				
				try {
				if(username.equals(realUser.getUsername()) && findPass == true) {
					//can now do what I want here as it works as intended.
					System.out.println(realUser);
					//it will go back to the while not sure what to do then 
					//maybe escape the while and or run another function
					//so that a user can interact with their account.
				} else {
					System.out.println("Please retype your username and password");
				}
				} catch(NullPointerException e) {
					System.out.println(ur.getUsername(username));
					System.out.println(e.getStackTrace());
				}
			break;
			case 3:
				System.out.println("Have a good day");
				running = false;
				break;
			default :
				System.out.println("Please type a number between 1 and 3");
			}
			
			
			
			
		
			
		}
		
	}
	public void login() {
		System.out.println("Please type Deposit and then an amount to deposit an amount in you account");
		System.out.println("\n Type withdraw to withdraw an amount");
	}
}
