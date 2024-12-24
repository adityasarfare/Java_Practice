package com.example.dp;

import java.awt.Desktop.Action;
import java.util.Arrays;

public class NinjaTraining8 {

	private static int ninjaTraining(int n, int[][] points) {

		int[][] dp = new int[n][4];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return dfs(n - 1, 3, points, dp);
	}

	private static int dfs(int day, int last, int[][] points, int[][] dp) {

		if (dp[day][last] != -1) {
			return dp[day][last];
		}
		if (day == 0) {
			int max = 0;
			for (int task = 0; task < 3; task++) {
				if (task != last) {
					max = Math.max(max, points[0][task]);
				}
			}
			return dp[day][last] = max;
		}

		int maxi = 0;
		for (int task = 0; task < 3; task++) {

			if (task != last) {
				int activity = points[day][task] + dfs(day - 1, task, points, dp);
				maxi = Math.max(maxi, activity);
			}
		}

		return dp[day][last] = maxi;
	}

	public static void main(String args[]) {
		// Define the points for each activity on each day
		int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };

		int n = points.length; // Get the number of days
		System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
		System.out.println(tabulation(points));
	}

	private static int tabulation(int[][] points) {
		int n = points.length;
		int dp[][] = new int[n][4];

		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

		for (int day = 1; day < n; day++) {
			for (int last = 0; last < 4; last++) {

				dp[day][last] = 0;

				for (int task = 0; task < 3; task++) {
					if (task != last) {
						int activity = points[day][task] + dp[day - 1][task];

						dp[day][last] = Math.max(dp[day][last], activity);
					}
				}

			}
		}
		return dp[n - 1][3];
	}
}
