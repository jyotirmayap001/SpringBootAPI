
package com.HostelManagement.api.Model;

public class JwtRequestModel {

	String tokendata;

	public JwtRequestModel()
	{
		
	}
	
	public JwtRequestModel(String tokendata) {
		super();
		this.tokendata = tokendata;
	}

	public String getTokendata() {
		return tokendata;
	}

	public void setTokendata(String tokendata) {
		this.tokendata = tokendata;
	}

	
	
	
}
