package com.demo.atomicNlocks;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

	static AtomicInteger sharedCounter = new AtomicInteger(0); // Thread-safe counter

  

	public static void main(String[] args) {
        // Creating multiple threads
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            for (int i = 0; i < 5000; i++) {
                sharedCounter.incrementAndGet(); // Atomic operation
            }
            System.out.println("Thread 1 completed");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            for (int i = 0; i < 5000; i++) {
                sharedCounter.incrementAndGet();
            }
            System.out.println("Thread 2 completed");
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final Cout " + sharedCounter);

}
}
