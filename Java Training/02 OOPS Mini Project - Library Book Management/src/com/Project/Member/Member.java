package com.Project.Member;

import java.util.*;

import com.Project.Exceptions.InvalidReturnException;
import com.Project.Exceptions.MaxLimitExceededException;

public abstract class Member {

	protected String memberId, name;

	protected List<String> borrowedBooks = new ArrayList<>();

	public Member(String memberId, String name) {
		this.memberId = memberId;
		this.name = name;
	}

	public abstract int getMaxBooksAllowed();

	public void borrowBook(String isbn) throws MaxLimitExceededException {
		if (borrowedBooks.size() >= getMaxBooksAllowed()) {
			throw new MaxLimitExceededException("Max borrow limit reached.");
		}
		borrowedBooks.add(isbn);
	}

	public void returnBook(String isbn) throws InvalidReturnException {
		if (!borrowedBooks.contains(isbn))
			throw new InvalidReturnException("Book not borrowed by member.");
		borrowedBooks.remove(isbn);
	}

	public String getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}
}





