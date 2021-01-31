package com.HostelManagement.api.Model;

public class UserResponse {

	private int UserId;
	private String Email;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@Override
	public String toString() {
		return "UserResponse [UserId=" + UserId + ", Email=" + Email + "]";
	}
	
	
	
}
