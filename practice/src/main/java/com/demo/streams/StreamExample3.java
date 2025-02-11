package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample3 {

	public static void main(String[] args) {
		
		// Sum: Find the sum of even number
		List<Integer> list = Arrays.asList(1,2,3,3,4,5,5,6,7,8,8,9,10);
		
		List<Integer> listofNo = list.stream()
				      .filter(x -> x%2==0)
				      .distinct()
				      .map(no-> no*no)
//				      .peek(System.out::println)
				      .collect(Collectors.toList());
		
		System.out.println(listofNo);
		
		// Count : Find the no greater than 5
		long greaterThan5 = list.stream()
				               .filter(x-> x>5)
				               .distinct()
				               .count();
		System.out.println(greaterThan5);
		
		int sum = list.stream()
				      .mapToInt(Integer::intValue)
				      .sum();
		System.out.println(sum);
	}
}
