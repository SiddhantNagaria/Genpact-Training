package com.day3.OOPs.Bank;

import java.util.Scanner;

//Hierarchical inheritance

public class CurrentAccount extends BankAccount {

	private double transactionFee;

	Scanner sc = new Scanner(System.in);

	public CurrentAccount(int accountNumber, String accHolderName, double balance, double transactionFee) {
		super(accountNumber, accHolderName, balance);
		this.transactionFee = transactionFee;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(double transactionFee) {
		this.transactionFee = transactionFee;
	}

	// Hierarchial Inheritance
	// -> from BA inherit another class - CurrentAccount
	// -> transactionFee (attribute) - 2%
	// -> override both deposit and withdraw
	// -> deposit -> 10000, 5000 - 2%5000=100 has to be deducted from balance
	// -> 10000 + 5000 - 100
	// Similiarly withdraw
	// -> 2% fee on amount to be withdrawn

	@Override
	public void depositAmount() {
		System.out.print("Enter amount to deposit: ");
		double amount = sc.nextDouble();
		if (amount > 0) {
			double fee = (transactionFee / 100) * amount;
			double netDeposit = amount - fee;
			setBalance(getBalance() + netDeposit);
			System.out.println("Deposit successful. Fee deducted: " + fee + ". Net Deposit Amount : " + netDeposit);
			System.out.println("Updated balance: " + getBalance());
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	@Override
	public void withdraw() throws InsufficientBalanceException{
		System.out.print("Enter amount to withdraw: ");
		double amount = sc.nextDouble();

		if (amount > 0) {
			double fee = (transactionFee / 100) * amount;
			double totalDeduction = amount + fee;

			if (totalDeduction <= getBalance()) {
				setBalance(getBalance() - totalDeduction);
				System.out.println(
						"Withdrawal successful. Fee deducted: " + fee + ". Total money deducted : " + totalDeduction);
				System.out.println("Updated balance: " + getBalance());
			} else {
				throw new InsufficientBalanceException("Insufficient balance for withdrawal including fee.");
			}
		} else {
			System.out.println("Invalid withdrawal amount.");
		}
	}
}
