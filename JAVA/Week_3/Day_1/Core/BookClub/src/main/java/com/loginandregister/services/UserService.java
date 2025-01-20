package com.loginandregister.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.loginandregister.models.User;
import com.loginandregister.models.LoginUser;
import com.loginandregister.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	//get all users
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	//get one user by id 
	public User findById(Long id) {
		Optional<User> u=userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}
	//get user by email
	public User findByEmail(String Email) {
		Optional<User> u=userRepo.findByEmail(Email);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}
	//regitration process
	public User register(User newUser,BindingResult result) {
		// check if the email is already in use 
		if(findByEmail(newUser.getEmail())!=null) {
			result.rejectValue("email", "email duplication","email already used !!!");
		}
		//we will check the password and confirm 
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "not-Match","Password most be Match with confirm password  !!!");
		}
		//we will check the other validation 
		if(result.hasErrors()) {
			return null;
		}
		//we will hash our password 
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		// we will set the hashed password 
		newUser.setPassword(hashed);
		//persist the data
		return userRepo.save(newUser);
		
	}
	//Login process
	public User login (LoginUser newLogin,BindingResult result) {
		// check the email existance 
		User user = findByEmail(newLogin.getEmail());
		if(user==null) {
			result.rejectValue("email", "WrongCredentials", "User does not exist with this email !");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		if(!BCrypt.checkpw(newLogin.getPassword(),user.getPassword())) {
			result.rejectValue("password", "WrongCredentials", "Wrong Password !");
		}
		return user;
	}
	
}
