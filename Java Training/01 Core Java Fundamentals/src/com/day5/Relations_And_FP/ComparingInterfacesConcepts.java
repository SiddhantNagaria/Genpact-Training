package com.day5.Relations_And_FP;

public class ComparingInterfacesConcepts {
	
	// Comparable and Comparator
	// - list.sort() -> 
	// comparing numbers/strings 
	
	// want to sort custom objects - Employee objects (based on salary, rating)
	// Students - marks, Products - prices
	
	// Collections - TreeSet, TreeMap -> Collections.sort() 
	// way - how ?
	
	// Interfaces
	// 1. Comparable - logic is defined inside the class
	//               - Natural sorting, default sorting
	// Defines in java.lang
	// predefined method - compareTo
	// public int compareTo(T other)
	// Sort emps by salary
	
	// 2.Comparator - logic is defined outside the class
	//              - Custom sorting / multiple sorting criteria
	//              - Enable multiple sorting strategies
	// two keys methods -> compare
	// int compare(T o1, T o2)
	// boolean equals(Object obj); // rarely used
	// Sort emps first by Name and then by salary

}
