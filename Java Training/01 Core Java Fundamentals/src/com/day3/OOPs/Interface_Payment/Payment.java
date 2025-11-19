package com.day3.OOPs.Interface_Payment;

public interface Payment {

	// by default - methods are abstract and public
	void makePayment(double amount);

	// concrete method are not permissible
//	public void display(){
//	};
	
	void display();
}
