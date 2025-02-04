package com.demo.Multithreading;

public class Thread3 extends Thread{

 ThreadSynchronization ts;
	
	int seats;

	
	public Thread3(ThreadSynchronization ts, int seats) {
		super();
		this.ts = ts;
		this.seats = seats;
	}

	@Override
	public void run() {
		ts.bookSeat(seats);
	}
	
}
