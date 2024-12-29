package com.example.dpSubsequence;

import java.util.Arrays;


//https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
public class FrogJump3 {

	//Memoization
  public int maxJump(int[] stones) {
        
	  int n= stones.length;
	  int dp[] = new int[n+1];
	  Arrays.fill(dp, -1);
	  
	  return dfs(n-1, stones, dp);
	  
    }                                    
                          
	private int dfs(int n, int[] stones, int[] dp) {
	
		if(n==0) {
			return 0;
		}
		
		
		if(dp[n] !=-1) {
			return dp[n];
		}
		
		int left= dfs(n-1, stones, dp) + Math.abs(stones[n] - stones[n-1]);
		
		  int right = Integer.MAX_VALUE;
		
		if(n>1) {
			right =  dfs(n-2, stones, dp) + Math.abs(stones[n] - stones[n-2]);
		}
		return  dp[n] =Math.min(left, right);
	}
	
	
	//Tabulation
//	public int maxJump(int[] stones) {
//        int n = stones.length;
//        int[] dp = new int[n];
//      
//      dp[0]=0;
//
//      for(int i=1; i< stones.length; i++){
//        int firstJump= dp[i-1] + Math.abs(stones[i] - stones[i-1]);
//        int secondJump = Integer.MAX_VALUE;
//        if(i>1){
//            secondJump = dp[i-2] + Math.abs(stones[i] - stones[i-2]);
//        }
//        dp[i] = Math.min(firstJump, secondJump);
//      }
//
//      return dp[n-1];
//}
	
	//public int maxJump(int[] stones) {
//      int n = stones.length;
//     
//    
//    int prev2=0;
//    int prev=0;
	
//    for(int i=1; i< stones.length; i++){
//      int firstJump= prev + Math.abs(stones[i] - stones[i-1]);
//      int secondJump = Integer.MAX_VALUE;
//      if(i>1){
//          secondJump = prev2 + Math.abs(stones[i] - stones[i-2]);
//      }
//      int curri = Math.min(firstJump, secondJump);
//	prev2 = prev;
//	prev = curri;
//    }
//
//    return prev;
//}
}
