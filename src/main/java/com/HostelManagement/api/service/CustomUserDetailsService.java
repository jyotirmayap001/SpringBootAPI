package com.HostelManagement.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HostelManagement.api.config.DataSourceConfig;
import com.HostelManagement.api.model.CustomUserDetail;
import com.HostelManagement.api.model.User;
import com.HostelManagement.api.model.UserModel;
import com.HostelManagement.api.model.UserResponse;
import com.HostelManagement.api.repo.UserRepository;

@Service
public class CustomUserDetailsService  {

	
	
	DataSourceConfig config=new DataSourceConfig();
	 
	 public UserResponse loginUser(UserModel user) {
		 
		 UserResponse userRes=new UserResponse();
		 
		 try {
			 
			 SimpleJdbcCall jdbcCall = new SimpleJdbcCall(config.getDataSource()).withProcedureName("loginUser");
			 SqlParameterSource in= new MapSqlParameterSource()
					 .addValue("emailid",user.getEmail())
					 .addValue("password", user.getUserpassword());
			 
			 Map<String,Object> resultFromProcedure=jdbcCall.execute(in);
			 
			 ArrayList<UserResponse> userData=new ArrayList<UserResponse>();
			 
			 ArrayList arrayList = new ArrayList();
			 
			 arrayList=(ArrayList) resultFromProcedure.get("#result-set-1");
			 
			 if(arrayList.size()>0) 
			 { 
				 Map resultMap=(Map)arrayList.get(0);
				 userRes.setUserId((Integer)resultMap.get("UserId"));
				 userRes.setEmail((String)resultMap.get("Email"));
			 }
			 else 
			 {
				return null;
			 }
			 
			 
			 
		 }
		 catch(Exception ex){
			 
			 ex.printStackTrace();
		 }
		 
		 
		 return userRes;
	 }
	
	
}
