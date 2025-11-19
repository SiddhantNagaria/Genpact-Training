package com.day5.Relations_And_FP.Composition;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private String car_name;
	private List<Engine> engineNames = new ArrayList<Engine>();
	
	public Car(String car_name) {
		this.car_name = car_name;
	}
	
	//add Engine
	public void addEngine(String e) {
		Engine engine = new Engine(e);
		engineNames.add(engine);
	}
	
	//print engine
	public void printEngine() {
		System.out.println("Car name is : "  + car_name);
		for(Engine e : engineNames) {
			System.out.println("Associated engine to " + car_name + " is : " + e.getEngineName());
		}
		System.out.println();
	}
}
