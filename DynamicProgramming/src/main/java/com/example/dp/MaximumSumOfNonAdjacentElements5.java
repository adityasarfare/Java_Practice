package com.example.dp;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements5 {

	
	private static int solve(int n, int[] arr) {
		int dp[] = new int [n]; 
		Arrays.fill(dp, -1);
		return dfs(n-1, arr, dp);
	}
	
	
	private static int dfs(int n, int[] arr, int[] dp) {
		
		if(n==0) {
		return arr[0];	
		}
		
		if(n<0) {
			return 0;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		int pick = arr[n] + dfs(n-2, arr, dp);
		int nonpick = 0 + dfs(n-1, arr, dp);
		
		dp[n] = Math.max(pick, nonpick);
		return dp[n];
	}


	public static void main(String args[]) {
        // Input array with elements.
        int arr[] = {2, 1, 4, 9};
        
        // Get the length of the array.
        int n = arr.length;
        
        // Call the solve function to find the maximum possible sum.
        int result = solve1(n, arr);
        
        // Print the result.
        System.out.println(result);
    }

	private static int solve1(int n, int[] arr) {
		int [] dp = new int [n];
		dp[0] =arr[0];
		
		for(int i=1; i<n; i++) {
			
			
		    int  pick = arr[i];
		    if(i>1) {
		    pick += dp[i-2]; 
		    }
			int nopick = 0 + dp[i-1];
			dp[i] = Math.max(pick, nopick);
		}
		return dp[n-1];
	}
	
	private static int solve2(int n, int[] arr) {
		
		int prev = arr[1];
		int prev2 =arr[0];
		
		for(int i=2; i<n; i++) {
			int pick = arr[i] + (i>1? prev2 :0);
			int nonpick = 0 + prev;
			
			int curr = Math.max(pick, nonpick);
			prev2 = prev;
			prev = curr;
		   
		}
		return prev;
	}
	
	
}
