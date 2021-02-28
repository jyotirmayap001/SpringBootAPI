package com.HostelManagement.api.model;

public class UserRegistrationResponse {
	
	 String message;
	 Integer status;
	 UserResponse data;
	
	public UserRegistrationResponse() {}
	
	
	public UserRegistrationResponse(String message, Integer status, UserResponse user) {
		super();
		this.message = message;
		this.status = status;
		this.data = user;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public UserResponse getUser() {
		return data;
	}


	public void setUser(UserResponse user) {
		this.data = user;
	}
	
	
	
}
