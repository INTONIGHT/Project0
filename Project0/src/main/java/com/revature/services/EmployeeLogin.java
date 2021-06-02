package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.repos.UserRepository;

public class EmployeeLogin {

	public void loginEmployee() {
		System.out.println("Please type out Access to see the user accounts");
		System.out.println("\n Type Approve to approve an account");
		System.out.println("\n Type Modify to change an account");
		System.out.println("\n Type Logout to exit");
		boolean running = true;
		Scanner in = new Scanner(System.in);
		UserRepository ur = new UserRepository();
		User u = new User();
		while(running) {
			switch(in.next()) {
			case "Access":
				System.out.println(ur.getAll());
				break;
			case "Approve":
				System.out.println("please type out the id of the user you wish to approve");
				int temp = in.nextInt();
				String choice;
				//overriding the user based on the id to then change their status.
				u = ur.getById(temp);
				System.out.println("Type Yes if you want to approve3 otherwise type No");
				choice = in.next();
				if(choice.equals("Yes")) {
					u.setApproved(true);
				}else if(choice.equals("No")) {
					u.setApproved(false);
				}else {
					System.out.println("Please type Yes or No");
				}
			case "Modify":
				System.out.println("please type what you would like to change for the user");
				System.out.println("You should try to format it to be a user with the changes in it");
				//will try to implement ur.modify();
				
				break;
			case "Logout":
				System.out.println("Goodbye");
				running = false;
				break;
			default:
					System.out.println("Please type a valid input");
			}
		}
	}
	
}
