package com.day4.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Hash_Set {

	public static void main(String[] args) {

		// HashSet stores elements in a hash table
		// does not maintain insertion order - 1,2,3
		// fastest - add, remove, search operations O(1)
		// almost one null element
		// no duplicate

		// store IDs of employee
		// emp names -> cannot use set, ArrayList

		HashSet<String> empId = new HashSet<>();

		// add
		empId.add("A03");
		empId.add("B01");
		empId.add("C02");
		empId.add("D04");
		empId.add("E04");
		empId.add("F04");
		empId.add(null);
		empId.add(null);

		System.out.println(empId);

		// for-each loop
		for (String s : empId) {
			System.out.print(s + " ");
		}
		System.out.println();
		// isEmpty
		System.out.println(empId.isEmpty());

		
		List<String> newIDs = Arrays.asList("E01", "E06", "E02", "E09");
		empId.addAll(newIDs);
		System.out.println(empId);

		// contains(), remove(), size(), Iterator(), clear(), removeAll()
		
		
		//clone() - creates a copy of the set
		HashSet<String> cl = (HashSet<String>) empId.clone();
		System.out.println(cl);
		
		//removeAll
		empId.removeAll(newIDs);
		System.out.println(empId);
		
	}

}
