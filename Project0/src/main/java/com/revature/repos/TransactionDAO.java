package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.utils.JDBCConnection;

public class TransactionDAO {
	private Connection conn = JDBCConnection.getConnection();
	public boolean createTransaction(String username ,String transaction, int accountId ) {
		
		//the transaction table has an id which is primary key
		//username of the person making the transaction string
		//what they did for a stransaction string
		//and then a fk which is to reference to the id i think.
		String sql = "insert into transactions values("
				+ "default,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, transaction);
			ps.setInt(3, accountId);
			boolean success = ps.execute();
			if(success) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
