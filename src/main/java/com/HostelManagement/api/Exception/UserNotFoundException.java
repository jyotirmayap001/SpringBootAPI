package com.HostelManagement.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String msg){
		
		super(msg);
	}

}
