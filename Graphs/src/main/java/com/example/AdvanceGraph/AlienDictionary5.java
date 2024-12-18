package com.example.AdvanceGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
// Topolocal Sort
public class AlienDictionary5 {
	Map<Character, Set<Character>> adj;
	Map<Character, Boolean> vis;
	List<Character> res;
	
//	adj: Adjacency list to represent a Directed Acyclic Graph (DAG) of character dependencies.
//	vis: Keeps track of visited nodes during the Depth First Search (DFS). It maps:
//	true: A character is currently being visited (part of the DFS stack).
//	false: A character has been fully processed.
//	res: A list to store the topological order of characters.


	public String foreignDictionary(String[] words) {
		
		if (words == null || words.length == 0) return "";
		if (words.length == 1) return words[0];
		
//		If the input is empty (words == null || words.length == 0), return an empty string as there is no order.
//		If there is only one word, return that word as there's no need to determine any character order.

		adj = new HashMap<>();
		for (String word : words) {
			for (char c : word.toCharArray()) {
				adj.putIfAbsent(c, new HashSet<>());
			}
		}
//		Each character from all the words is added to the adjacency list with an empty set of neighbors initially. 
//		This ensures that even isolated characters (with no dependencies) are included.

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
			
//	Compares adjacent words (w1 and w2) to determine the order of characters.
//	Invalid Case Check:
//	If w1 is longer than w2 but w1 starts with w2, the dictionary order is invalid (e.g., ["abc", "ab"]), so the function returns "".
//	Finding First Mismatch:
//	For each pair of words, it identifies the first differing characters (w1.charAt(j) and w2.charAt(j)).
//	Adds an edge from w1.charAt(j) to w2.charAt(j) in the adjacency list, indicating that w1.charAt(j) should come before w2.charAt(j) in the order.
//	Stops comparing further characters after finding the first mismatch.
//			
			vis = new HashMap<>();
			res = new ArrayList<>();
			for(char c : adj.keySet()) {
				if(dfs(c)) {
					return "";
				}
			}	
		}
//		Iterates through all characters in the adjacency list and performs a DFS for topological sorting.
//		If a cycle is detected during DFS, it returns "" because a valid order is not possible.
		
		
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


//vis Map:
//This map tracks the visiting state of each character:
//true: The character is currently being visited (part of the DFS stack).
//false: The character has been fully processed and added to the result.
//Logic:
//If the character c is already in the vis map:
//If vis.get(c) is true, it means the character is already in the current DFS stack or the current path, indicating a cycle. So, true is returned.
//If vis.get(c) is false, the character is fully processed, and there’s no need to process it again.



//Example Execution
//Let’s step through a simple graph for clarity.
//
//Graph:
//css
//Copy code
//a → b → c
//Steps:
//Start DFS from a:
//
//vis = {a: true}.
//Traverse neighbor b.
//Start DFS from b:
//
//vis = {a: true, b: true}.
//Traverse neighbor c.
//Start DFS from c:
//
//vis = {a: true, b: true, c: true}.
//c has no neighbors, so:
//vis.put(c, false).
//res = [c].
//Return false.
//Back to b:
//
//Mark b as processed: vis.put(b, false).
//Add b to res: res = [c, b].
//Return false.
//Back to a:
//
//Mark a as processed: vis.put(a, false).
//Add a to res: res = [c, b, a].
//Return false.
//Reverse res to get the correct order: [a, b, c].
//
//Cycle Example
//Graph:
//css
//Copy code
//a → b → c → a
//Steps:
//Start DFS from a:
//
//vis = {a: true}.
//Traverse neighbor b.
//Start DFS from b:
//
//vis = {a: true, b: true}.
//Traverse neighbor c.
//Start DFS from c:
//
//vis = {a: true, b: true, c: true}.
//Traverse neighbor a.
//Detect Cycle:
//
//a is already marked true in vis.
//Return true up the stack, indicating a cycle.
//The algorithm exits with a result of "" (invalid order).
//
//
//
//
