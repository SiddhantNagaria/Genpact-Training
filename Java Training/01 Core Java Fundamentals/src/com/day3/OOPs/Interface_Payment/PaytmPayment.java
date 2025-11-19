package com.day3.OOPs.Interface_Payment;

public class PaytmPayment implements Payment{

	@Override
	public void makePayment(double amount) {
		System.out.println("Paid INR : " + amount + "using Paytm");
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
