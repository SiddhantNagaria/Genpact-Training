package com.day4.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Array_List {

	public static void main(String[] args) {
		//resizable array
		//dynamic array
		//get(), set(), -> provide fast random access
		
		ArrayList<String> gadgets = new ArrayList<>();
		
		//add elements
		gadgets.add("laptop");
		gadgets.add("smartphones");
		gadgets.add("camera");
		gadgets.add("macbook air pro m4 chip");
		gadgets.add("Apple Iphone 17 pro max legendary ultra pro");
		
		//access elements using get()
		System.out.println("First element : " + gadgets.get(0));
		
		System.out.print(gadgets);
		System.out.println();
		System.out.println();
		
		//update element using set()
		gadgets.set(2, "Digital Camera");
		
		System.out.print(gadgets);
		System.out.println();
		
		//remove
		gadgets.remove(0);
//		gadgets.remove("Laptop"); //string will not work here
		System.out.print(gadgets);
		System.out.println();
		
		//iterate using for-each
		for(String g : gadgets) {
			System.out.print(g + " ");
			
		}
		System.out.println();
		
		//Iterate using Iterator
		System.out.println("Using Iterator");
		Iterator<String> it = gadgets.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		System.out.println("___________________________");
		
		//Iterate using Iterator from particular index
				System.out.println("Using Iterator from particular index");
				ListIterator<String> it2 = gadgets.listIterator(2);
				while(it2.hasNext()) {
					System.out.print(it2.next() + " ");
				}
				System.out.println();
				
		
		//check if some element exists or not
		System.out.println("Contains laptop ? -> : " + gadgets.contains("Laptop"));
		
		//isEmpty or not
		System.out.println("is the arraylist - Gadgets empty ? : " + gadgets.isEmpty()); 
		
		//indexOf - first occurence of element
		System.out.println("first occurence of  camera is : " + gadgets.indexOf("Camera"));
		
		//size of arraylist
		System.out.println("size of array list is : " + gadgets.size()); 
		
		//sorting
		// ascending (A-Z)
		Collections.sort(gadgets);
		System.out.println(gadgets);
		
		//reverse - desc order
		Collections.sort(gadgets, Collections.reverseOrder());
		System.out.println(gadgets);
		
		//set
		gadgets.set(1, "MacBook Air M4");
		System.out.print(gadgets);
		
		//add more
		
		
		
	}

}
