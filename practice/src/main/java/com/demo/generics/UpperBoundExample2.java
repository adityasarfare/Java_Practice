package com.demo.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundExample2 {

	
	public static<T extends Number> double sumList(List<T> list) {
		
		double sum =0;
		
		for(T element : list) {
			sum = element.doubleValue();
//			System.out.println(sum);
//			return sum;
//			if(element.equals(1) && element.equals(1.0)) {
//				break;
//			}
//			System.out.println(element);
		}
	
		return sum;
	}
	
	
	public static void main(String args[]) {
		List<Integer> arrayList = Arrays.asList(1,2,3,4);
		List<Double>  doubleList = Arrays.asList(1.0,2.0,3.0,4.0);
		
		System.out.println(sumList(arrayList));
		System.out.println(sumList(doubleList));
		
		
	}

}
