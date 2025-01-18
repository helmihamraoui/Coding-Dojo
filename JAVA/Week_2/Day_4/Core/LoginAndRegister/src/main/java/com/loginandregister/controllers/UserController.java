package com.loginandregister.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginandregister.models.User;
import com.loginandregister.models.loginUser;
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
		model.addAttribute("newLogin", new loginUser());
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
			model.addAttribute("newLogin", new loginUser());
			return "index";
		}
		
		// we will set the userId in the session if true
		session.setAttribute("userId", user.getId());
		// we will redirect to a home page 
		return "redirect:/home";
	}
	
	//Login process
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")loginUser newLogin,
			BindingResult result,
			HttpSession session,Model model) {
		User user = userService.login(newLogin,result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index";
		}
		session.setAttribute("userId", user.getId());
		// we will redirect to a home page 
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String homePage(HttpSession session,Model model) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("user",userService.findById((Long) session.getAttribute("userId")));
			return "home";
		}
		return "redirect:/";
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