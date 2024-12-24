package com.example.dp;

import java.util.Arrays;

public class MinimumFallingPathSum13 {

	public static void main(String args[]) {
        int matrix[][] = {{1, 2, 10, 4},
                          {100, 3, 2, 1},
                          {1, 1, 20, 2},
                          {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(getMaxPathSum(matrix));
        System.out.println(getMaxPathSumTabulation(matrix));
    }

	

	private static int  getMaxPathSum(int[][] matrix) {
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int result =Integer.MIN_VALUE;
		int dp [][] = new int [n][m];
		for(int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		
		for(int j=0; j<m; j++) {
			
			 result = Math.max(result, dfs(n-1, j, matrix, dp));
		}
		return result ;
	}

	private static int dfs(int i, int j, int[][] matrix, int[][] dp) {
		
		
		if(j<0 || j>= matrix[0].length) {
			return (int) Math.pow(-10, 9);
		}
		if(i == 0) {
			return matrix[i][j];
		}
		if(dp[i][j] !=-1) {
			 return dp[i][j];
		 }
		
		int straight = matrix[i][j] + dfs(i-1, j, matrix, dp);
		int leftdiag = matrix[i][j] + dfs(i-1, j-1, matrix, dp);
		int rightdiag = matrix[i][j] + dfs(i-1, j+1, matrix, dp);
		
		return dp[i][j] = Math.max(straight, (Math.max(leftdiag, rightdiag)));
	}
	
	 private static char[] getMaxPathSumTabulation(int[][] matrix) {
		
		 int n = matrix.length;
		 int m = matrix[0].length;
		 int dp [][] = new int [n][m];
		 
		 for(int j=0; j<m; j++) {
			 dp[0][j] = matrix[0][j];
		 }
		 
		 for(int i=1; i<n; i++) {
			 
			 for(int j =0; j<m ; j++) {
				 
				 int straight =0;
				 int leftdiag = 0;
				 int rightdiag =0;
				 
			     straight = matrix[i][j] + dp[i-1][j];
				
			     if(j-1>=0) {
			     leftdiag = matrix[i][j] + dp[i-1][j-1];
			     }else {
			    	 
			     }
			     straight = matrix[i][j] + dp[i-1][j];
				 }
			 }
		 
		return null;
	 }
}
