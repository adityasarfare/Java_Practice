package com.demo.Miscellanious;

public class VolatileExample {


	    private volatile boolean flag = false;

	    public void setFlag() {
	        flag = true;
	    }

	    public boolean checkFlag() {
	        return flag;
	    }

	    public static void main(String[] args) {
	        VolatileExample sharedResource = new VolatileExample();

	        // Thread 1: Sets the flag to true
	        new Thread(() -> {
	            System.out.println("Thread 1 is setting the flag.");
	            sharedResource.setFlag();
	        }).start();

	        // Thread 2: Reads the flag value
	        new Thread(() -> {
	            while (!sharedResource.checkFlag()) {
	                // Busy-waiting until the flag becomes true
	            }
	            System.out.println("Thread 2 detected the flag is true.");
	        }).start();
	    }
	}


