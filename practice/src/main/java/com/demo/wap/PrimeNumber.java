package com.demo.wap;

public class PrimeNumber {

	
	public static void main(String[] args) {
		
		int no =14;
		
		for(int i = 2; i<no; i++) {
			
			if(no%i ==0) {
				
				System.out.println("Is not aprime Number");
				break;
			}
			else {
				System.out.println("Is a prime number");
				break;
			}
			
		}
	}
}
