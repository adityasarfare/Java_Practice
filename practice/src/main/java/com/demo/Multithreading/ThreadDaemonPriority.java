package com.demo.Multithreading;

public class ThreadDaemonPriority extends Thread {

	
	@Override
	public void run() {
//		System.out.println(Thread.currentThread().isDaemon());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("Inside Thread");
	}
	

	public static void main(String args[]) {
		ThreadDaemonPriority t1 = new ThreadDaemonPriority();
//		t1.setDaemon(true);
		t1.setPriority(MAX_PRIORITY);
		t1.start();
	}
}
