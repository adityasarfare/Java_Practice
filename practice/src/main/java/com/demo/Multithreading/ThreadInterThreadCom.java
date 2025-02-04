package com.demo.Multithreading;

public class ThreadInterThreadCom extends Thread{

	int total =0;
	@Override
	public void run() {
		 synchronized (this) {
			
			 for(int i=0; i<=5; i++) {
					total = total + 100;
				}
			 this.notify();
		}	
	}
	
	public static void main(String args[]) throws InterruptedException {
		
		ThreadInterThreadCom com = new ThreadInterThreadCom();
		com.start();
		
		synchronized (com) {
			com.wait();
		}
		
		System.out.println("Total money" + com.total);
	}

	
	
}
