package com.example.dpStrings;

import java.util.Arrays;

public class DistinctSubsequences10 {

	 public static void main(String args[]) {
	        String s = "babgbag";
	        String t = "bag";

	                System.out.println(subsequenceCounting(s, t));
	                System.out.println(subsequenceCountingTabulation(s, t));
	    }


	private static  int subsequenceCounting(String s, String t) {

		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n][m];
		
		for(int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		return dfs(n-1, m-1, s, t, dp);
	}

	private static int dfs(int i, int j, String s, String t, int[][] dp) {

		
		if(j<0) {
			return 1;
		}
		
		if(i<0) {
			return 0;
		}

		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		if(s.charAt(i) == t.charAt(j)) {
		dp[i][j] = dfs(i-1, j-1, s, t, dp) + dfs(i-1, j, s, t, dp);
		}
		else {
			dp[i][j] = dfs(i-1, j, s, t, dp);
		}
		return dp[i][j];
	}
	

	private static int subsequenceCountingTabulation(String s, String t) {
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n+1][m+1];
		
		for(int i=0; i<=n; i++) {
			dp[i][0] =1;
		}
		
		for(int j=1; j<=m; j++) {
			//j=1 very important 
			dp[0][j] =0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				
				if(s.charAt(i-1) == t.charAt(j-1) ) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
			else {
				dp[i][j] = dp[i-1][j];
			}
		}
		
	}
		return dp[n][m];
	}
}
