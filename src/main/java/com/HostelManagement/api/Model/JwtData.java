package com.HostelManagement.api.model;

import java.util.Date;

public class JwtData {

	String Token;
	Date ExpiryDate;
	
	public JwtData() {}
	
	
	public JwtData(String token, Date expiryDate) {
		super();
		Token = token;
		ExpiryDate = expiryDate;
	}
	
	
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public Date getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		ExpiryDate = expiryDate;
	}
	
	
	
}
