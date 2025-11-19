package com.day6.MultiThreading;

//without sync

//class TicketCounter - availableSeat

class TicketCounter {
	private int availableSeat = 1;
	// sync
	synchronized void BookTicket(String userName) {
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

public class TicketBookingApp {
	public static void main(String[] args) {
		TicketCounter counter = new TicketCounter();
		TicketCounter counter2 = new TicketCounter();
		Thread t1 = new Thread(() -> counter.BookTicket("prakhar"));
		Thread t2 = new Thread(() -> counter.BookTicket("don"));
		Thread t3 = new Thread(() -> counter2.BookTicket("motu"));
		Thread t4 = new Thread(() -> counter2.BookTicket("rahul"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
