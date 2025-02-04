package com.demo.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	

	public static void main(String args[]) {
		
		Function<Integer, Integer> f = s -> s*s;
		
		System.out.println(f.apply(5));
//==================================================	
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Function<Integer, Integer> fun = s -> s*s;
		
	FunctionExample.applyandprint(numbers, fun);
	}
	
	public static void applyandprint(List<Integer> numbers, Function<Integer, Integer> calc) {
		
		for (Integer number : numbers) {
			
			System.out.println(calc.apply(number));
		}
	}
	
}