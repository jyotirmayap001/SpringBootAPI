package com.HostelManagement.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HostelManagement.api.Model.HostelModel;
import com.HostelManagement.api.Service.HostelManagementService;

@RestController
@RequestMapping("/api")
public class HostelManagementController {

	@Autowired
	private HostelManagementService hostelservice;
	
	@PostMapping("/adduser")
	public ResponseEntity<HostelModel> registrationUser(@RequestBody HostelModel hostelmodel) 
	{
		return ResponseEntity.ok(hostelservice.SaveUser(hostelmodel));
	}
	@GetMapping("/gettestdata")
	public String getTestData() 
	{
		return "====================  Hi This build and deploy by Jenkin server Yaaaa hoooooo    ======================== ";
	}
}
