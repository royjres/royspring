package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.User;

public interface UserService {
	List<User> getUsers();
	
	User saveUser(User user);
	
	User getSingleUser(Long id);
	
	void deleteUser(Long id);
	
	User updateUser( User user);
}
