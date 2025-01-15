package com.booksapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booksapi.models.Book;
import com.booksapi.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 //update book
 public Book updateBook(long id,Book newBook) {
	 Book currentBook=this.findBook(id);
	 currentBook.setTitle(newBook.getTitle());
	 currentBook.setDescription(newBook.getDescription());
	 currentBook.setLanguage(newBook.getLanguage());
	 currentBook.setNumberOfPages(newBook.getNumberOfPages());
	 return bookRepository.save(currentBook);
	 
	 
 }
//Delete Method by id 
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}

