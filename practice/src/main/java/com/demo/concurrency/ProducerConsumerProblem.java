package com.demo.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ProducerBlockingQueue implements Runnable{
	
	BlockingQueue<Integer> queue;

	public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
		for(int i=1; i<=100; i++) 
		{
			Thread.sleep(1000);
			queue.put(i);
		}
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
	
}

class ConsumerBlockingQueue implements Runnable{

	BlockingQueue< Integer> queue;
	
	
	public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {

		try {
			
			while(true) {
				Integer item = queue.take();
				System.out.println(item);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
}

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		
		ProducerBlockingQueue producerBlockingQueue = new ProducerBlockingQueue(queue);
		ConsumerBlockingQueue consumerBlockingQueue = new ConsumerBlockingQueue(queue);
		
		Thread t1 = new Thread(producerBlockingQueue);
		Thread t2 = new Thread(consumerBlockingQueue);
		
		t1.start();
		t2.start();
	}
}
