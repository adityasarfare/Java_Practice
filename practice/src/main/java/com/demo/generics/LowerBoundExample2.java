package com.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundExample2 {

	public static<T> void printFirstElement(List<? super Integer> list) {
		if(!list.isEmpty()) {
			Object firstElement = list.get(0);
			System.out.println("First Element: " + firstElement);
		}
			else {
				System.out.println("List is empty");
			}
		}
	
	
	public static void main(String args[]) {
		List<Object> arrayList = new ArrayList<>();
		arrayList.add("0");
		
		printFirstElement(arrayList);
	}

	}

