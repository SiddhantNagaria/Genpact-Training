package com.day4.Collections;

import java.util.PriorityQueue;

public class Prioriry_Queue {

	public static void main(String[] args) {

		// Priority Queue
		// priority is based on natural ordering
		// For integers, the default is a min-heap, so the smallest number has the
		// highest priority.

		// Create a PriorityQueue of integers (min-heap by default)
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// Add elements using add() or offer()
		pq.add(30);
		pq.add(10);
		pq.add(20);
		pq.add(40);

		// Display the queue (order not guaranteed)
		// internal structure of the heap - not in sorted order
		System.out.println("PriorityQueue: " + pq);

		// pq.peek() or pq.poll() -> returns the highest priority element
		// Iterating or printing -> does not show elements in priority order
		
		// Peek at the head (smallest element)
		System.out.println("Peek: " + pq.peek());

		// Poll elements (removes and returns the head)
		System.out.println("Polled: " + pq.poll());
		System.out.println("After poll: " + pq);

		// Iterate through the queue
		System.out.println("Remaining elements:");
		for (int num : pq) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int num : pq) {
			System.out.print(num + " ");
		}

	}

}
