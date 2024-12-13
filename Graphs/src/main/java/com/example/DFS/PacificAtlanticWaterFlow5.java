package com.example.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PacificAtlanticWaterFlow5 {
	
	int directions [][]= {{1,0}, {-1,0}, {0,1}, {0,-1}};
	 public List<List<Integer>> pacificAtlantic(int[][] heights) {
	        int ROW = heights.length;
	        int COL = heights[0].length;
	        boolean [][] pac = new boolean[ROW][COL];
	        boolean [][] atl = new boolean[ROW][COL];
	        
	        
	        for(int c=0; c < COL; c++) {
	        	dfs(0, c, pac, heights);
	        	dfs(ROW-1, c, atl, heights);
	        }
	        
	        for(int r=0; r<ROW; r++) {
	        	dfs(r, 0, pac, heights);
	        	dfs(r, COL-1, atl, heights);
	        }
	        
	        List<List<Integer>> ans = new ArrayList<>();
	        for(int i=0; i<heights.length; i++) {
	        	for(int j=0; j<heights[0].length; j++) {
	        		if(pac[i][j] && atl[i][j]) {
	        			ans.add(Arrays.asList(i,j));
	        		}
	        	}
	        }
	        
	        return ans;
	    }
	private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
	       ocean[r][c] = true;
	       
	       for(int[] dir : directions) {
	    	   int nr = r + dir[0];
	    	   int nc = c + dir[1];
	    	   
	    	   if(nr >=0 && nr < heights.length &&
	    		  nc >=0 && nc <heights[0].length && 
	    		  !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
	    		   dfs(nr, nc, ocean, heights);
	    	   }
	       }
		
	}
}
