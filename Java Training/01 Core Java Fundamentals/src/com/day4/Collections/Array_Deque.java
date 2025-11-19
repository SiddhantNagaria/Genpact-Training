package com.day4.Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Array_Deque {

	public static void main(String[] args) {
		
		// Create an ArrayDeque
		Deque<String> deque = new ArrayDeque<>();

		System.out.println(deque);
		// Add elements at the end
		deque.add("Apple");
		deque.add("Banana");
		deque.add("Cherry");

		// Add elements at the front
		deque.addFirst("Mango");
		
		// add elements at the last
		deque.addLast("Orange");

		// Display the deque
		System.out.println("Deque: " + deque);

		// Peek elements
		System.out.println("First element: " + deque.peekFirst());
		System.out.println("Last element: " + deque.peekLast());

		// Remove elements
		System.out.println("Removed first: " + deque.removeFirst());
		System.out.println("Removed last: " + deque.removeLast());

		// Display after removals
		System.out.println("Deque after removals: " + deque);

		// Iterate through deque
		System.out.println("Iterating:");
		for (String item : deque) {
			System.out.print(item + " ");
		}
	}
}
