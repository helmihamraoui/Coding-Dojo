package com.loginandregister.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginandregister.models.Book;
import com.loginandregister.repositories.BookRepository;

@Service
public class BookService  {
	@Autowired
	BookRepository bookRepo;
	//Get all Books Method
		public List<Book> getAllBooks(){
			return bookRepo.findAll();
		}
		//create Book
		public Book createNewBook(Book book) {
			return bookRepo.save(book);
		}
		public Book getBookById(long id) {
			Optional<Book> b=bookRepo.findById(id);
			if (b.isPresent()) {
				return b.get();
			}
			return null;
		}
		//Delete Method by id 
		public void deleteBookById(Long id) {
			getBookById(id).setUser(null);;
			bookRepo.deleteById(id);
		}
		//update Book by id  method 
		
		public Book updateBook(Long id,Book newBook) {
			newBook.setId(id);
			return bookRepo.save(newBook);
			
		}
}
