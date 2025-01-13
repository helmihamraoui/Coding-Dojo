package com.demo.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
@RequestMapping("/")
//...
//...
	public String index(HttpSession session) {
 	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer count=(Integer) session.getAttribute("count");
			session.setAttribute("count",count+=1);
		}
		return "home.jsp";
	}
@RequestMapping("/counter")
public String counter(HttpSession session) {
	session.getAttribute("count");
	return "counter.jsp";
}
//...
@RequestMapping("/double")
public String doubl(HttpSession session) {
 	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer count=(Integer) session.getAttribute("count");
			session.setAttribute("count",count+=2);
		}
		return "double.jsp";
	}
//...
@RequestMapping("/reset")
public String reset(HttpSession session) {
	session.removeAttribute("count");
	return "redirect:/double";
}


}
