package com.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoandninjas.models.DojoModel;
import com.dojoandninjas.servies.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	@GetMapping("/dojos/new")
	public String index (Model model,@ModelAttribute("dojo")DojoModel dojo) {
		return "dojoForm";
	}
	@PostMapping("/dojos/new")
	public String createDojo(Model model,@Valid @ModelAttribute("dojo")DojoModel dojo,BindingResult result) {
		if(result.hasErrors()) {
			return "dojoForm";
		}
		dojoService.create(dojo);
		return "redirect:/dojos/"+dojo.getId();
	}
	@GetMapping("/dojos/{id}")
	public String NinjasForDojo (Model model,@PathVariable long id) {
		model.addAttribute("dojo",dojoService.getDojoById(id));
		return "dojo";
	}
	
}
