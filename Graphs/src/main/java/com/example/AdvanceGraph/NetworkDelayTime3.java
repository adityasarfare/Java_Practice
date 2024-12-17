package com.example.AdvanceGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime3 {

public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edge = new HashMap<>();
        
//        for(int time[] : times) {
//        	edge.putIfAbsent(time[0], new ArrayList<>());
//        }
//        
//        for(int time[] : times) {
//        	edge.get(time[0]).add(new int[] {time[1], time[2]});
//        }
        
        
        for(int[] time : times) {
        	edge.computeIfAbsent(time[0], key-> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        		Comparator.comparingInt(a-> a[0]));
        
        pq.add(new int[] {0, k});
        boolean [] vis = new boolean[n];
        int finalTime = 0;
        while(!pq.isEmpty()) {
        	int cell[] = pq.poll();
        	int distu= cell[0];
        	int u = cell[1];
        	
        	if(vis[u]) {
        		continue;
        	}
        	finalTime = distu;
        	
        	if(edge.containsKey(u)) {
        		for(int[] next : edge.get(u)) {
        			int distv= next[0];
        			int v = next[0];
        			if(!vis[v]) {
        			pq.offer(new int[] {distu+ distv , v});	
        			}
        		}
        	}
        	
        }
        
        for(int i=0; i< n; i++) {
        	if(vis[i]) {
        		return finalTime;
        	}
       }
        return -1;
    }
	
}
