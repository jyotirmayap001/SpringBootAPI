package com.HostelManagement.api.model;

public class UserRegistrationModel {
	
	
	public String FirstName;
	public  String LastName;
	public String Email;
	public String Password;
	
	
	public UserRegistrationModel() {
		
	}
	
	
	
	public UserRegistrationModel(String firstName, String lastName, String email, String password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
	}
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}



	@Override
	public String toString() {
		return "UserRegistrationModel [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", Password=" + Password + "]";
	}
	
	

}
