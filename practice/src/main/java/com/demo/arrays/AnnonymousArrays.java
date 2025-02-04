package com.demo.arrays;

import java.util.Arrays;

public class AnnonymousArrays {	
	
	
	public static void main(String args[]) {
		
		AnnonymousArrays.show(new int []{1,3,4,5}); // new word is mandatory
	}
	
	
	public static void show(int [] array) {
		
		
	Arrays.stream(array).forEach(x -> System.out.println(x));
	
	for (int i : array) {
		System.out.println(i);
	}
	}

}
