package com.revature.services;

import java.util.Scanner;

import com.revature.repos.EmployeeRepository;
import com.revature.repos.UserRepository;
import com.revature.utils.MockDB;

public class ProcessInput {

	public void processString() {
		//try to change this logic to fit what Ive designed.
		Scanner in = new Scanner(System.in);
		//for now this is dummy data later on we will change this
		UserRepository ur = new UserRepository();
		EmployeeRepository er = new EmployeeRepository();
		boolean running = true;
		String username, password;
		
		//ideally we want a way to close this while loop.
		//ok it doesnt let you log out yet.
		
		while(running) {
			System.out.println("Type Logout to leave the program");
			System.out.println("Please type in your user name:");
			username = in.nextLine();
			System.out.println("Please type in your password:");
			password = in.nextLine();
			
			//here we will want to verify that the username
			//and password are correct.
			//this might not work
			//|| username.equals(er.getUsername(username)) && password.equals(er.getPassword(password))
			//remove this.
			
			try {
			if((username.equals(ur.getUsername(username)) && password.equals(ur.getPassword(password)))) {
				//here we will want to log into the program and show the account
				//for now we will pass a  dummy function
				//login();
				System.out.println("Success");
				//this currently throws an error
			} else if(in.nextLine().equals("Logout")) {
				running = false;
			}else {
				System.out.println("Please retype your username and password");
			}
			} catch(NullPointerException e) {
				System.out.println(ur.getUsername(username));
				System.out.println(e.getStackTrace());
			}
		}
		
	}
	
}
