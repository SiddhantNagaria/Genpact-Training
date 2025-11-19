package com.day5.Relations_And_FP.Streams_and_FI;

@FunctionalInterface
public interface FunctionalInterfaceCode {
	
	double applyDiscount(double price);
	
	// we can have only one abstract method
	// some helper methods were permitted in FI
	// default and static methods
	
	// instance methods - which we have to call with object
	default void printReceipt() { 
		System.out.println("Receipt Printed successfully");
	}
	
	// Utility Methods
	// belong to interface - not to instance(obj)
	// BankAcc - display bank Name - common
	static void showCurrency() {
		System.out.println("Currency : INR");
	}
	
	// lambda exp can be use for abstract method only
	
	// methods - how? - object.method() -> belong to objects - instance methods
	// static methods - do not belong to obj -> class/interface -by classname/interfacename
}
