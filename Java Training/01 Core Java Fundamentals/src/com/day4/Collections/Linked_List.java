package com.day4.Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Linked_List {

	public static void main(String[] args) {
		LinkedList<Integer> numbers = new LinkedList<Integer>();

		// add
		numbers.add(1);
		numbers.add(6);
		numbers.add(3);
		numbers.add(8);
		numbers.addFirst(0);
		numbers.addLast(9);
		System.out.print(numbers);
		System.out.println();

		// Iterate using Iterator
		System.out.println("Using Iterator");
		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		
		//Iterate using Iterator from particular index
		System.out.println("Using Iterator from a particular index");
		ListIterator<Integer> it2 = numbers.listIterator(2);
		while(it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}
		System.out.println();
	
		
		// remove
		numbers.remove(3);
		numbers.removeFirst();
		numbers.removeLast();
		System.out.println(numbers);

		// contains
		System.out.println("does LL numbers contains 7 : " + numbers.contains(7));

		// get element at a index
		System.out.println("element at index 1 is : " + numbers.get(1));

		// size of LL
		System.out.println("size of LL is : " + numbers.size());

		// first and last element
		System.out.println("first element of LL is : " + numbers.getFirst());
		System.out.println("last element of LL is : " + numbers.getLast());

		// set
		numbers.set(1, 17);
		System.out.println(numbers);

		// add elements at a index
		numbers.add(3, 18);
		numbers.add(4, 45);
		System.out.println(numbers);

		// clear all elements of linkedlist
		numbers.clear();
		System.out.println("elements of LL numbers after clear method are : " + numbers);

	}

}
