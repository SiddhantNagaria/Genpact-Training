package com.day4.Collections;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_CollectionFramework {

	public static void main(String[] args) {

		// Queue
		// FIFO - first in first out
		Queue<String> queue = new LinkedList<>();

		// Add elements to the queue using offer()
		queue.add("FRUITS");
		queue.offer("Apple");
		queue.offer("Banana");
		queue.offer("Cherry");

		// Display the queue
		System.out.println("Queue: " + queue);

		// Peek at the front element
		System.out.println("Peek: " + queue.peek()); 
//		System.out.println("Peek: " + queue.remove()); 

		// Remove elements
		System.out.println("Polled: " + queue.poll()); 
		System.out.println("Queue after poll: " + queue);

		// Check if queue is empty
		System.out.println("Is queue empty? " + queue.isEmpty());

		// Size of the queue
		System.out.println("Queue size: " + queue.size());

		// Iterate through the queue
		System.out.println("Iterating through queue using for-each :");
		for (String item : queue) {
			System.out.println(item);
		}

	}

}
