package com.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoandninjas.models.NinjaModel;
import com.dojoandninjas.servies.DojoService;
import com.dojoandninjas.servies.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	@GetMapping("ninjas/new")
	public String FormNinja(Model model,@ModelAttribute("ninja")NinjaModel ninja) {
		model.addAttribute("dojos", dojoService.getAllDojo());
		return "ninjaForm";
	}
	@PostMapping("ninjas/new")
	public String createTodo(@Valid @ModelAttribute("ninja")NinjaModel ninja,BindingResult result,Model model) {
		// if there is validation errors related to the model
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAllDojo());
			return "ninjaForm";
		}
		ninjaService.create(ninja);
		return "redirect:/dojos/"+ninja.getDojo().getId();
	}
}
