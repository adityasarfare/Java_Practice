package com.demo.Multithreading;

public class ThreadPrevention extends Thread  {
	@Override
	public void run() {
		
		for(int i=1; i<=5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	

	public static void main(String args[]) {
		ThreadPrevention t1 = new ThreadPrevention();
		t1.start();
//		
//		try {
//			Thread.currentThread().join();
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
		
	}
}
