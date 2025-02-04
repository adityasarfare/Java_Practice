package com.demo.Multithreading;

import java.util.concurrent.CompletableFuture;

public class WithoutVolatileExample {

	
	private volatile boolean flag= false;

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public static void main(String[] args) {
		
		WithoutVolatileExample withoutVolatileExample = new WithoutVolatileExample();
		
		
		new Thread(()->{
			System.out.println("Thread 1 started");
			try {
				System.out.println("Thread 1 logic started");
				Thread.sleep(1000);
				System.out.println("Thread 1 logic completed");
				withoutVolatileExample.setFlag(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()-> {
			System.out.println("Thread 2 started");
			while(!withoutVolatileExample.getFlag()) {
				
			}
			System.out.println("Thread 2 completed");
		}).start();
	}
	

}
