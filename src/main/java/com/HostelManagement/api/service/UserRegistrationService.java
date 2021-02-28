package com.HostelManagement.api.service;

import java.util.ArrayList;
import java.util.Map;


import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import org.springframework.stereotype.Service;

import com.HostelManagement.api.config.DataSourceConfig;
import com.HostelManagement.api.model.UserRegistrationModel;
import com.HostelManagement.api.model.UserResponse;

@Service
public class UserRegistrationService {

	
	
	
	DataSourceConfig config=new DataSourceConfig();
	
    
	public UserResponse registerUser(UserRegistrationModel user) {
		
		UserResponse res=new UserResponse();
		
		try {
			
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(config.getDataSource()).withProcedureName("save_User");
			 SqlParameterSource in= new MapSqlParameterSource()
					 .addValue("firstname", user.getFirstName())
					 .addValue("lastname", user.getLastName())
					 .addValue("email",user.getEmail())
					 .addValue("password", user.getPassword());
			 
			 Map<String,Object> resultFromProcedure=jdbcCall.execute(in);
			 
			 ArrayList<UserResponse> userData=new ArrayList<UserResponse>();
			 
			 ArrayList arrayList = new ArrayList();
			 
			 arrayList=(ArrayList) resultFromProcedure.get("#result-set-1");
			 
			 if(arrayList.size()>0) 
			 { 
				 Map resultMap=(Map)arrayList.get(0);
				 res.setUserId((Integer)resultMap.get("userid"));
				 res.setEmail((String)resultMap.get("Email"));
				 
				 
			 }
			 else 
			 {
				return null;
			 }
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		return res;
		
	}
	
	
}
