package com.example.dpSubsequence;

import java.util.Arrays;

public class MinimumPathSum11 {

	public static void main(String args[]) {
		// Define the matrix
		int matrix[][] = { { 5, 9, 6 }, { 11, 5, 2 } };

		int n = matrix.length;
		int m = matrix[0].length;

		// Calculate and print the minimum sum path in the matrix
		System.out.println(minSumPath(n, m, matrix));
		System.out.println(minumumPathSum2(matrix));
	}

	private static int minSumPath(int n, int m, int[][] matrix) {

		int dp[][] = new int[n][m];

		for (int rows[] : dp) {
			Arrays.fill(rows, -1);
		}

		return dfs(n - 1, m - 1, dp, matrix);
	}

	private static int dfs(int i, int j, int[][] dp, int[][] matrix) {

		if (i == 0 && j == 0) {
			return matrix[i][j];
		}

		if (i < 0 || j < 0) {
			return (int) Math.pow(10, 9);
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = matrix[i][j] + dfs(i - 1, j, dp, matrix);
		int left = matrix[i][j] + dfs(i, j - 1, dp, matrix);

		return dp[i][j] = Math.min(up, left);

	}

	private static int minumumPathSum2(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
//	    dp[0][0] = 1;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if (i == 0 && j == 0) {
					dp[i][j] = matrix[i][j];

				} else {
					int down = matrix[i][j];
					int right = matrix[i][j];
					if (i > 0) {
						down += dp[i - 1][j];
					} else {
						down += (int) Math.pow(10, 9);
					}

					if (j > 0) {
						right += dp[i][j - 1];
					} else {
						right += (int) Math.pow(10, 9);
					}
					dp[i][j] = Math.min(down, right);
				}
			}
		}
		return dp[n - 1][m - 1];
	}
}
