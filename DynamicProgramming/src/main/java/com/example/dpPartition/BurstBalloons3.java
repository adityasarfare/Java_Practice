package com.example.dpPartition;

import java.util.ArrayList;
import java.util.Arrays;

public class BurstBalloons3 {

	public static void main(String[] args) {
        int [] nums = {3, 1, 5, 8};
        int ans = maxCoins(nums);
        System.out.println(ans);
        
        int ans1 = maxCoinsTabulation(nums);
        System.out.println(ans1);
    }

	

	private static int maxCoins(int[] nums) {

        int n = nums.length;
        
        int dp[][] = new int [n+2][n+2];
        
        for(int[] row : dp) {
        	Arrays.fill(row, -1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int no : nums) {
        	list.add(no);
        }
        
        list.add(1);
        list.add(0, 1);
		return dfs(1, n, dp, list);
	}

	private static int dfs(int i, int j, int[][] dp, ArrayList<Integer> list) {
		
		if(i>j) {
			return 0;
		}
		
		
		if(dp[i][j] !=-1) {
			return dp[i][j];
		}
		int max =Integer.MIN_VALUE;
		for(int k=i; k<=j; k++) {
			
			int burst = list.get(i-1) * list.get(k) * list.get(j+1)+
					dfs(i, k-1, dp, list) + dfs(k+1, j, dp, list);
			
			max = Math.max(max, burst);
		}

		return dp[i][j] = max;
	}
	
	private static int maxCoinsTabulation(int[] nums) {
		
        int n = nums.length;
        
        int dp[][] = new int [n+2][n+2];
        
//        for(int[] row : dp) {
//        	Arrays.fill(row, -1);
//        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int no : nums) {
        	list.add(no);
        }
        
        list.add(1);
        list.add(0, 1);
		
        
        for(int i=n; i>=1; i--) {
        	
        	for(int j =1; j<=n; j++) {
        		
        		if(i>j) {
        			continue;
        		}
        		
        		int max = Integer.MIN_VALUE;
        		for(int k=i; k<=j; k++) {
        			int burst = list.get(i-1) * list.get(k)* list.get(j+1)+
        					dp[i][k-1] + dp[k+1][j];
        			max = Math.max(max, burst);
        			}
        		dp[i][j] = max;
        	}
        }
		return dp[1][n];
	}
}
