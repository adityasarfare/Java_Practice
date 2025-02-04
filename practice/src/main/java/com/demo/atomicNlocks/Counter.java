package com.demo.atomicNlocks;

public class Counter {

	
	static int i =0;
	
	 synchronized void increment() {
		i++;
		//get
		//increment
		//set 
		System.out.println(i);
	}
	
	public int getI() {
		return i;
	}
	
	public static void main(String args[]) {
	Counter c = new Counter();
	c.increment();
	
	Counter c1 = new Counter();
	c1.increment();
	
//	System.out.println(c.getI());
	}

}
