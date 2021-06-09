package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.repos.AccountDAO;


public class EmployeeLogin {

	public void loginEmployee() {
		System.out.println("Please type out Access to see the user accounts");
		System.out.println("\n Type Approve to approve an account");
		System.out.println("\n Type Modify to change an account");
		System.out.println("\n Type Transactions to see the transactions");
		System.out.println("\n Type Logout to exit");
		boolean running = true;
		Scanner in = new Scanner(System.in);
		
		AccountDAO adao = new AccountDAO();
		User u = new User();
		while(running) {
			switch(in.next()) {
			case "Access":
				//System.out.println(ur.getAll());
				break;
			case "Approve":
				System.out.println("Type out the id of the user you want to approve");
				int user_id = in.nextInt();
				System.out.println("Type Yes if you want to approve3 otherwise type No");
				String choice = in.next();
				boolean approval = true;
				if(choice.equals("Yes")) {
				adao.approveUser(user_id, approval);
				System.out.println("The user has been approved");
				}else if(choice.equals("No")) {
					approval = false;
					adao.approveUser(user_id, approval);
					System.out.println("The user has been rejected");
				}else {
					System.out.println("Please type Yes or No");
				}
			case "Modify":
				System.out.println("please type what you would like to change for the user");
				System.out.println("You should try to format it to be a user with the changes in it");
				//will try to implement ur.modify();
				
				break;
			case "Transactions":
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
