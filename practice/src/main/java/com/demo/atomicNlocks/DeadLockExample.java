package com.demo.atomicNlocks;

public class DeadLockExample {

	static final Object resource1 = new Object(); // First shared resource
    static final Object resource2 = new Object(); // Second shared resource

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) { // Lock resource1
                System.out.println("Thread 1: Locked resource1");

                // Simulate some work
                try { Thread.sleep(100); 
                } 
                catch (InterruptedException e) {
                	
                }

                synchronized (resource2) { // Tries to lock resource2
                    System.out.println("Thread 1: Locked resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) { // Lock resource2
                System.out.println("Thread 2: Locked resource2");

                // Simulate some work
                try { 
                	Thread.sleep(100); 
                	} 
                catch (InterruptedException e) {
                	
                }

                synchronized (resource1) { // Tries to lock resource1
                    System.out.println("Thread 2: Locked resource1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
