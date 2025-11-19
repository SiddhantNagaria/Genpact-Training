package com.day1.basics;

import java.util.Scanner;

public class LoopingStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter a value for a table : ");
//		int n = sc.nextInt();

//		FOR LOOP :-

//		for (int i = 1; i <= 10; i++) {
//			// initialization , stopping value, increment/decrement
//			System.out.println(n + "*" + i + "=" + (n * i));
//
//		}

//		System.out.println("--------------------");

//		for (int i = n; i >= 0; i--) {
//			System.out.println(i);
//		}

//		System.out.println("----------------------");
//
//		for (int j = 5; j >= 1; j--) {
//			for (int i = 1; i <= 10; i++) {
//				System.out.println(j + "*" + i + "=" + (j * i));	
//			}
//			System.out.println("--------------------------------");
//		}

		// WHILE LOOP -
//
//		int balance = 10000;
//		int choice = 0;
//
//		while (choice != 4) {
//			System.out.println("1. Deposit Money");
//			System.out.println("2. Withdraw Money");
//			System.out.println("3. Check Balance");
//			System.out.println("4. Exit");
//			System.out.println("Enter Choice :- ");
//
//			choice = sc.nextInt();
//
//			if (choice == 1) {
//				System.out.println("enter amount to be desposited");
//				int amount = sc.nextInt();
//				balance += amount;
//				System.out.println("Money Desposited. Your new balance is :" + balance);
//			} else if (choice == 2) {
//				System.out.println("enter amount to be withdrawn");
//				int amount = sc.nextInt();
//				balance -= amount;
//				System.out.println("Money Withdrawn. Your new balance is :" + balance);
//			} else if (choice == 3) {
//				System.out.println("Your balance is :" + balance);
//			} else if (choice == 4) {
//				System.out.println("Thank you for using ATM");
//			} else {
//				System.out.println("invalid choice");
//			}
//			System.out.println();
//	}
		// DO WHILE LOOP
		// ensure loop runs atleast once.
		// condition is checked at the end of the loop
//		String correctPwd = "Java123";
//		String enteredPwd;
//		do {
//			System.out.println("enter password");
//			enteredPwd = sc.next();
//			if (!enteredPwd.equals(correctPwd)) {
//				System.out.println("Incorrect pwd. Try again");
//			}
//		} while (!enteredPwd.equals(correctPwd));
//		System.out.println("Access given");
//		sc.close();

		// continue - skip the iteration
		// break - exit from loop in between
		int end = 10;
		for (int i = 1; i <= 10; i++) {
			if (i == 5)
				continue; //skip this iteration and move to next iteration
			System.out.println(end + "*" + i + "=" + (end * i));
		}
	}
}
