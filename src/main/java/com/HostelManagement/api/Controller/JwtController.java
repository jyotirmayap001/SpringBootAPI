package com.HostelManagement.api.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HostelManagement.api.Exception.UserNotFoundException;
import com.HostelManagement.api.helper.JwtUtil;
import com.HostelManagement.api.model.CustomUserDetail;
import com.HostelManagement.api.model.JwtData;
import com.HostelManagement.api.model.JwtResponse;
import com.HostelManagement.api.model.UserModel;
import com.HostelManagement.api.model.UserResponse;
import com.HostelManagement.api.service.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;

@RestController
@CrossOrigin
public class JwtController {

	/*
	 * @Autowired private AuthenticationManager authManager;
	 */
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private JwtUtil util;
	
	@RequestMapping(value="/token",method=RequestMethod.POST)
	public ResponseEntity<JwtResponse> generateToken(@RequestBody UserModel user) throws Exception 
	{
		
		System.out.println(user);
		
		
		UserResponse userData = this.userService.loginUser(user);
		
		if (userData==null) {
			
			throw new UserNotFoundException();
		}
		
		String token=this.util.generateToken(userData);
		
		Date extractExpiration = this.util.extractExpiration(token);
		
		System.out.println(token);
		System.out.println(extractExpiration);
		
		JwtData jwtData=new JwtData();
		
		jwtData.setToken(token);
		jwtData.setExpiryDate(extractExpiration);
		
		return  new ResponseEntity(new JwtResponse("Data Found",201,jwtData),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/wish")
	public String getWelocomeMessage(){
		
		return "Hi this is my first api";
		
	}
	
}
