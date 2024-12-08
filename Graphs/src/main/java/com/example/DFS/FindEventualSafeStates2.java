package com.example.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


//802
public class FindEventualSafeStates2 {
	
	 public List<Integer> eventualSafeNodes(int[][] graph) {
	   
		 Map<Integer, Boolean> memoizationMap = new HashMap<>();
		 
		 for(int i=0; i< graph.length; i++) {
			 if(graph[i].length == 0) {
				 memoizationMap.put(i, true);
			 }
		 }
		 
		 for(int i=0; i< graph.length; i++) {
			 boolean result = dfs(i, graph, new HashSet<Integer>(), memoizationMap );
			 memoizationMap.put(i, result);
		 }
		 
		 List<Integer> ans = new ArrayList<>();
		 for(int i=0; i< graph.length; i++) {
			 if(memoizationMap.get(i)) {
				 ans.add(i);
			 }
		 }
		 return ans;
	     }

	private boolean dfs(int curr, int[][] graph, HashSet<Integer> visited, Map<Integer, Boolean> memoizationMap) {

		if(memoizationMap.containsKey(curr)) {
			return memoizationMap.get(curr);
		}
		
		//if node is already visited, it mean multiple possible paths in that node, so will return false;
		if(visited.contains(curr)) {
			return false;
		}
		
		visited.add(curr);
		for(int i : graph[curr]) {
			boolean flag = dfs(i, graph, visited, memoizationMap);
			
			if(flag) {
				memoizationMap.put(i, true);
			}else {
				return false;
			}
		}
		
		//backtrack
		visited.remove(curr);
		return true;
	}
}
