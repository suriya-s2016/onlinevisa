package com.cg.vms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.exception.UserNotFoundException;
import com.cg.vms.model.User;
import com.cg.vms.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;
	

	public UserRepository getUserRepo() {
		return userRepo;
	}



	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}



	@Override
	public Optional<User> loginUser(Long userId,String emailId, String password) throws UserNotFoundException {
		
		Optional<User> user = getUserRepo().findById(userId);
		try {
			if(user.isPresent())
			{
				if((emailId.equals(user.get().getEmailId())) && (password.equals(user.get().getPassword())))
				{
					return user;
				}
			}
			else {
				throw new UserNotFoundException("No User with the given ID");
			}
		}catch (UserNotFoundException e) {
			e.getMessage();
		}
		return null;

	}
	
	
	
	
}
