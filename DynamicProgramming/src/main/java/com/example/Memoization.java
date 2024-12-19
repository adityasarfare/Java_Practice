package com.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Memoization{

    private static int f(int n, int[] dp) {
	
	if(n<=1) {
		return n;
	}
	
	if(dp[n]!=-1) {
		return dp[n];
	}
	return f(n-1, dp)+f(n-2, dp);
     }


    public static void main( String[] args )
    {
    	int n=6;
    	int dp[] = new int[n+1];
    	Arrays.fill(dp, -1);
        System.out.println(f(n, dp) );
    }

	
}

//Reason: The overlapping subproblems will return the answer in constant time O(1). Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
//
//Space Complexity: O(N)
//
//Reason: We are using a recursion stack space(O(N)) and an array (again O(N)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)