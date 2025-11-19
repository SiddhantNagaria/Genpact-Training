package com.day6.MultiThreading;

//1. synch for entire method

//2. static synch
//3. use sync block inside method - only for critical section - shared updation happens

class TicketCounter3 {

	private int availableSeat = 2;

	void BookTicket(String userName) {
		System.out.println("welcome to ticket booking app");
		System.out.println(userName + " is booking the seat...");

		// Critical Section
		synchronized (this) { // only critical section of the method is synchronized , not complete method
			if (availableSeat > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println();
				}
				availableSeat--;
				System.out.println(userName + " sucessfully booked the seat");
			} else {
				System.out.println("sorry " + userName + ", seat is already booked");
			}
		}
		System.out.println("Exiting ticket booking app. Thank you");
	}
}

public class TicketCounterApp2 {
	public static void main(String[] args) {
		TicketCounter3 counter = new TicketCounter3();
		TicketCounter3 counter2 = new TicketCounter3();
		Thread t1 = new Thread(() -> counter.BookTicket("prakhar"));
		Thread t2 = new Thread(() -> counter.BookTicket("don"));
		t1.start();
		t2.start();
		//Thread t3 = new Thread(() -> counter2.BookTicket("motu"));
		//Thread t4 = new Thread(() -> counter2.BookTicket("rahul"));
		//t3.start();
		//t4.start();

	}

}
