package com.example.DFS;

import java.security.interfaces.EdECKey;
import java.util.ArrayList;
import java.util.List;

public class CycleDetection8 {
	public boolean validTree(int n, int[][] edges) {
       
		if(edges.length != n-1) {
			return false;
		}
		
		List<Integer> [] adj = new List[n];
		
//		for(int [] edge : edges) {
//			
//			int num1 = edge[0];
//			int num2 = edge[1];
//			
//			if(adj[num1] == null) {
//				adj[num1] = new ArrayList<>();
//			}
//			
//			if(adj[num2] == null) {
//				adj[num2] = new ArrayList<>();
//			}
//			
//			adj[num1].add(num2);
//			adj[num2].add(num1);	
//		}
		
//		Yes, the code as originally written could result in a NullPointerException at this line:
//
//			java
//			Copy code
//			adj[num1].add(num2);
//			adj[num2].add(num1);
//			Why?
//			This happens because the adjacency list adj is declared as:
//
//			java
//			Copy code
//			List<Integer>[] adj = new List[n];
//			But it is not initialized for every node. When you declare an array of List<Integer>, its elements are initially null. Unless explicitly initialized, attempting to perform operations like add on null will throw a NullPointerException.
//

		
		for (int i = 0; i < n; i++) {
		    adj[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
		    int num1 = edge[0];
		    int num2 = edge[1];

		    adj[num1].add(num2);
		    adj[num2].add(num1);
		}
	        
		boolean [] vis = new boolean[n];
		if(hasCycle(adj, vis, 0, -1)) {
			return false;
		}
		
		for(boolean visited : vis) {
			if(!visited) {
				return false;
			}
		}
		
		return true;
    }

	private boolean hasCycle(List<Integer>[] adj, boolean[] vis, int current, int parent) {
		vis[current]= true;
		
		for(int neigh : adj[current]) {
			if(!vis[neigh]) {
				if(hasCycle(adj, vis, neigh, current)) {
				return true;	
				}
			}
			else if (neigh != parent) {
				return true;
			}
		}
		
		return false;
	}
}
