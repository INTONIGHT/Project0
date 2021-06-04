package com.revature.daotests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.models.User;
import com.revature.repos.UserDAO;

import junit.framework.Assert;

public class UserDAOTests {

	private UserDAO udao = new UserDAO();
	
	@Test
	public void getAllUsersTest(){
	List<User> users = new ArrayList<User>();
	User u = new User(1,"dummy","pass","User",true,50);
	User u2 = new User(2,"dummy","pass","User",true,50);
	User u3 = new User(3,"Tyler","password","user",true,50);
	User u4 = new User(4,"Dan","password","user",true,50);
	User u5 = new User(5,"Brandon","password","user",true,75);
	User u6 = new User(6,"Kaladin","password","user",true,26);
	User u7 = new User(7,"Elend","password","user",true,125);
	User u8 = new User(8,"Admin","password","employee",true,5);
	users.add(u);
	users.add(u2);
	users.add(u3);
	users.add(u4);
	users.add(u5);
	users.add(u6);
	users.add(u7);
	users.add(u8);
	//i know why this errors out.
	Assert.assertEquals(users, udao.getAll());
	}
}
