package com.HostelManagement.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Bad Credentials")
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(){}

}
