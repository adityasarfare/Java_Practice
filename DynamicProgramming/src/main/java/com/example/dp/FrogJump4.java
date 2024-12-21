package com.example.dp;

import java.util.Arrays;

public class FrogJump4 {

	//Memoization
  public static int maxJump(int[] stones, int k) {
        
	  int n= stones.length;
	  int dp[] = new int[n+1];
	  Arrays.fill(dp, -1);
	  
	  return dfs(n-1, stones, dp, k);
    }

	private  static int dfs(int n, int[] stones, int[] dp, int k) {
	
		if(n==0) {
			return 0;
		}	
		
		if(dp[n] !=-1) {
			return dp[n];
		}
		
		int minSteps = Integer.MAX_VALUE;
		for(int j=1; j<=k; j++) {
		
			if(n - j>=0) {
			int jump = dfs(n-j, stones, dp, k) + Math.abs(stones[n] - stones[n-j]);
			minSteps = Math.min(minSteps, jump);
		}	
	}
		return minSteps;
	}
	public static void main(String[] args) {
		
		int stones[] = { 30, 10, 60, 10, 60, 50 };
		int k=2;
	    System.out.println(maxJump(stones, k));
	}
	
}
