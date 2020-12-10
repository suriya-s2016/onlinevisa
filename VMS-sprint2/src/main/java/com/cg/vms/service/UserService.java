package com.cg.vms.service;


import java.util.Optional;

import com.cg.vms.exception.UserNotFoundException;
import com.cg.vms.model.User;

public interface UserService {
	
	public User addUser(User user);

	public Optional<User> loginUser(Long userId,String emailId, String password) throws UserNotFoundException;
}
