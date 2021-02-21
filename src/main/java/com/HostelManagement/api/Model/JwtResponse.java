package com.HostelManagement.api.model;

import java.util.Date;

public class JwtResponse {

	String message;
	Integer status;
	JwtData data;
	
	
	public JwtResponse() {}


	public JwtResponse(String message, Integer status, JwtData data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
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


	public JwtData getData() {
		return data;
	}


	public void setData(JwtData data) {
		this.data = data;
	}


	
			
	
	 
}
