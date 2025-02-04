package com.demo.Multithreading;

public class MovieBookapp{

	public static void main(String args[])  {
		
		ThreadSynchronization ts = new ThreadSynchronization();
		Thread3 t3 = new Thread3(ts, 5);
		t3.start();
		
		Thread3 t4 = new Thread3(ts, 6);
		t4.start();
		
		ThreadSynchronization tr = new ThreadSynchronization();
		Thread4 t5 = new Thread4(tr, 5);
		t5.start();
		
		Thread4 t6 = new Thread4(tr, 5);
		t6.start();
	}

}
