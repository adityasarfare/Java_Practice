package com.example.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandsAndTreasure2 {

	public void islandsAndTreasure(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(grid[i][j] == 0) {
        		q.add(new int[] {i,j});
        		}
        	}
        }
        //   if (q.size() == 0) return;
        int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!q.isEmpty()) {
        int size = q.size();
        	
        	for(int i=0; i< size; i++) {
        		int[] cell = q.poll();
        		int row= cell[0];
        		int col= cell[1];
        		
        	
        		for(int [] dir : directions) {
        			int nr = row + dir[0];
        			int nc = col + dir[1];
        			
        			if(nr <0 || nr>= n || nc<0 || nc>=m ||
        					vis[nr][nc] || grid[nr][nc] !=Integer.MAX_VALUE) {
        				continue;
        			}
        			q.add(new int[] {nr, nc});
        			vis[nr][nc] = true;
        			
        			grid[nr][nc] = grid[row][col] + 1;
        		}
        	}
        			
        }
    }
}
