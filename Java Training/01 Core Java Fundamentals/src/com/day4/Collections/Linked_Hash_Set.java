package com.day4.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Linked_Hash_Set {

	public static void main(String[] args) {

		// LinkedHashSet
		// maintains the insertion order
		// linked hash set - slightly slower than hashset
		// both uniqueness and iteration order

		LinkedHashSet<Integer> v = new LinkedHashSet<Integer>();

		// add(), allAll, remove, removeAll, contains
		// containsALl(), both HashSet, LinkedHashSet - collection is contains
		// clear , isEMpty, Iterator

		// add
		v.add(1);
		v.add(4);
		v.add(2);
		v.add(5);
		v.add(8);
		System.out.println(v);

		// contains
		System.out.println("LHS v contains 3 : " + v.contains(3));

		// containsAll
		System.out.println("v contains elements of v : " + v.containsAll(v));
	
		//isEmpty
		System.out.println("v is empy or not : " + v.isEmpty());
		
		//clone
		LinkedHashSet<Integer> al =  (LinkedHashSet<Integer>) v.clone();
		System.out.println(al);
		
		List<Integer> l = Arrays.asList(87,65,35,78,3,64,77,99);
		
		v.addAll(al);
		v.addAll(l);
		System.out.println(v);
		
		v.removeAll(l);
		System.out.println(v);
		
		v.clear();
		System.out.println(v);
		
	}

}
