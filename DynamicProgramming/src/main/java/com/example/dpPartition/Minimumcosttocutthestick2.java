package com.example.dpPartition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Minimumcosttocutthestick2 {

	public static void main(String[] args) {

		int[] cuts = { 3, 5, 1, 4 };

		int n = 7;

		System.out.println(minCost(n, cuts));
		System.out.println(minCostTabulation(n, cuts));

	}

	private static int minCost(int n, int[] cuts) {

		ArrayList<Integer> list = new ArrayList<>();

		int c = cuts.length;

		for (int no : cuts) {
			list.add(no);
		}

		list.add(n);
		list.add(0);

		Collections.sort(list);

		int dp[][] = new int[c + 1][c + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return dfs(1, c, dp, list);
	}

	private static int dfs(int i, int j, int[][] dp, ArrayList<Integer> list) {

		if (i > j) {
			return 0;
		}

		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			int cut = list.get(j + 1) - list.get(i - 1) + dfs(i, k - 1, dp, list) + dfs(k + 1, j, dp, list);
			min = Math.min(min, cut);
		}
		return dp[i][j] = min;
	}

	private static int minCostTabulation(int n, int[] cuts) {

		int c = cuts.length;

		ArrayList<Integer> list = new ArrayList<>();

		int[][] dp = new int[c + 2][c + 2];
//
//		for (int[] row : dp) {
//			Arrays.fill(row, 0);
//		}
		for (int no : cuts) {
			list.add(no);
		}

		list.add(0);
		list.add(n);

		Collections.sort(list);

		for (int i = c; i >= 1; i--) {
			for (int j = 1; j <= c; j++) {
				if (i > j) {
					continue;
				}
				int min = (int) Math.pow(10, 9);

				for (int k = i; k <= j; k++) {
					int cut = list.get(j + 1) - list.get(i - 1) + dp[i][k - 1] + dp[k + 1][j];
					min = Math.min(min, cut);
				}

				dp[i][j] = min;
			}
		}

		return dp[1][c];
	}
}



//By iterating i from c down to 1 and j from 1 up to c:
//
//We process smaller subproblems (closer to the diagonal) first.
//This ensures that when we calculate dp[i][j], all dependencies like dp[i][k - 1] or dp[k + 1][j] are already available.
//Visualization of the DP Table Filling
//Here’s how the DP table gets filled:
//
//Start filling from the bottom-left corner (i = c, j = c) and move upwards and rightwards.
//Smaller ranges (closer to the diagonal) are filled first, followed by larger ranges.
//Example:
//If c = 3 (cuts = [1, 3, 4]):
//
//i = 3, j = 3: Compute cost for range [3, 3].
//i = 2, j = 3: Compute cost for range [2, 3].
//i = 1, j = 3: Compute cost for range [1, 3].
//Why This Order Matters
//The DP recursion formula:
//
//java
//Copy code
//dp[i][j] = min(dp[i][k - 1] + dp[k + 1][j] + (cost of current cut))
//requires:
//
//dp[i][k - 1] (left segment)
//dp[k + 1][j] (right segment)
//Both of these must already be computed before calculating dp[i][j]. By iterating i in reverse and j forward, we guarantee that all necessary subproblems are solved before moving to larger ones.
//
//Conclusion
//Outer loop i (from c to 1) ensures that smaller subproblems are computed before larger ones.
//Inner loop j (from 1 to c) ensures all valid ranges for a given starting index i are processed.
//This order respects the dependency structure of the DP solution and ensures correctness.
//
//
//
//
//
//
