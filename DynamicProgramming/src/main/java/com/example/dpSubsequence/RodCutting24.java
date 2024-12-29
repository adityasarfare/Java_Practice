package com.example.dpSubsequence;

import java.util.Arrays;

public class RodCutting24 {

	public static void main(String args[]) {
//        int wt[] = { 2, 4, 6 };
        int price[] = { 2,5, 7, 8, 10 };
        int W = 5;

        int n = price.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + rodCutting(n, W, price));
        System.out.println("The Maximum value of items, the thief can steal is " + rodCuttingTabulation(n, W, price));
        System.out.println("The Maximum value of items, the thief can steal is " + rodCuttingSpaceOptimization(n, W, price));
    }


	private static int rodCutting(int n, int w, int[] price) {
		
		int dp [][] = new int[n][w+1];
		for(int [] row : dp) {
			Arrays.fill(row, -1);
		}
		
		return dfs(n-1, w, price, dp);
	}

	private static int dfs(int i, int w, int[] price, int[][] dp) {
		
		if(i==0) {
			return w * price[i];
		}
		
		if(dp[i][w]!=-1) {
			return dp[i][w];
		}
		
        int notTaken = dfs(i-1, w, price, dp);
		
		int taken =Integer.MIN_VALUE;
		int rodlength = i+1;
		if(rodlength<= w) {
			taken = price[i] + dfs(i, w-rodlength, price, dp); 
		}
		
		
		return dp[i][w] = Math.max(notTaken, taken);
		
	}


	private static int  rodCuttingTabulation(int n, int w, int[] price) {
		
		
		int dp [][] = new int[n][w+1];
		
		for(int N=0; N<=w; N++) {
			dp[0][N] = N * price[0];
		}
		
		
		for(int i=1; i<n; i++) {
			
			for(int len=0; len<=w; len++) {
				
				int notTaken = dp[i-1][len];
				
				int taken =Integer.MIN_VALUE;
				int rodlength = i+1;
				if(rodlength<= len) {
					taken = price[i] + dp[i][len-rodlength]; 
				}
				
				dp[i][len] = Math.max(taken, notTaken);
			}
		}
		return dp[n-1][w];
	}
	
private static int  rodCuttingSpaceOptimization(int n, int w, int[] price) {
		
		
		int prev [] = new int[w+1];
		
		for(int N=0; N<=w; N++) {
			prev[N] = N * price[0];
		}
		
		
		for(int i=1; i<n; i++) {
			
			for(int len=0; len<=w; len++) {
				
				int notTaken = prev[len];
				
				int taken =Integer.MIN_VALUE;
				int rodlength = i+1;
				if(rodlength<= len) {
					taken = price[i] + prev[len-rodlength]; 
				}
				
				prev[len] = Math.max(taken, notTaken);
			}
		}
		return prev[w];
	}
	
}
