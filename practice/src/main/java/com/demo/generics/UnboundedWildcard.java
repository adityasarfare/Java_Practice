package com.demo.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcard {

	
//	In Java, the wildcard <?> is known as an unbounded wildcard. It represents an unknown 
//	type, and it is used in generic types to indicate that a parameter can be of any type. 
//	The unbounded wildcard is used when you want to work with generic types in a way that 
//	is independent of the actual type parameter.

	public static void processedList(List<?> list) {
     
		for (Object element : list) {
			System.out.println(element);
		}
		
	List<? super Integer> l = new ArrayList<>();
	l.add(1);
	
	System.out.println(l);
	}
	
	public static void main(String[] args) {
		processedList(List.of(2,4,6,8));
	}
	
	
//	In this method, the List<?> parameter allows you to pass a list of any type, 
//	and you can iterate over the elements without specifying the exact type. 
//	It provides flexibility when you want to work with generic types in a more generic 
//	manner.
//
//	It's important to note that when you use an unbounded wildcard, you can't add elements 
//	to the collection. You can only read elements from it. If you need to both read and 
//	write elements, you might want to use a wildcard with an 
//	upper bound (e.g., <? extends SomeType>) or a lower bound (e.g., <? super SomeType>).

}
