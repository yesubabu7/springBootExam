package com.example.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.models.Book;
import com.example.task.models.PublishingHouse;
import com.example.task.repository.BookRepository;


@RestController
public class BookController {

	BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}

	@RequestMapping(value = "/publishers", method = RequestMethod.GET)
	public List<PublishingHouse> getAllPublishers() {

		
		return bookRepository.getAllPublishers();
	}
	
	@RequestMapping(value = "/Books/{id}", method = RequestMethod.GET)
	public List<Book> getAllBooksById(@PathVariable Long id) {
	    // Assuming you have a method in your repository to fetch books by the given id
	    return bookRepository.getAllBooksById(id);
	}
	
	
	 @DeleteMapping("/booksDeleteById/{bookId}")
	    public ResponseEntity<String> deleteBookById(@PathVariable Long bookId) {
	        // Check if the book exists
	        Book book = bookRepository.getBookById(bookId);
	        if (book == null) {
	            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
	        }

	        // Delete the book
	        bookRepository.deleteBookById(bookId);

	        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
	    }

	 

	
	
}