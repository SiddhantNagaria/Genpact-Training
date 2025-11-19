package com.Project;

import java.util.*;
import java.util.stream.Collectors;

import com.Project.Member.Member;

public class Library {
	private List<Book> books = new ArrayList<>();
	private List<Member> members = new ArrayList<>();
	private Map<String, Integer> borrowCount = new HashMap<>();

	public void addBook(Book b) {
		books.add(b);
	}

	public void addMember(Member m) {
		members.add(m);
	}

	public void showAllBooks() {
		books.forEach(System.out::println);
	}

	public void borrowBook(String isbn, String memberId) {
		try {
			Book book = findBook(isbn);
			Member member = findMember(memberId);

			book.borrowCopy();
			member.borrowBook(isbn);

			borrowCount.put(isbn, borrowCount.getOrDefault(isbn, 0) + 1);
			System.out.println(member.getName() + " borrowed " + book.getTitle());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void returnBook(String isbn, String memberId) {
		try {
			Book book = findBook(isbn);
			Member member = findMember(memberId);

			member.returnBook(isbn);
			book.returnCopy();

			System.out.println(member.getName() + " returned " + book.getTitle());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void searchBooks(String keyword) {
		books.stream().filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
				.forEach(System.out::println);
	}

	public void showTopBorrowedBooks() {
		borrowCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1)
				.map(entry -> findBook(entry.getKey())).forEach(book -> System.out.println("Top Book: " + book));
	}

	private Book findBook(String isbn) {
		return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst()
				.orElseThrow(() -> new RuntimeException("Book not found"));
	}

	private Member findMember(String memberId) {
		return members.stream().filter(m -> m.getMemberId().equals(memberId)).findFirst()
				.orElseThrow(() -> new RuntimeException("Member not found"));
	}
}