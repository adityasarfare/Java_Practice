package com.example.DFS;

import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph9 {

	public int countComponents(int n, int[][] edges) {

		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0; i< n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		
		boolean[] vis = new boolean[4];
		int res=0;
		for(int i=0; i<n; i++) {
			if(!vis[i])
			dfs(adj, vis, i);
			res++;
		}
		
		return res;
    }

	private void dfs(List<List<Integer>> adj, boolean[] vis, int current) {
         vis[current] = true;
		
         for(int nei : adj.get(current)) {
        	 if(!vis[nei]) {
        		 dfs(adj, vis, nei);
        	 }
         }
	}
	
}
