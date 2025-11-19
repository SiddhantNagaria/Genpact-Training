package com.day4.Collections;

public class CollectionsConcept {
	 
		// collection --> it is an object that group multiple elemnet
		// into a single unit
	 
		// Array -> Bankaccount[]-fixed size
	 
		// collection framework
		// --- more powerful and flexible collection
		// --- this available in java.util package
		// --- provide standardized interfaces and implementations
		// data structure - list of bankAccount[]
		// - sets,map,queues
		// --- algorithms(predefine) for these ds - sorting ,searching
	 
		// collection - grow and shrink dynamically - no fixed size
		// - rich operation - add/remove/search/sort/iterate
	 
		// 1------------------
		// list interface - ordered collection of elements
		// -- allows duplication elements
		// -- provides positional access
		// -- maintain the insertion order
		// -- support iteration - using loop, iterations and streams
		// implementations - ArrayList , LinkedList , vector
	 
		// vector is also the dynamic arry - similar to arraylist - grow ans shrink
		// - vector is synchorized collection - thread safe
		// access time - fast access - based on index
		// default capacity - 10 element initially
		// 10 elements gets full - growth - increase the capacity by 100% double when
		// full
	 
		// iterating - foreach
		// Iterator - is an object that allows you to traverse throw elements of a
		// collection
		// certain method - hasNext()- return true if we have more elements to iterate
		// next() -> return the next element in the iteration
	 
		// set interface
		// set -> collection of element - no duplicate element
		// -> elements must be unique
		// -> implementations - differ by ordering and performance
		// hashset,
	 
		// map interface
		// - java
	 
		// queue
		// - FIFO - first in first out
		// - collection of element waiting to be processed
		// - front end(deletion) , rear end(insertion)

		// linkedlist implements using  ll implement both ll and queue
	 
		// priority queue - CPU <- queue, task + priority
		//  - higher priority should be executed first
		//  - create priority queue -> natural ordering - asc
		//  - does not allow null value
	 
		// arrayDeque
		// - implement double ended queue
		// - allow both insertion/ deletion at both ends
		// - faster then linked list
		// does not allow null elements
	 
		// assignment  ---- implement all queue interface 
	
}
