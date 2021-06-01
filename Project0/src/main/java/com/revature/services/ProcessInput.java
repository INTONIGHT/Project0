package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
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
		String username, password ;
		User realUser; 
		int findUser ;
		//might change this
		boolean findPass;
		//ints to find the username and password in the list maybe.
		//ideally we want a way to close this while loop.
		//ok it doesnt let you log out yet.
		
		while(running) {
			System.out.println("Type Logout to leave the program");
			System.out.println("Please type in your user name:");
			username = in.nextLine();
			System.out.println("Please type in your password:");
			password = in.nextLine();
			
			findUser = ur.getUsername(username);
			//now it should return a boolean.
			findPass = ur.getPassword(username,password);
			
			realUser = ur.getById(findUser);
			
			
			//here we will want to verify that the username
			//and password are correct.
			
			//|| username.equals(er.getUsername(username)) && password.equals(er.getPassword(password))
		
			System.out.println(username.equals(realUser.getUsername()) + " this is the truth value");
			try {
			if(username.equals(realUser.getUsername()) && findPass == true) {
				//can now do what I want here as it works as intended.
				System.out.println(realUser);
				
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
