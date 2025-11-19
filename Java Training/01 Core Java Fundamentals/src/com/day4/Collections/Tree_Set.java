package com.day4.Collections;

import java.util.TreeSet;

public class Tree_Set {

	public static void main(String[] args) {
		// HS - no order
		// LHS - insertion order

		// TS - store in a sorted order
		// no duplicates
		// HS, LHS - allows one null value
		// TS - no null value
		// internally - it is maintained as Tree - Red Black Tree
		// navigation methods - not there for HS, LHS
		// first(), last(), lower(),..........

		TreeSet<Integer> n = new TreeSet<Integer>();

		n.add(435);
		n.add(123);
		n.add(875);
		n.add(99);

		System.out.println(n);

		//first
		System.out.println("lowest element is : " + n.first());
		
		//last
		System.out.println("highest element is : " + n.last());
		
		//larger than a given value
		System.out.println("least element greater than or euqal to 700 : " + n.ceiling(700));
		
		//less than a given value
		System.out.println("greatest element less than or euqal to 700 : " + n.floor(700));

		//first element removed
		System.out.println("lowest element removed is : " + n.pollFirst());
		System.out.println(n);
		
		//last element removed
		System.out.println("highest element removed is : " + n.pollLast());
		System.out.println(n);

		System.out.println("size of Tree set is : " + n.size());
	}

}
