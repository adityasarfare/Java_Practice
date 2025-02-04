package com.demo.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableandCallableExample {
	 public static int sumRun =0;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int number = 100;
		
		Callable<Integer> sumTask = () -> {
			int sum =0;
			
			for(int i=1; i<=number ; i++) {
				sum+=i;
			}
			
			return sum;
		};
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<Integer> fut = executor.submit(sumTask);
		
		int result = fut.get();
		
		System.out.println(result);
		
		executor.shutdown();
		
		ExecutorService executorR = Executors.newSingleThreadExecutor();
		executorR.execute(()->{
             
			
			for(int i=1; i<=number ; i++) {
				sumRun+=i;
			}
			System.out.println(sumRun);
		});
		
		
		
	}
}
