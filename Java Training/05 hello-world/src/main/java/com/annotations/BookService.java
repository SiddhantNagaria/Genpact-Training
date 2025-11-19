package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//tell spring that this is a service bean 
@Service
public class BookService {

	//spring - automatically inject dependency byType
	
	@Autowired
	private BookRepository bookRepository;
	
	public void displayBook() {
		System.out.println("Book title : " + bookRepository.getBookTitle());
	}
}
