package com.HostelManagement.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.HostelManagement.api.service.CustomUserDetailsService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
				.csrf()
				.disable()
				.cors()
				.disable()
				.authorizeRequests()
				.antMatchers("/login/token","/registration/registerUser")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.userDetailsService(userService);
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Bean
	public AuthenticationManager getAuthenticationManagerBean() throws Exception
	{
		return super.authenticationManager();
	}
	
}
