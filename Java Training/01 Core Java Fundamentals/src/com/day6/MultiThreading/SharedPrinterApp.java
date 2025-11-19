package com.day6.MultiThreading;

//imagine a printer shared among employees
//	- only one emp can use printer at a time - sync access
// take total 3 emp

class Printer {
	int usage = 1;

	synchronized void PrinterUse(String user) {
		if (usage > 0) {
			System.out.println(user + " is using the printer");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			usage--;
			System.out.println(user + " used the printer");
		} else {
			System.out.println("sorry " + user + ", printer is already in use");
		}
	}
}

public class SharedPrinterApp {
	public static void main(String[] args) {
		Printer p1 = new Printer();
		Thread t1 = new Thread(() -> p1.PrinterUse("EMP 1"));
		Thread t2 = new Thread(() -> p1.PrinterUse("EMP 2"));
		Thread t3 = new Thread(() -> p1.PrinterUse("EMP 3"));

		t1.start();
		t2.start();
		t3.start();

	}

}
