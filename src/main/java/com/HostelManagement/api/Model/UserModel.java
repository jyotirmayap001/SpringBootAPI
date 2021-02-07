package com.HostelManagement.api.Model;

public class UserModel {

	String email;
	String password;
	
	public UserModel()
	{
		
	}
	
	
	public UserModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
