package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

	/**
	 * THIS WILL BE IMPLEMENTED WHEN WE KNOW HOW TO CONNECT TO A DATABASE
	 */
	private static Connection conn = null;
	//definte a method to get the connection
	public static Connection getConnection() {
		//check if a connection exists.
		try {
		if(conn == null) {
			/**
			 * Dont need to know why it works
			 * 'hot fix to ensure that the driver loads correctly 
			 * when our application starts.
			 * this works for postgres
			 */
			Class.forName("org.postgresql.Driver");
			//in order to establish a connection to our DB
			//we need our credentials
			//url endpoint username,password
			//we use properties to save it that way its a bit more secure.
			Properties props = new Properties();
			InputStream input = JDBCConnection.class.getClassLoader()
								.getResourceAsStream("connections.properties");
			//just use this when you connect dont need to memorize
			//a secure way to log in.
			props.load(input);
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		} else {
			return conn;
		}
		}
		//not good practice but we lazy
		catch(SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
