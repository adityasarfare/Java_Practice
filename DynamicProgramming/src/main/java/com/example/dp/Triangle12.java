package com.example.dp;

import java.util.Arrays;

import javax.sound.midi.Track;

public class Triangle12 {

	 public static void main(String args[]) {
	        int triangle[][] = {{1},
	                            {2, 3},
	                            {3, 6, 7},
	                            {8, 9, 6, 10}};

	        int n = triangle.length;
	       

	        // Call the minimumPathSum function and print the result
	        System.out.println(minimumPathSum(triangle, n));
	        System.out.println(minimumPathSum2(triangle, n));
	        System.out.println(spaceOptimization(triangle, n));
	    }

	private static int minimumPathSum(int[][] triangle, int n) {
		
		int dp [][] = new int [n][n];
		
		for(int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		
		return dfs(0,0,  n, triangle, dp);
	}

	private static int dfs(int i, int j, int n, int[][] triangle, int[][] dp) {
		
		if(dp[i][j] !=-1) {
			 return dp[i][j];
		 }
		if(i==n-1) {
			return triangle[i][j];
		}
		 
		
		int down = triangle[i][j] + dfs(i+1, j, n, triangle, dp);
		int diag = triangle[i][j] + dfs(i+1, j+1, n, triangle, dp);
		
		return dp[i][j] = Math.min(down, diag);

	}
	
	private static int minimumPathSum2(int[][] triangle, int n) {
		
		int dp [][] = new int [n][n];
		
	 for(int j=0; j<n; j++) {
		 dp[n-1][j] = triangle[n-1][j];
	 }
	 
	 
	 for(int i = n-2; i>=0; i--) {
		 
		 for(int j=i; j>=0; j--) {
			 
			 int up = triangle[i][j] + dp[i+1][j];
			 int diag = triangle[i][j] + dp[i+1][j+1];
			 dp[i][j] = Math.min(up, diag);
		 }
	 }
		
		return dp[0][0];
	}
	
	private static int spaceOptimization(int[][] triangle, int n) {
		
		int [] prev = new int [n];
		int[] cur = new int[n];
		for(int j=0; j<n; j++) {
			 prev[j] = triangle[n-1][j];
		 }
		
		for(int i = n-2; i>=0; i--) {
			 
			 for(int j=i; j>=0; j--) {
				 
				 int up = triangle[i][j] + prev[j];
				 int diag = triangle[i][j] + prev[j+1];
				 cur[j] = (int) Math.min(up, diag);
			 }
			 
			 prev = cur;
		 }
		
		return prev[0];
	}
}
