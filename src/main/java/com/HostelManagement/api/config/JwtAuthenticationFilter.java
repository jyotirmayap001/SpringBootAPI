package com.HostelManagement.api.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.HostelManagement.api.helper.JwtUtil;
import com.HostelManagement.api.service.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;



@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private JwtUtil util;
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		
	
		String requestTokenHeader=request.getHeader("Authorization");
		
		System.out.println(request.getLocalAddr());
		System.out.println(request.getServerName());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		
		String UserName=null;
		
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			
			jwtToken=requestTokenHeader.substring(7);
			
			try {
				
				UserName=this.util.extractUsername(jwtToken);
				
			}
			catch(Exception ex) {ex.printStackTrace();}
			
			//UserDetails userDetails = this.userService.loadUserByUsername(UserName);
			
			
			/*
			 * Employee employee = new Employee(1, "Karan", "IT", 5000); String
			 * employeeJsonString = this.gson.toJson(employee);
			 * 
			 * PrintWriter out = response.getWriter();
			 * response.setContentType("application/json");
			 * response.setCharacterEncoding("UTF-8"); out.print(employeeJsonString);
			 * out.flush();
			 */ 
			
			
			
			
			/*
			 * if(UserName!=null &&
			 * SecurityContextHolder.getContext().getAuthentication()==null ) {
			 * 
			 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
			 * UsernamePasswordAuthenticationToken(userDetails,null,userDetails.
			 * getAuthorities());
			 * 
			 * usernamePasswordAuthenticationToken.setDetails(new
			 * WebAuthenticationDetailsSource().buildDetails(request));
			 * 
			 * SecurityContextHolder.getContext().setAuthentication(
			 * usernamePasswordAuthenticationToken);
			 * 
			 * } else {
			 * 
			 * System.out.println("Token is not valid... "); }
			 */
			
			
		}	
		
		filterChain.doFilter(request, response);
	}

}
