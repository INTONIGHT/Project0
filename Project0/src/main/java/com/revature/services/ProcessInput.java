package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.repos.EmployeeRepository;
import com.revature.repos.UserDAO;
import com.revature.repos.UserRepository;
import com.revature.utils.MockDB;
import com.revature.services.CreateAccount;

public class ProcessInput {
//this is where the user actually logs in i know i should
	//probably rename it.
	public void processString() {
		// try to change this logic to fit what Ive designed.
		Scanner in = new Scanner(System.in);
		// for now this is dummy data later on we will change this
		UserRepository ur = new UserRepository();
		EmployeeRepository er = new EmployeeRepository();
		UserDAO udao = new UserDAO();
		CreateAccount ca = new CreateAccount();
		boolean running = true;
		String username, password, employeeUser, employeePass;
		
		int  switchCase;
		// might change this
		
		// ints to find the username and password in the list maybe.
		// ideally we want a way to close this while loop.
		

		while (running) {
			System.out.println("Type 1 to create an account 2 to login 3 to logout 4 to login as an employee");
			switchCase = in.nextInt();
			switch (switchCase) {
			case 1:
				// this breaks you got to implement it.
				ca.createAccount();
				break;
			case 2:
				// it looks like username is set to the in.nextInt()
				System.out.println("Please type in your user name:");
				username = in.next();
				System.out.println("Please type in your password:");
				password = in.next();
				
				

				try {
						udao.getUser(username, password); 
						Login log = new Login();
						log.LoginUser(username,password);
						running = false;

					
				} catch (NullPointerException e) {
					System.out.println(ur.getUsername(username));
					System.out.println(e.getStackTrace());
				}
				break;
			case 3:
				System.out.println("Have a good day");
				running = false;
				break;
			case 4 :
				System.out.println("Please type in your user name:");
				employeeUser = in.next();
				System.out.println("Please type in your password:");
				employeePass = in.next();

				
				try {
					udao.getUser(employeeUser, employeePass);
						// can now do what I want here as it works as intended.
						System.out.println(udao.getUser(employeeUser, employeePass));
						EmployeeLogin el = new EmployeeLogin();
						el.loginEmployee();
						running = false;

					
				} catch (NullPointerException e) {
					System.out.println(er.getUsername(employeeUser));
					System.out.println(e.getStackTrace());
				}
				break;
				
				
			default:
				System.out.println("Please type a number between 1 and 3");
			}

		}

	}

	
	
}
