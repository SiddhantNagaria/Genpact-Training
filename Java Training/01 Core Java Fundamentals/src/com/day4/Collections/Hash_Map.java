package com.day4.Collections;

import java.util.HashMap;
import java.util.Map;

public class Hash_Map {

	public static void main(String[] args) {
		// hashmap store elements - key value pairs
		// no order of kets
		// allows one null key and multiple null values
		// values can be duplicated
		// fastest implementation

		Map<Integer, String> em = new HashMap<Integer, String>();

		// put() - used to add elements
		em.put(101, "E1");
		em.put(102, "E2");
		em.put(103, "E3");
		System.out.println(em);

		// containskey
		System.out.println(em.containsKey(108));

		// contains value
		System.out.println(em.containsValue("E1"));

		// set view mapping
		System.out.println("entry set : " + em.entrySet());

		// get value of a key
		System.out.println(em.get(101));

		// isEmpty or not
		System.out.println(em.isEmpty());

		// getOrdefault - return value of the key or default value if no mapped value
		// found for the key
		System.out.println(em.getOrDefault(106, "not found"));

		// get all keys from key set
		System.out.println("key set : " + em.keySet());

		// for-each loop
		for (Map.Entry<Integer,String> en : em.entrySet()) {
			System.out.println(en.getKey() + " - " + en.getValue());
		}
	}

}
