package com.loginandregister.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginandregister.models.User;
import com.loginandregister.models.LoginUser;
import com.loginandregister.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	// get the index page 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index";
	}
	
	//Register
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser")User newUser,
			BindingResult result,
			HttpSession session,
			Model model) {
		// we will call the register method from the service 
		User user =userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index";
		}
		
		// we will set the userId in the session if true
		session.setAttribute("userId", user.getId());
		// we will redirect to a home page 
		return "redirect:/books";
	}
	
	//Login process
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,
			BindingResult result,
			HttpSession session,Model model) {
		User user = userService.login(newLogin,result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index";
		}
		session.setAttribute("userId", user.getId());
		// we will redirect to a home page 
		return "redirect:/books";
	}
	
	
	//Logout 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//clear session
		session.invalidate();
		//redirect
		return "redirect:/";
	}
	
	
	
}