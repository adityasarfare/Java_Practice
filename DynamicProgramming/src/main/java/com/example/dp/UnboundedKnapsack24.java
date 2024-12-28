package com.example.dp;

import java.util.Arrays;

public class UnboundedKnapsack24 {

	
	 public static void main(String args[]) {
	        int wt[] = { 2, 4, 6 };
	        int val[] = { 5, 11, 13 };
	        int W = 10;

	        int n = wt.length;

	        // Call the unboundedKnapsack function and print the result
	        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
	        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsackTabulation(n, W, val, wt));
	        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsackSpaceOptimization(n, W, val, wt));
	    }


	private static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {

		int dp [][] = new int[n][w+1];
		for(int [] row : dp) {
			Arrays.fill(row, -1);
		}
		return dfs(n-1, w, val, wt, dp);
	}

	private static int dfs(int i, int w, int[] val, int[] wt, int[][] dp) {
		
		if(i == 0) {
			if(w%wt[i] ==0) {
				return (int)(w/wt[i]) * val[i];
			}
			else {
				return 0;
			}
		}
		
		if(dp[i][w]!=-1) {
			return dp[i][w];
		}
		
		
		int notTaken = dfs(i-1, w, val, wt, dp);
		
		int taken =Integer.MIN_VALUE;
		if(wt[i]< w) {
			taken = val[i] + dfs(i, w-wt[i], val, wt, dp); 
		}
		
		
		return dp[i][w] = Math.max(notTaken, taken);
	}
	
	private static int unboundedKnapsackTabulation(int n, int w, int[] val, int[] wt) {
		
		
		int dp [][] = new int[n][w+1];
		
		for(int i=0; i<=w; i++) {
			dp[0][i] = (int)(i/wt[0]) * val[0];
		}
		
		for(int i=1; i<n; i++) {
			
			for(int cap=0; cap<=w; cap++) {
				
				int notTaken = dp[i-1][cap];
			    
				int taken = Integer.MIN_VALUE;
				if(wt[i]<=cap) {
					taken = val[i] + dp[i][cap-wt[i]];
				}
				
				dp[i][cap] = Math.max(notTaken, taken);
			}
			
		}
		return dp[n-1][w];
	}
	
	private static int unboundedKnapsackSpaceOptimization(int n, int w, int[] val, int[] wt) {
		
           int prev [] = new int [w+1];
           int curr [] = new int [w+1];
		
		for(int i=0; i<=w; i++) {
			prev[i] = (int)(i/wt[0]) * val[0];
		}
		
		for(int i=1; i<n; i++) {
			
			for(int cap=0; cap<=w; cap++) {
				
				int notTaken = prev[cap];
			    
				int taken = Integer.MIN_VALUE;
				if(wt[i]<=cap) {
					taken = val[i] + curr[cap-wt[i]];
				}
				
				curr[cap] = Math.max(notTaken, taken);
			}
			prev = curr;
			
		}
		return prev[w];
	}

}
