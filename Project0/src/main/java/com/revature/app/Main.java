package com.revature.app;

import java.util.List;

import com.revature.models.User;
import com.revature.repos.EmployeeRepository;
import com.revature.repos.UserDAO;
import com.revature.repos.UserRepository;
import com.revature.services.ProcessInput;

//main method will run the code here.
public class Main {

	public static void main(String[] args) {
		UserRepository ur = new UserRepository();
		EmployeeRepository er = new EmployeeRepository();
		UserDAO udao = new UserDAO();
		User dummy = new User(6,"dummy","pass","User",true,50);
		System.out.println(udao.getAll());
		
		ProcessInput pi = new ProcessInput();
		pi.processString();
		//i had to take out the excess code.
		

	}

}
