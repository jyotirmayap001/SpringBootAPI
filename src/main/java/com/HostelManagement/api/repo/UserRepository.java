package com.HostelManagement.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HostelManagement.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	public User findByemail(String email);
	
	//public User findByemailAnduserpassword(String email,String userpassword);
	
	
}
