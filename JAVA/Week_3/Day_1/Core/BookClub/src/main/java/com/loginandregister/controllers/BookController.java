package com.loginandregister.controllers;

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

import com.loginandregister.models.Book;
import com.loginandregister.models.User;
import com.loginandregister.services.BookService;
import com.loginandregister.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	// get the main page 
	@GetMapping("/books")
	public String homePage(HttpSession session,Model model) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("user",userService.findById((Long) session.getAttribute("userId")));
			model.addAttribute("books",bookService.getAllBooks());
			return "home";
		}
		return "redirect:/";
	}
	// get create new Book page 
	@GetMapping("/book/new")
	public String newBookPage(@ModelAttribute("book")Book book,Model model,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "createBook";
	}
	@PostMapping("/book/new")
	public String createBook(@Valid @ModelAttribute("book")Book book,BindingResult result,Model model,HttpSession session) {
	
		// if there is validation errors related to the model
		if(result.hasErrors()) {
			
			return "createBook";
		}
		// Fetch the user from the session using the userId
		User user = userService.findById((Long) session.getAttribute("userId"));
		// Set the user as the owner of the book
		book.setUser(user);
		// Create a new book entry
		bookService.createNewBook(book);

		// Redirect to the books page
		return "redirect:/books";

	}
	// delete book process
	@PostMapping("/book/delete/{id}")
	public String deleteTodo(@PathVariable("id")Long id) {
		bookService.deleteBookById(id);
		return "redirect:/books";
	}
	@GetMapping("/books/{id}/edit")
	public String edit (@Valid @ModelAttribute("book")Book book,@PathVariable Long id,Model model,HttpSession session) {
		Book currentBook=bookService.getBookById(id);
		if(!session.getAttribute("userId").equals(currentBook.getUser().getId()) ) {
			return "redirect:/";
		}
		model.addAttribute("book",currentBook);
		return "editBook";
	}
	// perform edit
	@PutMapping("/books/{id}/edit") 
	public String updateTodo(@PathVariable Long id, @Valid @ModelAttribute("book") Book book, BindingResult result,HttpSession session)
	{ 
		if (result.hasErrors()) { 
		return "editBook"; 

	 } 
	book.setUser(userService.findById((Long) session.getAttribute("userId")));
	bookService.updateBook(id,book); 
	return "redirect:/books"; 
	}
	@GetMapping("/books/{id}")
	public String showOneBook(@PathVariable Long id,Model model,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		model.addAttribute("book",bookService.getBookById(id));
		return "showOne";
	}
	@DeleteMapping("/books/{id}/delete")
	public String deleteOneBook(@PathVariable Long id,Model model,HttpSession session) {
		bookService.deleteBookById(id);
		return "redirect:/books";
		
	}

}
