package com.HostelManagement.api.Controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HostelManagement.api.helper.JwtUtil;
import com.HostelManagement.api.Model.JwtRequestModel;
import com.HostelManagement.api.Model.JwtResponse;
import com.HostelManagement.api.Model.TokenModel;
import com.HostelManagement.api.Model.UserModel;
import com.HostelManagement.api.Service.CustomUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private CustomUserDetailService userService;
	
	@Autowired
	private JwtUtil util;
	
	@RequestMapping(value="/token",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody UserModel user) throws Exception 
	{
		
		//System.out.println(user);
		
		try 
		{
			this.authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
		}
		catch(UsernameNotFoundException ex) 
		{
			ex.printStackTrace(); 
			
			throw new Exception("Bad credentials");
		}
		catch(BadCredentialsException ex) {
			
			ex.printStackTrace();
			
			throw new Exception("Bad credentials try again");
		}  
		
		UserDetails userData = this.userService.loadUserByUsername(user.getEmail());
		
		String token=this.util.generateToken(userData);
		
		Date extractExpiration = this.util.extractExpiration(token);
		
		//System.out.println(token);
		//System.out.println(extractExpiration);
		
		return  ResponseEntity.ok(new JwtResponse(token,extractExpiration));
		
	}
	
	
}
