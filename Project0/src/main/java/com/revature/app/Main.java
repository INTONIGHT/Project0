package com.revature.app;

import java.util.List;

import com.revature.models.User;
import com.revature.repos.EmployeeRepository;
import com.revature.repos.UserRepository;
import com.revature.services.ProcessInput;

//main method will run the code here.
public class Main {

	public static void main(String[] args) {
		UserRepository ur = new UserRepository();
		EmployeeRepository er = new EmployeeRepository();
		ProcessInput pi = new ProcessInput();
		pi.processString();
		//i had to take out the excess code.
		

	}

}
