package com.day6.MultiThreading;

//create thread by extending from thread class
//override its run() method

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Run method called using start method");
	}
}

public class ThreadClass {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
	}

}
