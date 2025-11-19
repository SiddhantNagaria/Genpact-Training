package com.day3.OOPs.Bank;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message); // calling exception class to print message
	}
}
