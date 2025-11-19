package com.annotations;

import org.springframework.stereotype.Repository;

@Repository //spring understands that this is a repository class
public class BookRepository {

	public String getBookTitle() {
		return "Spring FrameWork Concepts";
		
	}
}
