package com.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardLowerBound {

//	Wildcard Lower Bound (<? super T>):
//		
//	The <? super T> wildcard is a lower-bounded wildcard, where T is a specific type.
//	It allows any type that is a supertype of T or T itself.
//	This is useful when you want to accept a collection of elements of a certain type or any of its supertypes.
	
//	When to Lower Bounds:
//	Use a lower-bounded wildcard (<? super T>) when you need to write to a collection.

	
	public static <T> void addElementsLowerBound(List<? super T> list, T element) {
	
		list.add(element);
		
	}
	
	public static void main(String args[]) {
		
		List<? super Integer> lowerBoundArraylist = new ArrayList<>();
		lowerBoundArraylist.add(4); // Ok. writing is allowed
		
		
	}

	
}
