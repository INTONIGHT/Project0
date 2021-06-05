package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.JDBCConnection;

public class AccountDAO implements Account{
	private Connection conn = JDBCConnection.getConnection();	
	public ArrayList<Double> getBalance(Integer id) {
		String sql = "select u.username,a.accountbalance,a.accountname\r\n" + 
				"from users u \r\n" + 
				"left join accounts a on u.id = a.user_id \r\n" + 
				"where u.id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Double> result = new ArrayList<Double>();
			while(rs.next()) {
				
				result.add(rs.getDouble("accountbalance"));
				
			}
			
			return result;
			}catch(SQLException e) {
			e.printStackTrace();
		}
		//my way of making it return something but still be an error
		//this will let you rturn a list with just a negative value
		ArrayList<Double> result = new ArrayList<Double>();
		result.add(-1.0);
		return result;
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
