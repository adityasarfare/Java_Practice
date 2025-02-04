package com.demo.atomicNlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMapRunnerWithHashmap {

	
	public static void main(String args[]) {
		
//		Map<Character, Integer> occurances = new HashMap<>();
//		
//		String str = "ABCD ABCD ABCD";
//		
//		for (Character charr : str.toCharArray()) {
//			Integer count =  occurances.get(charr);
//			 if (count == null) {
//				 occurances.put(charr, 1);
//			 }
//				 else {
//					 occurances.put(charr, count + 1);
//				 }
//			 }
//		System.out.println(occurances);
//		}
		
	//================================================================
	
	//Using Long Adder
		
	Map<Character, LongAdder> occurances = new HashMap<>();
	
	String str = "ABCD ABCD ABCD";
	
	for (Character charr : str.toCharArray()) {
		LongAdder longAdder =  occurances.get(charr);
		 if (longAdder == null) {
			 longAdder = new LongAdder();
		 }
			 longAdder.increment();
			 occurances.put(charr, longAdder);
		 }
	System.out.println(occurances);
	}
	}


