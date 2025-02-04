package com.demo.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardUpperBound {

//	Wildcard Upper Bound (<? extends T>):
//		
//	The <? extends T> wildcard is an upper-bounded wildcard, where T is a specific type.
//	It allows any type that is a subtype of T or T itself.
//	This is useful when you want to accept a collection of elements of a certain type or any of its subtypes.
//	
	
//	When to Use Upper:
//	Use an upper-bounded wildcard (<? extends T>) when you only need to read from a collection.

	
	public static <T> void processedListUpperBound(List<? extends T> list) {
	     
		for (T element : list) {
			System.out.println(element);
		}
	}
	
	public static void main(String args[]) {
	List<? extends Number> upperBoundArrayList = new ArrayList<>();
	
	upperBoundArrayList = Arrays.asList(1,2,3,4,4,8.9,0.6); //Ok, reading is allowed.
	}

}
