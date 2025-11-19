package com.day2.basics;

public class Function {
	// TODO Auto-generated method stub

	// function - (method)
	// -> block of code that performs a specific task and can be reused
	// modular approach

	// create a function(method) - does not get executed
	// call method - then it gets executed

	// syntax -
	// modifier returnType functionName (parameters){
	// logic of function
	// return statement or value
	// }
	public static void main(String[] args) {
		System.out.println("function calling ...........");
		welcomeUser();

		int result = addNumbers(4, 5);
		
		int answer = addNumbers(3, 4, 5);
		
		System.out.println("result of adition function is : " + result);

		System.out.println("result of 2nd adition function is : " + answer);

		System.out.println("area of rectangle is " + areaRect(5, 4));

		System.out.println("area of circle is " + areaCircle(4));

		greetUser("Siddhant");

	}

	public static void welcomeUser() {
		System.out.println("welcome to Java Training....... ");
	}

	public static int addNumbers(int a, int b) {
		return a + b;
	}

	public static double areaRect(double length, double width) {
		double area = length * width;
		return area;
	}

	public static double areaCircle(int radius) {
		double pi = Math.PI;
		double area = pi * radius * radius;
		return area;
	}

	public static void greetUser(String user) {
		System.out.println("Welcome to java training : " + user);
	}

	
	// FUNCTION OVERLOADING
	
	// when we create multiple functions with same name but with different parameter
	// list
	// Rules - Number of parameters can be different as well as datatype can be
	// different
	//Return type alone cannot be used to overload
	//Improve readability

	public static int addNumbers(int a, int b, int c) {
		return a + b + c;
	}

}
