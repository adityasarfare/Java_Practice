package com.demo.recursion;

public class NumberOfZeros {

	
	public static void main(String[] args) {
		System.out.println(numberOfSteps(4010002));
	}
	
	static int numberOfSteps(int n) {
		return helper(n, 0);
	}

	private static int helper(int n, int steps) {
		if(n ==0) {
			return steps;
		}
		
		int rem = n%10;
		if(rem ==0) {
			return helper(n/10, steps+1);
		}
		return helper(n/10, steps);
	}
}
