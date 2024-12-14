package com.example.DFS;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection10 {

	public int[] findRedundantConnection(int[][] edges) {
		
		int n= edges.length;
		
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0; i<=n; i++) { // since in this we are starting from 1 and not zero if we iterate from 0 till < n, we will get array list for 0,1,2,3 and not for 4
			// so we made i<=n.
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			
			adj.get(u).add(v);
			adj.get(v).add(u);
			
			boolean[] vis = new boolean[n+1];
			if(dfs(u, -1, adj, vis)) {
				return edge;
			}
		}
		
		return new int[] {};
	}

	private boolean dfs(int current, int parent, List<List<Integer>> adj, boolean[] vis) {
		
		if(vis[current]) {
			return true;
		}
		
		vis[current] = true;
		for(int nei : adj.get(current)) {
			if(nei == parent) {
				continue;
			}
			if(dfs(nei, current, adj, vis)) {
				return true;
			}	
		}
		return false;
	}
}
