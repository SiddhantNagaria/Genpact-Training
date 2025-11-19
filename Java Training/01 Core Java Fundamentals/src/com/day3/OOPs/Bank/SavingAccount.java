package com.day3.OOPs.Bank;

//to be inherited from parent class - BankAccount class
// extends - keyword 

// super keyword - referring to bankAccount class = base class of SavingsAccount

public class SavingAccount extends BankAccount {

	// specific to savingAccount Class only
	// in total 4 attributes - 3 inherited from base class
	private double InterestRate;

	public SavingAccount(int accountNumber, String accHolderName, double balance, double interestRate) {
		// calling super class constructor to initiate values
		super(accountNumber, accHolderName, balance);
		this.InterestRate = interestRate;
		// TODO Auto-generated constructor stub

	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingAccount [ Account Number= " + getAccountNumber() + " , AccountHolderName " + getAccHolderName()
				+ " , Balance = " + getBalance() + " , InterestRate= " + InterestRate + " ] ";
	}

	// create method addInterest
	public void addInterest() {
		// added to the balance
		// balance * interestRate / 100
		// calculate Interest

		double interest = getBalance() * InterestRate / 100;

		// add Interest to balance
		double newBalance = getBalance() + interest;
		setBalance(newBalance);

		System.out.println("Interest has been added. New balance : " + newBalance);
		System.out.println();
	}

	// implementing polymorphism - override
	@Override
	public void withdraw() throws InsufficientBalanceException {
		System.out.print("Enter amount to withdraw : ");
		double amount = sc.nextDouble();
		// minimum balance- 5000 always
		if (amount > 0 && amount <= (getBalance() - 5000)) {
			setBalance(getBalance() - amount);
			System.out.println("Withdrawal successful. Updated balance : " + getBalance());
		}else if(amount > getBalance()) {
			throw new InsufficientBalanceException("Withdrawal denied. Insufficient Funds");
		}
		else {
			if (amount < 0) {
				System.out.println("Invalid Amount");
			} else {
				System.out.println("Invalid Amount. Cannot Withdraw. Minimum balance 5000 should be there");
			}
		}
	}

}
