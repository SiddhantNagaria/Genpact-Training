package com.day6.MultiThreading;

class Printer2 {
	private boolean isBusy = false;

	public synchronized void printDocument(String empName, String document) {
		// if printer is busy, wait until it become free
		while (isBusy) {
			try {
				System.out.println(empName + " is waiting for printer");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		// mark printer is free
		isBusy = true;

		System.out.println(empName + " is printing " + document);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(empName + " has finished printing :" + document);
		isBusy = false;
		notify();
	}
}

class Employee extends Thread {

	private Printer2 printer;
	private String document;

	public Employee(String name, Printer2 printer, String document) {
		super(name);
		this.printer = printer;
		this.document = document;
	}

	public void run() {
		printer.printDocument(getName(), document);
	}
}

//Also modify this for sync block 

public class PrinterApp {
	public static void main(String[] args) {
		Printer2 sharedPrinter = new Printer2();
		Employee e1 = new Employee("Emp1", sharedPrinter, "report.pdf");
		Employee e2 = new Employee("Emp2", sharedPrinter, "report_two.pdf");
		Employee e3 = new Employee("Emp3", sharedPrinter, "report_three.pdf");

		e1.start();
		e2.start();
		e3.start();
	}

}
