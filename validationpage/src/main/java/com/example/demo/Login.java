package com.example.demo;

public class Login {
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
