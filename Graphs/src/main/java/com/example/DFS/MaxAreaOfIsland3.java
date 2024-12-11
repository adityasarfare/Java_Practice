package com.example.DFS;

public class MaxAreaOfIsland3 {
	 public int maxAreaOfIsland(int[][] grid) {
	        int n = grid.length;
	        int m = grid[0].length;
	        int island =0;
	  

	        for(int i=0; i< n; i++){
	            for(int j=0; j<m; j++){
	                if(grid[i][j] == 1){
	                    island = Math.max(island, dfs(grid, i , j));
	                }
	            }
	        }
	        return island;
	    }

	int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	    public int dfs(int[][] grid, int r, int c){
	        if(r<0 || r>=grid.length ||
	           c<0 || c>=grid[0].length ||
	           grid[r][c] ==0){
	            return 0;
	           }
	        
	        grid[r][c]= 0;
	        int total=1;
	        for(int dir[] : directions){
	         total +=dfs(grid, r+dir[0], c+dir[1]);
	        }
	         return total;
	    }
}
