package com.HostelManagement.api.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<ApiError> handleNoUserFoundException() {
		
		ApiError error=new ApiError(400,"Bad Credentitals",new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}
}


