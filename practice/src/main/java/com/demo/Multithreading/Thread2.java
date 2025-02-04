package com.demo.Multithreading;

public class Thread2 implements Runnable{

	@Override
	public void run() {
System.out.println("Inside Runnable");		
	}
	
	public static void main(String args[]) {
		Thread2 t2 = new Thread2();
		Thread th = new Thread(t2);
		th.start();
	}


}
