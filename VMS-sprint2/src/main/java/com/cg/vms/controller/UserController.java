package com.cg.vms.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exception.UserNotFoundException;
import com.cg.vms.model.User;
import com.cg.vms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/adduser") //http://localhost:8080/user/adduser
	public User addUser(@Valid @RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@GetMapping("/validate/{userId}/{emailId}/{password}")
	public Optional<User> loginUser(@PathVariable Long userId ,@PathVariable String emailId , @PathVariable String password) throws UserNotFoundException {
		 return userService.loginUser(userId,emailId,password);
	}
}
