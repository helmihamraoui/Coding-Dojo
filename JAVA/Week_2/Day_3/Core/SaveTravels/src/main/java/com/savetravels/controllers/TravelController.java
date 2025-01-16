package com.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.savetravels.models.TravelModel;
import com.savetravels.servies.TravelServies;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	@Autowired
	TravelServies TravelService;
	@GetMapping("/expense")
	public String index(Model model,@ModelAttribute("travel")TravelModel travel) {
		model.addAttribute("Travels",TravelService.getAllTravel());
		return "index";
		}
	@PostMapping("/expense")
	public String createTravel(@Valid @ModelAttribute("travel")TravelModel travel,BindingResult result,Model model) {
	if(result.hasErrors()) {
			model.addAttribute("Travels",TravelService.getAllTravel());
			return "index";
		}
		TravelService.createTravel(travel);
		return "redirect:/expense";
}
	@GetMapping("/expense/edit/{id}")
	public String edit(Model model,@ModelAttribute("travel")TravelModel travel,@PathVariable("id")long id) {
		model.addAttribute("travel",TravelService.getOneById(id));
		return "edit";
		}
	@PutMapping("/expense/edit/{id}")
	public String updateBurger(Model model,@PathVariable long id,@Valid @ModelAttribute("travel")TravelModel travel,BindingResult result) {
		if(result.hasErrors()) {
			
			return "edit";
		}
		TravelService.update(id,travel);
		return "redirect:/expense";
	}
	@GetMapping("/expense/{id}")
	public String show(Model model,@ModelAttribute("travel")TravelModel travel,@PathVariable("id")long id) {
		model.addAttribute("travel",TravelService.getOneById(id));
		return "show";
		}
	@DeleteMapping("/expense/delete/{id}")
	public String delete(@PathVariable("id")long id) {
		TravelService.delete(id);
		return "redirect:/expense";
		}
}
