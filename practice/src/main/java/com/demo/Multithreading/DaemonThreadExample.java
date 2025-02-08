package com.demo.Multithreading;

public class DaemonThreadExample {

	public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Marking thread as daemon
        daemonThread.start();

        try { 
        	Thread.sleep(5000); 
        } catch (Exception e) {
        	
        }

        System.out.println("Main thread finished execution.");
    }
}
