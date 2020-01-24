package com.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.DAO.Books;
import com.webapp.DAO.BooksDAO;

//communicates with other services
//manages domain model objects
//responsible for some logics like authorization
@Service
public class BooksService {

	private BooksDAO booksDAO;
	
	@Autowired
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	public List<Books> getData(){
		return booksDAO.getBooks();
	}
	
	public void addBook(Books book) {
		System.out.println("in service"+book);
		booksDAO.create(book);
	}
	
	/*
	 * // to throw an exception, but now it is handling internally as method is not
	 * available with params public void throwTestException() {
	 * booksDAO.getBooks(123); }
	 */
	 
}
