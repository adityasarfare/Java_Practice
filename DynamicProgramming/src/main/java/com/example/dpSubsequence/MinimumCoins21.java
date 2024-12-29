package com.example.dpSubsequence;

import java.util.Arrays;

public class MinimumCoins21 {

	public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int T = 7;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElements(arr, T));
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElementsTabulation(arr, T));
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElementsSpaceOptimization(arr, T));
    }

	
	private static int minimumElements(int[] arr, int T) {
		
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
				return t/arr[i];
			}else {
				return Integer.MAX_VALUE;
			}
		}
		
		if(dp[i][t]!=-1) {
			return dp[i][t];
		}
		
		
		int notTaken = 0 + dfs(i-1, t, arr, dp);
		
		int taken = Integer.MAX_VALUE;
		if(arr[i]<=t) {
			taken = 1 + dfs(i, t - arr[i], arr, dp);
		}
		
		return dp[i][t] = Math.min(notTaken, taken);
	}
	
	private static int minimumElementsTabulation(int[] arr, int T) {
		int n= arr.length;
		int dp [][] = new int [n][T+1];
		
		for(int t=0; t<=T; t++) {
			if(t%arr[0]==0) {
				dp[0][t]= t/arr[0];
			}else {
				dp[0][t] =Integer.MAX_VALUE;
			}
		}
		
		
		for(int i=1; i<n; i++) {
			for(int t=0; t<=T; t++) {
				
				int notTaken = 0 + dp[i-1][t];
				
				int taken = Integer.MAX_VALUE;
				if(arr[i]<=t) {
					taken = 1 + dp[i][t - arr[i]];
				}
				
				dp[i][t] = Math.min(notTaken, taken);
			}
		}
		return dp[n-1][T];
	}
	
	private static int minimumElementsSpaceOptimization(int[] arr, int T) {
		int n= arr.length;
		int prev[] = new int[T+1];
		int curr[] = new int[T+1];
		
		for(int t=0; t<=T; t++) {
			if(t%arr[0]==0) {
				prev[t]= t/arr[0];
			}else {
				prev[t]= Integer.MAX_VALUE;
			}
		}
		
		
		for(int i=1; i<n; i++) {
			for(int t=0; t<=T; t++) {
				
				int notTaken = 0 + prev[t];
				
				int taken = Integer.MAX_VALUE;
				if(arr[i]<=t) {
					taken = 1 + curr[t - arr[i]];
				}
				
				curr[t] = Math.min(notTaken, taken);
			}
			prev = curr.clone();
		}
		
		int ans = prev[T];
		if (ans >= (int) Math.pow(10, 9))
            return -1;
		return ans;
	}

}
