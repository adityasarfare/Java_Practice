package com.example.dpStrings;

import java.util.Arrays;

public class LongestCommonSubsequence1 {

	public static void main(String args[]) {
        String text1 = "acd";
        String text2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(text1, text2));
        System.out.println("The Length of Longest Common Subsequence is " + lcsTabulation(text1, text2));
    }

	
	private static int lcs(String text1, String text2) {
		
		int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n][m];
        for(int[] rows : dp) {
        	Arrays.fill(rows, -1);
        }
        
        return dfs(n-1, m-1, text1, text2, dp);
	
	}

	private static int dfs(int i, int j, String text1, String text2, int [][]dp) {
		
		if(i<0 || j<0) {
			return 0;
		}
		
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		
		if(text1.charAt(i) == text2.charAt(j)) {
			return dp[i][j] = 1 + dfs(i-1, j-1, text1, text2, dp);
		}
		else {
		
			return dp[i][j] = Math.max(dfs(i-1, j, text1, text2, dp), dfs(i, j-1, text1, text2, dp));
		}
	}
	
	// Shifting index
	private static int lcsTabulation(String text1, String text2) {
		
		int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];
        
        for(int rows[] : dp)
        Arrays.fill(rows, -1);
        
        for(int i=0; i<=n; i++) {
        	dp[i][0] = 0;
        }
          
        
        for(int j=0; j<=m; j++) {
        	dp[0][j] = 0;
        }
        
        
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=m; j++) {
        		
        		if(text1.charAt(i-1) == text2.charAt(j-1)) {
        			 dp[i][j] = 1 + dp[i-1][j-1];
        		}
        		else {
        		
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
        
		return dp[n][m];
	}

}
