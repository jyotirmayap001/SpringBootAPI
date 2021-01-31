package com.HostelManagement.api.Model;

public class User {
	
	public Integer UserId;
	public String FirstName;
	public String LastName;
	public String Email;
	public String UserPassWord;
	
	public User() {}
	
	
	public User(String firstName, String lastName, String email, String userPassWord,Integer userid) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		UserPassWord = userPassWord;
		UserId = userid;
	}
	
	
	public Integer getUserId() {
		return UserId;
	}


	public void setUserId(Integer userId) {
		UserId = userId;
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
	public String getUserPassWord() {
		return UserPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		UserPassWord = userPassWord;
	}


	@Override
	public String toString() {
		return "User [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", UserPassWord="
				+ UserPassWord + "]";
	}
	
	

}
