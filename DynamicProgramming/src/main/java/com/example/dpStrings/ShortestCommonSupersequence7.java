package com.example.dpStrings;

public class ShortestCommonSupersequence7 {

	public static void main(String args[]) {

		  String s1 = "brute";
		  String s2 = "groot";

		  System.out.println("The Longest Common Supersequence is "+shortestSupersequence(s1,s2));
		}

	private static String shortestSupersequence(String s1, String s2) {
		
		int n=s1.length();
		int m= s2.length();
		
		int dp[][] = new int [n+1][m+1];
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int len = dp[n][m];
		int i =n;
		int j =m;
		
//		int index = len-1;
		String ans ="";
		
		while(i>0 && j>0) {
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				ans += s1.charAt(i-1);
				i--;
				j--;
			}else if(dp[i-1][j]> dp[i][j-1]) {
				ans += s1.charAt(i-1);
				i--;
			}else {
				ans += s2.charAt(j-1);
				j--;
			}
		}
		
		while(i>0) {
			ans += s1.charAt(i-1);
			i--;
		}
		
		while(j>0) {
			ans += s2.charAt(j-1);
			j--;
		}
		
		StringBuilder sb = new StringBuilder(ans);
		sb.reverse();
		return sb.toString();
	}
	
}
