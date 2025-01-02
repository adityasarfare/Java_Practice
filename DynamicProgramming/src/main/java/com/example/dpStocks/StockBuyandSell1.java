package com.example.dpStocks;

public class StockBuyandSell1 {
	public static void main(String args[]) {

		  int[] Arr  ={7,1,5,3,6,4};

		  System.out.println("The maximum profit by selling the stock is "+
		  maximumProfit(Arr));
		}

	private static int maximumProfit(int[] arr) {
		int profit =0;
		int min=arr[0];
		for(int i=1; i<arr.length; i++) {
			int cost = arr[i] - min;
			profit = Math.max(profit, cost);
			
			min = Math.min(min, arr[i]);
		}
		
		return profit;
	}
}
