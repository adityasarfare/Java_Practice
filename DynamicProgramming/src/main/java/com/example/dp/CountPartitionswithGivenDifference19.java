package com.example.dp;

import java.util.Arrays;

public class CountPartitionswithGivenDifference19 {

	
	public static void main(String args[]) {

		  int arr[] = {5,2,6,4};
		  int d=3;
		                                 
		  System.out.println("The number of subsets found are "+ countPartitions(d,arr));
		  System.out.println("The number of subsets found are "+ countPartitionsTabulation(d,arr));
		}
	
	
	static int mod =(int)(Math.pow(10,9)+7);
	public static int  countPartitions(int d, int[] arr) {
		
		int n= arr.length;
		int totalSum=0;
		for(int i=0; i<n; i++) {
			totalSum += arr[i];
		}
		
		if((totalSum-d) <0) {
			return 0;
		}
		if((totalSum-d)%2 ==1) {
			return 0;
		}
		
		int s2 = (totalSum -d)/2;
		int dp[][] = new int [n][s2+1];
		for(int [] rows : dp) {
			Arrays.fill(rows, -1);
		}
		return  dfs( n-1, s2, arr, dp);
	}

	private static int dfs(int i, int target, int[] arr, int[][] dp) {
	
		if(i==0) {
			if(target==0 && arr[0]==0) {
				return 2;
			}
			
			if(target==0 || arr[0]== target) {
				return 1;
			}
			return 0;
		}
		
		if(dp[i][target] !=-1) {
			return dp[i][target];
		}
		
		int notTaken = dfs(i-1, target, arr, dp);
		
		int taken =0;
		if(arr[i]<=target) {
			taken =  dfs(i-1, target- arr[i], arr, dp);
		}
		return dp[i][target] = (taken + notTaken)%mod;
	}
	private static int countPartitionsTabulation(int d, int[] arr) {
		int n= arr.length;
		 int totalSum = 0;
		    for(int i=0; i<n;i++){
		        totalSum += arr[i];
		    }
		    
		    if((totalSum-d) <0) {
				return 0;
			}
			if((totalSum-d)%2 ==1) {
				return 0;
			}
			
			int s2 = (totalSum -d)/2;
		
		int dp[][] = new int[n][s2+1];
		
		
		if(arr[0] ==0) {
			dp[0][0] =2;
		}
		else {
			dp[0][0] =1;
		}
		
		if(arr[0]!=0 && arr[0]<=s2) {
			dp[0][arr[0]] =1;
		}
		
		for(int ind = 1; ind<n; ind++){
	        for(int target= 0; target<=s2; target++){
	            
	            int notTaken = dp[ind-1][target];
	    
	            int taken = 0;
	                if(arr[ind]<=target)
	                    taken = dp[ind-1][target-arr[ind]];
	        
	            dp[ind][target]= (notTaken + taken)%mod;
	        }
	    }
	    return dp[n-1][s2];
	
	}
}
