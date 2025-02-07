package com.demo.concurrency;

public class ThreadLocalExample {
public static void main(String[] args) {
	
	ThreadLocal<Long> userIdThrealLocal = new ThreadLocal<>();
	
	Long userId1 = 1234L;
	Long userId2 = 5678L;
	
	 Thread t1 = new Thread(() -> {
		System.out.println("Thread 1 started for" + userId1);
		userIdThrealLocal.set(userId1);
		System.out.println("Completed Logic for "+
		userIdThrealLocal.get());
		userIdThrealLocal.remove();
		System.out.println("Removed thread 1" + userIdThrealLocal.get());
	});
	
	Thread t2 = new Thread(() -> {
		System.out.println("Thread 2 started for" + userId2);
		userIdThrealLocal.set(userId2);
		System.out.println("Completed Logic for "+
		userIdThrealLocal.get());
		userIdThrealLocal.remove();
		System.out.println("Removed thread 1" + userIdThrealLocal.get());
	});
	
	t1.start();
	t2.start();
	
	
	InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
	
	Thread t3 = new Thread(() -> {
		System.out.println("Thread 3 started for");
		inheritableThreadLocal.set("Instagram");
		
		Thread t4 = new Thread(() -> {
			
			System.out.println(inheritableThreadLocal.get());
		});
		
		t4.start();
	});
	
	t3.start();
}
}
