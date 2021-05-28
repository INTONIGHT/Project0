package com.revature.app;

import java.util.List;

import com.revature.models.User;
import com.revature.repos.UserRepository;

//main method will run the code here.
public class Main {

	public static void main(String[] args) {
		UserRepository ur = new UserRepository();
		
		List<User> users = ur.getAll();
		//ToDO implement that method
		//uncomment when done
		//List<User> employees = ur.getEmployees();
		for(User u : users) {
			System.out.println(u);
		}
		//It freaking works.
		System.out.println(ur.getById(3));
		//oddly it will set the id to 6 even if i set it here as 7
		User newUser = new User(7,"Test","pass","user",true);
		ur.add(newUser);
		System.out.println(ur.getAll());
		
		ur.add(newUser);
		//it now fails successfully.
		System.out.println(ur.getAll());

	}

}
