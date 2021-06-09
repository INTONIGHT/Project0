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

public class AccountDAO implements Account {
	private Connection conn = JDBCConnection.getConnection();
	UserDAO udao = new UserDAO();

	public ArrayList<Double> getBalance(Integer id) {
		String sql = "select u.username,a.accountbalance,a.accountname\r\n" + "from users u \r\n"
				+ "left join accounts a on u.id = a.user_id \r\n" + "where u.id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			ArrayList<Double> result = new ArrayList<Double>();
			while (rs.next()) {

				result.add(rs.getDouble("accountbalance"));

			}

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// my way of making it return something but still be an error
		// this will let you rturn a list with just a negative value
		ArrayList<Double> result = new ArrayList<Double>();
		result.add(-1.0);
		return result;
	}

	public ArrayList<String> getAccountNames(int id) {
		String sql = "select u.username,a.accountbalance,a.accountname\r\n" + "from users u \r\n"
				+ "left join accounts a on u.id = a.user_id \r\n" + "where u.id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<String> result = new ArrayList<String>();
			while (rs.next()) {
				result.add(rs.getString("accountname"));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<String> result = new ArrayList<String>();
		result.add("-1.0");
		return result;
	}

	public int getAccountId(int userId, String accountName) {
		String sql = "select id from accounts where user_id = ? and accountname = ?; ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, accountName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int result = rs.getInt("id");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double getBalance(int id, String accountName) {
		String sql = "select accountbalance from accounts where user_id = ? and accountname = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, accountName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				double result = rs.getDouble("accountbalance");
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1.0;
	}

	@Override
	public double withdraw(double amount, int id, String accountName) {
		String sql = "update accounts set accountbalance = ? where user_id =? and accountname = ? ;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			AccountDAO adao = new AccountDAO();
			double userAccountValue = adao.getBalance(id, accountName);

			if (amount > userAccountValue) {
				System.out.println("your amount is greater than whats in your account");
				return -1;
			}
			// setting the amount to be equal to the users account value minus what they are
			// withdrawing
			double temp = userAccountValue - amount;
			amount = temp;
			ps.setDouble(1, amount);
			ps.setInt(2, id);
			ps.setString(3, accountName);
			boolean success = ps.execute();

			// not ideal to do this.
			// updateAccount(amount,accountName,id);
			if (success) {
				// returning the amount so it can be printed out
				return amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// this can be an error amount.
		return -1;
	}

	// ok i have to change get balance.
	@Override
	public double deposit(double amount, int id, String accountName) {
		String sql = "update accounts set accountbalance = ? where user_id =? and accountname = ? ;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			AccountDAO adao = new AccountDAO();
			double userAccountValue = adao.getBalance(id, accountName);

			double temp = userAccountValue + amount;
			amount = temp;
			ps.setDouble(1, amount);
			ps.setInt(2, id);
			ps.setString(3, accountName);
			boolean success = ps.execute();
			// updateAccount(amount,accountName,id);
			if (success) {
				return amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double transfer(double amount, int id, String accountFrom, String accountTo) {
		// for now it might be ebst to do two calls not ideal but ehhhhh.
		String sql = "update accounts set accountbalance = ? where user_id = ? and accountname = ?;";
		String sql2 = "update accounts set accountbalance = ? where user_id = ? and accountname = ?;";
		try {
			AccountDAO adao = new AccountDAO();
			double userWithdraw = adao.getBalance(id, accountFrom);
			double userDeposit = adao.getBalance(id, accountTo);
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			//one of these will handle a deposit essentially and one a withdraw
			double temp = userWithdraw - amount;
			if(temp < 0) {
				System.out.println("You dont have enough funds in that account");
			return -1;
			}
			double temp2 = userDeposit + amount;
			ps.setDouble(1, temp);
			ps.setInt(2, id);
			ps.setString(3, accountFrom);
			
			ps2.setDouble(1, temp2);
			ps2.setInt(2, id);
			ps2.setString(3, accountTo);
			boolean success = ps.execute();
			boolean success2 = ps2.execute();
			//bad coding practice but its being weird.
			return temp2;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean createUser(String username, String password, String role, double balance) {
		// might have to modify this lots of variables to take in
		String sql = "insert into users values(" + "default,?,?,?,false,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, role);
			ps.setDouble(4, balance);
			boolean success = ps.execute();
			if (success) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean createAccount(double balance, String accountName, int userId) {
		String sql = "insert into accounts values(" + "default,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, accountName);
			ps.setInt(3, userId);
			boolean success = ps.execute();
			if (success) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean approveUser(int id, boolean approvalStatus) {
		String sql = "update users set isApproved = ? where id = ?; ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, approvalStatus);
			ps.setInt(2, id);
			boolean success = ps.execute();
			if (success) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
