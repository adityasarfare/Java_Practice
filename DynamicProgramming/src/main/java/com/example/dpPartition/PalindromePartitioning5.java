package com.example.dpPartition;

import java.util.Arrays;

public class PalindromePartitioning5 {

	public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int partitions = palindromePartitioning(str)-1;
        System.out.println("The minimum number of partitions: " + partitions);
        
        int partitionsTab = palindromePartitioningTabulation(str);
        System.out.println("The minimum number of partitions: " + partitionsTab);
    }

	

	private static int palindromePartitioning(String str) {

      int n= str.length();
      
      int [] dp = new int[n];
      Arrays.fill(dp, -1);
      
      
	  return dfs(0, n, str, dp);
	}

	private static int dfs(int i, int n, String str, int[] dp) {

       if(i==n) {
    	   return 0;
       }
       
       if(dp[i] !=-1) {
    	   return dp[i];
       }
       
       int min = Integer.MAX_VALUE;
       for(int j=i; j<n; j++) {
    	   
    	if(isPalandrome(i, j, str)) {
    		int cost = 1+ dfs(j+1, n, str, dp);
            min = Math.min(min, cost);
    	}
    	  
       }
       return dp[i] = min;
	}

	private static boolean isPalandrome(int i, int j, String str) {
		
		while(i<j) {
		if(str.charAt(i) != str.charAt(j)){
			return false;
		} 
		
			i++;
			j--;
		}
		return true;
}
	
	private static int palindromePartitioningTabulation(String str) {
		
		int n= str.length();
	      
	      int [] dp = new int[n+1];
	           dp[n] =0;
	     for(int i=n-1; i>=0; i--) {
	     int min = Integer.MAX_VALUE;
	     for(int j=i; j<n; j++){
	    	 if(isPalandrome(i, j, str)) {
	     		int cost = 1+ dp[j+1];
	             min = Math.min(min, cost);
	     	}
	    	 
	     }
	     dp[i] = min;
	     }
		return dp[0]-1;
	}
}
