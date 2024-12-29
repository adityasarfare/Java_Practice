package com.example.dpSubsequence;

public class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff17 {

	 public static int minimumDifference(int[] nums) {
		 int n= nums.length;   
		 
		 int totalSum =0;
		 for(int i=0; i<n; i++) {
			 totalSum += nums[i];
		 }
		 
		 boolean [][] dp = new boolean[n][totalSum+1];
		for(int i=0; i<n; i++) {
			dp[i][0] = true;
		}
		
	     if(nums[0]<= totalSum) {
	    	 dp[0][nums[0]] = true;
	     }
	     
	     for(int i=1; i<n; i++) {
	    	 
	    	 for(int target =1; target<=totalSum; target++) {
	    		 
	    		 boolean notTaken = dp[i-1][target];
	    		 
	    		 boolean taken = false;
	    		 if(nums[i]<=target) {
	    			 taken = dp[i-1][target- nums[i]];
	    		 }
	    		 
	    		 dp[i][target]= taken || notTaken;
	    	 }
	     }
		 
	     int min = Integer.MAX_VALUE;
	     
	     for(int i=0; i<=totalSum; i++) {
	    	 if(dp[n-1][i] == true) {
	    		 int diff = Math.abs(i - (totalSum -i));
	    		 min = Math.min(min, diff);
	    	 }
	     }
		 return min;
	    }
	 
	 public static void main(String[] args) {
		int [] nums = {1,2,3,4};
		
		System.out.println("The minimum absolute difference is: " + minimumDifference(nums));
	}
}
