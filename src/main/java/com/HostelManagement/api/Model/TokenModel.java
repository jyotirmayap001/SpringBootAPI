package com.HostelManagement.api.Model;

public class TokenModel {

	String isExpiry;

	public TokenModel() {}

	
	
	public TokenModel(String isExpiry) {
		super();
		this.isExpiry = isExpiry;
	}



	public String getIsExpiry() {
		return isExpiry;
	}

	public void setIsExpiry(String isExpiry) {
		this.isExpiry = isExpiry;
	}
	
	
	
	
}
