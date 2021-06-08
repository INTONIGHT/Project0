package com.revature.models;

import java.util.ArrayList;

public interface Account {
	public ArrayList<Double> getBalance(Integer t);
	public double withdraw(double amt,int id,String accountName);
	public double deposit(double amt,int id,String accountName);
	
	
}
