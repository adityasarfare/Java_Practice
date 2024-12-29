package com.example.dpSubsequence;

import java.awt.datatransfer.ClipboardOwner;
import java.util.Arrays;

public class GridUniquePaths9 {
	
	
	public static void main(String[] args) {
		int m = 3;
        int n = 2;

        // Call the countWays function and print the result
        System.out.println(countWays(m, n));
        
        System.out.println(countWays2(m, n));
	}

	
	private static int countWays(int m, int n) {
		
		int dp[][] = new int [m][n];
		
		for(int rows[] : dp) {
			Arrays.fill(rows, -1);
		}
		
		return dfs(m-1, n-1, dp );
	}

	private static int dfs(int i, int j, int[][] dp) {
		
		
		if(i ==0 && j==0) {
			return 1;
		}
		
		if(i<0 || j<0) {
			return 0;
		}
		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		
		int up = dfs(i-1, j, dp);
		int left = dfs(i, j-1, dp);
		return dp[i][j] = up + left;
	}
	
	
	private static int countWays2(int m, int n) {
	    int dp[][] = new int [m][n];
//	    dp[0][0] = 1;
	    
	    
	    for(int i =0; i< m; i++) {
	    	
	    	for(int j=0; j<n; j++) {
	    		
	    		if(i==0 && j==0) {
	    			dp[i][j] =1;
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
