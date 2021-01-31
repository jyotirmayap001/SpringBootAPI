package com.HostelManagement.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HostelManagement.api.Model.HostelModel;
import com.HostelManagement.api.Model.User;
import com.HostelManagement.api.Model.UserResponse;
import com.HostelManagement.api.Service.HostelManagementService;
import com.HostelManagement.api.Service.UserRegistration;

@RestController
@RequestMapping("/api")
public class HostelManagementController {

	@Autowired
	private HostelManagementService hostelservice;
	
	@Autowired
	private UserRegistration userService;
	
	@PostMapping("/adduser")
	public ResponseEntity<UserResponse> registrationUser(@RequestBody User hostelmodel) 
	{
		return ResponseEntity.ok(userService.saveUser(hostelmodel));
	}
	@GetMapping("/getname/{name}")
	public String getTestData(@PathVariable("name") String name) 
	{
		return "====================   Hi  "+ name+"  you are using Jenkin CI/CD tool   ===========================";
	}
	
	@GetMapping("/printname/{name}")
	public String printTestData(@PathVariable("name") String name) 
	{
		return "====================   Welcome  "+ name+" to Jenkin auto deployment..! ======================== ";
	}
	
}
