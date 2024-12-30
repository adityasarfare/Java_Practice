package com.example.dpStrings;

public class CountofPalindromicSubstring9 {

	public int longestPalindrome(String s) {
		int n= s.length();
		if(n==0) return 0;
		
		boolean dp[][] = new boolean [n][n];
		
		int count =0; 
		
		for(int i=n-1; i>=0; i--) {
			for(int j=i; j<n; j++) {
				if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1] )) {
					
					dp[i][j] = true;
					count++;
					
					}
				}
			}
		
		
		return count;
	}
}
