package com.HostelManagement.api.Model;

import java.util.Date;

public class JwtResponse {

	String Token;
	Date ExpiryDate;
	
	public JwtResponse() {
		
	}

	
	public JwtResponse(String token, Date expiryDate) {
		
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
