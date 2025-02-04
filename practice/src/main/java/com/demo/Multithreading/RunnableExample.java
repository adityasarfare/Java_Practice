package com.demo.Multithreading;

public class RunnableExample implements Runnable{

	
	@Override
	public void run() {
		System.out.println("Hii how are you!");
		
	}
	
	public static void main(String args[]) {
		
		
		Thread t1 = new Thread(() ->{
			
			
				System.out.println("Hii how are you..!");
				
			
		});
		t1.start();
		
//		RunnableExample r1 = new RunnableExample();
//		Thread t2 = new Thread(r1);
//		t2.start();
	}



	
}
