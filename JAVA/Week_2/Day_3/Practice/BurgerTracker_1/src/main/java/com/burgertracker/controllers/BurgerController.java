package com.burgertracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.burgertracker.models.BourgerModel;
import com.burgertracker.servies.BurgerService;

import jakarta.validation.Valid;



@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String index(Model model,@ModelAttribute("burger")BourgerModel burger) {
		model.addAttribute("burgers",burgerService.getAllBurgers());
		return "index";
		}
	@PostMapping("/")
	public String createBurger(@Valid @ModelAttribute("burger")BourgerModel burger,BindingResult result,Model model) {
	if(result.hasErrors()) {
			model.addAttribute("burgers",burgerService.getAllBurgers());
			return "index";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
}
