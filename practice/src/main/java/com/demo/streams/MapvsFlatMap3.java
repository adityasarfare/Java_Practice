package com.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap3 {

	public static void main(String[] args) {
		
		// Map: It only performs trasforming
		List<String> list = Arrays.asList("hello", "world");
		
		List<String> mapResult = list.stream()
				                          .map(s-> s.toUpperCase())
				                          .collect(Collectors.toList());
		System.out.println(mapResult);
		
		// FlatMap: It performs transforming as well as flatenning
		List<List<Integer>> list1 = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(4,5,6),
				Arrays.asList(7,8,9));
		
		List<Integer> flatMapResult = list1.stream()
				                          .flatMap(List::stream)
				                          .map(x -> x*2)
				                          .collect(Collectors.toList());
		System.out.println(flatMapResult);
		
		List<List<String>> list3 = Arrays.asList(
				Arrays.asList("hello", "world"),
				Arrays.asList("aditya", "sarfare"));
		
		List<String> result = list3.stream()
				                   .flatMap(List::stream)
				                   .map(x-> x.toUpperCase())
				                   .collect(Collectors.toList());
		System.out.println(result);
	}
}
