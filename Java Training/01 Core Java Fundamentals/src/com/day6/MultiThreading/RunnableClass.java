package com.day6.MultiThreading;

//RUnnable interface
//	- only one abstract method - run()
//	- you can implement Runnable when your class
//	- pass the Runnable object to a Thread class Constructor

class MyTask implements Runnable {

	@Override
	public void run() {
		System.out.println("run method");
	}

}

public class RunnableClass {
	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread t1 = new Thread(task);
		t1.start();
	}

}
