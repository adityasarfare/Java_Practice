package com.example.dp;

import javax.security.auth.callback.CallbackHandler;

public class ClimbingAStair1 {
	// TOP- DOwn Memoization
//	int cache[];
//	 public int climbStairs(int n) {
//		
//		 cache = new int[n];
//		 
//		 for(int i= 0; i<n; i++) {
//			 cache[i]=-1;
//		 }
//		 
//		 return dfs(n, 0);
//		 
//	 }
//	private int dfs(int n, int i) {
//	if(i>=n) {
//		return i==n ?1:0;
//	}
//	if(cache[i]!=-1) {
//		return cache[i];
//	}
//		return cache[i] = dfs(n, i+1) + dfs(n, i+2);
//	}
	
	//BOTTOM-UP Tabular
	public int climbStairs(int n) {
		if(n<=2) {
			return n;
		}
		
		int[] dp= new int[n+1];
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];	
		
		}
		
		return dp[n];
		
	}
}
