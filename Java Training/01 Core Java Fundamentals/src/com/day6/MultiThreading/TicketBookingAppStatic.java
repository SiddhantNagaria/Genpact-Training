package com.day6.MultiThreading;

class TicketCounter2 {
	private static int availableSeat = 1;
	// sync
	static synchronized void BookTicket(String userName) {
		if (availableSeat > 0) {
			System.out.println(userName + " is booking the seat...");
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
//		System.out.println(availableSeat);
	}
}

public class TicketBookingAppStatic {
	public static void main(String[] args) {
		TicketCounter2 counter = new TicketCounter2();
		TicketCounter2 counter2 = new TicketCounter2();
		Thread t1 = new Thread(() -> counter.BookTicket("prakhar"));
		Thread t2 = new Thread(() -> counter.BookTicket("don"));
		t1.start();
		t2.start();
		Thread t3 = new Thread(() -> counter2.BookTicket("motu"));
		Thread t4 = new Thread(() -> counter2.BookTicket("rahul"));
		t3.start();
		t4.start();

	}

}
