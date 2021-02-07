package com.HostelManagement.api.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		if(username.equals("jyotirmaya@gmail.com"))
		{
			return new User("jyotirmaya@gmail.com","jyotirmaya",new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		
	}

	
}
