package com.example.dp;

import java.util.Arrays;

public class CherryPickupII14 {

	public static void main(String args[]) {
		int matrix[][] = { { 2, 3, 1, 2 }, 
				           { 3, 4, 2, 2 }, 
				           { 5, 6, 3, 5 } };
		int n = matrix.length;
		int m = matrix[0].length;

		// Call the maximumChocolates function and print the result
		System.out.println(maximumChocolates(n, m, matrix));
	}

	private static int maximumChocolates(int n, int m, int[][] matrix) {

		int[][][] dp = new int[n][m][m];
		for (int row1[][] : dp) {
			for (int row2[] : row1) {
            Arrays.fill(row2, -1);
			}
		}

		return dfs(0, 0, m-1, m, matrix, dp);
	}

	private static int dfs(int i, int j1, int j2, int m, int[][] matrix, int[][][] dp) {
		if(j1<0 || j1>=m || j2<0 || j2>=m) {
			return -1000000000;
		}
		
		
		if(i == matrix.length-1) {
			if(j1 == j2) {
				return matrix[i][j1];
			}
			else {
				return matrix[i][j1] + matrix[i][j2];
			}
		}
		
		if(dp[i][j1][j2]!=-1) {
			return dp[i][j1][j2];
		}
		int max = Integer.MIN_VALUE;
		for(int d1=-1; d1<=1; d1++) {
			for(int d2=-1; d2<=1; d2++) {
		       int ans;
		
		  if(j1 == j2) {
			ans = matrix[i][j1] + dfs(i+1, j1+d1, j2+d2, m, matrix, dp);
		}else {
			ans = matrix[i][j1] + matrix[i][j2] + dfs(i+1, j1+d1, j2+d2, m, matrix, dp);
		}
			
		  max = Math.max(max, ans);
			}
		}
		
		dp[i][j1][j2] = max;
		return max;
	}
}