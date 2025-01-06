package com.example.dpPartition;

public class EvaluateBooleanExpressiontoTrue4 {

	public static void main(String[] args) {
        String exp = "F|T^F";
        Long ways = evaluateExpWays(exp);
        System.out.println("The total number of ways: " + ways);
    }

	private static Long evaluateExpWays(String exp) {
		
		int n= exp.length();
		Long[][][] dp = new Long[n][n][2];
		
		return evaluateExpresssionways(exp, 0, n-1, 1, dp);
	}

	static final int MOD = 1000000007;
	private static Long evaluateExpresssionways(String exp, int i, int j, int isTrue, Long[][][] dp) {
		
		if(i>j) {
			return (long) 0;
		}
		
		if(i==j) {
			if(isTrue==1) {
				return (long) (exp.charAt(i) == 'T' ?1:0);
			}else {
				return (long) (exp.charAt(i) == 'F' ?1:0);
			}
		}
		
		if (dp[i][j][isTrue] != null) {
            return dp[i][j][isTrue];
        }
		
		long ways =0;
		
		for(int ind = i+1; ind<=j-1; ind+=2) {
			
			long lT = evaluateExpresssionways(exp, i, ind-1, 1, dp);
			long lF = evaluateExpresssionways(exp, i, ind-1, 0, dp);
			long rT = evaluateExpresssionways(exp, ind+1, j, 1, dp);
			long rF = evaluateExpresssionways(exp, ind+1, j, 0, dp);
			
			char operator = exp.charAt(ind);
			if(operator == '&') {
				if(isTrue==1) {
					ways = (ways + (lT*rT) %MOD) %MOD;
				}else {
					ways = (ways + (lF*rT)%MOD + (lT*rF)%MOD + (lF*rF)%MOD)%MOD;
				}
			}
			else if (operator == '|') {
				if(isTrue==1) {
					ways = (ways + (lF*rT)%MOD + (lT*rF)%MOD + (lT*rT)%MOD)%MOD;
				}else {
					ways = (ways + (lF*rF)%MOD)%MOD;
				}
			}
			else {
				if(isTrue==1) {
					ways = (ways + (lF*rT)%MOD + (lT*rF)%MOD)%MOD;
				}else {
					ways = (ways + (lF*rF)%MOD + (lT*rT)%MOD)%MOD;
				}
			}
		}
		dp[i][j][isTrue] = ways;
        return ways;
	}
}
