package com.example.AdvanceGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary5 {
	Map<Character, Set<Character>> adj;
	Map<Character, Boolean> vis;
	List<Character> res;

	public String foreignDictionary(String[] words) {
		adj = new HashMap<>();
		for (String word : words) {
			for (char c : word.toCharArray()) {
				adj.putIfAbsent(c, new HashSet<>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];
			int minLen = Math.min(w1.length(), w2.length());
			if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
				return "";
			}
			
			for(int j=0; j<minLen; j++) {
				if(w1.charAt(i) != w2.charAt(i)) {
					adj.get(w1.charAt(i)).add(w2.charAt(i));
					break;
				}
			}
			
			vis = new HashMap<>();
			res = new ArrayList<>();
			
			
		}
		
	return ""; 	
	}
}
