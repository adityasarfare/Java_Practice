package com.example.dpSubsequence;

import java.util.Arrays;

public class Knapsack20 {

	static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
 
		
		int dp [][] = new int [n][maxWeight+1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		return dfs(n-1, maxWeight, weight, value,dp);
	}

	private static int dfs(int i, int maxWeight, int[] weight, int[] value, int[][] dp) {
		
		if(i==0) {
			if(weight[0]<= maxWeight) {
				return value[0];
			}
			
			return 0;
		}
		
		if(dp[i][maxWeight] != -1) {
			return dp[i][maxWeight];
		}
		
		
		int notTaken = dfs(i-1, maxWeight, weight, value, dp);
		
		int taken = Integer.MIN_VALUE;
		if(weight[i]<= maxWeight) {
			taken = value[i] +dfs(i-1, maxWeight - weight[i], weight, value, dp);
		}
		
		return dp[i][maxWeight] = Math.max(taken, notTaken);
	}
	
	     static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight) {
	    	 int dp [][] = new int [n][maxWeight+1];
	    	 
	    	 for (int W = 0; W <= maxWeight; W++) {
	    	        if (weight[0] <= W) {
	    	            dp[0][W] = value[0];
	    	        }
	    	    }
	    	 
	    	 for(int i=1; i<n;i++) {
	    		 
	    		 for(int W=1; W<=maxWeight; W++) {
	    			
	    			 int notTaken = dp[i-1][W];
	    				
	    				int taken = 0;
	    				if(weight[i]<= W) {
	    					taken =  value[i] +dp[i-1][ W - weight[i]];
	    				}
	    				return dp[i][W] = Math.max(taken, notTaken);	
	    		 }
	    	 }
	    	 
	    	 return dp[n-1][maxWeight];
	}

	     
	     static int knapsackSpaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
	    	 int prev[] = new int[maxWeight+1];
	    	 int curr[] = new int[maxWeight+1];
	    	 
	    	 for (int W = 0; W <= maxWeight; W++) {
	    	        if (weight[0] <= W) {
	    	            prev[W] = value[0];
	    	        }
	    	    }
	    	 
	    	 for(int i=1; i<n;i++) {
	    		 
	    		 for(int W=1; W<=maxWeight; W++) {
	    			
	    			 int notTaken = prev[W];
	    				
	    				int taken = 0;
	    				if(weight[i]<= W) {
	    					taken =  value[i] + prev[ W - weight[i]];
	    				}
	    				return curr[W] = Math.max(taken, notTaken);	
	    		 }
	    		 
	    		 prev = curr.clone();
	    	 }
	    	 
	    	 return prev[maxWeight];
	}

	     static int knapsackSingleSpaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
	    	 int prev[] = new int[maxWeight+1];
	    	
	    	 
	    	 for (int W = 0; W <= maxWeight; W++) {
	    	        if (weight[0] <= W) {
	    	            prev[W] = value[0];
	    	        }
	    	    }
	    	 
	    	 for(int i=1; i<n;i++) {
	    		 
	    		 for(int W=maxWeight; W>=0; W++) {
	    			
	    			 int notTaken = prev[W];
	    				
	    				int taken = 0;
	    				if(weight[i]<= W) {
	    					taken =  value[i] + prev[ W - weight[i]];
	    				}
	    				return prev[W] = Math.max(taken, notTaken);	
	    		 }
	    		 
	  
	    	 }
	    	 
	    	 return prev[maxWeight];
	}
}
