package com.Project;

import com.Project.Member.Member;
import com.Project.Member.StaffMember;
import com.Project.Member.StudentMember;
import com.Project.Utils.FineCalculator;

public class MainApp {
	public static void main(String[] args) {
		Library lib = new Library();

		// Sample Books
		lib.addBook(new Book("B101", "Java Basics", "Genpact", "Programming", 5, 3));
		lib.addBook(new Book("B102", "Effective Java", "TCS", "Programming", 3, 2));
		lib.addBook(new Book("B103", "Clean Code", "Accenture", "Programming", 4, 4));

		// Sample Members
		Member s1 = new StudentMember("S001", "Alice");
		Member s2 = new StaffMember("T001", "Bob");
		lib.addMember(s1);
		lib.addMember(s2);

		// Borrow Books
		lib.borrowBook("B101", "S001");
		lib.borrowBook("B102", "S001");
		lib.borrowBook("B103", "S001");
		lib.borrowBook("B101", "S001"); // Should fail (limit)

		// Return Book
		lib.returnBook("B101", "S001");
		lib.returnBook("B101", "S001"); // Should fail (already returned)

		// Search Books
		System.out.println("\nSearch Results:");
		lib.searchBooks("Java");

		// Top Borrowed Book
		lib.showTopBorrowedBooks();

		// Fine Calculation
		FineCalculator fine = days -> days * 2.0;
		System.out.println("\nFine for 5 days late : " + fine.calculateFine(5));
	}
}