package com.demo.wap;

public class FactorialRecursion {
   
	int fact = 1;
	public static void main(String[] args) {
		
		FactorialRecursion fr = new FactorialRecursion();
		
		System.out.println(fr.callFact(10));
		
	}
	
	
	int callFact( int no) {
		
		if(no>1) {
			fact = fact*no;
			this.callFact(no-1);
		}
		
		
		return fact;
	}
}
