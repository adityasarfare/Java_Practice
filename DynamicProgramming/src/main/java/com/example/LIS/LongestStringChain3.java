package com.example.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain3 {

	
	private static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

	public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        System.out.println("The length of the longest string chain is: " + longestStrChain(words));
    }

	private static int longestStrChain(String[] words) {
		
		int n = words.length;
		
		List<String> list = new ArrayList<>();
		
		for(String s : words) {
			list.add(s);
		}
		
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
	
		int max =1;
		list.sort(comp);
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(compare(list.get(i), list.get(j)) && 1+dp[j] > dp[i]){
					dp[i] = 1+ dp[j];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	private static boolean compare(String s1, String s2) {
	if(s1.length() != s2.length()+1) {
		return false;
	}
	
	int first =0;
	int second =0;
	
	while(first < s1.length()) {
		if(second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
			
			first ++;
			second ++;
		}else {
			first ++;
		}
		
	}
	
		return s1.length() == first && s2.length() == second;
	}
}
