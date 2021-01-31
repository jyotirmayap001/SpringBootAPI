package com.HostelManagement.api.Service;


import java.io.Console;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.HostelManagement.api.Model.User;
import com.HostelManagement.api.Model.UserResponse;
import com.HostelManagement.api.config.DataSourceConfig;
import com.HostelManagement.api.repo.UserRegistrationRepo;

@Service
public class UserRegistration implements UserRegistrationRepo {

	  DataSourceConfig config=new DataSourceConfig();
	
	@Override
	public UserResponse saveUser (User user) {
		
	try {
			
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(config.getDataSource()).withProcedureName("save_User");
		
		 SqlParameterSource in= new MapSqlParameterSource().addValue("firstname",user.getFirstName()).addValue("lastname", user.getLastName())
				 .addValue("email", user.getEmail()).addValue("password",user.getUserPassWord());
		 
		 Map<String,Object> resultFromProcedure=jdbcCall.execute(in); 
		 
		 UserResponse userRes=new UserResponse();
		 
		 ArrayList<UserResponse> userData=new ArrayList<UserResponse>();
		 
		 ArrayList arrayList = new ArrayList();
		 
		 arrayList=(ArrayList) resultFromProcedure.get("#result-set-1");
		 
		 Map resultMap=(Map)arrayList.get(0);
		 
		 
		 userRes.setUserId((Integer)resultMap.get("userid"));
		 userRes.setEmail((String)resultMap.get("Email"));
		
		 return userRes;
		}
		catch(Exception ex) {
			
			String message=ex.getMessage();
			
			return new UserResponse();
		}
		
		
	}


}
