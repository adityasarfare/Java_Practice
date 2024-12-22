package com.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobberII7 {

	 public int rob(int[] nums) {
	      
		 int n= nums.length;
		 int[] dp = new int[n];
		 Arrays.fill(dp, -1);
		 
		 if(nums.length ==0) {
			 return 0;
		 }
		 
		 List<Integer> list1 = new ArrayList<>();
		 List<Integer> list2 = new ArrayList<>();
		 
		 for(int i=0; i<n; i++) {
			 if(i!=0) {
				 list1.add(nums[i]);
			 }
			 
			 if(i!= n-1) {
				 list2.add(nums[i]);
			 }
		 }
		 
		 return Math.max(solve1(list1),  solve1(list2));
	    }

	 private static int solve1(List<Integer> list) {
		 int n = list.size();
			int [] dp = new int [n];
			dp[0] =list.get(0);
			
			for(int i=1; i<n; i++) {
				
				
			    int  pick = list.get(i) + (i>1? dp[i-2] : 0);
				
				int nopick = 0 + dp[i-1];
				dp[i] = Math.max(pick, nopick);
			}
			return dp[n-1];
		}
	
	
}
