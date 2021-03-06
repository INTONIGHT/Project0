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
				
				//take the service layer and then exceute the query.
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				u.setApproved(rs.getBoolean("isApproved"));
				
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
		String sql = "select * from users where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				u.setApproved(rs.getBoolean("isApproved"));
				u.setBalance(rs.getDouble("balance"));
				return u;
			}
	}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUser(String username,String password) {
		String sql = "select * from users where username = ? "
				+ "and password = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				u.setApproved(rs.getBoolean("isApproved"));
				u.setBalance(rs.getDouble("balance"));
				return u;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
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
	public boolean update(User u) {
		String sql = "call update_user(?,?,?,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUsername());
			ps.setString(3,u.getPassword());
			ps.setString(4, u.getRole());
			ps.setBoolean(5, u.isApproved());
			//have to set it to float as the sql side didnt have double
			ps.setFloat(6, (float) u.getBalance());
			boolean success = ps.execute();
			if(success){
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User u) {
		String sql = "delete from users where id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			boolean success = ps.execute();
			if(success) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
