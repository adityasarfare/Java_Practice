package com.example.AdvanceGraph;

import java.util.Arrays;

//Bellmons ford
//787
public class CheapestFlightsWithinKStops6 {
	 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		 int [] prices = new int[n];
		 for(int i=0; i<n; i++) {
			
				 prices[i]= Integer.MAX_VALUE;
		 }
		 
		 prices[src] = 0; 
		 
		 for(int i=0; i<=k; i++) {
			 int[] tempprice = Arrays.copyOf(prices, n);
			 
			 for(int flight[] : flights){
				 int s = flight[0];
				 int d = flight[1];
				 int p = flight[2];
				 
				 if(prices[s]== Integer.MAX_VALUE) {
					 continue;
				 }
				 
				 if(prices[s]+ p < tempprice[d]) {
					 tempprice[d] = prices[s] + p;
				 }
				
			 }
			 prices = tempprice;
		 }
		 
		 return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	    }
}


//This problem involves finding the cheapest price from a starting city (src) to a destination city (dst) with at most k stops using a graph represented by the flights array. Each entry in flights represents a direct flight between two cities along with its cost.
//
//Algorithm:
//The algorithm uses Bellman-Ford's approach, which relaxes all edges multiple times. Here, the graph is traversed up to k + 1 times (because k stops mean up to k + 1 edges), updating the minimum cost to each city during each iteration.
//
//Input:
//n = 3: There are 3 cities labeled 0, 1, and 2.
//flights = [[0,1,100],[1,2,100],[0,2,500]]: The flight connections:
//0 → 1 with cost 100.
//1 → 2 with cost 100.
//0 → 2 with cost 500.
//src = 0: Starting city is 0.
//dst = 2: Destination city is 2.
//k = 1: At most 1 stop allowed.
//Steps of Execution:
//1. Initialization:
//java
//Copy code
//int[] prices = new int[n];
//Arrays.fill(prices, Integer.MAX_VALUE);
//prices[src] = 0;
//prices array represents the minimum cost to reach each city.
//Initially, all cities have a cost of Integer.MAX_VALUE (unreachable), except src (city 0) which has a cost of 0.
//State:
//
//css
//Copy code
//prices = [0, ∞, ∞]
//2. Relaxing Edges (k + 1 = 2 iterations):
//For each of the k + 1 iterations, a temporary copy of prices is used (tmpPrices) to prevent immediate overwriting of values during the current iteration.
//
//Iteration 1 (i = 0):
//java
//Copy code
//int[] tmpPrices = Arrays.copyOf(prices, n);
//Relax Flights:
//
//Flight 0 → 1 with cost 100:
//
//Current cost to 0 is 0.
//New cost to 1 = 0 + 100 = 100.
//Update tmpPrices[1] = 100.
//Flight 1 → 2 with cost 100:
//
//Current cost to 1 is ∞ (unreachable).
//No update.
//Flight 0 → 2 with cost 500:
//
//Current cost to 0 is 0.
//New cost to 2 = 0 + 500 = 500.
//Update tmpPrices[2] = 500.
//Update prices:
//
//css
//Copy code
//prices = [0, 100, 500]
//Iteration 2 (i = 1):
//java
//Copy code
//int[] tmpPrices = Arrays.copyOf(prices, n);
//Relax Flights:
//
//Flight 0 → 1 with cost 100:
//
//Current cost to 0 is 0.
//New cost to 1 = 0 + 100 = 100.
//No update (already 100).
//Flight 1 → 2 with cost 100:
//
//Current cost to 1 is 100.
//New cost to 2 = 100 + 100 = 200.
//Update tmpPrices[2] = 200.
//Flight 0 → 2 with cost 500:
//
//Current cost to 0 is 0.
//New cost to 2 = 0 + 500 = 500.
//No update (already 200).
//Update prices:
//
//css
//Copy code
//prices = [0, 100, 200]
//3. Final Result:
//java
//Copy code
//return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
//prices[dst] = prices[2] = 200.
//Since the cost is not Integer.MAX_VALUE, the result is 200.