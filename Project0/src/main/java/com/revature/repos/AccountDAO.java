package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.JDBCConnection;

public class AccountDAO implements Account{
	private Connection conn = JDBCConnection.getConnection();	
	public double getBalance(Integer id) {
		String sql = "select balance from users where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			double result = 0;
			if(rs.next()) {
				result = rs.getDouble("balance");
				return result;
			}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		//my way of making it return something but still be an error
		return -1;
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}

}
