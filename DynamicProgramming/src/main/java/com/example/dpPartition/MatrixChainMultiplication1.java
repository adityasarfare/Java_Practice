package com.example.dpPartition;

import java.util.Arrays;

public class MatrixChainMultiplication1 {

	public static void main(String args[]) {
		
		int arr[] = {10, 20, 30, 40, 50};
		
		int n = arr.length;
		
		System.out.println("The minimum number of operations are "+
	        matrixMultiplication(arr,n));
		
		System.out.println("The minimum number of operations are "+
		        matrixMultiplicationMemoization(arr,n));
		
	}


	private static int matrixMultiplication(int[] arr, int n) {
		
		int i=1;
		int j=n-1;
		return dfs(i, j, arr);
	}

	private static int dfs(int i, int j, int[] arr) {
		
		if(i ==j) {
			return 0;
		}
		
		int min= Integer.MAX_VALUE;
		for(int k =i; k<=j-1; k++) {
			
			int steps = dfs(i, k, arr) + dfs(k+1, j, arr) + arr[i-1]*arr[k]*arr[j];
			
		    min = Math.min(min, steps);
		}
		return min;
	}
	
	private static int matrixMultiplicationMemoization(int[] arr, int n) {
		
		int dp[][]= new int[n][n];
	    
	    for(int row[]:dp)
	    Arrays.fill(row,-1);
	    
	    int i =1;
	    int j = n-1;
		return dfs(arr, i, j, dp);
	}


	private static int dfs(int[] arr, int i, int j, int[][] dp) {
		
		if(i ==j) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int min= Integer.MAX_VALUE;
		
		for(int k=i; k<=j-1; k++) {
			int steps = dfs(arr, i, k, dp) + dfs(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j];
			
			min = Math.min(min, steps);
			
			dp[i][j] = min;
		}
		return min;
	}
}
