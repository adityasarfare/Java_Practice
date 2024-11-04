package com.demo;

public class NumberOfSteps {

	
	public static void main(String[] args) {
		System.out.println(numberOfSteps(41));
	}
	
	static int numberOfSteps(int n) {
		return helper(n, 0);
	}

	private static int helper(int n, int steps) {
		if(n ==0) {
			return steps;
		}
		
		if(n%2==0) {
			return helper(n/2, steps+1);
		}
		return helper(n-1, steps+1);
	}
}
