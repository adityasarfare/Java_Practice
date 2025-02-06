package com.demo.concurrency;


class MyThread extends Thread{
	
	public void run() {
		System.out.println("Thread 1 is running");
	}

	public MyThread(){
		
	}

	public MyThread(Runnable runnable) {
      super(runnable);
	}


}
public class CreateThreadExample1 {

	public static void main(String[] args) {
		System.out.println("Main Thread");
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		
		Thread myThread2= new Thread(() -> 
		{
			System.out.println("Thread 2 is running");
			
		});
		
		myThread2.start();
		
		Runnable objRunnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread 3 is running");	
			}
		};
		
		Thread myThread3 = new Thread(objRunnable);
		
		myThread3.start();
		
		
        Runnable objRunnable1 = () ->{
				System.out.println("Thread 4 is running");	
				try {
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 4 completed");
        };
		Thread myThread4 = new Thread(objRunnable1);
		myThread.setDaemon(true);
		myThread4.start();
		
		System.out.println("Main Thread is completed");
		
	}
}
