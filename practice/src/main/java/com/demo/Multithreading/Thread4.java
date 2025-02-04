package com.demo.Multithreading;

public class Thread4 extends Thread {

	
 ThreadSynchronization ts;
	
	int seats;

	public Thread4(ThreadSynchronization ts, int seats) {
		super();
		this.ts = ts;
		this.seats = seats;
	}
	
	@Override
	public void run() {
		ts.bookSeat(seats);
	}
	
}
