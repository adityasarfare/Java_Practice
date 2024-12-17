package com.example.AdvanceGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwiminRisingWater4 {
	 public int swimInWater(int[][] grid) {
	        int N = grid.length;
	        
	        boolean[][] vis = new boolean[N][N];
	        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
	        minHeap.offer(new int[] {grid[0][0], 0, 0});
	        vis[0][0]= true;
	        
	        int time;
	        
	        int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	        
	        while(!minHeap.isEmpty()) {
	        	int cell[] = minHeap.poll();
	        	time = cell[0];
	        	int r = cell[1];
	        	int c = cell[2];
	        	
	        	if(r ==N && c==N) {
	        		return  time;
	        	}
	        	
	        	for(int dir[] : directions) {
	        		int neir = r + dir[0];
	        		int neic = c + dir[1];
	        		
	        		if(neir>=0 && neic>=0 &&
	        		   neir < N && neic < N &&
	        		   !vis[neir][neic]) {
	        			vis[neir][neic] = true;
	        			minHeap.offer(new int[] {Math.max(time, grid[neir][neic])});
	        			
	        		}
	        	}
	        }
	        
	        return N*N;
	    }
}
