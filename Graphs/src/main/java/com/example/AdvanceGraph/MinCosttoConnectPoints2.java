package com.example.AdvanceGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinCosttoConnectPoints2 {

	//1584 leet code important 
 public int minCostConnectPoints(int[][] points) {
 
	 int n= points.length;
	 int min_cost =0;
	 boolean [] vis = new boolean[n];
	 Map<Integer, Integer> cache = new HashMap<>();
	 PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
	 pq.offer(new int[]{0,0});
	 
	 
	 while(!pq.isEmpty()) {
		 int cell[] = pq.poll();
		 int cost = cell[0];
		 int u = cell[1];
		 
		 if(vis[u]) {
			 continue;
		 }
		 
		 vis[u] = true;
		 min_cost +=cost;
		 
		 for(int v=0; v<n; v++) {
			 int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
			 if(dist < cache.getOrDefault(v, Integer.MAX_VALUE)) {
				 cache.put(v, dist);
				 pq.offer(new int[] {dist, v});
			 }
		 }
	 }
	 return min_cost;
    }
}
