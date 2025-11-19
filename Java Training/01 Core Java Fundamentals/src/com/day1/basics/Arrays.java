package com.day1.basics;

import java.util.Scanner;

public class Arrays {
	public static void main(String args[]) {
		// arrays - collection of homogeneous values
		// store multiple values of same type

		// declare an array
		// datatype[] = new datatype[size];
		Scanner sc = new Scanner(System.in);

//		int marks[] = new int[5]; // declared array marks of size 5
//		System.out.println(marks.length);
//
//		for (int i = 0; i < marks.length; i++) {
//			System.out.println("enter marks in subject : " + (i + 1) + " : ");
//			marks[i] = sc.nextInt();
//		}
//		int sum = 0;
//		// enhanced for loop
//		for (int j : marks) {
//			sum += j;
//		}
//		System.out.println("total marks is : " + sum);
//		double avg = (double) sum/marks.length;
//		
//		System.out.println("avg marks is : " + avg);

		// 2D Arrays - matrices
		// matrix like structure
		// represent data in form of rows and columns

		int[][] sales_data = new int[2][2];

		for (int i = 0; i < sales_data.length; i++) {
			for (int j = 0; j < sales_data[i].length; j++) {
				System.out.print("enter value for store " + (i + 1) + " for day " + (j + 1) + " : ");
				sales_data[i][j] = sc.nextInt();
			}
		}
		System.out.println("sales data is given below");
		for (int i = 0; i < sales_data.length; i++) {
			for (int j = 0; j < sales_data[i].length; j++) {
				System.out.print(sales_data[i][j] + "\t");
			}
			System.out.println();
		}

//		for (int i = 0; i < sales_data.length; i++) {
//			int total = 0;
//			for (int j = 0; j < sales_data[i].length; j++) {
//				total += sales_data[i][j];
//			}
//			System.out.println("store " + (i + 1) + " : " + total);
//		}

		for (int i = 0; i < sales_data.length; i++) { // Outer-loop handling store
			System.out.print("Store - " + (i + 1) + " : \t");
			int totalSalesPerStore = 0;
			for (int j = 0; j < sales_data[i].length; j++) { // Inner-loop handling days
				System.out.print(sales_data[i][j] + "\t");
				totalSalesPerStore += sales_data[i][j];
			}
			System.out.println("| \t" + totalSalesPerStore);
		}

		
		
		
		// Jagged Array - 2D array - rows of different length
		int jaggedArray[][] = new int[3][];

		jaggedArray[0] = new int[4];
		jaggedArray[1] = new int[2];
		jaggedArray[2] = new int[3];

		for (int i = 0; i < jaggedArray.length; i++) {
			for (int j = 0; j < jaggedArray[i].length; j++) {
				System.out.println("enter sales for store : " + (i + 1) + "for day : " + (j + 1) + " : ");
				jaggedArray[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<jaggedArray.length;i++) {
			for(int j=0;j<jaggedArray[i].length;j++) {
				System.out.println(jaggedArray[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
