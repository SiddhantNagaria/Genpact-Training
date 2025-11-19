package com.day6.MultiThreading;

//Scenario -> simulate multiple file downloads concurrently
//			- like a browser multiple files download

class FileDownloader implements Runnable {

	private String fileName;

	public FileDownloader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println("Starting download : " + fileName + ". Thread : " + Thread.currentThread().getName());

		// simulate
		for (int i = 1; i <= 5; i++) {
			System.out.println("Downloading ...... " + fileName + " : " + (i * 20) + "% completed");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(fileName + "download interrupted");
			}
		}
		System.out.println("Completed downloading : " + fileName + ". Thread : " + Thread.currentThread().getName());
	}
}

public class DownloadManager {
	public static void main(String[] args) {
		// multiple threads = download multiple files
		Runnable file1 = new FileDownloader("Doc1.pdf");
		Runnable file2 = new FileDownloader("music.mp3");
		Runnable file3 = new FileDownloader("movie.mkv");

		// Assign each task to its own thread
		Thread t1 = new Thread(file1, "Downloader-1");
		Thread t2 = new Thread(file2, "Downloader-2");
		Thread t3 = new Thread(file3, "Downloader-3");

		// start all threads - call run() method
		t1.start();
		t2.start();
		t3.start();
		
		//main thread
		System.out.println("Main thread has finished scheduling");

	}

}
