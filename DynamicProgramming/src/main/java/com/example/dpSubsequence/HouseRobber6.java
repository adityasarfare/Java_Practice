package com.example.dpSubsequence;

import java.util.Arrays;

public class HouseRobber6 {
	public int rob(int[] nums) {
		
		int n= nums.length;
		int dp [] = new int [n];
		Arrays.fill(dp, -1);
		
		
		return dfs(n-1, nums, dp);
	}

	private int dfs(int n, int[] nums, int dp[]) {

       if(n==0) {
    	   return nums[n];
       }
       
       if(n<1) {
    	   return 0;
       }
		
		if(dp[n] !=1) {
			return dp[n];
		}
		
		int pick = nums[n] + dfs(n-2, nums, dp);
		int nonpick = 0 + dfs(n-1, nums, dp);
		
		dp[n] = Math.max(pick, nonpick);
		return dp[n];
	}
	
	
	public int rob2(int[] nums) {
		int n = nums.length;
		int dp[] = new int [n];
		
		dp[0] = nums[0];
		
		for(int i=1; i<n; i++) {
			int pick = nums[i] + (i>1 ? dp[i-2] :0);
			int nonpick = 0+ dp[i-1];
			
			dp[i] = Math.max(pick, nonpick);
		}
		
		return  dp[n-1];
	}
}
