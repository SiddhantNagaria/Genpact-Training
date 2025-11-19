package com.day3.OOPs.Interface_Payment;

public class PaymentApp {
	public static void main(String args[]) {
		
		Payment payment1 = new CreditCardPayment();
		Payment payment2 = new UPIPayment();
		Payment payment3 = new PaytmPayment();
		
		payment1.makePayment(2000.00);
		payment2.makePayment(2000.00);
		payment3.makePayment(2000.00);
		
		CreditCardPayment paymentcd = new CreditCardPayment();
		paymentcd.display();
		paymentcd.refund(1000);
		paymentcd.makePayment(2000.00);
		
		PaytmPayment paytm1 = new PaytmPayment();
		paytm1.display();
		paytm1.makePayment(20000.00);
		
		UPIPayment upi1 = new UPIPayment();
		upi1.display();
		upi1.makePayment(3000.00);
		
	}
}
