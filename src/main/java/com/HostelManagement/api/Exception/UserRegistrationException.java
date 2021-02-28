package com.HostelManagement.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="Something went wrong")
public class UserRegistrationException extends RuntimeException {

	public UserRegistrationException() {}
}
