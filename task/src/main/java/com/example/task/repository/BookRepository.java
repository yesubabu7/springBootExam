package com.example.task.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.task.contracts.BookInterfaceRepository;
import com.example.task.daos.Bookdao;
import com.example.task.models.Book;
import com.example.task.models.PublishingHouse;

@Repository
public class BookRepository implements BookInterfaceRepository {

	
	private Bookdao bookdao;
	
	@Autowired
	public BookRepository(Bookdao bookdao) {
		this.bookdao=bookdao;
		
	}
	
	public List<PublishingHouse> getAllPublishers() {
		
		
		 return bookdao.getPublishersFromDao();
		
		
		
		
	}

	

	public List<Book> getAllBooksById(Long id) {
		// TODO Auto-generated method stub
		return  bookdao.getBooksByIdFromDao(id);
	}

	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return  bookdao.getBookByIdFromDao(id);
	}

	public void deleteBookById(Long id) {
		bookdao.deleteBookByIdFromDao(id);
		
	}
	
	
	
	

}
