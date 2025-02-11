package com.demo.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStream4 {

	public static void main(String[] args) {
		
//		int[] intArray = new int[100000];
//		Arrays.fill(intArray, 2);
//		
//		long startTime = System.currentTimeMillis();
//		
//		long sum = Arrays.stream(intArray)
//				         .mapToLong(x -> x*x)
//				         .sum();
//		
//		long endTime = System.currentTimeMillis();
//		
//		System.out.println(endTime - startTime);
		
		
		// Using Parallel
		
		int[] intArray1 = new int[100000];
		Arrays.fill(intArray1, 2);
		long startTimep = System.currentTimeMillis();
		long sump = Arrays.stream(intArray1)
				.parallel()
		         .mapToLong(x -> x*x)
		         .sum();

      long endTimep = System.currentTimeMillis();

      System.out.println(endTimep - startTimep);
	}
}
