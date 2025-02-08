package com.demo.concurrency;

class SharedResources{
	
	public  volatile boolean flag = false;

	public  boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}


public class VisibilityProblemUsingVolatile {
	public static void main(String[] args) {
		System.out.println("Main thread startes");
	SharedResources sr = new SharedResources();
	
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
		System.out.println("Thread 2 started");
		
		while(!sr.isFlag()) {
			
		}
		System.out.println("Thread 2 completed");
	}).start();
	}
}
