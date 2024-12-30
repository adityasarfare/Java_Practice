package com.example.dpStrings;

import java.util.Arrays;

public class MinimumInsertionstoMakeStringPalindrome5 {
	public static void main(String args[]) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
    }

	private static int minInsertion(String s) {
	int n = s.length();
	int k = longestPalindromeSubsequence(s);
		return n-k;
	}
	
	
	static int longestPalindromeSubsequence(String s) {
        // Create a reversed version of the input string
        String reversed = new StringBuilder(s).reverse().toString();

        // Calculate the LCS of the original string and its reverse
        return lcs(s, reversed);
    }

	private static int lcs(String s, String reversed) {
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
