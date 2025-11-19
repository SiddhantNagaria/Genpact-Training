package com.day6.MultiThreading;

class TaskDownloader extends Thread {
	private final String taskName;

	public TaskDownloader(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println("Starting Task: " + taskName + " | Thread: " + Thread.currentThread().getName());
		for (int i = 1; i <= 3; i++) {
			System.out.println("Downloading Task: " + taskName + " - " + (i * 33) + "% completed");
			try {
				Thread.sleep(1000); // Simulate download time
			} catch (InterruptedException e) {
				System.out.println("Download interrupted for task: " + taskName);
				Thread.currentThread().interrupt(); // Restore interrupted status
			}
		}
		System.out.println("Completed Task: " + taskName + " | Thread: " + Thread.currentThread().getName());
	}
}

public class TaskManager {
	public static void main(String[] args) {
		TaskDownloader cleaningTask = new TaskDownloader("Cleaning");
		TaskDownloader washingTask = new TaskDownloader("Washing");
		TaskDownloader dryingTask = new TaskDownloader("Drying");

		// Initial thread states
		printThreadStates(cleaningTask, washingTask, dryingTask);

		// Start threads
		cleaningTask.start();
		printThreadStates(cleaningTask, washingTask, dryingTask);

		washingTask.start();
		printThreadStates(cleaningTask, washingTask, dryingTask);

		dryingTask.start();
		printThreadStates(cleaningTask, washingTask, dryingTask);

		System.out.println("Main thread has finished scheduling tasks.");
	}

	private static void printThreadStates(Thread... threads) {
		for (Thread thread : threads) {
			System.out.println("Thread [" + thread.getName() + "] State: " + thread.getState());
		}
	}
}