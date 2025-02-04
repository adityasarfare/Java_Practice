package com.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundExample1 {

	
	public static <T> void addElementLowerBound(List<? super T> list, T element) {
		
		list.add(element);
		System.out.println(element);
	}
	
	public static void main(String args[]) {
		
		List<Object> arrayList = new ArrayList<>();
		
		
		addElementLowerBound(arrayList, 42);
		addElementLowerBound(arrayList, "Aditya");
	}

}
