package com.day3.OOPs.Abstraction;

public class TestApp {

	public static void main(String[] args) {
		
		//abstract class cannot be instantiated
		//cannot create object of abstract class
//		Test obj1 = new Test(1234);
		
		TestInherited obj1 = new TestInherited(1234, 5678);

		obj1.multiply(4);
		obj1.display();
	}

}
