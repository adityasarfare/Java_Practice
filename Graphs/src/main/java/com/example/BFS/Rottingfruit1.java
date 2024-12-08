package com.example.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

//994
public class Rottingfruit1 {

	  public int orangesRotting(int[][] grid) {
	     
		  int n=grid.length;
		  int m=grid[0].length;
		  int time =0;
		  int fresh=0;
		  
		  Queue<int[]> q = new ArrayDeque<>();
		  boolean vis[][] = new boolean[n][m];
		  
		  for(int i =0; i<n; i++) {
			  for(int j=0; j<m ; j++) {
				  if(grid[i][j] == 1) {
					  fresh++;
				  }else if (grid[i][j] == 2) {
					  vis[i][j] = true;
					  q.offer(new int[] {i , j});
				  }
			  }
		  }
		  
		  int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
		  
		  while(fresh !=0 && !q.isEmpty()) {
			  int size = q.size();
			  time++;
			  for(int i=0; i< size; i++) {
				  int cell[] = q.poll();
				  int r = cell[0];
				  int c = cell[1];
				  
				  for(int[] dir : directions) {
					  int row = r + dir[0];
					  int col = c + dir[1];
					  
					  if(row >=0 && row<n && 
					     col >=0 && col<n &&
					     !vis[row][col] &&
					     grid[row][col] ==1) {
						  vis[row][col]= true;
						  grid[row][col] = 2;
						  q.offer(new int[] {row, col});
						  fresh--;
					  }
				  }
			  }
		  }
		  return fresh == 0 ? time : -1;
	    }
	
}
