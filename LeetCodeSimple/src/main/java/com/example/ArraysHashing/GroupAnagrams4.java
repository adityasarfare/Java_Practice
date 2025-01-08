package com.example.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams4 {

	public List<List<String>> groupAnagrams(String[] strs) {
		
		HashMap<String, List<String>> hm = new HashMap<>();
		
		for(String s : strs) {
			
			int [] count = new int[26];
			
			for(char c : s.toCharArray()) {
				count[c-'a']++;
			}
			
			String key = Arrays.toString(count);
			if(!hm.containsKey(key)) {
				hm.put(key, new ArrayList<>());
			}
			
			hm.get(key).add(s);
		}
		
		return new ArrayList<>(hm.values());
	}
}
