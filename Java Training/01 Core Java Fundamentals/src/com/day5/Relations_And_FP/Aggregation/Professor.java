package com.day5.Relations_And_FP.Aggregation;

public class Professor {
 
	private String id;
	private String name;
	
	public Professor(String id, String name) {	
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}	
}
