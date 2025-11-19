package com.day3.OOPs.Interface_Payment;

public class CreditCardPayment implements Payment, Refundable {

	@Override
	public void makePayment(double amount) {
		System.out.println("Paid INR : " + amount + "using credit card");

	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded INR : " + amount + "to Credit Card Payment");

	}

	@Override
	public void display() {
		System.out.println("Using Credit card as payment method");
	}

}
