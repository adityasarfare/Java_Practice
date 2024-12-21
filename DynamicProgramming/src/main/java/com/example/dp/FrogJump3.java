package com.example.dp;

import java.util.Arrays;

public class FrogJump3 {

	//Brute Force
  public int maxJump(int[] stones) {
        
	  int n= stones.length;
	  int dp[] = new int[n];
	  Arrays.fill(dp, -1);
	  
	  return dfs(n-1, stones, dp);
	  
    }

	private int dfs(int n, int[] stones, int[] dp) {
	
		if(n==0) {
			return 0;
		}
		
		
		if(dp[n] !=-1) {
			return dp[n];
		}
		
		int left= dfs(n-1, stones, dp) + Math.abs(stones[n] - stones[n-1]);
		
		  int right = Integer.MAX_VALUE;
		
		if(n>1) {
			right =  dfs(n-2, stones, dp) + Math.abs(stones[n] - stones[n-2]);
		}
		return  dp[n] =Math.min(left, right);
	}
}
