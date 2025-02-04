package com.demo.atomicNlocks;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithAtomic {

	private AtomicInteger i = new AtomicInteger();
	private AtomicInteger j = new AtomicInteger();	
	

	public void incrementI() {
		i.incrementAndGet();
		System.out.println(i);
	}
	
	public AtomicInteger getI() {
		return i;
	}
	
	public void incrementJ() {
		j.incrementAndGet();
		System.out.println(j);
	}
	

	public AtomicInteger getJ() {
		return j;
	}
	
	public static void main(String args[]) {
	BiCounterWithAtomic ba = new BiCounterWithAtomic();
	   ba.incrementI();
	   ba.getI();
	   ba.incrementJ();
	   ba.getJ();
	}

}
