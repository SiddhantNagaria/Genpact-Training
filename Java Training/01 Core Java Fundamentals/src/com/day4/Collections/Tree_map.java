package com.day4.Collections;

import java.util.TreeMap;

public class Tree_map {

	public static void main(String[] args) {
		// sorted order by keys (ascending)
		// no null keys are allowed
		// red black tree
		// ordering - keys

		// firstkey(), lastkey()
		// higherKey(), lowerkey()

		// descending Map() -> reverse order
		// subMap

		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

		tm.put(1, "A");
		tm.put(6, "F");
		tm.put(2, "B");
		tm.put(4, "D");
		tm.put(3, "C");
		System.out.println(tm);

		// lowest key in map
		System.out.println(tm.firstKey());

		// highest key in map
		System.out.println(tm.lastKey());

		// least key greater than given key
		System.out.println(tm.higherKey(3));

		// greater key less than given key
		System.out.println(tm.lowerKey(7));

		// descending map
		System.out.println(tm.descendingMap());

		// subMap - like substring - from -> to
		System.out.println(tm.subMap(0, 3));

		// entry set and key set and values
		System.out.println("Entry set : " + tm.entrySet());
		System.out.println("Key set : " + tm.keySet());
		System.out.println("value set : " + tm.values());

		// least key-value pair greater than equal to key
		System.out.println(tm.ceilingEntry(5));
	}

}
