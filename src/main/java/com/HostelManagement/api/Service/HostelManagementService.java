package com.HostelManagement.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HostelManagement.api.Model.HostelModel;
import com.HostelManagement.api.repo.HostelManagementRepo;

@Service
public class HostelManagementService implements IHostelManager {
	
	@Autowired
	public HostelManagementRepo hostelrepo;
	
	
	@Override
	public HostelModel SaveUser(HostelModel hostel) {
		
		return hostelrepo.save(hostel);
		
	}
}
