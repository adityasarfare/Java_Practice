package com.example.dpPartition;

import java.util.Arrays;

public class PartitionArrayforMaximumSum6 {

	public static void main(String[] args) {
        int[] num = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int maxSum = maxSumAfterPartitioning(num, k);
        System.out.println("The maximum sum is: " + maxSum);
        
        int maxSumTab = maxSumAfterPartitioningTabulation(num, k);
        System.out.println("The maximum sum is: " + maxSumTab);
    }

	private static int maxSumAfterPartitioning(int[] num, int k) {

     int n = num.length;
     
     int[] dp = new int[n];
     Arrays.fill(dp, -1);
     
		return dfs(0, n, num, k, dp);
	}

	private static int dfs(int i, int n, int[] num, int k, int[] dp) {
		
		if(i==n) {
			return 0;
		}
		
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int max = Integer.MIN_VALUE;
 		int ans = Integer.MIN_VALUE;
 		int length=0;
		for(int j=i; j<Math.min(n, i+k); j++) {
			length++;
			max = Math.max(max, num[j]);
			int sum = length *max + dfs(j+1, n, num, k, dp);
			
			ans = Math.max(ans, sum);
		}
		return dp[i] = ans;
	}
	
	private static int maxSumAfterPartitioningTabulation(int[] num, int k) {
		
		int n = num.length;
	     
	     int[] dp = new int[n+1];
	     dp[n] =0;
	     
	     for(int i=n-1; i>=0; i--) {
	    	 int max = Integer.MIN_VALUE;
	 		int ans = Integer.MIN_VALUE;
	 		int length=0;
	 		for(int j=i; j<Math.min(n, i+k); j++) {
				length++;
				max = Math.max(max, num[j]);
				int sum = length *max + dp[j+1];
				
				ans = Math.max(ans, sum);
			}
	 		dp[i]= ans;
	     }
		
		return dp[0];
	}
}
