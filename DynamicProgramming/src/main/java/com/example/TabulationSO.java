package com.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class TabulationSO{

 
    public static void main( String[] args )
    {
    	int n=6;
    	int prev2=0;
    	int prev =1;
        for(int  i=2; i<=n; i++) {
        	int curr = prev + prev2;
        	prev2 = prev;
        	prev = curr;
        }
        
        System.out.println(prev);
    }

	
}

//Time Complexity: O(N)
//
//Reason: We are running a simple iterative loop
//
//Space Complexity: O(N)
//
//Reason: We are using an external array of size ‘n+1’.