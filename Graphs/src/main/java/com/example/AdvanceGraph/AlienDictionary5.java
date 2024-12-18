package com.example.AdvanceGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
			for(char c : adj.keySet()) {
				if(dfs(c)) {
					return "";
				}
			}	
		}
		
		Collections.reverse(res);
		StringBuilder sb = new StringBuilder();
		for(char ch : res) {
			sb.append(ch);
		}
		return sb.toString(); 	
	}

	private boolean dfs(char c) {
		if(vis.containsKey(c)) {
			return vis.get(c);
		}
		
		vis.put(c, true);
		for(char ch: adj.get(c)) {
			if(dfs(ch)) {
				return true;
			}
		}
		
		vis.put(c, false);
		res.add(c);
		return false;
	}
}
