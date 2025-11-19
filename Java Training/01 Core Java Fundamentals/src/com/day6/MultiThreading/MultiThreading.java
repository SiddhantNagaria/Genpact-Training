//MultiThreading

//Thread -> single sequential flow of control within a program
//			- smallest independent unit of a process

//Process -> may contain one or more threads

//Thread - has its own program counter , call stack, local variables
//		 -	shared among threads are - memory(heap, static variables)

//MultiThreading -> ability to manage multiple threads execution at same time(concurrently)
//				 - can create many threads within same JVM instance.

//Concurrency / Parallelism

//Concurrency -> multiple threads executing at overlapping time periods.
//			  - single core CPU
//			  - 3 threads running - 1,2,3
//			  - JVM switch b/w threads - they appear simultaneous
//			  - MultiThreading enables concurrency
//Parallelism -> MultiCore CPU - threads / process are actually running simultaneously

//Benifits : 
//	- Throughput -> server can handle multiple requests at same time.
//	- Better Resource utilization
// Overheads : 
//	-	overhead of thread creation, switching, synchronization
//	- add up complexity

//Two options -
//1. inbuilt Thread Class - extend from this class
//2. using Runnable interface

//Thread LifeCycle
//	- synchronize
//	- actually what happens inside JVM thread is created, started, running ....
//	- describe the diff states that a thread goes through -
//	- from its creation until final execution or termination

//1. NEW state - Thread is created but not started
//			   - exists as an object but no call stack is thread
// Thread t1 = new Thread() -

//2. Runnable state - when you call start(), thread moves from New -> Runnable
//	- ready to run and waiting for CPU time.
//	- CPU scheduler will execute.
// t1.start() -> thread is now RUNNABLE

// 3. Blocked State 
//	- waiting to acquire a lock on an object currently held by another thread.

// 4. Waiting State ->
// 	- waiting for another thread to perform specific action

// 5. Timed Waiting state
//	- Similar like a waiting state but for a fixed time

// 6. Terminated State
//  - once run() method finishes, thread exists - done/ exception
//	- cannot be re-started


//Thread Synchronization ->
//	- multiple threads share same memory area(heap)
//	- means multiple threads can access and modify the same object or variable at the same time.
//	- t1, t2, t3 - sharing amount variable
//	- if they do this without coordination
//	- get data inconsistency
//	- problem - known as RACE CONDITION

//	- Solve problem using SYNCHRONIZATION
//		- Mechanism - ensures that a thread accesses a shared resources at a time
//		- prevent race condition by locking the shared object when no thread using it.
//		- Java - sync methods , sync blocks, static sync

//take some example - w/o sync
//apply sync methods - how execution changes


//STATIC SYNCHRONIZATION

//InterThreaded Communication
//	- thread communicate with each other
// wait(), notify(), notifyAll()

//Rules for wait() and notify()
//	- must be called inside a sync block or method
//	- thread must own the lock before calling them
//	- after calling wait() - thread releases the lock immediately - waiting state
//	- when another thread calls notify on some other thread, their state changes to runnable.


//Producer Consumer Problem - Assignment - InterThreaded communication





package com.day6.MultiThreading;

public class MultiThreading {

}
