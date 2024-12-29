package com.example.dpStrings;

import java.util.Arrays;

public class PrintLongestCommonSubsequence2 {

	public static void main(String args[]) {
        String text1 = "acd";
        String text2 = "ced";

        // Call the lcs function and print the result
        printLcs(text1, text2);
        
    }

	private static void printLcs(String text1, String text2) {
	
		int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];
        
        for(int rows[] : dp)
        Arrays.fill(rows, -1);
        
        for(int i=0; i<=n; i++) {
        	dp[i][0] = 0;
        }
          
        
        for(int j=0; j<=m; j++) {
        	dp[0][j] = 0;
        }
        
        
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=m; j++) {
        		
        		if(text1.charAt(i-1) == text2.charAt(j-1)) {
        			 dp[i][j] = 1 + dp[i-1][j-1];
        		}
        		else {
        		
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
		
		int len = dp[n][m];
		int i=n;
		int j=m;
		
		int index = len-1;
		String str ="";
		for(int k=1; k<=len; k++) {
			str +="$";
		}
		
		StringBuilder ss = new StringBuilder(text1);
		StringBuilder str2 = new StringBuilder(str);
		
		while(i>0 && j>0) {
			if(ss.charAt(i-1) == text2.charAt(j-1)) {
				str2.setCharAt(index, ss.charAt(i-1));
				index--;
				i--;
				j--;
			}
			else if(ss.charAt(i-1)> text2.charAt(j-1)){
				
				i = i-1;
			}else {
				j = j-1;
			}
		}
		
		System.out.println(str2);
	}
}
