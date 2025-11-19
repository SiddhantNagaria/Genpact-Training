package com.day3.OOPs.Bank;

import java.util.Scanner;

public class BankAccount {

	// attributes and behavior(implemented with method)
	// attributes/properties -
	// data belonging to object - data should be secure
	// make the data/attributes private by using private access modifier
	// private - these attributes can not access outside the class

	private int accountNumber;
	private String accHolderName;
	private double balance;

	// Constructor
	public BankAccount(int accountNumber, String accHolderName, double balance) {
		super(); // refer to the base class - Object class
		this.accountNumber = accountNumber;
		this.accHolderName = accHolderName;
		this.balance = balance;
	}

	Scanner sc = new Scanner(System.in);

	// methods - deposit amount(), withdrawMoney(), checkBalance()
	// method - behavior
	// special method - constructor - purpose is to initiate the object
	// it have same name as class

	// getters and setters
	// getters are used to fetch the values of private attributes
	// setters are used to set or update the values of private attributes

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// display method
	public void display() {
		System.out.println("AccNum : " + accountNumber);
		System.out.println("AccHolderName : " + accHolderName);
		System.out.println("Balance : " + balance);
		System.out.println();
	}

	// Deposit money
	public void depositAmount() {
		System.out.println("Enter amount to deposit");
		double amount = sc.nextDouble();
		if (amount > 0) {
			balance += amount;
			System.out.println("deposit successful. Updated blance is : " + balance);
		}else {
			System.out.println("Invalid amount");
		}
		System.out.println();
	}

	// withdraw amount
	//declared method can throw an exception
	public void withdraw() throws InsufficientBalanceException {
		System.out.println("Enter amount to withdraw");
		double amount = sc.nextDouble();
		if (amount <= balance && amount > 0) {
			balance -= amount;
			System.out.println("withdrawn successful. Updated balance : " + balance);
		} else if (amount > balance) {
			throw new InsufficientBalanceException("Withdrawal denied. Insufficient Funds");
		} else {
			System.out.println("Cannot withdraw. Invalid amount");
		}
		System.out.println();
	}

	// check balance
	public void checkBalance() {
		System.out.println("Current balance : " + balance);
		System.out.println();
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber : " + accountNumber + " , accHolderName : " + accHolderName + " , balance : "
				+ balance + " ]";
	}

}
