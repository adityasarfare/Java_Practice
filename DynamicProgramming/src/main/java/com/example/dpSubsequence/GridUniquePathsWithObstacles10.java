package com.example.dpSubsequence;

import java.awt.datatransfer.ClipboardOwner;
import java.util.Arrays;

public class GridUniquePathsWithObstacles10 {
	
	
	public static void main(String[] args) {
		int[][] maze = {
	            {0, 0, 0},
	            {0, -1, 0},
	            {0, 0, 0}
	        };
		
		int m = maze.length;
		int n = maze[0].length;

        // Call the countWays function and print the result
        System.out.println(countWays(m, n, maze));
        
        System.out.println(countWays2(m, n, maze));
	}

	
	private static int countWays(int m, int n, int[][] maze) {
		
		int dp[][] = new int [m][n];
		
		for(int rows[] : dp) {
			Arrays.fill(rows, -1);
		}
		
		return dfs(m-1, n-1, dp, maze );
	}

	private static int dfs(int i, int j, int[][] dp, int[][] maze) {
		
		
		if(i ==0 && j==0) {
			return 1;
		}
		
		if(i<0 || j<0) {
			return 0;
		}
		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		
		if(maze[i][j] ==-1) {
			return 0;
		}
		
		int up = dfs(i-1, j, dp, maze);
		int left = dfs(i, j-1, dp, maze);
		return dp[i][j] = up + left;
	}
	
	
	private static int countWays2(int m, int n, int[][] maze) {
	    int dp[][] = new int [m][n];
//	    dp[0][0] = 1;
	    
	    
	    for(int i =0; i< m; i++) {
	    	
	    	for(int j=0; j<n; j++) {
	    		
	    		if(i==0 && j==0) {
	    			dp[i][j] =1;
	    			continue;
	    		}
	    		
	    		if( i<0 || j<0 || maze[i][j] ==-1) {
	    		 continue;
	    		}
	    		int down =0;
	    		int right =0;
	    		if(i>0) {
	    			down = dp[i-1][j];
	    		}
	    		
	    		if(j>0) {
	    			right = dp[i][j-1];
	    		}
	    		dp[i][j] = down + right;
	    	}
	    }
		return dp[m-1][n-1];
	}

}
