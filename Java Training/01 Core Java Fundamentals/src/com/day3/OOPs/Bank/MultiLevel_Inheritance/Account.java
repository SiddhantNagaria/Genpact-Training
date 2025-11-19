package com.day3.OOPs.Bank.MultiLevel_Inheritance;

public class Account extends Bank {

	protected String accountHolder;
	protected double balance;

	public Account(String accountHolder, double balance) {
		super();
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public void displayAccountInfo() {
		displayBankName();
		System.out.println("Account holder : " + accountHolder);
		System.out.println("Balance : " + balance);
	}
}
