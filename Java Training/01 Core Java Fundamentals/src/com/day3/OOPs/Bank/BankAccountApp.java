package com.day3.OOPs.Bank;

import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		///////////////////////////////////////////////////////////////////

		// BANKACCOUNT OBJECT

		// initialize the object
		// constructor is called automatically

		BankAccount BA1 = new BankAccount(101, "Siddhant Nagaria", 20000.00);

//		BankAccount BA2 = new BankAccount();

		// SETTER
		// to use setter , remove constructor of the object and then initialize values
		// using setter

//		BA2.setAccHolderName("Siddhant Nagaria");
//		BA2.setAccountNumber(101);
//		BA2.setBalance(15000);

		// methods
		BA1.checkBalance();
		BA1.depositAmount();
		BA1.checkBalance();
		try {
			BA1.withdraw();
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		BA1.display();

//		BA2.display();
//
		System.out.println(BA1);
		System.out.println();

//		GETTERS
		System.out.println(BA1.getAccountNumber());
		System.out.println(BA1.getAccHolderName());
		System.out.println(BA1.getBalance());
		System.out.println(BA1.getClass());

///////////////////////////////////////////////////////////////////////////////////

		// SAVING ACCOUNT CLASS - OBJECT AND METHODS

		System.out.print("enter account holder name : ");
		String name = sc.next();
		System.out.print("Enter bank account initial balance : ");
		double balance = sc.nextDouble();
		System.out.print("Enter Interest : ");
		double interest = sc.nextDouble();

		SavingAccount savAcc1 = new SavingAccount(101, name, balance, interest);

//		SavingAccount savAcc2 = new SavingAccount(101, "Siddhant", 10000, 2);

		savAcc1.checkBalance();
		savAcc1.depositAmount();
		savAcc1.addInterest();
		savAcc1.checkBalance();

		// GETTER
		System.out.println(savAcc1.getInterestRate());
		System.out.println(savAcc1.getAccHolderName());
		System.out.println(savAcc1.getAccountNumber());
		System.out.println(savAcc1.getBalance());

		// SETTER
		// to use setter , remove constructor of the object and then initialize values
		// using setter

		try {
			savAcc1.withdraw();
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(savAcc1);

		//////////////////////////////////////////////////////////////////

		CurrentAccount curAc1 = new CurrentAccount(101, "Siddhant", 10000, 2);

		curAc1.checkBalance();
		curAc1.depositAmount();

		try {
			curAc1.withdraw();
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(curAc1);
		System.out.println();

		// GETTERS
		System.out.println(curAc1.getTransactionFee());
		System.out.println(curAc1.getAccHolderName());
		System.out.println(curAc1.getAccountNumber());
		System.out.println(curAc1.getBalance());

		// SETTER
		// to use setter , remove constructor of the object and then initialize values
		// using setter

	}

}
