package com.demo.atomicNlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPractice extends Thread {


	
 static int i =0;
 
 
	Lock lock = new ReentrantLock();
	
	 public void run() {
		 lock.lock();
		i++;
		
		 System.out.println(i);
		 lock.unlock();
	}
	
	public int getI() {
		return i;
	}
	
public static void main(String args[]) {
	
	LockPractice lp = new LockPractice();
	lp.start();
	
	LockPractice lp1 = new LockPractice();
	lp1.start();
	try {
        lp.join();
        lp1.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("Final value of i: " + i);
}
}
