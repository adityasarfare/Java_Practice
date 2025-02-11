package com.demo.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Convert_Array_To_Streams1 {

	public static void main(String[] args) {
		
		//Primitive Type Array
		int[] arr = {1,2,3,4};
		IntStream streamPrimitive = Arrays.stream(arr);
		streamPrimitive.forEach(System.out::println);
		
//		Arrays.stream(arr).forEach(System.out::println);
		
		//Object type wrapper class
		Integer[] arr1 = {5,6,7,8};
		Stream<Integer> streamObject =  Stream.of(arr1);
		streamObject.forEach(System.out::println);
	}
}
