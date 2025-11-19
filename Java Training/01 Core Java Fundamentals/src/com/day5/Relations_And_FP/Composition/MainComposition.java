package com.day5.Relations_And_FP.Composition;

public class MainComposition {

	public static void main(String[] args) {
		
		House h1 = new House("Noida");
		
		h1.addRooms("R1", 120.00);
		h1.addRooms("R2", 220.00);
		h1.addRooms("R3", 150.00);
		h1.addRooms("R4", 180.00);
		
		h1.printRooms();
	}
}
