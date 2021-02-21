package com.HostelManagement.api.model;

public class UserResponse {

	private Integer UserId;
	private String Email;
	
	public UserResponse() {}
	
	public UserResponse(Integer userId, String email) {
		super();
		UserId = userId;
		Email = email;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
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
