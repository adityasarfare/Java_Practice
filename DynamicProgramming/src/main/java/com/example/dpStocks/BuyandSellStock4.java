package com.example.dpStocks;

import java.util.Arrays;

public class BuyandSellStock4 {

	public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
           int k =2;
        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " 
        + maxProfit(prices, k));
        
        System.out.println("The maximum profit that can be generated is " 
                + maxProfitTabulation(prices, k));
        System.out.println("The maximum profit that can be generated is " 
                + maxProfitSpaceOptimization(prices, k));
    }


	private static int maxProfit(int[] prices, int k) {
		
		int n= prices.length;
		int [][][] dp = new int [n][2][3];
		
		for(int[][] rows : dp) {
			for(int [] row : rows) {
				Arrays.fill(row, -1);
			}
		}
		return dfs(0, 0, k, prices, dp);
	}

	private static int dfs(int i, int buy, int cap, int[] prices, int[][][] dp) {
		
		if(i == prices.length || cap ==0) {
			return 0;
		}
		
		if(dp[i][buy][cap] !=-1) {
			return dp[i][buy][cap];
		}
		
		int profit =0;
		if(buy ==0) {
			profit = Math.max(-prices[i] + dfs(i+1, 1, cap, prices, dp), dfs(i+1, 0, cap, prices, dp));
		}
		if(buy == 1) {
			profit = Math.max(prices[i] + dfs(i+1, 0, cap-1, prices, dp), dfs(i+1, 1, cap, prices, dp));
		}
		
		dp[i][buy][cap]= profit;
		return profit;
	}
	
	private static int maxProfitTabulation(int[] prices, int k) {
		
		int n = prices.length;
		int [][][] dp = new int [n+1][2][k+1];

		
		// this is not important
		for(int i=0; i<=n; i++) {
			
			for(int  buy =0; buy<=1; buy++) {
				
				dp[i][buy][0]= 0;
			}
		}
		
		for(int buy=0; buy<=1; buy ++) {	
			for(int cap =0; cap<=k; cap++) {
			
				dp[n][buy][cap] = 0;
				
			}
		}
		
		
		for (int i= n-1; i>=0; i--) {
			for(int buy=0; buy<=1; buy ++) {
				for (int cap =1; cap<=2; cap++) {
					
					int profit =0;
					if(buy ==0) {
						profit = Math.max(-prices[i] + dp[i+1][1][cap], dp[i+1][0][cap]);
					}
					if(buy == 1) {
						profit = Math.max(prices[i] + dp[i+1][0][cap-1], dp[i+1][1][cap]);
					}
					
					dp[i][buy][cap]= profit;
		
				}
			}
		}
		
		return dp[0][0][k];
	}
	

	private static int maxProfitSpaceOptimization(int[] prices, int k) {
	
		int n = prices.length;
		int [][] prev = new int [2][k+1];
		int [][] cur = new int [2][k+1];
		
		for (int i= n-1; i>=0; i--) {
			for(int buy=0; buy<=1; buy ++) {
				for (int cap =1; cap<=k; cap++) {
					
					int profit =0;
					if(buy ==0) {
						profit = Math.max(-prices[i] + prev[1][cap], prev[0][cap]);
					}
					if(buy == 1) {
						profit = Math.max(prices[i] + prev[0][cap-1], prev[1][cap]);
					}
					
					cur[buy][cap]= profit;
				}
			}
			prev = cur;
		}
		
		return prev[0][k];
	}
}
