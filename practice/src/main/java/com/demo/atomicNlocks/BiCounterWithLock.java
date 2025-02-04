package com.demo.atomicNlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLock {

	
	private int i = 0;
	private int j = 0;
	
	
	Lock lockForI = new ReentrantLock();
	Lock lockForJ = new ReentrantLock();
	
	public void incrementI() {
		lockForI.lock();
		i++;
		System.out.println(i);
		lockForI.unlock();
	}
	
	public void incrementJ() {
		lockForJ.lock();
		j++;
		lockForJ.unlock();
	}
	
	public static void main(String args[]) {
		BiCounterWithLock bi = new BiCounterWithLock();
		bi.incrementI();
	}

}
