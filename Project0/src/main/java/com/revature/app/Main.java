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
		User u3 = new User(2,"Tyler","password","user",true,50);
		User u4 = new User(3,"Dan","password","user",true,50);
		User u5 = new User(4,"Brandon","password","user",true,75);
		User u6 = new User(5,"Kaladin","password","user",true,26);
		User u7 = new User(6,"Elend","password","user",true,125);
		User u8 = new User(1,"Admin","password","employee",true,5);
		udao.add(u3);
		udao.add(u4);
		udao.add(u5);
		udao.add(u6);
		udao.add(u7);
		udao.add(u8);
		
		//udao.add(dummy);
		System.out.println(udao.getAll());
		System.out.println(udao.getById(1));
		//ok and now its working.
		ProcessInput pi = new ProcessInput();
		pi.processString();
		//i had to take out the excess code.
		

	}

}
