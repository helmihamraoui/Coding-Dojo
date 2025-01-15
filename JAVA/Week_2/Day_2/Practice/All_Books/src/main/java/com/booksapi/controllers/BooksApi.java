package com.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booksapi.models.Book;
import com.booksapi.services.BookService;
@RestController
public class BooksApi {	
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    // other methods removed for brevity
    @PutMapping("/api/books/{id}")
    public Book update(
    	    @PathVariable("id") Long id, 
    	    @RequestParam(value = "title") String title, 
    	    @RequestParam(value = "description") String desc, 
    	    @RequestParam(value = "language") String lang, 
    	    @RequestParam(value = "pages") Integer numOfPages) {
    	    
    	    // Retrieve the existing book by its ID
    	    Book existingBook = bookService.findBook(id);
    	    if (existingBook == null) {
    	        throw new RuntimeException("Book with ID " + id + " not found");
    	    }
    	    
    	    // Update the book's details
    	    existingBook.setTitle(title);
    	    existingBook.setLanguage(lang);
    	    existingBook.setDescription(desc);
    	    existingBook.setNumberOfPages(numOfPages);
    	    
    	    // Save the updated book
    	    Book updatedBook = bookService.updateBook(id, existingBook);
    	    return updatedBook;
    	}

    
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
