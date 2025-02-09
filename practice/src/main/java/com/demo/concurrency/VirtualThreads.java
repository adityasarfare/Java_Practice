package com.demo.concurrency;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreads {

	public static void main(String[] args) throws InterruptedException {
		
	final  int numberOfThreads = 1000;
		
	List<Thread> listOFThread = new ArrayList<>();
	
	Runnable objRunnable = new  Runnable() {
		
		public void run() {
			
			//Simulate fetching data from database
			System.out.println("Fetching data from API");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
	};
	
	for(int i=1; i<numberOfThreads; i++) {
		Thread thread = new Thread(objRunnable);
		//This is virtual thread
//		Thread thread = Thread.OfVirtual().unstarted();
		
		//And in virtual thread we dont have to make that thread deamon it is by default deamon
		thread.setDaemon(true);
		thread.setName("Thread "+ i);
		thread.start();
		
		String str = String.format("Thread number %s", i);
		System.out.println(str);
		listOFThread.add(thread);
	}
		for(Thread th: listOFThread) {
			th.join();
			System.out.println(th.getName() + "completed");
		}
	}
}
