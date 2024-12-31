package com.example.dpStrings;

import java.util.Arrays;

public class WildcardMatchingRegularExpressionMatching {

	public static void main(String args[]) {
		String pattern = "ab*cd";
		String text = "abdefcd";

		if (wildcardMatching(pattern, text) == 1) {
			System.out.println("String S1 and S2 do match");
		} else {
			System.out.println("String S1 and S2 do not match");
		}

		System.out.println(wildcardMatchingTabulation(pattern, text));
		System.out.println(wildcardMatchingSpaceOptimization(pattern, text));
	}

	

	private static int wildcardMatching(String pattern, String text) {

		int n = pattern.length();
		int m = text.length();

		int[][] dp = new int[n][m];

		for (int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		return dfs(n - 1, m - 1, pattern, text, dp);
	}

	private static int dfs(int i, int j, String pattern, String text, int[][] dp) {

		if (i < 0 && j < 0) {
			return 1;
		}

		if (i < 0 && j >= 0) {
			return 0;
		}

		if (j < 0 && i >= 0) {

			for (int k = 0; k <= i; k++) {
				if (pattern.charAt(i) != '*') {
					return 0;
				}
			}

			return 1;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
			return dp[i][j] = dfs(i - 1, j - 1, pattern, text, dp);
		} else if (pattern.charAt(i) == '*') {
			return dp[i][j] = (dfs(i - 1, j, pattern, text, dp) == 1 || dfs(i, j - 1, pattern, text, dp) == 1) ? 1 : 0;
		} else {

			return 0;
		}
	}

	private static boolean wildcardMatchingTabulation(String pattern, String text) {

		int n = pattern.length();
		int m = text.length();

		boolean[][] dp = new boolean[n + 1][m + 1];

		dp[0][0] = true;

		for (int j = 1; j <= m; j++) {
			dp[0][j] = false;
		}

		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int k = 1; k <= i; k++) {
				if (pattern.charAt(k) != '*') {
					flag = false;
					break;
				}
			}

			dp[i][0] = flag;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(i - 1) == '*') {

					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}
	
	private static boolean wildcardMatchingSpaceOptimization(String pattern, String text) {
		int n = pattern.length();
		int m = text.length();

		boolean[] prev = new boolean[m + 1];
		boolean[] cur = new boolean[m + 1];

		prev[0] = true;


		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int k = 1; k <= i; k++) {
				if (pattern.charAt(k) != '*') {
					flag = false;
					break;
				}
			}

			dp[i][0] = flag;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(i - 1) == '*') {

					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}
}
