package com.example.dpStrings;

public class LongestCommonSubstring3 {

	 public static void main(String args[]) {
	        String s1 = "abcjklp";
	        String s2 = "acjkp";

	        // Call the lcs function and print the result
	       System.out.println(longestCommonSubtstring(s1, s2));
	       System.out.println(longestCommonSubtstringSpaceOptimization(s1, s2)); 
	    }

	private static int longestCommonSubtstring(String s1, String s2) {
		
		int n= s1.length();
		int m= s2.length();
		
		int dp[][] = new int[n+1][m+1];
		int ans = 0;
		for(int i=0; i<=n; i++) {
			dp[i][0] =0;
		}
		
		for(int j=0; j<=m; j++) {
			dp[0][j] =0;
		}
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=m; j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					ans = Math.max(ans, dp[i][j]);
				}else {
					dp[i][j] =0;
				}
			}
		}
		
		return ans;
	}
	
private static int longestCommonSubtstringSpaceOptimization(String s1, String s2) {
		
		int n= s1.length();
		int m= s2.length();
		
		int prev [] = new int[n+1];
		int cur [] = new int[n+1];
		int ans = 0;
		for(int i=0; i<=n; i++) {
			prev[i]=0;
		}
//		
//		for(int j=0; j<=m; j++) {
//			dp[0][j] =0;
//		}
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=m; j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					cur[j] = 1 + prev[j-1];
					ans = Math.max(ans, cur[j]);
				}else {
					cur[j] =0;
				}
			}
			prev = cur.clone();
		}
		
		return ans;
	}
}
