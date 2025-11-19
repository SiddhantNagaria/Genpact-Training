package com.day6.MultiThreading;

class Printer3 {
	private boolean isBusy = false;

	public void printDocument(String empName, String document) {
		// if printer is busy, wait until it become free
		while (isBusy) {
			synchronized (this) {
				try {
					System.out.println(empName + " is waiting for printer");
					wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		// mark printer is free
		isBusy = true;

		// simulate printing
		System.out.println(empName + " is printing " + document);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(empName + " has finished printing :" + document);

		synchronized (this) {
			isBusy = false;
			notify();
		}
	}
}

class Employee2 extends Thread {

	private Printer2 printer;
	private String document;

	public Employee2(String name, Printer2 printer, String document) {
		super(name);
		this.printer = printer;
		this.document = document;
	}

	public void run() {
		printer.printDocument(getName(), document);
	}
}

//Also modify this for sync block 

public class PrinterAppSyncBlock {
	public static void main(String[] args) {
		Printer2 sharedPrinter = new Printer2();
		Employee2 e1 = new Employee2("Emp1", sharedPrinter, "report.pdf");
		Employee2 e2 = new Employee2("Emp2", sharedPrinter, "report_two.pdf");
		Employee2 e3 = new Employee2("Emp3", sharedPrinter, "report_three.pdf");

		e1.start();
		e2.start();
		e3.start();
	}

}
