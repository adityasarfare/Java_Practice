package com.example.dpStrings;

import java.util.Arrays;

public class LongestPalindromicSubsequence4 {

	 public static void main(String args[]) {
	        String s = "bbabcbcab";
	        
	        String reversed = new StringBuilder(s).reverse().toString();

	        System.out.print("The Length of Longest Palindromic Subsequence is ");
	        System.out.println(longestPalindromeSubsequence(s, reversed));
	    }

	private static int longestPalindromeSubsequence(String s, String reversed) {
	
		int n = s.length();
        int m = reversed.length();

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
        		
        		if(s.charAt(i-1) == reversed.charAt(j-1)) {
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
