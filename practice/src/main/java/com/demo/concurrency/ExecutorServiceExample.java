package com.demo.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
		//Single Thread Executor
		ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();
		System.out.println("Single Thread Executor");
		for(int i=1; i<=5; i++) {
			final int  taskId=i;
			singleThreadExecutorService.execute(() -> {
				System.out.println("Single Thread Task " + taskId + "executed by Thread: " 
						+ Thread.currentThread().getName());
			});
		}
	
		singleThreadExecutorService.shutdown();
		
		//Fixed thread pool
				ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
				System.out.println("\nFixed Thread Executor");
				for(int i=1; i<=5; i++) {
					final int  taskId=i;
					
					fixedThreadPool.execute(() -> {
						System.out.println("Fixed Thread Task " + taskId + "executed by Thread: " 
								+ Thread.currentThread().getName());
					});
				}
				fixedThreadPool.shutdown();
				
		//Cached thread pool
				ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
				System.out.println("\nCached Thread Executor");
				for(int i=1; i<=5; i++) {
					final int  taskId=i;
					
					cachedThreadPool.execute(() -> {
						System.out.println("Cached Thread Task " + taskId + "executed by Thread: " 
								+ Thread.currentThread().getName());
					});
				}
				cachedThreadPool.shutdown();
				
		//Schedule thread pool
				ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(3);
				System.out.println("\nSchedule Thread Executor");
				for(int i=1; i<=5; i++) {
					final int  taskId=i;
					
					scheduleThreadPool.schedule(() -> {
						System.out.println("Schedule Thread Task " + taskId + "executed by Thread: " 
								+ Thread.currentThread().getName());
					}, 3, TimeUnit.SECONDS);
				}
				
				scheduleThreadPool.shutdown();
				
				
				
	}
}
