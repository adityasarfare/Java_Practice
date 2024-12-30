package com.example.dpStrings;

import java.util.Arrays;

public class MinimumInsertionsDeletionstoConvertString6 {

	public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                + canYouMake(str1, str2));
    }

	private static int canYouMake(String str1, String str2) {
		int n= str1.length();
		int m = str2.length();
		
		//deletion =2 int abcd as band c
		//insertion = 1 in that as to equal anc as n
		
		return (n+m) - 2*lcs(str1, str2);
	}
	
	private static int lcs(String s, String str2) {
		int n = s.length();
        int m = str2.length();

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
        		
        		if(s.charAt(i-1) == str2.charAt(j-1)) {
        			 dp[i][j] = 1 + dp[i-1][j-1];
        		}
        		else {
        		
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
        
		return dp[n][m];
	}
}
