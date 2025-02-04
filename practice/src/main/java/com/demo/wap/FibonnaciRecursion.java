package com.demo.wap;

public class FibonnaciRecursion {
    
	
	static int a=0, b=1,c;
	
	public static void main(String[] args) {
		
		
		 FibonnaciRecursion fr = new FibonnaciRecursion();
		 fr.recursion(10);
	}
	
	void recursion( int i) {
		if(i>=1) {
			c= a+b;
			System.out.println(c);
			a=b;
			b=c;
			recursion(i-1);
		}
	}
}

