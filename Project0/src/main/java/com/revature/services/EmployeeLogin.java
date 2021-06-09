package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.repos.AccountDAO;
import com.revature.repos.TransactionDAO;
import com.revature.repos.UserDAO;


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
		UserDAO udao = new UserDAO();
		TransactionDAO tdao = new TransactionDAO();
		while(running) {
			switch(in.next()) {
			case "Access":
				List<User> users = udao.getAll();
				for(User customers :users) {
					System.out.println(customers);
				}
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
				break;
			case "Modify":
				//modifies user with an id and can change as desired.
				System.out.println("Please type the id of the user you want to modify");
				int select_id = in.nextInt();
				System.out.println("you will now output any values you want to change,Start with username");
				String username = in.next();
				System.out.println("\n Now the password");
				String password = in.next();
				String role = "user";
				boolean approved = true;
				System.out.println("Type the balance you want them to have");
				double balance = in.nextDouble();
				u.setId(select_id);
				u.setUsername(username);
				u.setPassword(password);
				u.setRole(role);
				u.setApproved(approved);
				u.setBalance(balance);
				boolean success = udao.update(u);
				if(success) {
					System.out.println("You have succesfully modified the user. pleas tell them the changes");
				}
				break;
			case "Transactions":
				List<String> transactions = tdao.getAllTransactions();
				for(String t : transactions) {
					System.out.println(t);
				}
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
