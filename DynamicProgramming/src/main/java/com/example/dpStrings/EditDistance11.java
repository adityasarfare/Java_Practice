package com.example.dpStrings;

import java.util.Arrays;

public class EditDistance11 {

	public static void main(String args[]) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                editDistance(s1, s2));
        System.out.println("The minimum number of operations required is: " +
                editDistanceTabulation(s1, s2));
        System.out.println("The minimum number of operations required is: " +
                editDistanceSpaceOptimaztion(s1, s2));
    }

	private static int editDistance(String s1, String s2) {

        int n= s1.length();
        int m= s2.length();
        
        int[][] dp = new int[n][m];

		for (int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
        return dfs(n-1, m-1, s1, s2, dp);
	}

	private static int dfs(int i, int j, String s1, String s2, int[][] dp) {
		
		if(i<0) {
			return j+1;
		}
		if(j<0) {
			return i+1;
		}
		
		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		if(s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = dfs(i-1, j-1, s1, s2, dp);
		}else {
		return dp[i][j] = 1+ Math.min(dfs(i, j-1, s1, s2, dp), Math.min(dfs(i-1, j, s1, s2, dp), dfs(i-1, j-1, s1, s2, dp)));
		}
		}
	
	private static int  editDistanceTabulation(String s1, String s2) {
		    int n= s1.length();
	        int m= s2.length();
	        
	        int[][] dp = new int[n+1][m+1];
	        
	        for(int j=0; j<=m; j++) {
	        	dp[0][j] = j;
	        }
	        
	        for(int i=0; i<=n; i++) {
	        	dp[i][0] = i;
	        }
	        
	        for(int i=1; i<=n; i++) {
	        	for(int j=1; j<=m; j++) {
	        		
	        		if(s1.charAt(i-1) == s2.charAt(j-1)) {
	    	           dp[i][j] = dp[i-1][j-1];
	    	        }else {
	    	        	dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
	    	        }
	        	}
	        }
		return dp[n][m];
	}
	
	private static int editDistanceSpaceOptimaztion(String s1, String s2) {
		int n= s1.length();
        int m= s2.length();
        
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        for(int j=0; j<=m; j++) {
        	prev[j] = j;
        }
        
        for(int i=1; i<=n; i++) {
        	curr[0] =i;
        	for(int j=1; j<=m; j++) {	
        		if(s1.charAt(i-1) == s2.charAt(j-1)) {
    	           curr[j] = prev[j-1];
    	        }else {
    	        	curr[j] = 1 + Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
    	        }
        	}
        	prev = curr.clone();
        }
	return prev[m];
	}


}
