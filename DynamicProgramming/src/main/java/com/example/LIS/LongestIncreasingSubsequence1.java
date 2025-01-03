package com.example.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence1 {

	public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequenceTabulation(arr, n));
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequenceSpaceOptimization(arr, n));
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequenceSpaceOptimization2(arr, n));
    }




	private static int longestIncreasingSubsequence(int[] arr, int n) {
		
		
		int dp[][] = new int [n][n+1];
		
		for(int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		
		return dfs(0, -1, n, arr, dp);
	}

	private static int dfs(int i, int prev, int n, int[] arr, int[][] dp) {
		
		if(i==n) {
			return 0;
		}
		
		if(dp[i][prev+1] !=-1) {
			return dp[i][prev+1];
		}
		
		
		int notTake = 0 + dfs(i+1, prev, n, arr, dp);
		
		int taken = Integer.MIN_VALUE;
		if(prev ==-1 || arr[i] > arr[prev]) {
			taken = 1+ dfs(i+1, i, n, arr, dp);
		}
		
		int max = Math.max(notTake, taken);
		dp[i][prev+1] = max;
		return  max;
	}
	
	private static int longestIncreasingSubsequenceTabulation(int[] arr, int n) {
	
		int dp[][] = new int [n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			dp[n][i] = 0;
		}
		
		
		for(int i=n-1; i>=0; i--) {
			
		   for(int prev =i-1; prev>=-1; prev--) {
				
				int notTake = 0 + dp[i+1][prev+1];
				
				int taken = Integer.MIN_VALUE;
				if(prev == -1 || arr[i] > arr[prev]) {
					taken = 1 + dp[i+1][i+1];	
				}
				
				dp[i][prev+1] = Math.max(notTake, taken);
			}
		}
		return dp[0][0];
	}
	
	private static int longestIncreasingSubsequenceSpaceOptimization(int[] arr, int n) {
	
          int next[] = new int[n+1];
          int curr[] = new int [n+1];
		
		for(int i=0; i<=n; i++) {
			next[i] = 0;
		}
		
		
		for(int i=n-1; i>=0; i--) {
			
		   for(int prev =i-1; prev>=-1; prev--) {
				
				int notTake = 0 + next[prev+1];
				
				int taken = Integer.MIN_VALUE;
				if(prev == -1 || arr[i] > arr[prev]) {
					taken = 1 + next[i+1];	
				}
				
				curr[prev+1] = Math.max(notTake, taken);
			}
		   
		   next = curr;
		}
		return next[0];
	}
	
	private static int longestIncreasingSubsequenceSpaceOptimization2(int[] arr, int n) {
		
     int dp[] = new int[n];
     Arrays.fill(dp, 1);
     
     for(int i=0; i<n; i++) {
    	 
    	 for(int prev =0; prev<i; prev++) {
    		 
    		 if(arr[i] > arr[prev]) {
    			 dp[i] = Math.max(1+ dp[prev], dp[i]);
    		 }
    	 }
     }
     int maxLength = Arrays.stream(dp).max().orElse(0);
     return maxLength;
	}
}
