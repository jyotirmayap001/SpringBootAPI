package com.HostelManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HostelManagement.api.Exception.UserRegistrationException;
import com.HostelManagement.api.model.JwtResponse;
import com.HostelManagement.api.model.UserRegistrationModel;
import com.HostelManagement.api.model.UserRegistrationResponse;
import com.HostelManagement.api.model.UserResponse;
import com.HostelManagement.api.service.UserRegistrationService;

@RestController
@CrossOrigin
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userService;
	
	/*
	 * private BCryptPasswordEncoder bCryptPasswordEncoder;
	 * 
	 * 
	 * public UserRegistrationController(BCryptPasswordEncoder
	 * bCryptPasswordEncoder) {
	 * 
	 * this.bCryptPasswordEncoder=bCryptPasswordEncoder; }
	 */
	
	@PostMapping("/registerUser")
	public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationModel userRegModel)throws Exception{
		
		/*
		 * userRegModel.setPassword(new
		 * BCryptPasswordEncoder().encode(userRegModel.getPassword()));
		 */
		
		System.out.println(userRegModel);
		
		UserResponse registerUser = this.userService.registerUser(userRegModel);
		
		if(registerUser==null) {
			
			throw new UserRegistrationException();
			
		}
		
		return  new ResponseEntity(new UserRegistrationResponse("Data Found",200,registerUser),HttpStatus.OK);
		
	}
	
	

}
