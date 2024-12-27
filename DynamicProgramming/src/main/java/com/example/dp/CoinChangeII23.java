package com.example.dp;

import java.util.Arrays;

public class CoinChangeII23 {

	public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, target));
        System.out.println("The total number of ways is " + countWaysToMakeChangeTabulation(arr, target));
    }

	private static int countWaysToMakeChange(int[] arr, int T) {
		
          int n = arr.length;
		
		
		int dp [][] = new int [n][T+1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		
		return dfs(n-1, T, arr, dp);
	}

	private static int dfs(int i, int t, int[] arr, int[][] dp) {
		
		if(i==0) {
			if(t%arr[i] ==0) {
				return 1;
			}else {
				return 0;
			}
		}
		
		if(dp[i][t]!=-1) {
			return dp[i][t];
		}
		
		
		int notTaken = 0 + dfs(i-1, t, arr, dp);
		
		int taken = 0;
		if(arr[i]<=t) {
			taken = dfs(i, t - arr[i], arr, dp);
		}
		
		return dp[i][t] = notTaken + taken;
	}
	
	private static int countWaysToMakeChangeTabulation(int[] arr, int T) {
		int n= arr.length;
		int dp [][] = new int [n][T+1];
		
		for(int t=0; t<=T; t++) {
			if(t%arr[0]==0) {
				dp[0][t]= 1;
			}else {
				dp[0][t] =0;
			}
		}
		
		
		for(int i=1; i<n; i++) {
			for(int t=0; t<=T; t++) {
				
				int notTaken = 0 + dp[i-1][t];
				
				int taken = 0;
				if(arr[i]<=t) {
					taken = dp[i][t - arr[i]];
				}
				
				dp[i][t] = notTaken+taken;
			}
		}
		return dp[n-1][T];
	}
}
