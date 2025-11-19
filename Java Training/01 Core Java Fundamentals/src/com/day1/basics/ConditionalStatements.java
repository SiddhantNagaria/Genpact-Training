package com.day1.basics;

import java.util.Scanner;

public class ConditionalStatements {

	public static void main(String[] args) {
		// Control statements - conditional , looping
		// program execution is line by line
		// decide based on certain condition - 2 statements - when to execute what
		// 2-3 statements - execute multiple times

		// if else elseif switch

		int num = 25;
		// number is even or odd

		// number % 2 ==0 -> remainder = 0-> even - else odd

		if (num % 2 == 0) {
			// this block will run if conditition is true in if block
			System.out.println(num + " is even");
		} else {
			System.out.println(num + " is odd");
		}

		System.out.println("------------------------------------");

		int age = 24;
		boolean citizenshipIndian = true;
		if (age >= 18 && citizenshipIndian) {
			System.out.println("he can vote");
		} else {
			System.out.println("he cannot vote");
		}

		System.out.println("------------------------------------");

		int marks = 55;
		if (marks >= 90) {
			System.out.println("grade A");
		} else if (marks >= 75 && marks < 90) {
			System.out.println("grade B");
		} else if (marks >= 60 && marks < 75) {
			System.out.println("grade C");
		} else {
			System.out.println("grade D");
		}

		System.out.println("------------------------------------");

		// Scanner class

		Scanner sc = new Scanner(System.in);
		System.out.println("enter marks of students :");
		int mark = sc.nextInt();
		System.out.println(mark);

		// switch case
		// restaurant menu
		System.out.println("Press 1. Pasta");
		System.out.println("Press 2. Pizza");
		System.out.println("Press 3. Burger");
		System.out.println("Press 4. Exit");

		int choice = sc.nextInt();
		switch (choice) {
		// cases
		case 1:
			System.out.println("pasta ordered");
			break;
		case 2:
			System.out.println("pizza ordered");
			break;
		case 3:
			System.out.println("burger ordered");
			break;
		case 4:
			System.out.println("thank you for visit");
			break;
		default:
			System.out.println("invalid input");
		}

	}

}
