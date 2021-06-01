package com.revature.utils;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class MockDB {

	public static List<User> userList = new ArrayList<User>();
	public static List<User> employeeList = new ArrayList<User>();
	
	static {
		//user is id username pass ,role is approved can also add balance
		userList.add(new User(1,"Tyler","password","user",true));
		userList.add(new User(2,"Dan","password","user",true));
		userList.add(new User(3,"Brandon","password","user",true));
		userList.add(new User(4,"Kaladin","password","user",true));
		userList.add(new User(5,"Elend","password","user",true));
		
		employeeList.add(new User(1,"Admin","password","employee",true));
	}
	//remove this main method later on for now its to test everything is working as intended
	
	
}
