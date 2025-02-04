package com.demo.wap;

public class SwapTwoNumber {

	
	public static void main(String[] args) {
//		int a = 30;
//		int b = 56;
//		
//		int t;
//		
//		t=a;
//		a=b;
//		b=t;
//		
//		System.out.println(a);
//		System.out.println(b);
		
		int a = 30;
		int b = 10;
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println(a);
		System.out.println(b);
	}
}
