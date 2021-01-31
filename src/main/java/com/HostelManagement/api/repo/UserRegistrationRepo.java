package com.HostelManagement.api.repo;

import org.springframework.stereotype.Repository;

import com.HostelManagement.api.Model.User;
import com.HostelManagement.api.Model.UserResponse;

@Repository
public interface UserRegistrationRepo {

	public UserResponse saveUser(User user);
}
