package com.example.dpSubsequence;

public class TargetSum22 {
	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 1 };
        int target = 3;                    
		  
		  System.out.println("The number of subsets found are "+ targetSumTabulation(target,arr));
		}
	static int mod =(int)(Math.pow(10,9)+7);
	private static int targetSumTabulation(int d, int[] arr) {
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
	        for(int tar= 0; tar<=s2; tar++){
	            
	            int notTaken = dp[ind-1][tar];
	    
	            int taken = 0;
	                if(arr[ind]<=tar)
	                    taken = dp[ind-1][tar-arr[ind]];
	        
	            dp[ind][tar]= (notTaken + taken)%mod;
	        }
	    }
	    return dp[n-1][s2];
	}
}
