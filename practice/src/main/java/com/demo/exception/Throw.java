package com.demo.exception;

import java.util.Scanner;

public class Throw {
  
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age <18) {
			throw new YoungerAgeException("Your age is less");
		}
		else {
			System.out.println("you can vote");
		}
	}
	
	
//  Example of rethrow also	
//	class ThrowExcep {
//	    static void fun()
//	    {
//	        try {
//	            throw new NullPointerException("demo");
//	        }
//	        catch (NullPointerException e) {
//	            System.out.println("Caught inside fun().");
//	            throw e; // rethrowing the exception
//	        }
//	    }
//	 
//	    public static void main(String args[])
//	    {
//	        try {
//	            fun();
//	        }
//	        catch (NullPointerException e) {
//	            System.out.println("Caught in main.");
//	        }
//	    }
//	}
//	
//	
}

class YoungerAgeException extends RuntimeException{
	 public YoungerAgeException(String msg) {
		super(msg);
	}
	  
}


