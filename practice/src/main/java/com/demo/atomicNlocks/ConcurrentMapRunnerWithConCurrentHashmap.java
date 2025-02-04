package com.demo.atomicNlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMapRunnerWithConCurrentHashmap {

	public static void main(String args[]) {
		ConcurrentHashMap<Character, LongAdder> occurances = new ConcurrentHashMap<>();
		
		String str = "ABCD ABCD ABCD";
		
		for (Character charr : str.toCharArray()) {
			
			occurances.computeIfAbsent(charr, ch -> new LongAdder()).increment(); 
//			LongAdder longAdder =  occurances.get(charr);
//			 if (longAdder == null) {
//				 longAdder = new LongAdder();
//			 }
//				 longAdder.increment();
//				 occurances.put(charr, longAdder);
//			 }
		
		}
		System.out.println(occurances);
	}

	
}
