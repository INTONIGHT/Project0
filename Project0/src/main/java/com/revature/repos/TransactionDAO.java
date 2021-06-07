package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.utils.JDBCConnection;

public class TransactionDAO {
	private Connection conn = JDBCConnection.getConnection();
	//this account id would be what their account is in the database.
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
	public List<String> getAllTransactions() {
		String sql = "select * from transactions;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<String> transactions = new ArrayList<String>();
			while(rs.next()) {
				transactions.add(rs.getString("username")+ rs.getString("transaction"));
			}
			return transactions;
			
		}catch(SQLException e) {
			
		}
		return null;
	}
	
	
}
