package com.day3.OOPs.Bank.MultiLevel_Inheritance;

public class Bank {

	// protected - directly accessible in the inherited class
	protected String bankName = "National Bank";

	public void displayBankName() {
		System.out.println("Bank Name : " + bankName);
	}
}
