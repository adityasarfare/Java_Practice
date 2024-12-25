package com.example.dp;

import java.lang.annotation.Target;
import java.util.Arrays;

public class CountSubsetswithSumK18 {

	
	public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays(arr, k));
        System.out.println("The number of subsets found are " + findWaysTabulation(arr, k));
    }



	private static int  findWays(int[] arr, int k) {
	 
		int n = arr.length;
        int dp[][] = new int [n][k+1];
		
		for(int row[]: dp) {
			Arrays.fill(row, -1);
		}
		return dfs(n-1, k, arr, dp);
	}

	private static int dfs(int i, int target, int[] arr, int[][] dp) {
		if(target ==0) {
			return 1;
		}
		
		if(i ==0) {
			if(arr[i]== target) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		if(dp[i][target]!=-1) {
			return dp[i][target];
		}
		
		int notTaken =  dfs(i-1, target, arr, dp);
		
		int taken = 0;
		if(arr[i]<= target) {
			taken = dfs(i-1, target - arr[i], arr, dp);
		}
		
		return dp[i][target] = notTaken + taken;
	}
	
	private static int findWaysTabulation(int[] arr, int k) {
		int n = arr.length;
		
		int dp [][] = new int [n][k+1];
		
		for(int i=0; i<n; i++) {
		    dp[i][0] = 1;
		}
		
		if(arr[0] <= k) {
			dp[0][arr[0]] = 1;
		}
		
		for(int i=1; i<n; i++) {
			for(int target =1; target<=k; target++) {
				int notTaken =  dp[i-1][target];
				
				int taken = 0;
				if(arr[i]<= target) {
				taken = dp[i-1][target - arr[i]];
				}
				
				dp[i][target] = taken + notTaken;
			}
		}
		return dp[n-1][k];
	}
}
