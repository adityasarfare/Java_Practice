package com.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TraditionalvsStreamExample2 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		//Traditional Approach to find even numbers sum
		int tradtionalSum=0;
		for(int no : list) {
			if(no%2==0) {
				int sum = no *no;
				tradtionalSum +=sum;
			}
		}
		System.out.println(tradtionalSum);
		
		//Stream Approach to find square of even numbers sum;
		int streamSum = list.stream().filter(x -> x%2 ==0)
				                     .mapToInt(no -> no * no)
				                     .sum();
		
		System.out.println(streamSum);
	}
}
