package com.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class Form {
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
}
	@PostMapping("/omikuji/show")
	public String form (@RequestParam(value = "number") int number,
			@RequestParam(value = "nameOfCity") String nameOfCity,
			@RequestParam(value = "personName") String personName, @RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "something") String something, @RequestParam(value = "type") String type,
			HttpSession session, RedirectAttributes redirectAttribuites) {
		session.setAttribute("number", number);
		session.setAttribute("nameOfCity", nameOfCity);
		session.setAttribute("personName", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("type", type);
		session.setAttribute("something", something);

		return "show.jsp";
	}
}
