package com.Project;

import com.Project.Exceptions.BookNotAvailableException;

public class Book {

	private String isbn, title, author, category;

	private int totalCopies, availableCopies;

	public Book(String isbn, String title, String author, String category, int totalCopies, int availableCopies) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.category = category;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + "]";
	}

	public void borrowCopy() throws BookNotAvailableException  {
		if (availableCopies <= 0) {
			throw new BookNotAvailableException("No copies available");
		}
		availableCopies--;
	}

	public void returnCopy() {
		if (availableCopies < totalCopies) {
			availableCopies++;
		}
	}
}
