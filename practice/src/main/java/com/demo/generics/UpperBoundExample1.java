package com.demo.generics;

import java.util.Arrays;
import java.util.List;

public class UpperBoundExample1 {

	
	public static <T> void processUpperBound(List<? extends T> list) {
		    
		for( T element : list) {
			System.out.println(element);
		}
	}
	
	
	public static void main(String args[]) {
		
		List<Integer> integerList = Arrays.asList(1,2,3,4);
		List<Double> doubleList  = Arrays.asList(1.0, 2.0, 3.0, 4.0); 
		
		
		
		processUpperBound(integerList);
		processUpperBound(doubleList);
	}

}
