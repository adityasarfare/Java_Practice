package com.demo.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// This same example can be resolved using synchronized keyword
class SharedCounter {
//	public int count;
	
	public AtomicInteger count = new AtomicInteger(0);

	public void increment() {
//		count++;
		count.incrementAndGet();
	}

	public int getCount() {
//		return count;
		return count.get();
	}
}

public class RaceConditionUsingAtomic {
      public static void main(String[] args) throws InterruptedException {
	
     SharedCounter sc = new SharedCounter();
     
      Thread thread1 = new Thread(() -> 
     {
    	System.out.println("Thread 1 started"); 
    	 for(int i=0; i<5000; i++) {
    		 sc.increment();
    	 }
     });
    thread1.start();
     
     
     Thread thread2 = new Thread(() -> 
     {
    	System.out.println("Thread 2 started"); 
    	 for(int i=0; i<5000; i++) {
    		 sc.increment();
    	 }
     });
     
     thread2.start();
     
     thread1.join();
     thread2.join();
     
		System.out.println(sc.getCount());
}
}
