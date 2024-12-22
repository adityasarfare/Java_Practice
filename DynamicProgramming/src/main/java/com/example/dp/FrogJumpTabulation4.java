package com.example.dp;

import java.util.Arrays;

public class FrogJumpTabulation4 {

	//Tabulation
  public static int maxJump(int[] stones, int k) {
        
	  int n= stones.length;
	  int dp[] = new int[n];
	  dp[0] =0;
	  
	  for(int i=1; i<n; i++) {
		  
		  int step =Integer.MAX_VALUE;
		  for(int j=1; j<=k; j++){
			  if(i-j>=0) {
				  int jump = dp[i-j] + Math.abs(stones[i] - stones[i-j]);
				  step = Math.min(step, jump);
			  }
			dp[i] = step;
		  }
	  }
		return dp[n-1];
	}
	public static void main(String[] args) {
		
		int stones[] = { 30, 10, 60, 10, 60, 50 };
		int k=2;
	    System.out.println(maxJump(stones, k));
	}
	
}
