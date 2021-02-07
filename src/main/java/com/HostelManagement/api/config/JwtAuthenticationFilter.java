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
import com.HostelManagement.api.Service.CustomUserDetailService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private CustomUserDetailService userService;
	
	@Autowired
	private JwtUtil util;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		
	
		String requestTokenHeader=request.getHeader("Authorization");
		
		String UserName=null;
		
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			
			jwtToken=requestTokenHeader.substring(7);
			
			try {
				
				UserName=this.util.extractUsername(jwtToken);
				
			}
			catch(Exception ex) {ex.printStackTrace();}
			
			UserDetails userDetails = this.userService.loadUserByUsername(UserName);
			
			if(UserName!=null && SecurityContextHolder.getContext().getAuthentication()==null )
			{
				
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
							new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					
			}
			else
			{
				
				System.out.println("Token is not valid... ");
			}
			
			
		}	
		
		filterChain.doFilter(request, response);
	}

}
