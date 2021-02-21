package com.HostelManagement.api.model;

public class UserModel {

	String email;
	String userpassword;
	
	public UserModel()
	{
		
	}

	
	public UserModel(String email, String userpassword) {
		super();
		this.email = email;
		this.userpassword = userpassword;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "UserModel [email=" + email + ", userpassword=" + userpassword + "]";
	}
	
	
	
	
	
	
	
}
