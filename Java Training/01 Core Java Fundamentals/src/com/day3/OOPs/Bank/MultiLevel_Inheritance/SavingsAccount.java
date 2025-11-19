package com.day3.OOPs.Bank.MultiLevel_Inheritance;

//derived class - level 2
public class SavingsAccount extends Account {

	private double interestRate;
	
	public SavingsAccount(String accountHolder, double balance, double interestRate) {
		super(accountHolder, balance);
		this.interestRate = interestRate;
	}
	
	void displaySavingsInfo() {
		displayBankName();
		displayAccountInfo();
		System.out.println("Interest Rate : " + interestRate);
	}
	
	public void calculateInterest() {
		double interest = balance * (interestRate/100);
		System.out.println("Annual Interest : " + interest);
		
		//directly accesssing protected members without getter and setter
		System.out.println("Account Holder : " + accountHolder);
		System.out.println("Bank Name : " + bankName);
	}
}
