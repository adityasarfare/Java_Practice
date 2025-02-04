package com.demo.Multithreading;

public class ThreadbasicNameMethods extends Thread {

	@Override
	public void run() {
	    System.out.println(	Thread.currentThread().getName());
		System.out.println(Thread.currentThread().isAlive());
	    Thread.currentThread().setName("thread-11");
	    System.out.println(	Thread.currentThread().getName());
		System.out.println("Inside Thread");
	}
	

	public static void main(String args[]) {
		ThreadbasicNameMethods t1 = new ThreadbasicNameMethods();
		t1.start();
	}

}
