package com.kodnest.tune.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tune.entity.User;
import com.kodnest.tune.repository.UserRepository;

import Service.UserService;
@Service
public class UserServiceimpl  implements UserService {
	@Autowired
	UserRepository userRepository;

	public String addUser(User user){
		userRepository.save(user);
		return "User add successfully";
	}
// logic  to check the duplicate entries or not
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email)!=null) {
		 return true;
	}
	else  
		return false;
	
	
}
//it check if the emial and password is there are not we have to give email and passwrd if its
	//all ready there its go to the home page other wise its stay on login page only
	public boolean validateUser(String email, String password) {
       User user= userRepository.findByEmail(email);
		
      String db= user.getPassword();
      if(password.equals(db)) {
    	  return true;
	}
	else
		return false;
}
	public String getRole(String email) {
	User user =	userRepository.findByEmail(email);
		return user.getRole();
	}
	@Override
	public User getUser(String email) {
	return	userRepository.findByEmail(email);
	
	}
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
}