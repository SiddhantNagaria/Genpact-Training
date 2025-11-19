package com.day3.OOPs.Bank.MultiLevel_Inheritance;

public class MultiLevelApp {

	public static void main(String[] args) {
		
		SavingsAccount sav1 = new SavingsAccount("Siddhant", 10000.00, 5);   
		
		sav1.displaySavingsInfo();
		System.out.println();
		
		sav1.calculateInterest();
		System.out.println();
		
		sav1.displayBankName();
		System.out.println();
		
		sav1.displayAccountInfo();
	}

}
