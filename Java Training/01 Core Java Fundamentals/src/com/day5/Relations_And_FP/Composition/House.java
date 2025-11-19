package com.day5.Relations_And_FP.Composition;

import java.util.ArrayList;
import java.util.List;

public class House {
	
	public House(String address) {
		
		this.address = address;
	}
	private String address;
	private List<Room> rooms = new ArrayList<>();

    // House composes Rooms, rooms are created inside house
	// create rooms in house class not in main class
	
	public void addRooms(String roomName, double areaSqM) {
		Room r = new Room(roomName, areaSqM); // created and owned by house
		rooms.add(r);
	}
	
	// PrintRooms() - for each
	public void printRooms() {
		System.out.println("House Address : " + address + " has rooms");
		for (Room r : rooms) {
			System.out.println(r.getName());
			System.out.println(r.getAreaSqM());
		}
		
	}
	
	// main -> create h1 -> 4 rooms - , print rooms
	
	// private -> Army Dept -> 
	// protected -> org -> Genpact - Data -> Sumita Dept - Rahul Dept
	
}
