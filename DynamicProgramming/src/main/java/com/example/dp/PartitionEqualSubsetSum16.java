package com.example.dp;

import java.lang.annotation.Target;
import java.util.Arrays;

public class PartitionEqualSubsetSum16 {
	public static void main(String args[]) {
		int arr[] = { 2, 3, 3, 3, 4, 5 };
		int n = arr.length;

		// Check if the array can be partitioned into two equal subsets
		if (canPartition(n, arr))
			System.out.println("The Array can be partitioned into two equal subsets");
		else
			System.out.println("The Array cannot be partitioned into two equal subsets");

		if (canPartitionTabulation(n, arr))
			System.out.println("The Array can be partitioned into two equal subsets");
		else
			System.out.println("The Array cannot be partitioned into two equal subsets");
	}

	private static boolean canPartition(int n, int[] arr) {

		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}

		if (totalSum / 2 == 1) {
			return false;
		} else {

			int k = totalSum / 2;
			int[][] dp = new int[n][k + 1];

			for (int[] row : dp) {
				Arrays.fill(row, -1);
			}

			return dfs(n - 1, k, arr, dp);
		}

	}

	private static boolean dfs(int i, int target, int[] arr, int[][] dp) {

		if (target == 0) {
			return true;
		}

		if (i == 0) {
			return target == arr[0];
		}

		if (dp[i][target] != -1) {
			return dp[i][target] == 0 ? false : true;
		}

		boolean notTaken = dfs(i - 1, target, arr, dp);

		boolean taken = false;
		if (arr[i] <= target) {
			taken = dfs(i - 1, target - arr[i], arr, dp);
		}

		dp[i][target] = taken || notTaken ? 1 : 0;
		return taken || notTaken;
	}

	static boolean canPartitionTabulation(int n, int[] arr) {

		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}

		if (totalSum % 2 == 1) {
			return false;
		} else {

			int k = totalSum / 2;
			boolean[][] dp = new boolean[n][k + 1];

			
			for(int i=0; i<n; i++) {
				dp[i][0] = true;
			}
			
			if(arr[0]<= k) {
				dp[0][arr[0]] = true;
			}
			
			for(int ind =1; ind<n; ind++) {
				for(int target=1; target<=k; target++) {
					
					boolean notTaken = dp[ind-1][target];
					
					boolean taken= false;
					if(arr[ind]<=target) {
						taken = dp[ind-1][target- arr[ind]];
					}
					dp[ind][target] = taken || notTaken;
				}
			}
			return dp[n-1][k];
		}

		
	}
}
