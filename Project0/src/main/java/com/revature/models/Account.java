package com.revature.models;

import java.util.ArrayList;

public interface Account {
	public ArrayList<Double> getBalance(Integer t);
	public void withdraw();
	public void deposit();
	
	
}
