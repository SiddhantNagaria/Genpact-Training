package com.day2.basics;

import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message); // calling exception class to print message
	}
}

public class ExceptionHandling {

	// domain specific custom exception
	public static void withdraw(double balance, double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance. Withdrawal cannot be done. ");
		}
		System.out.println("withdrawal successful");
	}
	
	public static void main(String args[]) {
		// Exception
		// errors - wrong parameter, missing ; , -> syntax error

		// runtime error - execute a program , a/b ->
		// asking fom user to enter a and b
		// user enters b as 0 -> 123/0 ->

		// int a = 123;
		// int b = 0;
		// System.out.println(a / b); //run-time error
		// program has crashed abruptly
		// handle these exceptions gracefully

		// try-catch-finally blocks

//		Scanner sc = new Scanner(System.in);
//		int marks[] = new int[2];
//
//		try {
//			System.out.println("enter numerator");
//			int num = sc.nextInt();
//			System.out.println("enter denominator");
//			int den = sc.nextInt();
//
//			int result = num / den; // may result in an axception
//			System.out.println("Result : " + result);
//			System.out.println(marks[4]);
//		}
//		catch (ArithmeticException e) {
//			System.out.println("Error : Division by 0 is not possible");
//		} 
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("array index is out of bound");
//		} catch (InputMismatchException e) {
//			System.out.println("enter only integer value");
//		}
		// generic catch block
		// generic class - Exception
//		catch (Exception e) {
//			System.out.println("some exception occured : " + e.getMessage());
//		} finally {
//			// closing statements are written
//			System.out.println("task finished");
//			sc.close();
//		}
		// built-in exceptions

		// custom exceptions
		// useful for domain specific error
		// extends from Exception class

		double balance = 10000;
		double w_amount = 1000;
		try {
			withdraw(balance, w_amount);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

	}
}
