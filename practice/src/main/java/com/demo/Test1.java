package com.demo;

import java.util.HashMap;

//String input1 = "abccde", o/p : 3 (bcoz "abc" or "cde")


//String input2 = "abccdefghkd", o/p : 7 (bcoz "cdefghk")

public class Test1 {

	
	public static String longest(String s) {
		
		int maxlength =0;
		int start=0; // Start of the index
		int left =0;
		
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		// Variables to track long string
		
		int longestStart =0;
		int longestEnd =0;
		
		for(int right =0; right< s.length(); right++) {
			char currentChar = s.charAt(right);
		
		
		if((map.containsKey(currentChar) && map.get(currentChar) >= left)){
			left =  map.get(currentChar) +1;
			// Move the left pointer;
		}
		 map.put(currentChar, right);
		 
		 if(right -left +1 > maxlength) {
			 maxlength = right -left +1;
			 longestStart = left;
			 longestEnd = right;
		 }
		}
		
		String longestSubString = s.substring(longestStart, longestEnd+1);
		
		
		return longestSubString;
	}
	
	public static void main(String[] args) {
		String s = "abccde";
		
		String res = longest(s);
		System.out.println(res);
	}
}
