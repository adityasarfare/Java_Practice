package com.demo.exception;

public class TryAndCatch {

	
	public static void main(String args[]) {
	
	int a = 4;
	int c= 0;
    
	try {
	int d =	a/c;
	
	
    System.out.println(a/c);
   
	}
	catch(Exception e) {
		System.out.println(e);
		System.out.println("hii");
	}
	finally {
		System.exit(a);
		System.out.println("Close");
	}
	
	}
}
