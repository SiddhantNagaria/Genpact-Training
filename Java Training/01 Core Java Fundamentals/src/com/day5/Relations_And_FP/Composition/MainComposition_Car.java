package com.day5.Relations_And_FP.Composition;

public class MainComposition_Car {

	public static void main(String[] args) {
		
		Car BMW = new Car("BMW M4");
		Car AUDI = new Car("AUDI Q4");
		
		BMW.addEngine("2500 CC");
		
		AUDI.addEngine("2300 CC");
		
		BMW.printEngine();
		
		AUDI.printEngine();
	}

}
