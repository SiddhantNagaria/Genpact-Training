//Producer-Consumer Problem  ->
//thread synchronization, inter-thread communication (wait, notify),
// and shared resource management.

//1. Problem Statement
//Two types of threads share a common resource (like a queue or buffer):
//  Producer -> produces data items and puts them into the buffer
//  Consumer -> takes data items out of the buffer and uses them
// But:
//If the buffer is full, producer must wait
//If the buffer is empty, consumer must wait
//So, both must coordinate to avoid:
//Overfilling the buffer
//Reading from an empty buffer
//Data inconsistency (race conditions)


package com.day6.MultiThreading;

import java.util.LinkedList;

class SharedBuffer {
    private final LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACITY = 3;

    // Producer adds item
    public synchronized void produce(int value) throws InterruptedException {
        // if buffer full, wait
        while (list.size() == CAPACITY) {
            System.out.println("Buffer full. Producer waiting...");
            wait();
        }

        list.add(value);
        System.out.println("Produced: " + value);

        // notify consumer that item is available
        notify();
    }

    // Consumer removes item
    public synchronized void consume() throws InterruptedException {
        // if buffer empty, wait
        while (list.isEmpty()) {
            System.out.println("Buffer empty. Consumer waiting...");
            wait();
        }

        int value = list.removeFirst();
        System.out.println("Consumed: " + value);

        // notify producer that space is available
        notify();
    }
}

class Producer extends Thread {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int value = 0;
        try {
            while (true) {
                buffer.produce(value++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}
