package com.demo.atomicNlocks;

import java.util.concurrent.locks.ReentrantLock;

public class PreventDeadLockExample {

	static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            if (lock1.tryLock()) {
                try {
                    System.out.println("Thread 1: Locked lock1");
                    Thread.sleep(100);
                    if (lock2.tryLock()) {
                        try {
                            System.out.println("Thread 1: Locked lock2");
                        } finally {
                            lock2.unlock();
                        }
                    }
                } catch (InterruptedException e) {} 
                finally { lock1.unlock(); }
            }
        });

        Thread thread2 = new Thread(() -> {
            if (lock2.tryLock()) {
                try {
                    System.out.println("Thread 2: Locked lock2");
                    Thread.sleep(100);
                    if (lock1.tryLock()) {
                        try {
                            System.out.println("Thread 2: Locked lock1");
                        } finally {
                            lock1.unlock();
                        }
                    }
                } catch (InterruptedException e) {} 
                finally { lock2.unlock(); }
            }
        });

        thread1.start();
        thread2.start();
    }
}

//Thread 1: Locked lock1
//Thread 2: Locked lock2
//Thread 1: Locked lock2
//Thread 2: Locked lock1
