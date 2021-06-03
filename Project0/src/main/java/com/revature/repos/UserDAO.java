package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.JDBCConnection;

public class UserDAO implements GenericRepository<User> {
private Connection conn = JDBCConnection.getConnection();
	@Override
	public User add(User u) {
		//id username pass role isapproved balance
		String sql = "insert into users values"
				+ "(default,?,?,?,?,?) returning *;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2,u.getPassword());
			ps.setString(3, u.getRole());
			ps.setBoolean(4, u.isApproved());
			//have to set it to float as the sql side didnt have double
			ps.setFloat(5, (float) u.getBalance());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				u.setApproved(rs.getBoolean("isApproved"));
				//this might trhow an error
				u.setBalance(rs.getDouble("balance"));
				return u;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from users;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				u.setApproved(rs.getBoolean("isApproved"));
				//this might trhow an error
				u.setBalance(rs.getDouble("balance"));
				users.add(u);
			}
			return users;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(User change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}
	
}
