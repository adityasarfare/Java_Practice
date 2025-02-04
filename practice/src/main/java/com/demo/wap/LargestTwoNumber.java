package com.demo.wap;

public class LargestTwoNumber {

	
	public static void main(String[] args) {
		int a =20;
		int b =30;
		
		if(a>b) {
			System.out.println("a is greater");
		}
		else {
			System.out.println("b is greater");
		}
		
		
		int c =20;
		int d =30;
		int e =50;
		
		if(c>d) {
			
			if(c>e) {
			System.out.println("c is greater");
			}
			else {
				System.out.println("e is greater");
			}	
		}
		else if (d>e) {
			System.out.println("d is greater");
		}
		else {
			System.out.println("e is greater");
		}
		 
	}
}
