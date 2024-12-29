package com.example.dpSubsequence;

import java.util.Arrays;

public class SubsetSumEqualToTarget15 {
  
	public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }

	private static boolean subsetSumToK(int n, int target, int[] arr) {
		
		int dp[][] = new int [n][target+1];
		
		for(int row[]: dp) {
			Arrays.fill(row, -1);
		}
		return dfs(n-1, target, arr, dp);
	}

	private static boolean dfs(int i, int target, int[] arr, int[][] dp) {
		
		if(target==0) {
			return true;
		}
		
		if(i ==0) {
			return arr[0] == target;
		}
		
		
		if(dp[i][target] != -1) {
			return dp[i][target] == 0 ? false: true;
		}
		
		boolean notTaken = dfs(i-1, target, arr, dp);
		
		boolean taken= false;
		if(arr[i]<target) {
			taken = dfs(i, target- arr[i], arr, dp);
		}
		
		dp[i][target] = notTaken || taken ?1:0;
		return notTaken || taken;
	}
	
}
