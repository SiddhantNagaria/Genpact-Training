package com.day4.Collections;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Vector_Code {

	public static void main(String[] args) {

		Vector<Integer> v = new Vector<Integer>();

		Vector<Integer> v2 = new Vector<Integer>(5, 3);
		// 5 - initial capacity , 3 - increment by 3

		System.out.println("capacity of v is : " + v.capacity());
		System.out.println("size of vector V is : " + v.size());

		v.add(1);
		v.add(5);
		v.add(7);
		v.add(0);
		v.add(2);
		v.add(3);
		v.add(6);
		v.add(4);
		v.add(9);
		v.add(8);
		System.out.print(v);
		System.out.println();

		// Iterate using Iterator
		System.out.println("Using Iterator");
		Iterator<Integer> it = v.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
			 
		}
		System.out.println();

		// Iterate using Iterator from particular index
		System.out.println("Using Iterator from a particular index");
		ListIterator<Integer> it2 = v.listIterator(2);
		while (it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}
		System.out.println();

		// get at index()
		System.out.println("element at index 5 is : " + v.get(5));

		// set at index()
		v.set(0, 0);
		v.set(3, 1);
		System.out.print(v);
		System.out.println();

		// size
		System.out.println("size of vector V is : " + v.size());

		// capacity
		System.out.println("capacity of v is : " + v.capacity());

		v.add(122);
		v.add(3445);
		System.out.println("size of vector V is : " + v.size());
		System.out.println("capacity of v is : " + v.capacity());

		// remove at index 1
//		v.remove(1);
//		System.out.print("vector after removing element is : " + v);

		System.out.println("_______________________");
		System.out.println("capacity of v2 is : " + v2.capacity());
		System.out.println("size of vector V2 is : " + v2.size());

		v2.add(1);
		v2.add(5);
		v2.add(7);
		v2.add(0);
		v2.add(2);
		v2.add(3);
		v2.add(6);
		v2.add(4);
		v2.add(9);
		v2.add(8);
		System.out.println("capacity of v2 is : " + v2.capacity());
		System.out.println("size of vector V2 is : " + v2.size());
		v2.add(8);
		v2.add(8);
		System.out.println("capacity of v2 is : " + v2.capacity());
		System.out.println("size of vector V2 is : " + v2.size());

	}

}
