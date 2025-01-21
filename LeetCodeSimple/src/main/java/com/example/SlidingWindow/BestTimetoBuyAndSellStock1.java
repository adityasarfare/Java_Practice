package com.example.SlidingWindow;

public class BestTimetoBuyAndSellStock1 {

	public int maxProfit(int[] prices) {

	       int minPrice = Integer.MAX_VALUE;
	       int maxRes =0;

	       for(int price : prices){
	        if(price < minPrice){
	            minPrice = price;
	        }
	        else{
	            int profit = price - minPrice;
	            maxRes = Math.max(maxRes, profit);
	        }
	       }

	       return maxRes; 
	    }
}
