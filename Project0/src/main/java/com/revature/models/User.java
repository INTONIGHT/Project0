package com.revature.models;

public class User {
	private Integer id;
	private String username, password ,role ;
	boolean isApproved;
	private double balance;
	//empty constructor probably wont use it
	public User() {
		super();
	}
	//Might add more constructors but will only do that later
	public User(Integer id, String username, String password, String role, boolean isApproved, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isApproved = isApproved;
		this.balance = balance;
	}
	
	public User(Integer id, String username, String password, String role, boolean isApproved) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isApproved = isApproved;
	}
	//All the getters and setters.
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//To string because of course
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", isApproved=" + isApproved + ", balance=" + balance + "]";
	}
	//Not sure if i will use but Might be good practice
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + balance);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isApproved ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (balance != other.balance)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isApproved != other.isApproved)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
