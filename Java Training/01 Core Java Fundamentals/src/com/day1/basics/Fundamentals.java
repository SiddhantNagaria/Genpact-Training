package com.day1.basics;

public class Fundamentals {

	public static void main(String[] args) {
		// variables
		// -which can hold some value and that value can be cahnged also
		// - variable declaration - define variable should hold what kind of value
		// -integer, decimal, boolean

		// data types
		// -tell what kind of value we can store in a variable
		// -strongly typed language

		// operators
		// -tells what kind of operation we have to perform
		// a+b -> + is an operator, a and b are operands

		// Integer Types in java
		byte byteVar2;
		byte byteVar = 100;
		short shortVar = 2000;
		int intNum = 10000;
		long longNum = 1500000L;

		// FLoating data type
		float floatNum = 12.56f; // after decimal, we can store upto 6 decimal digits - precision
		double doubleNum = 123.7868; // after decimal, we can store upto 14 decimal digits

		// Character Type
		char grade = 'A';

		// String - colllection of characters(not a primitive type)
		String message = "we are creating a String type";

		// boolean type - true or false
		boolean hasAdharCard = false;

		// operators
		int a = 1, b = 20; // assign value

		// arithmetic operators
		// + - * /

		// relational operators
		// (a==b) -> equality
		// (a!=b) ->inequality
		// > < >= <=

		// Logical Operators
		// && ||

		boolean cond1 = true;
		boolean cond2 = false;
		System.out.println("cond1 && cond2 : " + (cond1 && cond2)); //logical AND
		System.out.println("cond1 || cond2 : " + (cond1 || cond2)); //logical OR
		// ! -> logical NOT = works with only one operand
		System.out.println("!cond1 : " + !cond1); // if cond1 is true then its logical not will give false - and vice versa
		
		//Assignment operators
		// = 
		//short hand operators :
		// a = a+10;
		// a+=10;
		
		System.out.println("--------------------------------------");
		
		int count = 10;
		System.out.println(count);
		System.out.println("after ++count :" + (++count)); //pre-increment
		System.out.println(count);
		System.out.println("after count++ :" + (count++)); //post-increment
		System.out.println(count);
		System.out.println("after ++count :" + (++count)); //pre-increment
		System.out.println(count);
		System.out.println("after count++ :" + (count++)); //post-increment
		System.out.println(count);
		
		int decCount = 20;
		System.out.println(decCount);
		System.out.println("after --decCount :" + (--decCount)); //pre-dec
		System.out.println(decCount);
		System.out.println("after decCount-- :" + (decCount--)); //post-dec
		System.out.println(decCount);
		
		
		
	}

}
