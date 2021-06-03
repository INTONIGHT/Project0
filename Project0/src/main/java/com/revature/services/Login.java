package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;

public class Login {

	public void LoginUser() {
		
		System.out.println("Please type Deposit and then an amount to deposit an amount in you account");
		System.out.println("\n Type Withdraw to withdraw an amount");
		System.out.println("\n Type Access to see your accounts value");
		System.out.println("\n Type Logout to leave");
		Scanner in = new Scanner(System.in);
		double depositAmt, withdrawAmt ,temp;
		boolean running = true;
		User u = new User();
		while(running) {
		switch(in.next()) {
		case "Deposit" :
			System.out.println("type the amount you wish to deposit");
			depositAmt = in.nextDouble();
			temp = u.getBalance();
			//Im not sure if this will actually permanently change the balance
			if(depositAmt <= 0) {
				System.out.println("Please type in a correct amount above $0");
				//could be fixed for now this is just for testing.
				return;
			}
			u.setBalance(temp + depositAmt);
			System.out.println("Successfully deposited" + depositAmt + " into your account");
			break;
		case "Withdraw" :
			System.out.println("Type the amount you wish to withdraw");
			withdrawAmt = in.nextDouble();
			temp = u.getBalance();
			if(withdrawAmt > temp) {
				System.out.println("insufficient funds please withdraw less");
				return;
			}
			u.setBalance(temp - withdrawAmt);
			break;
		case "Access":
			System.out.println("Your current account balance is " + u.getBalance());
			break;
		case "Logout":
			System.out.println("Have a good day!");
			break;
			default : 
				System.out.println("Please try something else");
				
		}
		}
	}
	
}