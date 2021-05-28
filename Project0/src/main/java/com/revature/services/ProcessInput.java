package com.revature.services;

import java.util.Scanner;

public class ProcessInput {

	public void processString() {
		Scanner in = new Scanner(System.in);
		//for now this is dummy data later on we will change this
		String correctUsername = "test";
		String correctPassword = "password";
		boolean running = true;
		String username, password;
		
		//ideally we want a way to close this while loop.
		while(running) {
			System.out.println("Type Logout to leave the program");
			System.out.println("Please type in your user name:");
			username = in.nextLine();
			System.out.println("PLease type in your password:");
			password = in.nextLine();
			//here we will want to verify that the username
			//and password are correct.
			if(username == correctUsername && password == correctPassword) {
				//here we will want to log into the program and show the account
				//for now we will pass a  dummy function
				login();
				//this currently throws an error
			} else if(in.nextLine().equals("Logout")) {
				running = false;
			}else {
				System.out.println("Please retype your username and password");
			}
		}
		
	}
	
}
