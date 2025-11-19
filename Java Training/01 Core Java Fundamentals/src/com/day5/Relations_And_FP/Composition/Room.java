package com.day5.Relations_And_FP.Composition;

public class Room {

	private String name;
	private double areaSqM;
	
	// should not initiate a room object directly
	Room(String name, double areaSqM) {
	
		this.name = name;
		this.areaSqM = areaSqM;
	}

	public String getName() {
		return name;
	}
	
	public double getAreaSqM() {
		return areaSqM;
	}	

}
