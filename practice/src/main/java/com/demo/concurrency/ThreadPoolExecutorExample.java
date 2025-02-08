package com.demo.concurrency;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

	public static void main(String[] args) {
		
		ExecutorService threadPoolExample = new ThreadPoolExecutor(
				1, 5, 0, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<>(2));
		
		for(int i=1; i<=5; i++) {
			final int taskId=i;
			threadPoolExample.execute(() ->{
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread Pool Executor" +
				" Thread Task " + taskId +
				"executed by thread: " +
				Thread.currentThread().getName());
			});
		}
		
		threadPoolExample.shutdown();
	}
}
