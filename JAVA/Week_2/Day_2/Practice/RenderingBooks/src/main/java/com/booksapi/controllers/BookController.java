package com.booksapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.booksapi.models.Book;
import com.booksapi.services.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
    	Book book= bookService.findBook(id);
        model.addAttribute("book",book);
        return "index";
    }
}
