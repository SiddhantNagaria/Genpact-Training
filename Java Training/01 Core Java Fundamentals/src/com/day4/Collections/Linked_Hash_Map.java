package com.day4.Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class Linked_Hash_Map {
	public static void main(String[] args) {

		// LHM
		// maintain insertion order
		// maintained as linked list - slow as compared to HashMap

		Map<String, Double> map = new LinkedHashMap<String, Double>();

		// put() - add elements
		map.put("hp pavilion gaming", 50000.00);
		map.put("macbook air pro m4", 100000.00);
		map.put("alienware ryzen 9", 250000.00);
		map.put("asus zephyrus", 150000.00);
		System.out.println(map);
		
		//containskey
		System.out.println(map.containsKey("macbook"));
		
		//contains value
		System.out.println(map.containsValue(150000.00));

		//for-each loop
		for(Map.Entry<String, Double> en : map.entrySet()) {
			System.out.println(en.getKey() + " - " + en.getValue());
		}
		
		//entry set
		System.out.println("Entry set : " + map.entrySet());
		
		//key set
		System.out.println("Key set : " + map.keySet());
		
		//getOrDefault
		System.out.println(map.getOrDefault("asus tuf", 0.0));
	}

}
