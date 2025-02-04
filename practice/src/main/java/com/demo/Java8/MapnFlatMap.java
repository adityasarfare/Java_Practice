package com.demo.Java8;

import java.util.List;
import java.util.stream.Collectors;

public class MapnFlatMap {

	
	public static void main(String args[]) {
		
		List<Customer> list = EkartForStreampAPI.getall();
		
		List<List<String>> name = list.stream().map(x -> x.getPhone()).collect(Collectors.toList());
		System.out.println(name);
		
		List<String> number = list.stream().flatMap(x -> x.getPhone().stream()).collect(Collectors.toList());
		System.out.println(number);
	}
																
}
