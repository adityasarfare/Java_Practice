package com.demo.concurrency;

class SharedResources1{
	
	public   boolean flag = false;

	public synchronized boolean isFlag() {
		return flag;
	}

	public synchronized void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}


public class VisibilityProblemUsingSynchronized {
	public static void main(String[] args) {
		System.out.println("Main thread startes");
	SharedResources1 sr = new SharedResources1();
	
	new Thread (() ->{
		try {
			System.out.println("Thread 1 logic started");
			Thread.sleep(2000);
			sr.setFlag(true);
			System.out.println("Thread 1 logic completed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("Thread 1 completed");
	}).start();
	
	
	new Thread(() -> {
		System.out.println("Thread 2 logic started");
		
		while(!sr.isFlag()) {
			
		}
		System.out.println("Thread 2 completed");
	}).start();
	}
}
