package com.demo.Multithreading;

public class ThreadInterruption extends Thread{

	
		
		@Override
		public void run() {
//			System.out.println(Thread.interrupted());
			
			for(int i=1; i<=5; i++) {
				try {
//					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			System.out.println("Inside Thread");
		}
		

		public static void main(String args[]) {
			ThreadInterruption t1 = new ThreadInterruption();
			t1.start();
			
			try {
			Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
		
			Thread.currentThread().interrupt();
			System.out.println("hello");
		}
	}

